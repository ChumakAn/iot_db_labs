
USE pharmacy_db;


-- №1: для employee шукати AVG стовпця experience

DROP FUNCTION IF EXISTS get_average_experience;
DELIMITER //
CREATE FUNCTION get_average_experience()
RETURNS DECIMAL(10,1) 
BEGIN
return(
SELECT AVG(experience)
FROM employee
);
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
	SELECT post.name
    FROM employee
    LEFT JOIN post on employee.post_id = post.id
    WHERE employee.id = post_id
);
END //
DELIMITER ;