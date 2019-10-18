BEGIN TRANSACTION;

CREATE TABLE "customer" (
        "customer_id" SERIAL,
        "first_name" VARCHAR(100) NOT NULL,
        "last_name" VARCHAR(100) NOT NULL,
        "phone" VARCHAR(20),

        CONSTRAINT "pk_customer" PRIMARY KEY("customer_id")
);

CREATE TABLE "artist" (
        "artist_id" SERIAL,
        "first_name" VARCHAR(100) DEFAULT 'Anonymous',
        "last_name" VARCHAR(100) DEFAULT 'Anonymous',
        
        CONSTRAINT "pk_artist" PRIMARY KEY("artist_id")
);

CREATE TABLE "painting" (
        "painting_id" SERIAL,
        "title" VARCHAR(512) NOT NULL DEFAULT 'Untitled.',
        "artist_id" INT NOT NULL,
        
        CONSTRAINT "pk_painting" PRIMARY KEY("painting_id"),
        CONSTRAINT "fk_artist_id" FOREIGN KEY("artist_id") REFERENCES "artist" ("artist_id")
);

CREATE TABLE "sale" (
        "customer_id" INT NOT NULL,
        "painting_id" INT NOT NULL,
        "sale_date" TIMESTAMP NOT NULL,
        "sale_price" MONEY NOT NULL,
        
        CONSTRAINT "pk_sale" PRIMARY KEY("customer_id", "painting_id", "sale_date"),
        CONSTRAINT "fk_sale_customer_id" FOREIGN KEY("customer_id") REFERENCES "customer" ("customer_id"),
        CONSTRAINT "fk_sale_painting_id" FOREIGN KEY("painting_id") REFERENCES "painting" ("painting_id")
);

COMMIT;