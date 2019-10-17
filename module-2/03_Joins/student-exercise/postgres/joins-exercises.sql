-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_actor" "fa" ON "f"."film_id" = "fa"."film_id"
JOIN "actor" "a" ON "a"."actor_id" = "fa"."actor_id"
WHERE "a"."first_name" = 'NICK' AND "a"."last_name" = 'STALLONE'
;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_actor" "fa" ON "f"."film_id" = "fa"."film_id"
JOIN "actor" "a" ON "a"."actor_id" = "fa"."actor_id"
WHERE "a"."first_name" = 'RITA' AND "a"."last_name" = 'REYNOLDS'
;

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_actor" "fa" ON "f"."film_id" = "fa"."film_id"
JOIN "actor" "a" ON "a"."actor_id" = "fa"."actor_id"
WHERE ("a"."first_name" = 'JUDY' OR "a"."first_name" = 'RIVER')
        AND "a"."last_name" = 'DEAN'
;

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "c"."name" = 'Documentary'
;

-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "c"."name" = 'Comedy'
;

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "c"."name" = 'Children' AND "f"."rating" = 'G'
;

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "c"."name" = 'Family' AND "f"."rating" = 'G' AND "f"."length" < 120
;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_actor" "fa" ON "fa"."film_id" = "f"."film_id"
JOIN "actor" "a" ON "a"."actor_id" = "fa"."actor_id"
WHERE "a"."first_name" = 'MATTHEW' AND "a"."last_name" = 'LEIGH'
      AND "f"."rating" = 'G'
;

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "c"."name" = 'Sci-Fi' AND "f"."release_year" = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT "f"."title"
FROM "film" "f"
JOIN "film_actor" "fa" ON "f"."film_id" = "fa"."film_id"
JOIN "actor" "a" ON "a"."actor_id" = "fa"."actor_id"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
WHERE "a"."first_name" = 'NICK' AND "a"."last_name" = 'STALLONE'
     AND "c"."name" = 'Action'
;

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)
SELECT "address", "district", "city", "co"."country"
FROM "store" "s"
JOIN "address" "a" ON "a"."address_id" = "s"."address_id"
JOIN "city" "c" ON "c"."city_id" = "a"."city_id"
JOIN "country" "co" ON "co"."country_id" = "c"."country_id"
;


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT "store"."store_id", "a"."address", "first_name"||' '||"last_name" AS "manager"
FROM "store"
JOIN "address" "a" ON "a"."address_id" = "store"."address_id"
JOIN "staff" ON "staff"."store_id" = "store"."store_id"
;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals)
SELECT "c"."first_name"||' '||"c"."last_name" AS "name", COUNT("r"."rental_id")
FROM "customer" "c"
JOIN "rental" "r" ON "r"."customer_id" = "c"."customer_id"
GROUP BY "c"."customer_id"
ORDER BY "count" DESC
LIMIT 10
;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent)
SELECT "c"."first_name"||' '||"c"."last_name" AS "name", SUM("amount")
FROM "customer" "c"
JOIN "payment" "p" ON "c"."customer_id" = "p"."customer_id"
GROUP BY "c"."customer_id"
ORDER BY "sum" DESC
LIMIT 10
;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)
SELECT "s"."store_id", "a"."address", COUNT("r"."rental_id"), SUM("p"."amount"), AVG("p"."amount")
FROM "address" "a"
JOIN "store" "s" ON "s"."address_id" = "a"."address_id"
JOIN "inventory" "i" ON "i"."store_id" = "s"."store_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
JOIN "payment" "p" ON "p"."rental_id" = "r"."rental_id"
GROUP BY "s"."store_id", "a"."address";

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals)
SELECT "f"."title", COUNT(*)
FROM "film" "f"
JOIN "inventory" "i" ON "i"."film_id" = "f"."film_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
GROUP BY "f"."title"
ORDER BY "count" DESC, "f"."title"
LIMIT 10;

-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals)
SELECT "c"."name", COUNT(*)
FROM "category" "c"
JOIN "film_category" "fc" ON "fc"."category_id" = "c"."category_id"
JOIN "film" "f" ON "f"."film_id" = "fc"."film_id"
JOIN "inventory" "i" ON "i"."film_id" = "f"."film_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
GROUP BY "c"."name"
ORDER BY "count" DESC, "c"."name"
LIMIT 5;

-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT "f"."title", COUNT(*)
FROM "film" "f"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
JOIN "inventory" "i" ON "i"."film_id" = "f"."film_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
WHERE "c"."name" = 'Action'
GROUP BY "f"."title"
ORDER BY "count" DESC, "f"."title"
LIMIT 5;

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals)
SELECT "a"."first_name"||' '||"a"."last_name" AS "name", COUNT(*)
FROM "actor" "a"
JOIN "film_actor" "fa" ON "fa"."actor_id" = "a"."actor_id"
JOIN "film" "f" ON "f"."film_id" = "fa"."film_id"
JOIN "inventory" "i" ON "i"."film_id" = "f"."film_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
GROUP BY "a"."actor_id"
ORDER BY "count" DESC, "name"
LIMIT 10;

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
SELECT "a"."first_name"||' '||"a"."last_name" AS "name", COUNT(*)
FROM "actor" "a"
JOIN "film_actor" "fa" ON "fa"."actor_id" = "a"."actor_id"
JOIN "film" "f" ON "f"."film_id" = "fa"."film_id"
JOIN "film_category" "fc" ON "fc"."film_id" = "f"."film_id"
JOIN "category" "c" ON "c"."category_id" = "fc"."category_id"
JOIN "inventory" "i" ON "i"."film_id" = "f"."film_id"
JOIN "rental" "r" ON "r"."inventory_id" = "i"."inventory_id"
WHERE "c"."name" = 'Comedy'
GROUP BY "a"."actor_id"
ORDER BY "count" DESC, "name"
LIMIT 5;