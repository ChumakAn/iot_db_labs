SELECT model, speed, price 
FROM labor_sql.pc
WHERE speed < 750 and speed > 500
ORDER BY  hd DESC;

SELECT SUBSTRING_INDEX(name, ' ', -1)
FROM labor_sql.passenger
WHERE SUBSTRING_INDEX(name, ' ', -1) like 'C%';

SELECT outcomes.ship, outcomes.battle, battles.date FROM outcomes
inner join battles on outcomes.battle = battles.name
WHERE  result ='OK' ;

SELECT distinct maker FROM product
where maker = all(select maker from product where type = 'РС' and type = 'Laptop')
order by maker ;

SELECT product.maker FROM product
JOIN pc ON product.model = pc.model
WHERE speed = (SELECT MAX(pc.speed) FROM pc);

SELECT DATE_FORMAT(date,'%d.%m.%Y') as date FROM battles;

SELECT AVG(hd) AS average_hd
FROM product 
JOIN pc ON product.model = pc.model 
WHERE maker = ALL (SELECT maker FROM product WHERE TYPE = 'Printer' AND TYPE = 'PC');

SELECT speed, AVG(price) AS avg_price 
FROM pc
where speed>600
 GROUP BY speed;
 
SELECT *
FROM (SELECT name, numGuns, bore, displacement, type,
country, launched, classes.class , (numGuns=8) + (bore=15) + (displacement=32000) + (type='bb') + (country='USA') + (launched=1915) + (classes.class='Kon') AS n
FROM ships JOIN classes ON ships.class  = classes.class ) AS x
WHERE n>=4;

SELECT DISTINCT product.model,product.type, AVG(pc.price) AS avg_price FROM product JOIN pc ON product.model= pc.model GROUP BY price
union
SELECT DISTINCT product.model,product.type,  AVG(laptop.price) FROM product JOIN laptop ON product.model= laptop.model GROUP BY price
union
SELECT DISTINCT product.model,product.type,  AVG(printer.price) FROM product JOIN printer ON product.model= printer.model GROUP BY price
;