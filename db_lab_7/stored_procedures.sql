USE pharmacy_db;

-- параметризована вставка в аптечні установи
DROP PROCEDURE IF EXISTS insert_into_pharmacy;
DELIMITER //
CREATE PROCEDURE insert_into_pharmacy(
name VARCHAR (45),
 building_number INT,
  web_adress VARCHAR(45),
   work_time_open TIME,
   work_time_close TIME,
   is_open_saturday TINYINT,
   is_open_sunday TINYINT
)
BEGIN
INSERT INTO pharmacy(name, building_number,web_adress,work_time_open,work_time_close,is_open_saturday,is_open_sunday )
VALUES(name, building_number,web_adress,work_time_open,work_time_close,is_open_saturday,is_open_sunday )
;
END //
DELIMITER ;
	
-- 2 завд
DROP PROCEDURE IF EXISTS select_medicine_zone;
DELIMITER //
CREATE PROCEDURE select_medicine_zone()
BEGIN
SELECT * from medicine_zone
 join medicine_list on medicine_list.id = medicine_zone.medicine_id
join effect_zone on effect_zone.id = medicine_zone.zone_id;
END //
DELIMITER ;


-- курсори 

drop procedure if exists create_random_tables;

DELIMITER //
create procedure create_random_tables()
begin
declare done bool default false;
declare new_id int;
declare new_name varchar(45);

DECLARE zones CURSOR
for select  * from effect_zone;

DECLARE CONTINUE HANDLER FOR
not found set done = true ;
	
    drop table if exists new_effect_zone_1;
	drop table if exists new_effect_zone_2;
    
     create table new_effect_zone_1 like effect_zone;
    create table new_effect_zone_2 like effect_zone;
    
     open zones;
     
     effect_zone_loop:
				LOOP
						fetch zones into new_id, new_name ;
                        if done then 
								leave effect_zone_loop;
                                END IF;
						if rand() > 0.5 then
                        insert into new_effect_zone_1(name) values (new_name);
                        ELSE
                        insert into new_effect_zone_2 (name) values (new_name);
                        END IF;
                        END LOOP;
                        CLOSE zones;
                        
end// 
DELIMITER ;
                        




