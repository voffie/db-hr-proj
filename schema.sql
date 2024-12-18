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
    school VARCHAR(255) NOT NULL,
    educator INT NOT NULL,
    FOREIGN KEY (school) REFERENCES school(id),
    FOREIGN KEY (educator) REFERENCES educator(id)
);

INSERT courses -- lägg till educator + school
VALUES ('PV2104','Magic Resource Management in a Societal Perspective','Hogwarts' ,),
       ('PV2101','Strategic Magic Resource Management','Hogwarts' ,),
       ('PV2301', 'Research Theories and Methods','Hogwarts' ,),
       ('PV2400','Magic resource and management work placement','Beauxbatons' ,),
       ('PV2205',' Conflict and Collaboration in Organisations','Beauxbatons' ,),
       ('PV2206','Magic Analytics','Beauxbatons' ,),
       ('PV2102','Sustainable leadership','Beauxbatons' ,),
       ('PV2203','Challenges in Strategic Human Resource Management','Durmstrang' ,),
       ('PV2500','Master Thesis in Strategic HRM and Labour relations','Durmstrang' ,);

SELECT * FROM courses;

UPDATE courses
SET name = 'Updated HR Management in a Societal Perspective'
WHERE id = 'PV2104';

DELETE FROM courses
WHERE id = 'PV2301';