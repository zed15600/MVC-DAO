# DROP database universidad;
#CREATE DATABASE Universidad;  /*User: root -  Password: 1234*/
USE  Universidad;


CREATE TABLE Tbl_Estudiantes(
	Est_Codigo int primary key,
    Est_Nombre varchar(45),
    Est_Correo varchar(45),
    Est_Tel varchar(45),
    Est_Direccion varchar(45),
    Est_Cedula int
);


CREATE TABLE Tbl_Profesores(
	Pro_Codigo int primary key,
    Pro_Nombre varchar(45),
    Pro_Tel varchar(45),
    Pro_Direccion varchar(45),
    Pro_Cedula int
);


CREATE TABLE Tbl_Carreras(
	Car_Codigo int primary key,
    Car_Nombre varchar(45),
    Car_Jefe_Carrera int,
    foreign key (Car_Jefe_Carrera) references Tbl_Profesores(Pro_Codigo)	
);

CREATE TABLE Tbl_Estudiante_Carrera(
	Est_Car_Codigo int primary key, 
    Est_Car_Codigo_Estudiante int,
    Est_Car_Codigo_Carrera int,
    foreign key (Est_Car_Codigo_Estudiante) references Tbl_Estudiantes(Est_Codigo),
    foreign key (Est_Car_Codigo_Carrera) references Tbl_Carreras(Car_Codigo)
);

#select * from Tbl_Estudiantes
#select * from Tbl_Profesores
#select * from Tbl_Carreras
#select * from Tbl_Estudiante_Carrera
