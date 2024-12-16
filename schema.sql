use db_proj;

CREATE TABLE educator
(
    id   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE student (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) FOREIGN KEY (country) REFERENCES country(id),
    school VARCHAR(255) FOREIGN KEY (school) REFERENCES school(id),
    course VARCHAR(255) FOREIGN KEY (course) REFERENCES course(id)
);

INSERT INTO student(name, country, school, course)
VALUES ('Harry Potter', 'England', '', ''),
       ('Ron Weasley', 'England', '', ''),
       ('Hermione Granger', 'England', '', ''),
       ('Neville Longbottom', 'England', '', ''),
       ('Luna Lovegood', 'England', '', ''),
       ('Fred Weasley', 'England', '', ''),
       ('George Weasley', 'England', '', ''),
       ('Ginny Weasley', 'England', '', ''),
       ('Cho Chang', 'England', '', ''),

       ('Nicolas Flamel', 'France', '', ''),
       ('Aurélie Dumont', 'France', '', ''),
       ('Celine Castillon', 'France', '', ''),
       ('Fleur Delacour', 'France', '', ''),
       ('Gabrielle Delacour', 'France', '', ''),
       ('Élise Martin', 'France', '', ''),
       ('Sylvie Garnier', 'France', '', ''),
       ('Perenelle Flamel', 'France', '', ''),
       ('Luc Millefeuille', 'France', '', ''),

       ('Malin Matsdotter', 'Sweden', '', ''),
       ('Gertrud Svensdotter', 'Sweden', '', ''),
       ('Märit Jonsdotter', 'Sweden', '', ''),
       ('Elisabetta Näs', 'Sweden', '', ''),
       ('Margareta Nilsdotter', 'Sweden', '', ''),
       ('Anna Olsdotter', 'Sweden', '', ''),
       ('Anna Månsdotter', 'Sweden', '', ''),
       ('Britta Sippel', 'Sweden', '', ''),
       ('Anna Sippel', 'Sweden', '', '');

