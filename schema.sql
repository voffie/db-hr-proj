use db_proj;

CREATE TABLE educator
(
    id   INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
)

CREATE TABLE school
(
    id VARCHAR NOT NULL PRIMARY KEY,
    namne VARCHAR(255)
    contry_id BIGINT NOT NULL,
    FOREIGN KEY (contry_id) REFERENCES country(id) ON DELETE CASCADE
)