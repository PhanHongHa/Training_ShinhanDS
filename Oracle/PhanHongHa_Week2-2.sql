--Bài 1:
Create table CAMPUS
(CampusID varchar2(5) not null,
 CampusName varchar2(100),
 Street varchar2(100),
    City varchar2(100),
    State varchar2(100),
     Zip varchar2(100),
      Phone varchar2(100),
      CampusDiscount DECIMAL(2,2),
      CONSTRAINT Campus_pk PRIMARY Key (CampusID)
      );
      

Create table POSITION
(PositionID varchar2(5) not null,
 POSITION varchar2(100),
 YearlyMembershipFee DECIMAL(2,2),
      CONSTRAINT Position_pk PRIMARY Key (PositionID)
      );
      
      
Create table MEMBERS
(MemberID varchar2(5) not null,
 LastName varchar2(100),
 FirstName varchar2(100),
 CampusPhone varchar2(100),
    CampusAddress varchar2(100),
     CampusID varchar2(5),
     PositionID varchar2(5),
     ContractDiration INTEGER,
      CONSTRAINT Members_pk PRIMARY Key (MemberID)
      );
      
ALTER TABLE MEMBERS
ADD FOREIGN KEY (CampusID) REFERENCES Campus(CampusID);

ALTER TABLE MEMBERS
ADD FOREIGN KEY (PositionID) REFERENCES Position(PositionID);



Create table PRICES
(FoodItemTypeID number(20) not null,
 MealType varchar2(100),
 MealPrice DECIMAL(7,2),
      CONSTRAINT Price_pk PRIMARY Key (FoodItemTypeID)
      );
      
      

Create table FoodItems
(FoodItemID VARCHAR2(20) not null,
 FoodItemName varchar2(100),
 FoodItemTypeID NUMBER(20),
      CONSTRAINT FoodItem_pk PRIMARY Key (FoodItemID)
      );
ALTER TABLE FoodItems
ADD FOREIGN KEY (FoodItemTypeID) REFERENCES Prices(FoodItemTypeID);




Create table ORDERS
(OrderID varchar2(5) not null,
 MemberID varchar2(5),
OrderDate varchar2(25),
 
      CONSTRAINT Order_pk PRIMARY Key (OrderID)
      );
ALTER TABLE ORDERS
ADD FOREIGN KEY (MemberID) REFERENCES Members(MemberID);


Create table ORDERLINE
(OrderID varchar2(5) not null,
 FoodItemID varchar2(5),
 Quantity Integer,  
CONSTRAINT OrderLine_pk PRIMARY Key (OrderID, FoodItemID)
      );
ALTER TABLE ORDERLINE
ADD FOREIGN KEY (OrderID) REFERENCES Orders(OrderID);    
ALTER TABLE ORDERLINE
ADD FOREIGN KEY (FoodItemID) REFERENCES FoodItems(FoodItemID);

SELECT * FROM   orderline


--Bài 2:

