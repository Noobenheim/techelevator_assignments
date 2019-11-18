-- INSERT

-- 1. Add Klingon as a spoken language in the USA
--INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA',      'Klingon',    false,       0.0001);

INSERT INTO countrylanguage (isofficial, percentage, countrycode,     language)
                       VALUES (false,        0.01,      'USA',     'Elvish');

SELECT * 
FROM countrylanguage
WHERE countrycode = 'USA'
;

-- 2. Add Klingon as a spoken language in Great Britain
INSERT INTO countrylanguage VALUES ('GBR', 'Klingon', false, 0.001);

SELECT * 
FROM countrylanguage
WHERE countrycode = 'GBR'
;

-- UPDATE

-- 1. Update the capital of the USA to Houston

UPDATE country
SET capital = 3796
WHERE code = 'AFG'
;

SELECT *  
FROM country
;

SELECT * FROM city WHERE id = 3813; -- Washington, DC
SELECT * FROM city WHERE name = 'Pittsburgh'; -- id: 3796 (Houston), id: 3844 (Pittsburgh)

-- 2. Update the capital of the USA to Washington DC and the head of state
UPDATE country
SET capital = 3844, headofstate = 'Lil'' Wayne'
WHERE code = 'USA'
;

SELECT *  
FROM country
WHERE code = 'USA'
;


-- DELETE

-- 1. Delete English as a spoken language in the USA
SELECT * FROM countrylanguage WHERE countrycode = 'USA';
SELECT * FROM countrylanguage WHERE countrycode = 'USA' AND language = 'English';


DELETE 
FROM countrylanguage
WHERE countrycode = 'USA' AND language = 'English'
; 


-- 2. Delete all occurrences of the Klingon language 
DELETE
FROM countrylanguage
WHERE language = 'Klingon';




-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvis to the country language table.
SELECT * FROM countrylanguage;
INSERT INTO countrylanguage (language) VALUES ('Elvis');




-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage) VALUES ('English', 'ZZZ', false, 0.1);



-- 3. Try deleting the country USA. What happens?
DELETE FROM country
WHERE code = 'USA';





-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
INSERT INTO countrylanguage VALUES ('USA', 'English', true, 87);
SELECT * FROM countrylanguage;

-- 2. Try again. What happens?
INSERT INTO countrylanguage VALUES ('USA', 'English', true, 87);


-- 3. Let's relocate the USA to the continent - 'Outer Space'
SELECT * FROM country WHERE code = 'USA';
UPDATE country
SET continent = 'Outer Space', headofstate = 'Los Locos'
WHERE code = 'USA';


-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.
DELETE FROM countrylanguage;
SELECT * FROM countrylanguage;
ROLLBACK;


-- 2. Try updating all of the cities to be in the USA and roll it back

SELECT * FROM city ORDER BY id DESC;
UPDATE city SET countrycode = 'USA';



-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.

ROLLBACK;

INSERT INTO city VALUES (4080, 'Tomland', 'USA', 'Pittsburgh', 1);
