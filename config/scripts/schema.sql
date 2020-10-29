CREATE DATABASE "hoag-dev"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE ROLE userdev WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	NOREPLICATION
	CONNECTION LIMIT 10
	PASSWORD 'userdev';

GRANT ALL ON DATABASE "hoag-dev" TO userdev WITH GRANT OPTION;

CREATE SCHEMA "ft000"
    AUTHORIZATION postgres;

CREATE SEQUENCE ft000."seq-user"
    INCREMENT 1
    START 0
    MINVALUE 0
    MAXVALUE 1000000;

ALTER SEQUENCE ft000."seq-user"
    OWNER TO postgres;

CREATE TABLE "ft000"."users"
(
    id bigint NOT NULL,
    login character varying(12),
    password character varying(30),
    email character varying(128),
    CONSTRAINT "Users_pkey" PRIMARY KEY (id)
)

    TABLESPACE pg_default;

