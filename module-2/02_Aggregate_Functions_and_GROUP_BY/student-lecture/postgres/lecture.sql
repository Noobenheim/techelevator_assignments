-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT "population" FROM "country" ORDER BY "population" DESC;

--Names of countries and continents in ascending order
SELECT "name", "continent" FROM "country" ORDER BY "name" ASC, "continent" ASC;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT "name", "lifeexpectancy" AS "average life expectancy" FROM "country" WHERE "lifeexpectancy" IS NOT NULL ORDER BY "lifeexpectancy" DESC LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city
SELECT "name"||', '||"district" AS "City, State" FROM "city" WHERE "district" IN ('California', 'Oregon', 'Washington') ORDER BY "district", "name";

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG("lifeexpectancy") AS "Average Life Expectancy" FROM "country";

-- Total population in Ohio
SELECT SUM("population") AS "Total Population in Ohio" FROM "city" WHERE "district" = 'Ohio';

-- The surface area of the smallest country in the world
SELECT "name", "value" AS "smallest country surface area" FROM "country", (SELECT MIN("surfacearea") AS "value" FROM "country") AS "tmp" WHERE "surfacearea" = "value";

-- The 10 largest countries in the world
SELECT "name", "surfacearea"
FROM "country"
ORDER BY "surfacearea" DESC
LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT COUNT("code") AS "1991 Independence" FROM "country" WHERE "indepyear" = 1991;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least
SELECT "language", COUNT("language") AS "language count" FROM "countrylanguage" GROUP BY "language" ORDER BY "language count" DESC;

-- Average life expectancy of each continent ordered from highest to lowest
SELECT "continent", COALESCE(AVG("lifeexpectancy"),0) AS "Average Life Expectancy" FROM "country" GROUP BY "continent" ORDER BY "Average Life Expectancy" DESC;

-- Exclude Antarctica from consideration for average life expectancy
SELECT "continent", AVG("lifeexpectancy") AS "Average Life Expectancy" FROM "country" WHERE "lifeexpectancy" IS NOT NULL GROUP BY "continent" ORDER BY "Average Life Expectancy" DESC;

-- Sum of the population of cities in each state in the USA ordered by state name
SELECT "district", SUM("population") FROM "city" WHERE "countrycode" = 'USA' GROUP BY "district" ORDER BY "district";

-- The average population of cities in each state in the USA ordered by state name
SELECT "district", AVG("population") FROM "city" WHERE "countrycode" = 'USA' GROUP BY "district" ORDER BY "district";

-- SUBQUERIES
-- Find the names of cities under a given government leader
SELECT "name", "headofstate"
FROM "city",
     (SELECT DISTINCT "code", "headofstate" FROM "country" WHERE "headofstate" IS NOT NULL AND "headofstate" <> '') AS hoslist
WHERE "countrycode" = "code"
;



-- Find the names of cities whose country they belong to has not declared independence yet
SELECT "name"
FROM "city"
WHERE "countrycode" IN (
        SELECT code
        FROM "country"
        WHERE "indepyear" IS NULL
);




-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

-- Gets the MIN population and the MAX population from the city table.

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