INSERT INTO CAMPUS (CampusID,CampusName, Street, City, State, Zip, Phone, CampusDiscount) 
VALUES ('1','IUPUI','425 University Blvd.','Indianapolis', 'IN','46202', '317-274-4591',.08); 
INSERT INTO CAMPUS (CampusID,CampusName, Street, City, State, Zip, Phone, CampusDiscount) 
VALUES ('2','Indiana University','107 S. Indiana Ave.','Bloomington', 'IN','47405', '812-855-
4848',.07); 
INSERT INTO CAMPUS (CampusID,CampusName, Street, City, State, Zip, Phone, CampusDiscount) 
VALUES ('3','Purdue University','475 Stadium Mall Drive','West Lafayette', 'IN','47907', '765-
494-1776',.06);
      
      
      
INSERT INTO POSITION (PositionID, Position, YearlyMemberShipFee) 
VALUES ('1','Lecturer', .50);
INSERT INTO POSITION (PositionID, Position, YearlyMemberShipFee) 
VALUES ('2','Associate Professor',.50);
INSERT INTO POSITION (PositionID, Position, YearlyMemberShipFee) 
VALUES ('3','Assistant Professor', .50);
INSERT INTO POSITION (PositionID, Position, YearlyMemberShipFee) 
VALUES ('4','Professor', .75);
INSERT INTO POSITION (PositionID, Position, YearlyMemberShipFee) 
VALUES ('5','Full Professor', .50);



INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('1','Ellen','Monk','009 Purnell', '812-123-1234', '2', '5', 12);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('2','Joe','Brady','008 Statford Hall', '765-234-2345', '3', '2', 10);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('3','Dave','Davidson','007 Purnell', '812-345-3456', '2', '3', 10);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('4','Sebastian','Cole','210 Rutherford Hall', '765-234-2345', '3', '5', 10);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('5','Michael','Doo','66C Peobody', '812-548-8956', '2', '1', 10);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('6','Jerome','Clark','SL 220', '317-274-9766', '1', '1', 12);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('7','Bob','House','ET 329', '317-278-9098', '1', '4', 10);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('8','Bridget','Stanley','SI 234', '317-274-5678', '1', '1', 12);
INSERT INTO MEMBERS(MemberID, LastName, FirstName, CampusPhone,CampusAddress, CampusID, PositionID,Contractdiration) 
VALUES ('9','Bradley','Wilson','334 Statford Hall', '765-258-2567', '3', '2', 10);


--Sequence
INSERT INTO PRICES(FoodItemTypeID,MealType,MealPrice) 
VALUES (Prices_sequence.Nextval,'Beer/Wine', 5.50);
INSERT INTO PRICES(FoodItemTypeID,MealType,MealPrice) 
VALUES (Prices_sequence.Nextval, 'Dessert', 2.75);
INSERT INTO PRICES(FoodItemTypeID,MealType,MealPrice) 
VALUES (Prices_sequence.Nextval,'Dinner', 15.50);
INSERT INTO PRICES(FoodItemTypeID,MealType,MealPrice) 
VALUES (Prices_sequence.Nextval,'Soft Drink', 2.50); 
INSERT INTO PRICES(FoodItemTypeID,MealType,MealPrice) 
VALUES (Prices_sequence.Nextval,'Lunch', 7.25);



INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10001','Lager', '1');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10002','Red Wine', '1');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10003','White Wine', '1');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10004','Coke', '4');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10005','Coffee', '4');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10006','Chicken a la King', '3');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10007','Rib Steak', '3');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10008','Fish and Chips', '3');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10009','Veggie Delight', '3');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10010','Chocolate Mousse', '2');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10011','Carrot Cake', '2');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10012','Fruit Cup', '2');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10013','Fish and Chips', '5');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10014','Angus Beef Burger', '5');
INSERT INTO FOODITEMS(FoodItemID,FoodItemName,FoodItemTypeID) 
VALUES ('10015','Cobb Salad', '5');




INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('1', '9', 'March 5, 2005');
INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('2', '8', 'March 5, 2005');
INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('3', '7', 'March 5, 2005');
INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('4', '6', 'March 7, 2005');
INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('5', '5', 'March 7, 2005');
INSERT INTO ORDERS(OrderID,MemberID,OrderDate) 
VALUES ('6', '4', 'March 10, 2005');



INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('1','10001',1);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('1','10006',1);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('1','10012',1);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('2','10004',2);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('2','10013',1);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('2','10014',1);
INSERT INTO ORDERLINE(OrderID,FoodeItemID,Quantity) 
VALUES ('3','10005',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('3','10011',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('4','10005',2);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('4','10004',2);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('4','10006',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('4','10007',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('4','10010',2);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('5','10003',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('6','10002',2);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('7','10005',2);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('8','10005',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('8','10011',1);
INSERT INTO ORDERLINE(OrderID,FoodItemID,Quantity) 
VALUES ('9','10001',1);


--Bài 3:
-- 1)
select constraint_name, table_name FROM user_constraints;

-- 2)
select owner, table_name from all_tables;

-- 3)
select sequence_owner, sequence_name from all_sequences;

 -- 4)
select m.FirstName, m.LastName, p.Position, c.CampusName, (p.YearlyMembershipFee/12) as Monthly_Dues
from Members m, Position p, Campus c
where m.PositionID = p.PositionID and m.CampusID = c.CampusID
order by c.CampusName desc, m.LastName asc
 
