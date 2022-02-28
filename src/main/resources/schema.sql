create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);

create table if not exists Taco (
  id int identity,
  name varchar(50) not null,
  createdAt timestamp not null
);

-- @ManyToMany -> Taco no supone que la tabla taco referencia ingredientes
-- para eso creamos esta tabla intermedia
create table if not exists Taco_Ingredients (
  taco_id bigint not null,
  ingredient_id varchar(4) not null
);

--ALTER TABLE Taco_Ingredients ADD CONSTRAINT FK_Taco FOREIGN KEY (taco_id) REFERENCES Taco(id);
--ALTER TABLE Taco_Ingredients ADD CONSTRAINT FK_Ingredient FOREIGN KEY (ingredient_id) REFERENCES Ingredient(id);
alter table Taco_Ingredients add foreign key (taco_id) references Taco(id);
alter table Taco_Ingredients add foreign key (ingredient_id) references Ingredient(id);

create table if not exists Taco_Order (
    id int identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Taco_Order_Tacos (
  tacoOrder bigint not null,
  taco bigint not null
);

alter table Taco_Order_Tacos add foreign key (tacoOrder) references Taco_Order(id);
alter table Taco_Order_Tacos add foreign key (taco) references Taco(id);