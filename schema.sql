use db_proj;

CREATE TABLE educator
(
    id   INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

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
