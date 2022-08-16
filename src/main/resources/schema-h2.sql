CREATE TABLE location
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(255),
    city    VARCHAR(255),
    street  VARCHAR(255),
    zip_code VARCHAR(50),
    status  VARCHAR(50)
);

CREATE TABLE factory
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255),
    description VARCHAR(255),
    latitude    double,
    longitude   double,
    status      VARCHAR(50),
    location_id    VARCHAR(50)
);