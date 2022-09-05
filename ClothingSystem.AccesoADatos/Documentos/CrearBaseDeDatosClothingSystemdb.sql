USE [master]
GO
CREATE DATABASE [ClothingSystemdb]
GO
USE [ClothingSystemdb]
GO
-- Crear la tabla de Rol
CREATE TABLE [dbo].[Rol](
  [Id] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
  [Nombre] [varchar](30) NOT NULL
);
GO
-- Crear la tabla de Usuario
CREATE TABLE [dbo].[Usuario](
   [Id] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
   [IdRol] [int] NOT NULL,
   [Nombre] [varchar](30) NOT NULL,
   [Apellido] [varchar](30) NOT NULL,
   [Login] [varchar](25) NOT NULL,
   [Password] [char](32) NOT NULL,
   [Estatus] [tinyint] NOT NULL,
   [FechaRegistro] [datetime] NOT NULL,
   CONSTRAINT FK1_Rol_Usuario FOREIGN KEY (IdRol) REFERENCES Rol (Id)
);

go
create table Marca(
Id int PRIMARY KEY IDENTITY (1,1) NOT NULL,
Nombre nvarchar (30) not null,
Estatus tinyint not null,
Descripcion nvarchar (200) default null,
PaisOrigen nvarchar (60) default null,
);

go
create table Ropa(
Id int PRIMARY KEY IDENTITY (1,1) NOT NULL,
IdMarca int not null,
CodigoBarra nvarchar (20) not null,
Nombre nvarchar (60) not null,
PrecioCompra nvarchar (20) not null,
PrecioVenta nvarchar (20) not null,
Existencia int not null,
Estatus tinyint not null,
Talla nvarchar (10) not null,
Color nvarchar (60) not null,
Estilo nvarchar (60) default null,
Descripcion nvarchar (200) default null,
TipoTela nvarchar (60) default null,
CONSTRAINT FK1_Marca_Ropa FOREIGN KEY (IdMarca) REFERENCES Marca (Id) 
);

go 
create table RopaFoto(
Id int PRIMARY KEY IDENTITY (1,1) NOT NULL,
IdRopa int not null,
Url  nvarchar (200) not null,
Estatus tinyint not null,
CONSTRAINT FK1_Ropa_RopaFoto FOREIGN KEY (IdRopa) REFERENCES Ropa (Id)
);