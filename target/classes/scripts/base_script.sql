CREATE TABLE Users (
idUser int,
nombre varchar(255),
dni varchar(8),
carrera varchar(100)
)

select * from Users


INSERT INTO Users
VALUES (1,'Angel','74095214','ING SOFTWARE');

INSERT INTO Users
VALUES (2,'Kelly','71234590','Medicina');

INSERT INTO Users
VALUES (3,'Miguel','78471515','Pintor');

INSERT INTO Users
VALUES (4,'Piero','78222525','Abogado');

INSERT INTO Users
VALUES (5,'Mijail','78212545','ING INDUSTRIAL');

delete from users where nombre = 'Mijail';

create procedure listarAllUsers()
begin
	select * from Users;
end

call listarAllUsers() ;