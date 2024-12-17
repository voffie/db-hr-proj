use db_proj;

CREATE TABLE educator
(
    id     INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(255) NOT NULL UNIQUE,
    school INT,
    FOREIGN KEY (school) REFERENCES school (id)
);

INSERT INTO educator(name, school)
VALUES ('Albus Dumbledore', 1),
       ('Hagrid', 2),
       ('Severus Snape', 3);

CREATE TABLE country
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

INSERT INTO country(name)
VALUES('Sweden'),
      ('Denmark'),
      ('France');

SELECT * FROM country;
