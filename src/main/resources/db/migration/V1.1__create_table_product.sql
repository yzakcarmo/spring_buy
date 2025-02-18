CREATE SEQUENCE IF NOT EXISTS seq_category
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE IF NOT EXISTS category (
    id              INTEGER NOT NULL DEFAULT nextval('seq_category'),
    name            varchar(50) NOT NULL UNIQUE,
    description     varchar(50) NOT NULL UNIQUE,
    price           numeric(10,2),
    category_id     INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id)  REFERENCES category(id)
);