CREATE TABLE stoomdsilva.CADASTRO (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	streetname VARCHAR(50) NOT NULL,
	number VARCHAR(50) NOT NULL,
	complement VARCHAR(50) NOT NULL,
	neighbourhood VARCHAR(50) NOT NULL,
	city VARCHAR(50),
	state VARCHAR(50) NOT NULL,
	country VARCHAR(50) 	NOT NULL,
	zipcode VARCHAR(50) NOT NULL,
	latitude VARCHAR(50)  NOT NULL,
	longitude VARCHAR(50)  NOT NULL	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA MARGARIDA','59','CIDADE FLORES','CASA','SAO JOSE','SP','BRASIL','06184444','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA ROSA','12635','ITATINGA','APTO 10','SAO MIGUEL','SP','BRASIL','06454412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA SOL','554','BONANZA','CASA','SAO LONGUINHO','SP','BRASIL','0112284412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA MARTE','876','JARDINS','APTO 221','SAO CRISTOVAO','SP','BRASIL','01184412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA LUA','1','JAGUARI','CASA 3','SAO JORGE','SP','BRASIL','56184412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA VIOLETA','236','DELL REY','CASA','SAO AGOSTINHO','SP','BRASIL','656884412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA LIMAO','665','MARCIANOS','CASA 2','SANTOS','SP','BRASIL','06181231','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA ACUCAR','569','FLOURENCE','APTO 2','SAO AMARO','SP','BRASIL','06133312','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA LUNAR','1447','CENTRO','TERREO','SAO DOMINGOS','SP','BRASIL','0618456712','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('AV SOARES','66','ZONA RURAL','ANDAR 1','SAO ARTHUR','SP','BRASIL','06145612','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('AV PEDRO LIMA','10','URBANO','CASA','SAO PEDRO','SP','BRASIL','06187412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('AV CARLOS COSTA','98','SOL NASCENTE','CASA','SAO VITTO','SP','BRASIL','066594412','0','0');
INSERT INTO stoomdsilva.CADASTRO  (streetname, number,complement, neighbourhood,city,state,country,zipcode,latitude,longitude) VALUES ('RUA ESTEVAO','48','LUA MINGUANTE','CASA','SAO LUIS','SP','BRASIL','06184114','0','0');