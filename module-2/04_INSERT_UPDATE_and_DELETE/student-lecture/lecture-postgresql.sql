-- INSERT

-- 1. Add Klingon as a spoken language in the USA
INSERT INTO "countrylanguage"
("countrycode", "language", "isofficial", "percentage")
VALUES('USA', 'Klingon', false, 0.0001);

-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO "countrylanguage"
--("countrycode", "language", "isofficial", "percentage")
VALUES('GBR', 'Klingon', false, 0.001);


-- UPDATE

-- 1. Update the capital of the USA to Houston
select country.capital, country.name, city.name, country.headofstate from country left join city on country.code = city.countrycode and country.capital = city.id where code = 'USA';

UPDATE "country"
SET "capital" = (
                 SELECT "id"
                 FROM "city"
                 WHERE "city"."name" = 'Houston' AND "city"."countrycode" = 'USA'
)
WHERE "country"."code" = 'USA'
;

-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE "country"
SET "capital" = (
                 SELECT "id"
                 FROM "city"
                 WHERE "city"."name" = 'Washington' AND "city"."countrycode" = 'USA'
), "headofstate" = 'Cheeto Head'
WHERE "country"."code" = 'USA'
;

-- DELETE

-- 1. Delete English as a spoken language in the USA
DELETE FROM "countrylanguage"
WHERE "countrylanguage"."countrycode" = 'USA' AND "countrylanguage"."language" = 'English';

SELECT * FROM "countrylanguage" WHERE "countrylanguage"."countrycode" = 'USA';

-- 2. Delete all occurrences of the Klingon language 
DELETE FROM "countrylanguage" WHERE "language" = 'Klingon';


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.
INSERT INTO "countrylanguage" 
       ("language")
VALUES('Elvish');

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO "countrylanguage"
        ("countrycode", "language", "isofficial", "percentage")
VALUES  ('ZZZ',         'English', false, 0.1);

-- 3. Try deleting the country USA. What happens?
DELETE FROM "country"
WHERE "code" = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO "countrylanguage"
VALUES( 'USA', 'English', true, 87);

-- 2. Try again. What happens?
INSERT INTO "countrylanguage"
VALUES( 'USA', 'English', true, 87);

-- 3. Let's relocate the USA to the continent - 'Outer Space'
UPDATE "country"
SET "continent" = 'Outer Space'
WHERE "code" = 'USA';

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;

SELECT con.*
       FROM pg_catalog.pg_constraint con
            INNER JOIN pg_catalog.pg_class rel
                       ON rel.oid = con.conrelid
            INNER JOIN pg_catalog.pg_namespace nsp
                       ON nsp.oid = connamespace;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
DELETE FROM "countrylanguage";
SELECT * FROM "countrylanguage";
ROLLBACK;



-- 2. Try updating all of the cities to be in the USA and roll it back
SELECT * FROM "city";
UPDATE "city" SET "countrycode" = 'USA';
ROLLBACK;

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.

-- it has been demonstrated



