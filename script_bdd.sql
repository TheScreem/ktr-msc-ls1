-- Table: public.card

-- DROP TABLE public.card;

CREATE TABLE public.card
(
    name character varying(50) COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('seq_card_id'::regclass),
    email character varying(100) COLLATE pg_catalog."default",
    company_name character varying(100) COLLATE pg_catalog."default",
    phone_number character varying(10) COLLATE pg_catalog."default",
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Card_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.card
    OWNER to postgres;

-- SEQUENCE: public.seq_card_id

-- DROP SEQUENCE public.seq_card_id;

CREATE SEQUENCE public.seq_card_id
INCREMENT 1
START 7
MINVALUE 1
MAXVALUE 999999
CACHE 1;

ALTER SEQUENCE public.seq_card_id
OWNER TO postgres;

INSERT INTO public.card(name, email, company_name, phone_number, password)
VALUES ('John', 'john@gmail.com', 'Google', '0102030405', MD5('password'));
