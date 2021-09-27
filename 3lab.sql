CREATE DATABASE IF NOT EXISTS student_project;
USE student_project; 

DROP TABLE IF EXISTS tour_has_hotel;
DROP TABLE IF EXISTS route_has_place;
DROP TABLE IF EXISTS tour;
DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS transport_type;
DROP TABLE IF EXISTS guide;
DROP TABLE IF EXISTS place;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS payment_type;


CREATE TABLE guide (
guide_id  INT NOT NULL AUTO_INCREMENT , 
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
telephone_number VARCHAR(12) NOT NULL,
PRIMARY KEY (guide_id)
)
ENGINE = InnoDB;

CREATE TABLE country (
 country_id  INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (country_id)
)
ENGINE = InnoDB;

CREATE TABLE hotel (
  hotel_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  rate INT NOT NULL,
  PRIMARY KEY (hotel_id)
  )
ENGINE = InnoDB;

CREATE TABLE city (
 city_id  INT NOT NULL AUTO_INCREMENT,
 hotel_id INT NOT NULL ,
 name VARCHAR(45) NOT NULL,
 country_id INT NOT NULL,
 PRIMARY KEY (city_id),
 INDEX fk_city_hotel_idx (hotel_id ASC) ,
  INDEX fk_city_country_idx (country_id ASC),
 CONSTRAINT fk_city_hotel
 FOREIGN KEY (hotel_id) 
 REFERENCES hotel (hotel_id),
 CONSTRAINT fk_city_country
 FOREIGN KEY (country_id)
 REFERENCES country (country_id)
)
ENGINE = InnoDB;

CREATE TABLE transport_type (
  transport_type_id  INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (transport_type_id)
  )
ENGINE = InnoDB;
CREATE TABLE  route (
  route_id  INT NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  guide_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (route_id),
  INDEX fk_route_guide_idx (guide_id ASC),
  CONSTRAINT fk_route_guide 
  FOREIGN KEY (guide_id) 
  REFERENCES guide(guide_id)
)
ENGINE = InnoDB;

CREATE TABLE place (
  place_id  INT NOT NULL AUTO_INCREMENT,
  city_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (place_id),
  CONSTRAINT fk_place_city 
  FOREIGN KEY (city_id) 
  REFERENCES city (city_id)
  )
ENGINE = InnoDB;
CREATE TABLE route_has_place (
  route_id  INT NOT NULL AUTO_INCREMENT,
  place_id INT NOT NULL,
  PRIMARY KEY (route_id, place_id),
  CONSTRAINT fk_route_has_place
    FOREIGN KEY (route_id)
    REFERENCES route (route_id),
  CONSTRAINT fk_route_has_place1
    FOREIGN KEY (place_id)
    REFERENCES place (place_id)
)
ENGINE = InnoDB;
CREATE TABLE payment_type(
payment_type_id INT NOT NULL AUTO_INCREMENT,
type VARCHAR(10) NOT NULL,
PRIMARY KEY (payment_type_id)
)
ENGINE = InnoDB;
CREATE TABLE  tour (
  tour_id INT NOT NULL AUTO_INCREMENT,
  transport_type_id INT NOT NULL,
  duration VARCHAR(45) NOT NULL,
  price_per_person DECIMAL(10,2) NOT NULL,
  date_of_departure DATE NOT NULL,
  next_departure_date DATE NOT NULL,
  route_id INT NOT NULL,
  payment_type_id INT NOT NULL,
  PRIMARY KEY (tour_id),
  INDEX fk_tour_transport_type_idx (transport_type_id ASC),
  INDEX fk_tour_route_idx (route_id ASC) ,
  CONSTRAINT fk_tour_transport_type
    FOREIGN KEY (transport_type_id)
    REFERENCES transport_type (transport_type_id),
  CONSTRAINT fk_tour_route
    FOREIGN KEY (route_id)
    REFERENCES route (route_id),
    CONSTRAINT fk_tour_payment_type
    FOREIGN KEY (payment_type_id)
    REFERENCES payment_type(payment_type_id)
)
ENGINE = InnoDB;

CREATE TABLE tour_has_hotel (
  tour_id INT NOT NULL AUTO_INCREMENT,
  hotel_id INT NOT NULL,
  PRIMARY KEY (tour_id, hotel_id),
  CONSTRAINT fk_tour_has_hotel_tour
    FOREIGN KEY (tour_id)
    REFERENCES tour (tour_id),
  CONSTRAINT fk_tour_has_hotel_hotel
    FOREIGN KEY (hotel_id)
    REFERENCES hotel (hotel_id)
)
ENGINE = InnoDB;


