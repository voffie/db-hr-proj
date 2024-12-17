use db_proj;

CREATE TABLE educator
(
    id   INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE courses
(
    id varchar(255) NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    school INT NOT NULL,
    educator INT NOT NULL,
    FOREIGN KEY (school) REFERENCES school(id),
    FOREIGN KEY (educator) REFERENCES educator(id)
);

INSERT courses -- lägg till educator + school
VALUES ('PV2104','Human Resource Management in a Societal Perspective'),
       ('PV2101','Strategic Human Resource Management'),
       ('PV2301', 'Research Theories and Methods'),
       ('PV2400','Human resource and management work placement'),
       ('PV2205',' Conflict and Collaboration in Organisations'),
       ('PV2206','People Analytics'),
       ('PV2102','Sustainable leadership'),
       ('PV2203','Challenges in Strategic Human Resource Management'),
       ('PV2500','Master Thesis in Strategic HRM and Labour relations');

SELECT * FROM courses;

UPDATE courses
SET name = 'Updated HR Management in a Societal Perspective'
WHERE id = 'PV2104';

DELETE FROM courses
WHERE id = 'PV2301';