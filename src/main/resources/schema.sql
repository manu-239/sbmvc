drop table  if exists  	car;
drop table  if exists 	engine;
drop table 	if exists 	manufacturer ;

CREATE TABLE `manufacturer` (                                                                  
`manufacturerId` bigint(20) NOT NULL AUTO_INCREMENT,                                   
`name` varchar(50) DEFAULT NULL,  
`address` varchar(200) DEFAULT NULL,
`contactNumber` bigint(20) DEFAULT NULL, 		  
PRIMARY KEY (`manufacturerId`) 
);
CREATE TABLE `engine` (                                                                            
`engineId` bigint(20) NOT NULL AUTO_INCREMENT,                                                               
`name` varchar(50) DEFAULT NULL,  
`enginetype` varchar(50) DEFAULT NULL,				 
`displacement` int(10) DEFAULT NULL,  
`manufacturerId` bigint(20),				 
PRIMARY KEY (`engineId`),                                                                                    
KEY `manufacturerId` (`manufacturerId`),                                                                  
CONSTRAINT `manufacturerId_fk_1` FOREIGN KEY (`manufacturerId`) REFERENCES `manufacturer` (`manufacturerId`)    
);
CREATE TABLE `car` (
`carId` bigint(20) NOT NULL AUTO_INCREMENT,    
`model` varchar(50) DEFAULT NULL,                                          
`color` varchar(50) DEFAULT NULL,                                         
`price` double(13,3) DEFAULT NULL,                        
`engineId` bigint(20) , 
`manufacturerId` bigint(20),
PRIMARY KEY (`carId`),
KEY `engineId` (`engineId`),                                                                  
CONSTRAINT `engineId_fk_1` FOREIGN KEY (`engineId`) REFERENCES `engine` (`engineId`) ,
KEY `manufacturerId` (`manufacturerId`),                                                                  
CONSTRAINT `manufacturerId_fk_2` FOREIGN KEY (`manufacturerId`) REFERENCES `manufacturer` (`manufacturerId`)  				 
);

		
insert into manufacturer(manufacturerId,name,address,contactNumber)
	values(1,'Honda','Honda Cars India Ltd.1302-1306,<br>Kesar Solitaire,Plot No 5, Sector 19,<br>Sanpada, Navi Mumbai - 400705',1244263121);
insert into manufacturer(manufacturerId,name,address,contactNumber)
	values(2,'Tata Motors','A Block, Tata Motors Ltd 4th Floor,<br>Ahura Centre 82 Mahakali Caves Road MIDC,<br>Andheri East Mumbai - 400093',2262407101);
insert into manufacturer(manufacturerId,name,address,contactNumber)
	values(3,'Maruti Suzuki','Maruti Suzuki India Limited<br>1, Nelson Mandela Road,<br>Vasant Kunj,<br>New Delhi - 110070',1146781000);
insert into manufacturer(manufacturerId,name,address,contactNumber)
	values(4,'Fiat','Fiat India Ltd., Plot No. B, 19, Ranjangaon MIDC,<br> Industrial Area, Pune,<br> Maharashtra 412220',2138672700);

insert into engine(engineId,name,enginetype,displacement,manufacturerId)
	values(1,'i VTEC','Petrol',1497,1);
insert into engine(engineId,name,enginetype,displacement,manufacturerId)
	values(2,'Kryotec 2.0 L Turbocharge','Diesel',1956,2);
insert into engine(engineId,name,enginetype,displacement,manufacturerId)
	values(3,'K15 Smart Hybrid Petrol E','Petrol',1462,3);
insert into engine(engineId,name,enginetype,displacement,manufacturerId)
	values(4,'1.3 Multijet','Diesel',1248,4);

insert into car(carId,model,color,price,engineId,manufacturerId)
	values(1,'City','White',1100000,1,1);
insert into car(carId,model,color,price,engineId,manufacturerId)
	values(2,'Harrier','Black',1500000,2,2);
insert into car(carId,model,color,price,engineId,manufacturerId)
	values(3,'Ciaz','Blue',1000000,3,3);
insert into car(carId,model,color,price,engineId,manufacturerId)
	values(4,'Swift Dzire','Red',800000,4,3);

