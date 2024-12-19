use db_proj;

CREATE TABLE country
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE school
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE,
    country_id INT,
    FOREIGN KEY (country_id) REFERENCES country(id) ON DELETE CASCADE
);

CREATE TABLE educator
(
    id     INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(255) NOT NULL UNIQUE,
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES school (id)
);

CREATE TABLE course
(
    id       VARCHAR(255) NOT NULL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL UNIQUE,
    school_id   INT NOT NULL ,
    educator_id INT          NOT NULL,
    FOREIGN KEY (school_id) REFERENCES school (id),
    FOREIGN KEY (educator_id) REFERENCES educator (id)
);

CREATE TABLE student
(
    id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255)    NOT NULL,
    country_id INT,
    school_id  INT,
    course_id  VARCHAR(255),
    FOREIGN KEY (country_id) REFERENCES country (id),
    FOREIGN KEY (school_id) REFERENCES school (id),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

INSERT INTO country(name)
VALUES('Sweden'),
      ('England'),
      ('France');

INSERT INTO school(name, country_id)
VALUES ('Hogwarts', 2), ('Beauxbatons', 3), ('Durmstrang', 1);

INSERT INTO educator(name, school_id)
VALUES ('Albus Dumbledore', 1),
       ('Hagrid', 2),
       ('Severus Snape', 3);

INSERT INTO course(id, name, school_id, educator_id)
VALUES
    ('PV2104', 'Management of Magical Creatures and Artifacts',1,1),
    ('PV2101', 'Strategic Spellcasting for Resource Management',1,1),
    ('PV2301', 'Research Theories and Enchanted Methods',1,1),
    ('PV2400', 'Wizarding Resource Management Apprenticeship',2,2),
    ('PV2205', 'Conflict and Collaboration in Magical Alliances',2,2),
    ('PV2206', 'Advanced Divination and Muggle Analytics',2,2),
    ('PV2102', 'Sustainable Magical Leadership',2,2),
    ('PV2203', 'Challenges in Strategic Spell and Potion Management',3,3),
    ('PV2500', 'Master Thesis in Enchanted Resource Relations',3,3),
    ('PV2800', 'Defense Against the Magical Resource Arts',3,1),
    ('PV2240', 'Advanced Transfiguration for Resource Optimization',1,2),
    ('PV2601', 'Charms and Enchantments for Organizational Success',1,2);

INSERT INTO student(name, country_id, school_id, course_id)
VALUES ('Harry Potter', 2, 1, 'PV2800'),
       ('Ron Weasley', 2, 1, 'PV2800'),
       ('Hermione Granger', 2, 1, 'PV2800'),
       ('Neville Longbottom', 2, 1, 'PV2240'),
       ('Luna Lovegood', 2, 1, 'PV2240'),
       ('Fred Weasley', 2, 1, 'PV2240'),
       ('George Weasley', 2, 1, 'PV2601'),
       ('Ginny Weasley', 2, 1, 'PV2601'),
       ('Cho Chang', 2, 1, 'PV2601'),

       ('Nicolas Flamel', 3, 2, 'PV2400'),
       ('Aurélie Dumont', 3, 2, 'PV2400'),
       ('Celine Castillon', 3, 2, 'PV2400'),
       ('Fleur Delacour', 3, 2, 'PV2205'),
       ('Gabrielle Delacour', 3, 2, 'PV2205'),
       ('Élise Martin', 3, 2, 'PV2205'),
       ('Sylvie Garnier', 3, 2, 'PV2102'),
       ('Perenelle Flamel', 3, 2, 'PV2102'),
       ('Luc Millefeuille', 3, 2, 'PV2102'),

       ('Gellert Grindelwald', 1, 3, 'PV2104'),
       ('Viktor Krum', 1, 3, 'PV2104'),
       ('Pieter Talli', 1, 3, 'PV2104'),
       ('Grozdan Petkov', 1, 3, 'PV2101'),
       ('Baglan Wellnelly', 1, 3, 'PV2101'),
       ('Davyd Zakon', 1, 3, 'PV2101'),
       ('Karkaroff''s Aide', 1, 3, 'PV2301'),
       ('Vasil Stena', 1, 3, 'PV2301'),
       ('Áillun Wärnach', 1, 3, 'PV2301');

/* Elever per kurs -> COUNT */
SELECT c.id, COUNT(st.id) AS student_count
FROM course c
INNER JOIN student st on c.id = st.course_id
GROUP BY c.id;

/* Kurser per utbildare -> COUNT */
SELECT e.name, COUNT(c.id) AS course_count
FROM educator e
INNER JOIN course c on e.id = c.educator_id
GROUP BY e.name;

/* Skolor per land -> COUNT */
SELECT c.name, COUNT(sc.id) AS school_count
FROM country c
         INNER JOIN school sc on c.id = sc.country_id
GROUP BY c.name;
