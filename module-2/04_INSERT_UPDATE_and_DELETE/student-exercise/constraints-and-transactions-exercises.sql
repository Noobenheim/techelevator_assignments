-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO "actor" ("first_name", "last_name")
        VALUES      ('HAMPTON',    'AVENUE'),
                    ('LISA',       'BYWAY')
;

-- Verify it's in there
SELECT "actor_id", "first_name" || ' ' || "last_name" AS "name"
FROM "actor" WHERE "first_name" IN('HAMPTON', 'LISA') AND "last_name" IN('AVENUE', 'BYWAY');

--DELETE FROM "actor" WHERE "first_name" = 'HAMPTON' AND "last_name" = 'AVENUE';
--DELETE FROM "actor" WHERE "first_name" = 'LISA' AND "last_name" = 'BYWAY';

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
INSERT INTO "film" ("title", "description", "release_year", "language_id", "length")
VALUES('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008,
-- get English ID
(SELECT "language_id" FROM "language" WHERE "name" = 'English'),
((3*60)+18)
)
;

-- Verify it's there
SELECT * FROM "film" WHERE "title" = 'Euclidean PI';

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
INSERT INTO "film_actor" ("actor_id", "film_id") VALUES
        ( (SELECT "actor_id" FROM "actor" WHERE "first_name" = 'HAMPTON' AND "last_name" = 'AVENUE'),
          (SELECT "film_id" FROM "film" WHERE "title" = 'Euclidean PI') ),
        ( (SELECT "actor_id" FROM "actor" WHERE "first_name" = 'LISA' AND "last_name" = 'BYWAY'),
          (SELECT "film_id" FROM "film" WHERE "title" = 'Euclidean PI') )
;

-- Verify it's there
SELECT "film_actor"."actor_id", "actor"."first_name" || ' ' || "actor"."last_name" AS "name", "film"."title"
FROM "actor"
JOIN "film_actor" USING("actor_id")
JOIN "film" USING("film_id")
WHERE "film"."title" = 'Euclidean PI';

-- 4. Add Mathmagical to the category table.
INSERT INTO "category" ("name") VALUES('Mathmagical');

-- Verify it's there
SELECT * FROM "category" WHERE "name" = 'Mathmagical';

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO "film_category" ("film_id", "category_id")
        (SELECT "film"."film_id", "category"."category_id"
        FROM "category", "film"
        WHERE "category"."name" = 'Mathmagical'
        AND "film"."title" IN('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE')
        )
;

-- Verify it's there
SELECT *
FROM "film_category"
JOIN "category" USING("category_id")
JOIN "film" USING("film_id")
WHERE "name" = 'Mathmagical';

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
UPDATE "film"
SET "rating" = 'G'
WHERE "film_id" IN (
        SELECT "film_id" FROM "film_category"
        JOIN "category" USING("category_id")
        WHERE "category"."name" = 'Mathmagical'
);

-- Verify it's there
SELECT *
FROM "film_category"
JOIN "category" USING("category_id")
JOIN "film" USING("film_id")
WHERE "name" = 'Mathmagical';


-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO "inventory" ("film_id", "store_id") 
        (SELECT DISTINCT "film"."film_id", "store"."store_id"
         FROM "store", "film"
         WHERE "film"."title" = 'Euclidean PI'
        )
;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
DELETE FROM "film"
WHERE "title" = 'Euclidean PI';
-- "film_id" is a foreign key for the "film_actor" table

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
DELETE FROM "category"
WHERE "name" = 'Mathmagical';
-- "category_id" is a foreign key for the "film_category" table

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
DELETE FROM "film_category"
WHERE "category_id" = (SELECT "category_id" FROM "category" WHERE "name" = 'Mathmagical');
-- It did succeed because there's no foreign key references needed outside this table

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
DELETE FROM "category"
WHERE "name" = 'Mathmagical';
-- Deleting Mathmagical was successful because the foreign key was removed from "film_category"
DELETE FROM "film"
WHERE "title" = 'Euclidean PI';
-- Deleting Euclidean PI did not succeed because there's still a foreign key restraint on "film_actor"

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
SELECT "constraint_name", "tc"."table_name", "tc"."constraint_type" AS "Constraint Table", "ccu"."table_name" AS "Constraint Column Table", "column_name" AS "Constraint Column", "unique_constraint_name"
FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS "tc"
JOIN INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE "ccu" USING("constraint_name")
JOIN INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS "rc" USING("constraint_name")
WHERE "ccu"."table_name" = 'film';

-- film_actor_film_id_fkey for "film_actor" needs to be resolved
DELETE FROM "film_actor"
WHERE "film_id" = (SELECT "film_id" FROM "film" WHERE "title" = 'Euclidean PI');
-- film_category_film_id_fkey is also a foreign key constraint, but we removed that category in #11
-- inventory_film_id_fkey for "inventory" needs to be resolved
DELETE FROM "inventory"
WHERE "film_id" = (SELECT "film_id" FROM "film" WHERE "title" = 'Euclidean PI');
-- now we can successfully remove from "film"
DELETE FROM "film"
WHERE "title" = 'Euclidean PI';