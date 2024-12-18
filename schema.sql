use db_proj;

CREATE TABLE educator
(
    id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE student (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country INT,
    school VARCHAR(255),
    course VARCHAR(255),
    FOREIGN KEY (country) REFERENCES country(id),
    FOREIGN KEY (school) REFERENCES school(id),
    FOREIGN KEY (course) REFERENCES course(id)
);

INSERT INTO student(name, country, school, course)
VALUES ('Harry Potter',2,'Hogwarts','PV2104'),
       ('Ron Weasley',2,'Hogwarts','PV2101'),
       ('Hermione Granger',2,'Hogwarts','PV2301'),
       ('Neville Longbottom',2,'Hogwarts','PV2400'),
       ('Luna Lovegood',2,'Hogwarts','PV2205'),
       ('Fred Weasley',2,'Hogwarts','PV2206'),
       ('George Weasley',2,'Hogwarts','PV2102'),
       ('Ginny Weasley',2,'Hogwarts','PV2203'),
       ('Cho Chang',2,'Hogwarts','PV2500'),

       ('Nicolas Flamel',3,'Beauxbatons','PV2104'),
       ('Aurélie Dumont',3, 'Beauxbatons','PV2101'),
       ('Celine Castillon',3,'Beauxbatons','PV2301'),
       ('Fleur Delacour',3,'Beauxbatons','PV2400'),
       ('Gabrielle Delacour',3, 'Beauxbatons','PV2205'),
       ('Élise Martin',3,'Beauxbatons','PV2206'),
       ('Sylvie Garnier',3, 'Beauxbatons','PV2102'),
       ('Perenelle Flamel',3,'Beauxbatons','PV2203'),
       ('Luc Millefeuille',3, 'Beauxbatons','PV2500'),

       ('Gellert Grindelwald',1,'Durmstrang','PV2104'),
       ('Viktor Krum',1, 'Durmstrang','PV2101'),
       ('Pieter Talli',1,'Durmstrang','PV2301'),
       ('Grozdan Petkov',1,'Durmstrang','PV2400'),
       ('Baglan Wellnelly',1,'Durmstrang','PV2205'),
       ('Davyd Zakon',1,'Durmstrang','PV2206'),
       ('Karkaroff''s Aide',1,'Durmstrang','PV2102'),
       ('Vasil Stena',1,'Durmstrang','PV2203'),
       ('Áillun Wärnach',1,'Durmstrang','PV2500');

