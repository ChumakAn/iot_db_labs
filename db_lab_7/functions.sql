
USE pharmacy_db;

SET GLOBAL log_bin_trust_function_creators = 1;

-- №1: для employee шукати AVG стовпця experience

DROP FUNCTION IF EXISTS get_average_experience;
DELIMITER //
CREATE FUNCTION get_average_experience()
RETURNS DECIMAL(10,1) 
BEGIN
return(SELECT AVG(experience) FROM employee);
END //	
DELIMITER ;

-- №2: витягує за ключем між таблицями post та employee значення поля post_name
DROP FUNCTION IF EXISTS get_post_name;
DELIMITER //	
CREATE FUNCTION get_post_name(
post_id INT
)
RETURNS VARCHAR(25)
BEGIN	
RETURN(
	select name from post where id =(select post_id from employee where id = post_id)
);
END //
DELIMITER ;


-- вибірка даних 
-- SELECT * from employee where experience > get_average_experience();
-- SELECT name, surname, middle_name, identity_number, passport_data, experience, birth_date, get_post_name(id) from employee;
