use db_proj;

CREATE TABLE educator
(
    id     INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(255) NOT NULL UNIQUE,
    school INT,
    FOREIGN KEY (school) REFERENCES school (id)
);

CREATE TABLE school
(
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES country(id) ON DELETE CASCADE
);

CREATE TABLE course
(
    id       VARCHAR(255) NOT NULL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    school   VARCHAR(255) NOT NULL ,
    educator INT          NOT NULL,
    FOREIGN KEY (school) REFERENCES school (id),
    FOREIGN KEY (educator) REFERENCES educator (id)
);
CREATE TABLE student
(
    id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255)    NOT NULL,
    country INT,
    school  VARCHAR(255),
    course  VARCHAR(255),
    FOREIGN KEY (country) REFERENCES country (id),
    FOREIGN KEY (school) REFERENCES school (id),
    FOREIGN KEY (course) REFERENCES course (id)
);

INSERT INTO student(name, country, school, course)
VALUES ('Harry Potter', 2, 'Hogwarts', 'PV2104'),
       ('Ron Weasley', 2, 'Hogwarts', 'PV2101'),
       ('Hermione Granger', 2, 'Hogwarts', 'PV2301'),
       ('Neville Longbottom', 2, 'Hogwarts', 'PV2400'),
       ('Luna Lovegood', 2, 'Hogwarts', 'PV2205'),
       ('Fred Weasley', 2, 'Hogwarts', 'PV2206'),
       ('George Weasley', 2, 'Hogwarts', 'PV2102'),
       ('Ginny Weasley', 2, 'Hogwarts', 'PV2203'),
       ('Cho Chang', 2, 'Hogwarts', 'PV2500'),

       ('Nicolas Flamel', 3, 'Beauxbatons', 'PV2104'),
       ('Aurélie Dumont', 3, 'Beauxbatons', 'PV2101'),
       ('Celine Castillon', 3, 'Beauxbatons', 'PV2301'),
       ('Fleur Delacour', 3, 'Beauxbatons', 'PV2400'),
       ('Gabrielle Delacour', 3, 'Beauxbatons', 'PV2205'),
       ('Élise Martin', 3, 'Beauxbatons', 'PV2206'),
       ('Sylvie Garnier', 3, 'Beauxbatons', 'PV2102'),
       ('Perenelle Flamel', 3, 'Beauxbatons', 'PV2203'),
       ('Luc Millefeuille', 3, 'Beauxbatons', 'PV2500'),

       ('Gellert Grindelwald', 1, 'Durmstrang', 'PV2104'),
       ('Viktor Krum', 1, 'Durmstrang', 'PV2101'),
       ('Pieter Talli', 1, 'Durmstrang', 'PV2301'),
       ('Grozdan Petkov', 1, 'Durmstrang', 'PV2400'),
       ('Baglan Wellnelly', 1, 'Durmstrang', 'PV2205'),
       ('Davyd Zakon', 1, 'Durmstrang', 'PV2206'),
       ('Karkaroff''s Aide', 1, 'Durmstrang', 'PV2102'),
       ('Vasil Stena', 1, 'Durmstrang', 'PV2203'),
       ('Áillun Wärnach', 1, 'Durmstrang', 'PV2500');

INSERT INTO course
VALUES
    ('PV2104', 'Management of Magical Creatures and Artifacts','Hogwarts',1),
    ('PV2101', 'Strategic Spellcasting for Resource Management','Hogwarts',1),
    ('PV2301', 'Research Theories and Enchanted Methods','Hogwarts',1),
    ('PV2400', 'Wizarding Resource Management Apprenticeship','Beauxbatons',2),
    ('PV2205', 'Conflict and Collaboration in Magical Alliances','Beauxbatons',2),
    ('PV2206', 'Advanced Divination and Muggle Analytics','Beauxbatons',2),
    ('PV2102', 'Sustainable Magical Leadership','Beauxbatons',2),
    ('PV2203', 'Challenges in Strategic Spell and Potion Management','Durmstrang',3),
    ('PV2500', 'Master Thesis in Enchanted Resource Relations','Durmstrang',3),
    ('PV2800', 'Defense Against the Magical Resource Arts','Durmstrang',1),
    ('PV2240', 'Advanced Transfiguration for Resource Optimization','Hogwarts',2),
    ('PV2601', 'Charms and Enchantments for Organizational Success','Hogwarts',2);

INSERT INTO educator(name, school)
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
