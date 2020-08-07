CREATE DATABASE web_cars
    WITH
    OWNER = cars_web
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


CREATE TABLE customer
(
    id         SERIAL,
    first_name character varying(50)  NOT NULL,
    last_name  character varying(50)  NOT NULL,
    email      character varying(50)  NOT NULL,
    password   character varying(200) NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id),
    CONSTRAINT customer_email_uniqe UNIQUE (email)
);

INSERT INTO customer (password, first_name, last_name, email) VALUES ('password', 'David', 'Adams', 'admin@job4j.com');
INSERT INTO customer (password, first_name, last_name, email) VALUES ('password', 'John', 'Doe', 'john@job4j.com');
INSERT INTO customer (password, first_name, last_name, email) VALUES ('password', 'Ajay', 'Rao', 'ajay@job4j.com');
INSERT INTO customer (password, first_name, last_name, email) VALUES ('password', 'Mary', 'Public', 'mary@job4j.com');


drop table ad;
drop table marital_status;
drop table genders;

CREATE TABLE genders
(
    language    CHARACTER VARYING(3)  NOT NULL,
    gender      CHARACTER VARYING(2)  NOT NULL,
    gender_name CHARACTER VARYING(50) NOT NULL,
    CONSTRAINT genders_pk PRIMARY KEY (language, gender)
);

INSERT INTO genders(language, gender, gender_name) VALUES ('en', 'm', 'man');
INSERT INTO genders(language, gender, gender_name) VALUES ('en', 'w', 'woman');
INSERT INTO genders(language, gender, gender_name) VALUES ('ru', 'm', 'мужчина');
INSERT INTO genders(language, gender, gender_name) VALUES ('ru', 'w', 'женщина');


CREATE TABLE marital_status
(
    marital_status_id                          int,
    language        CHARACTER VARYING(3)  NOT NULL,
    gender          CHARACTER(1)          NOT NULL,
    status_name     CHARACTER VARYING(50) NOT NULL,
    CONSTRAINT marital_status_pk PRIMARY KEY (marital_status_id, language, gender)
);

ALTER TABLE marital_status ADD CONSTRAINT marital_status_fk_01 FOREIGN KEY (language, gender)  REFERENCES genders (language, gender);


INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (0, 'ru', 'm', 'не выбрано');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (1, 'ru', 'm', 'не женат (и не был)');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (2, 'ru', 'm', 'разведен');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (3, 'ru', 'm', 'вдовец');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (4, 'ru', 'm', 'разошлись, разводимся');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (5, 'ru', 'm', 'женат');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (0, 'ru', 'w', 'не выбрано');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (1, 'ru', 'w', 'не замужем (и не была)');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (2, 'ru', 'w', 'разведена');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (3, 'ru', 'w', 'вдова');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (4, 'ru', 'w', 'разошлись, разводимся');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (5, 'ru', 'w', 'за мужем');

INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (0, 'en', 'm', 'not selected');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (1, 'en', 'm', 'single / never married');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (2, 'en', 'm', 'divorced');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (3, 'en', 'm', 'widower');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (4, 'en', 'm', 'separated');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (5, 'en', 'm', 'married');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (0, 'en', 'w', 'not selected');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (1, 'en', 'w', 'single / never married');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (2, 'en', 'w', 'divorced');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (3, 'en', 'w', 'widow');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (4, 'en', 'w', 'separated');
INSERT INTO marital_status (marital_status_id, language, gender, status_name) VALUES (5, 'en', 'w', 'married');


CREATE TABLE ad
(
    customer_id SERIAL,
    language                CHARACTER VARYING(3)    NOT NULL,
    gender                  CHARACTER(1)            NOT NULL,
    ad_nickname             CHARACTER VARYING(100)  NOT NULL,
    marital_status_id       INTEGER                 NOT NULL DEFAULT 0,
    CONSTRAINT ad_pk PRIMARY KEY (customer_id)
);

ALTER TABLE ad ADD CONSTRAINT ad_fk_01 FOREIGN KEY (marital_status_id, language, gender)  REFERENCES marital_status (marital_status_id, language, gender);
ALTER TABLE ad ADD CONSTRAINT ad_fk_02 FOREIGN KEY (gender)  REFERENCES genders (language, gender);

INSERT INTO ad (language, gender, ad_nickname, marital_status_id) VALUES ('ru', 'm', 'Вася', '2');
INSERT INTO ad (language, gender, ad_nickname, marital_status_id) VALUES ('ru', 'w', 'Васелиса', '3');
INSERT INTO ad (language, gender, ad_nickname, marital_status_id) VALUES ('en', 'm', 'Jhon', '4');
INSERT INTO ad (language, gender, ad_nickname, marital_status_id) VALUES ('en', 'w', 'Vanessa', '5');