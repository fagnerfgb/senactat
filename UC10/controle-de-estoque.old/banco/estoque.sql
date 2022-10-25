/**
 * Projeto de um sistema para gestão de estoque
 * @author Fagner Geraldes Braga
 * @version 1.0
*/

show databases;
create database db_estoque;
use db_estoque;
create table usuarios(
	id int primary key auto_increment,
    usuario varchar(50) not null,
    login varchar(20) not null,
    senha varchar(250) not null    
);
show tables;
describe usuarios;

-- CRUD
-- CREATE (Inserir 5 usuários)
insert into usuarios (usuario, login, senha) values ('Fagner Geraldes Braga', 'fagner.braga', '123@senac');
insert into usuarios (usuario, login, senha) values ('Allan Gomes', 'allan.gomes', '123@senac');
insert into usuarios (usuario, login, senha) values ('Felipe Cachufi', 'felipe.cachufi', '123@senac');
insert into usuarios (usuario, login, senha) values ('Higor Ribeiro', 'higor.ribeiro', '123@senac');
insert into usuarios (usuario, login, senha) values ('Giovana Gio', 'giovana.gio', '1234@senac');
insert into usuarios (usuario, login, senha) values ('Pedro Henrique', 'pedro.henrique', '123@senac');

-- READ1 (Selecionar todos os usuários)
select * from usuarios;

-- READ2 (Selecionar um usuário específico por ID)
select * from usuarios where id = 4;

-- UPDATE (Alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Giovana Gio', login = 'giovana.gio', senha = '123@senac' where id = 4;
update usuarios set usuario = 'Higor Ribeiro', login = 'higor.ribeiro', senha = '123@senac' where id = 5;

-- DELETE (Excluir um usuário específico)
delete from usuarios where id = 6;
