USE pharmacy_db;


INSERT INTO street (name) VALUES ('Kvitky-Osnovianenka'),
('Nyzynna'), ('Stepanivny'),  ( 'Shevchenka'),( 'Warszawska'),
( 'Armii Ludowej'),('Wesela'), ('Veresneva'), ('Ochota'),( 'Virmenska');

INSERT INTO post ( name) VALUES ( 'clerk'),
('dispencer'),('assistant'),('technician'),('pharmacist'),
('director'),('manager'),('pharmalogist');

INSERT INTO pharmacy (id, name,street_id, building_number, web_adress, work_time_open, 
work_time_close, is_open_saturday, is_open_sunday)
 VALUES ('1', 'Apteka','1', '23', 'www.adress.com', '9:00', '18:00', '1', '1'),
 ('2', 'biomed','4', '12', 'www.biomed.ua', '00:00', '00:00', '1', '1'),
 ('3', 'aptechka','8', '1', 'www.apt.com', '10:00', '21:00', '0', '0'),
 ('4', 'Znahar','4', '4', 'www.znahar.org', '6:00', '22:00', '0', '1'),
 ('5', 'apt24','1', '5', 'www.art24.ua', '9:00', '17:00', '0', '0'),
 ('6', 'StopAsylum','7', '32', 'www.stpslm.com', '13:00', '18:00', '1', '0'),
 ('7', 'Fight your shyzophrenia','1', '13', 'www.aptekaforyou.com', '10:00', '16:00', '0', '1'),
 ('8', 'AptekaIot', '4','21', 'www.iotapteka.com', '8:30', '00:00', '1', '1'),
 ('9', 'pharmacy','3', '1', 'www.pharmacy.ua', '10:00', '17:00', '1', '0'),
 ('10', 'drugStore', '2','42', 'www.drugstore.ua', '9:45', '21:45', '0', '0');


INSERT INTO effect_zone (name) VALUES ('lungs'),
 ('heart'), ('bones'),('neck'), ('back'),
 ('stomach'),('liver'),('tooth'),('eyes'), ('ears');


INSERT INTO employee (name, surname, middle_name, identity_number, passport_data, experience, birth_date, post_id, pharmacy_id) VALUES 
('Harry', 'Potter', 'Jamesovich', '1234342674', 'fn2123111', '2 ', '2002-12-12', '1', '1'),
 ('Ron', 'Veesley', 'Batkovysh', '1213423100', 'af1901930', '0 ', '2000-11-07', '3', '1'),
('Hermione', 'Granger', 'Jean', '3221213400', 'at3003291', '4 ', '2003-09-15', '5', '4'),
('Draco', 'Malfoy', 'Lutsiusius', '4233909400', 'gr3020392', '15 ', '1980-07-28', '7', '2'),
('Severus', 'Snape', 'Forever', '1000000000', 'ui2039029', '12', '1991-09-09', '6', '9'),
('Andrii', 'Andrew', 'Andriiovych', '2329310900', 're4039404', '6.5', '2000-01-01', '4', '3'),
('Kostiantyn', 'Mininkov', 'Maksymovych', '9999999999', 'ps1337220', '9', '2003-05-15', '6', '6'),
('Taras', 'Shevchenko', 'Hryhorovych', '2930293092', 'rt3949392', '13', '1840-03-09', '8', '8'),
('Ivan', 'Franko', 'Yakovych', '3209302940', 'po093094', '5', '1876-05-07', '2', '4'),
('Lesia', 'Ukrainka', 'Petrivna', '2930290392', 'uy309403', '4', '1856-08-27', '3', '1');


INSERT INTO medicine_list (name, ministry_code, require_recipe, is_narcotic, is_psychtropic) VALUES ('Nimesyl', '324', '1', '0', '0'),
('Mefenaminka', '789', '0', '0', '0'),
('Aspiryn', '123', '0', '0', '0'),
('Viks', '324', '0', '0', '0'),
 ('Ibuprom', '789', '0', '0', '1'),
 ('Kanefron', '176', '1', '0', '0'),
 ('Vitamin C', '300', '0', '0', '0'),
 ('Hlicysed', '993', '0', '1', '0'),
('NervoNorm', '993', '1', '0', '1'),
('Tamipul', '346', '0', '0', '0');


INSERT INTO pharmaсy_has_medicine (pharmacy_id, medicine_id) VALUES (1, 3),
(3, 2),
(6, 6),
(1, 7),
(2, 5),
(3, 8),
(4, 4),
(10, 10),
(8, 1),
(7, 6);


INSERT INTO medicine_zone (medicine_id, zone_id) VALUES 
(1, 3),
(2, 5),
(3, 4),
(5, 1),
(7, 2),
(10, 4),
(4, 6),
(6, 7),
(9, 2),
(3, 8);