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
    school INT,
    course INT,
    FOREIGN KEY (country) REFERENCES country(id),
    FOREIGN KEY (school) REFERENCES school(id),
    FOREIGN KEY (course) REFERENCES course(id)
);

INSERT INTO student(name, country, school, course)
VALUES ('Harry Potter', 2, '', ''),
       ('Ron Weasley', 2, '', ''),
       ('Hermione Granger', 2, '', ''),
       ('Neville Longbottom', 2, '', ''),
       ('Luna Lovegood', 2, '', ''),
       ('Fred Weasley', 2, '', ''),
       ('George Weasley', 2, '', ''),
       ('Ginny Weasley', 2, '', ''),
       ('Cho Chang', 2, '', ''),

       ('Nicolas Flamel', 3, '', ''),
       ('Aurélie Dumont', 3, '', ''),
       ('Celine Castillon', 3, '', ''),
       ('Fleur Delacour', 3, '', ''),
       ('Gabrielle Delacour', 3, '', ''),
       ('Élise Martin', 3, '', ''),
       ('Sylvie Garnier', 3, '', ''),
       ('Perenelle Flamel', 3, '', ''),
       ('Luc Millefeuille', 3, '', ''),

       ('Malin Matsdotter', 1, '', ''),
       ('Gertrud Svensdotter', 1, '', ''),
       ('Märit Jonsdotter', 1, '', ''),
       ('Elisabetta Näs', 1, '', ''),
       ('Margareta Nilsdotter', 1, '', ''),
       ('Anna Olsdotter', 1, '', ''),
       ('Anna Månsdotter', 1, '', ''),
       ('Britta Sippel', 1, '', ''),
       ('Anna Sippel', 1, '', '');