INSERT INTO transport_type VALUES (1,'cruise'),(2,'car'),(3,'train'),(4,'plane'),(5,'pedestrian'),(6,'bus');
INSERT INTO country VALUES (1,'Ukraine'),(2,'Poland'),(3,'Itally'),(4,'France'),(5,'Spain'),(6,'Germany'),(7,'Egypt'),(8,'Albania'),(9,'USA'),(10,'Japan');
INSERT INTO hotel VALUES (1,'Hypnos',5),(2,'Iris',3),(3,'Azul',8),(4,'Ebony',6),(5,'Altheda',1),(6,'Aurelia',5),(7,'Citrus',4),(8,'Xanthe',9),(9,'Saros',10),(10,'Ceilo',7);
INSERT INTO city VALUES (1,3,'Paris',4),(2,5,'Kyiv',1),(3,2,'Warsaw',2),(4,4,'Berlin',6),(5,3,'Kair',7),(6,5,'California',9),(7,1,'Tokio',10),(8,6,'Rome',3),(9,9,'Madrid',5),(10,10,'Lublin',2);
INSERT INTO guide VALUES (1,'Velva','Gilbert','3806595652'),(2,'Jose','Brown','3809055415'),(3,'Mary','Levey','3856120021'),(4,'Sue','Bartz','3805646432'),(5,'Richard','Mullins','3806564151'),(6,'Adrienne','Sena','4804656210'),(7,'Danny','Gaytan','7809095225'),(8,'Joan','Miller','4452024875'),(9,'Dorothy','Scanlon','4809907252'),(10,'Glenda','Merz','3806584562');
INSERT INTO place VALUES (1,1,'Eifel Tower'),(2,3,'Old City'),(3,6,'Lake Tahoe'),(4,10,'Poland DisneyLand'),(5,8,'Colizeum'),(6,2,'Khreshchatyk'),(7,4,'Reichstag'),(8,7,'Sensoji Temple'),(9,1,'Louvre'),(10,9,'Prado Museum');
INSERT INTO route VALUES (1,'2022-10-21 00:00:00',2,'Germany-Italy-France'),(2,'2023-02-14 00:00:00',1,'Japan Best Places'),(3,'2023-03-14 00:00:00',5,'Spain-France'),(4,'2023-09-08 00:00:00',3,'Italy-France'),(5,'2024-01-15 00:00:00',7,'Kyiv-Warsaw'),(6,'2021-10-15 00:00:00',6,'Holidays  in Egypt '),(7,'2023-08-08 00:00:00',2,'States of USA'),(8,'2021-11-11 00:00:00',8,'Spain-Italy-France'),(9,'2022-04-23 00:00:00',10,'Capitals of Europe'),(10,'2024-09-15 00:00:00',6,'Cities of Italy');
INSERT INTO route_has_place VALUES (3,1),(8,2),(4,3),(6,3),(2,4),(1,5),(5,5),(7,6),(9,7),(10,8);
INSERT INTO payment_type VALUES (1,'card'), (2, 'cash'),(3, 'cheque');
INSERT INTO tour VALUES (1,2,'3 days',150.00,'2021-12-09','2022-01-15',3, 1) ,(2,1,'14 days',400.00,'2022-02-16','2022-04-22',6, 2),(3,5,'5 days',120.00,'2021-11-11','2022-02-14',7, 3),(4,3,'7 days',99.00,'2022-02-14','2022-03-21',2, 1),(5,5,'3 days',100.00,'2023-09-15','2023-09-23',1,1),(6,3,'5 days',115.00,'2021-10-18','2021-11-12',4, 1),(7,4,'8 days',225.00,'2022-04-05','2022-04-29',9, 2),(8,3,'2 days',50.00,'2021-12-31','2022-02-14',6, 2),(9,4,'15 days',750.00,'2022-06-29', '2022-07-29',10, 2),(10,5,'9 days',465.00,'2012-12-12','2022-02-04',8, 3);
INSERT INTO tour_has_hotel VALUES (6,1),(7,2),(8,3),(1,4),(2,4),(9,5),(3,7),(4,8),(5,10),(10,10);

