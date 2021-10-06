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
id  INT NOT NULL AUTO_INCREMENT , 
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
telephone_number VARCHAR(12) NOT NULL,
PRIMARY KEY (id)
)
ENGINE = InnoDB;

CREATE TABLE country (
 id  INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
)
ENGINE = InnoDB;

CREATE TABLE hotel (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  rate INT NOT NULL,
  PRIMARY KEY (id)
  )
ENGINE = InnoDB;

CREATE TABLE city (
 id  INT NOT NULL AUTO_INCREMENT,
 hotel_id INT NOT NULL ,
 name VARCHAR(45) NOT NULL,
 country_id INT NOT NULL,
 PRIMARY KEY (id),
 INDEX fk_city_hotel_idx (hotel_id ASC) ,
  INDEX fk_city_country_idx (country_id ASC),
 CONSTRAINT fk_city_hotel
 FOREIGN KEY (hotel_id) 
 REFERENCES hotel (id),
 CONSTRAINT fk_city_country
 FOREIGN KEY (country_id)
 REFERENCES country (id)
)
ENGINE = InnoDB;

CREATE TABLE transport_type (
  id  INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
  )
ENGINE = InnoDB;
CREATE TABLE  route (
  id  INT NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  guide_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_route_guide_idx (guide_id ASC),
  CONSTRAINT fk_route_guide 
  FOREIGN KEY (guide_id) 
  REFERENCES guide(id)
)
ENGINE = InnoDB;

CREATE TABLE place (
  id  INT NOT NULL AUTO_INCREMENT,
  city_id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_place_city 
  FOREIGN KEY (city_id) 
  REFERENCES city (id)
  )
ENGINE = InnoDB;
CREATE TABLE route_has_place (
  route_id  INT NOT NULL AUTO_INCREMENT,
  place_id INT NOT NULL,
  PRIMARY KEY (route_id, place_id),
  CONSTRAINT fk_route_has_place
    FOREIGN KEY (route_id)
    REFERENCES route (id),
  CONSTRAINT fk_route_has_place1
    FOREIGN KEY (place_id)
    REFERENCES place (id)
)
ENGINE = InnoDB;
CREATE TABLE payment_type(
id INT NOT NULL AUTO_INCREMENT,
type VARCHAR(10) NOT NULL,
PRIMARY KEY (id)
)
ENGINE = InnoDB;
CREATE TABLE  tour (
  id INT NOT NULL AUTO_INCREMENT,
  transport_type_id INT NOT NULL,
  duration VARCHAR(45) NOT NULL,
  price_per_person DECIMAL(10,2) NOT NULL,
  date_of_departure DATE NOT NULL,
  next_departure_date DATE NOT NULL,
  route_id INT NOT NULL,
  payment_type_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_tour_transport_type_idx (transport_type_id ASC),
  INDEX fk_tour_route_idx (route_id ASC) ,
  CONSTRAINT fk_tour_transport_type
    FOREIGN KEY (transport_type_id)
    REFERENCES transport_type (id),
  CONSTRAINT fk_tour_route
    FOREIGN KEY (route_id)
    REFERENCES route (id),
    CONSTRAINT fk_tour_payment_type
    FOREIGN KEY (payment_type_id)
    REFERENCES payment_type(id)
)
ENGINE = InnoDB;

CREATE TABLE tour_has_hotel (
  tour_id INT NOT NULL AUTO_INCREMENT,
  hotel_id INT NOT NULL,
  PRIMARY KEY (tour_id, hotel_id),
  CONSTRAINT fk_tour_has_hotel_tour
    FOREIGN KEY (tour_id)
    REFERENCES tour (id),
  CONSTRAINT fk_tour_has_hotel_hotel
    FOREIGN KEY (hotel_id)
    REFERENCES hotel (id)
)
ENGINE = InnoDB;



INSERT INTO transport_type (`name`) VALUES ('cruise'), ('car'), ('train'), ('plane'), ('pedestrian'), ('bus');
INSERT INTO country (`name`) VALUES ('Ukraine'),('Poland'),('Itally'),('France'),('Spain'),('Germany'),('Egypt'),('Albania'),('USA'),('Japan');
INSERT INTO hotel (`name`,`rate`) VALUES ('Hypnos',5),('Iris',3),('Azul',8),('Ebony',6),('Altheda',1),('Aurelia',5),('Citrus',4),('Xanthe',9),('Saros',10),('Ceilo',7);
INSERT INTO city (`hotel_id`, `name`, `country_id`) VALUES (3,'Paris',4),(5,'Kyiv',1),(2,'Warsaw',2),(4,'Berlin',6),(3,'Kair',7),(5,'California',9),(1,'Tokio',10),(6,'Rome',3),(9,'Madrid',5),(10,'Lublin',2);
INSERT INTO guide (`name`,`surname`,`telephone_number`) VALUES ('Velva','Gilbert','3806595652'),('Jose','Brown','3809055415'),('Mary','Levey','3856120021'),('Sue','Bartz','3805646432'),('Richard','Mullins','3806564151'),('Adrienne','Sena','4804656210'),('Danny','Gaytan','7809095225'),('Joan','Miller','4452024875'),('Dorothy','Scanlon','4809907252'),('Glenda','Merz','3806584562');
INSERT INTO place (`city_id`,`name`) VALUES (1,'Eifel Tower'),(3,'Old City'),(6,'Lake Tahoe'),(10,'Poland DisneyLand'),(8,'Colizeum'),(2,'Khreshchatyk'),(4,'Reichstag'),(7,'Sensoji Temple'),(1,'Louvre'),(9,'Prado Museum');
INSERT INTO route (`date`, `guide_id`, `name`) VALUES ('2022-10-21 00:00:00',2,'Germany-Italy-France'),('2023-02-14 00:00:00',1,'Japan Best Places'),('2023-03-14 00:00:00',5,'Spain-France'),('2023-09-08 00:00:00',3,'Italy-France'),('2024-01-15 00:00:00',7,'Kyiv-Warsaw'),('2021-10-15 00:00:00',6,'Holidays  in Egypt '),('2023-08-08 00:00:00',2,'States of USA'),('2021-11-11 00:00:00',8,'Spain-Italy-France'),('2022-04-23 00:00:00',10,'Capitals of Europe'),('2024-09-15 00:00:00',6,'Cities of Italy');
INSERT INTO route_has_place VALUES (3,1),(8,2),(4,3),(6,3),(2,4),(1,5),(5,5),(7,6),(9,7),(10,8);
INSERT INTO payment_type (`type`) VALUES ('card'), ( 'cash'),('cheque');
INSERT INTO tour VALUES (1,2,'3 days',150.00,'2021-12-09','2022-01-15',3, 1) ,(2,1,'14 days',400.00,'2022-02-16','2022-04-22',6, 2),(3,5,'5 days',120.00,'2021-11-11','2022-02-14',7, 3),(4, 3,'7 days',99.00,'2022-02-14','2022-03-21',2, 1),(5, 5,'3 days',100.00,'2023-09-15','2023-09-23',1,1),(6, 3,'5 days',115.00,'2021-10-18','2021-11-12',4, 1),(7, 4,'8 days',225.00,'2022-04-05','2022-04-29',9, 2),(8, 3,'2 days',50.00,'2021-12-31','2022-02-14',6, 2),(9, 4,'15 days',750.00,'2022-06-29', '2022-07-29',10, 2),(10, 5,'9 days',465.00,'2012-12-12','2022-02-04',8, 3);
INSERT INTO tour_has_hotel VALUES (6,1),(7,2),(8,3),(1,4),(2,4),(9,5),(3,7),(4,8),(5,10),(10,10);

