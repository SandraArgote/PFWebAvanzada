CREATE DATABASE Alumnos;
use Alumnos;
create table Alumno(
    NUMEROCONTROL VARCHAR(15) NOT NULL PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    CURSO VARCHAR(50) NOT NULL,
    SEMESTRE VARCHAR(5) NOT NULL
);

insert into Alumno values('16240616','AGULAR AGUILAR MARIA VIRGINIA','CO','9');
insert into Alumno values('16240449','ALVAREZ ZAMORA JOSE DE JESUS','CO','9');
insert into Alumno values('16240820','ARGOTE ROMO SANDRA PAULINA','CO','9');
insert into Alumno values('16240367','CORTES JIMENEZ ZAIRA','CO','9');

