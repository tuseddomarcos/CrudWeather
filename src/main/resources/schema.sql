DROP TABLE IF EXIST USERS
DROP TABLE IF EXIST Weather
DROP TABLE IF EXIST Roll


CREATE TABLE IF NOT EXISTS Weather (  
	id INT PRIMARY KEY AUTO_INCREMENT,  
	name VARCHAR(50) NOT NULL
);  

CREATE TABLE IF NOT EXISTS USERS (  
	id_usuario INT PRIMARY KEY AUTO_INCREMENT,  
	name VARCHAR(50) NOT NULL,
	userName VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
);  

CREATE TABLE IF NOT EXISTS Roll (  
	idRol INT PRIMARY KEY AUTO_INCREMENT,  
	rolName ENUM NOT NULL
);  