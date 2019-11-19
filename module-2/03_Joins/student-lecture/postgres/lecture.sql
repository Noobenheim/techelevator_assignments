-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT *
FROM "payment"
WHERE "payment_id" = 16666;

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT *
FROM "customer"
WHERE "customer_id" = 204;

SELECT *
FROM "payment"
JOIN "customer" ON "payment"."customer_id" = "customer"."customer_id"
WHERE "payment_id" = 16666;

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:
SELECT p.*, c.first_name, c.last_name
FROM payment p  
INNER JOIN customer c ON c.customer_id = p.customer_id
WHERE p.payment_id = 16666
;


SELECT p.*, c."first_name", c."last_name"
FROM "payment" p
JOIN "customer" c ON p."customer_id" = c."customer_id"
WHERE "payment_id" = 16666;


-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.
SELECT p.*, c.first_name, c.last_name, r.*
FROM payment p
JOIN customer c ON p.customer_id = c.customer_id
JOIN rental r ON r.rental_id = p.rental_id
WHERE p.payment_id = 16666
;



SELECT p.amount, p.payment_date, r.rental_date, r.inventory_id, c."first_name", c."last_name"
FROM "payment" p
JOIN "customer" c ON p."customer_id" = c."customer_id"
JOIN "rental" r ON r."rental_id" = p."rental_id"
WHERE "payment_id" = 16666;


-- What did they rent? Film id can be gotten through inventory.
SELECT c.first_name, c.last_name, p.amount, p.payment_date, f.title
FROM payment p
JOIN customer c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
WHERE p.payment_id = 16666
;


SELECT p.amount, p.payment_date, r.rental_date, r.inventory_id, c."first_name", c."last_name", f.title
FROM "payment" p
JOIN "customer" c ON p."customer_id" = c."customer_id"
JOIN "rental" r ON r."rental_id" = p."rental_id"
JOIN "inventory" i ON r."inventory_id" = i."inventory_id"
JOIN "film" f ON i."film_id" = f."film_id"
WHERE "payment_id" = 16666;

-- What if we wanted to know who acted in that film?
SELECT *
FROM payment p
JOIN customer c ON c.customer_id = p.customer_id
JOIN rental r ON r.rental_id = p.rental_id
JOIN inventory i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
JOIN film_actor fa ON f.film_id = fa.film_id
JOIN actor a ON a.actor_id = fa.actor_id
WHERE p.payment_id = 16666
;


SELECT p.amount, p.payment_date, r.rental_date, c."first_name", c."last_name", f.title, a.first_name, a.last_name
FROM "payment" p
JOIN "customer" c ON p."customer_id" = c."customer_id"
JOIN "rental" r ON r."rental_id" = p."rental_id"
JOIN "inventory" i ON r."inventory_id" = i."inventory_id"
JOIN "film" f ON i."film_id" = f."film_id"
JOIN "film_actor" fa ON fa."film_id" = f."film_id"
JOIN "actor" a ON a."actor_id" = fa."actor_id"
WHERE "payment_id" = 16666;


-- What if we wanted a list of all the films and their categories ordered by film title
SELECT f.title, c.name 
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
ORDER BY f.title;


SELECT f.title, c.name
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
ORDER BY f.title;

-- Show all the 'Comedy' films ordered by film title
-- NO



-- Finally, let's count the number of films under each category

SELECT count(*), c.name
FROM film f
JOIN film_category fc ON f.film_id = fc.film_id
JOIN category c ON c.category_id = fc.category_id
GROUP BY c.name
ORDER BY c.name;

-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists.
-- Let's display a list of all countries and their capitals, if they have some.
SELECT city.name, country.name 
FROM country
JOIN city ON country.capital = city.id;


SELECT * 
FROM country
JOIN city ON country.capital = city.id
;

-- Only 232 rows
-- But we’re missing entries:

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
SELECT country.name, city.*
FROM country
LEFT JOIN city ON country.capital = city.id
WHERE city.id IS NULL
;


-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

SELECT city.name, country.name
FROM country
LEFT JOIN city ON country.capital = city.id
;



SELECT country.name, city.*
FROM country
LEFT JOIN city ON country.capital = city.id
WHERE city.id IS NULL
;

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates

SELECT first_name
FROM actor
UNION
SELECT first_name
FROM customer
ORDER BY first_name;


-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer

SELECT first_name, 'A'
FROM actor
UNION
SELECT first_name, 'C'
FROM customer;