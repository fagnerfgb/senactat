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
    -- unique - nao permite valores duplicados
    login varchar(20) not null unique,
    senha varchar(250) not null,
    perfil varchar(50) not null
);
show tables;
describe usuarios;

-- CRUD
-- CREATE (Inserir 5 usuários)
insert into usuarios (usuario, login, senha, perfil) values ('Fagner Geraldes Braga', 'fagner.braga', md5('123@senac'), 'admin');
insert into usuarios (usuario, login, senha, perfil) values ('Allan Gomes', 'allan.gomes', md5('123@senac'), 'user');
insert into usuarios (usuario, login, senha, perfil) values ('Felipe Cachufi', 'felipe.cachufi',md5('123@senac'), 'user');
insert into usuarios (usuario, login, senha, perfil) values ('Higor Ribeiro', 'higor.ribeiro', md5('123@senac'),'user');
insert into usuarios (usuario, login, senha, perfil) values ('Giovana Gio', 'giovana.gio', md5('123@senac'),'user');
insert into usuarios (usuario, login, senha, perfil) values ('Pedro Henrique', 'pedro.henrique', md5('123@senac'),'user');

-- READ1 (Selecionar todos os usuários)
select * from usuarios;

-- READ2 (Selecionar um usuário específico por ID)
select * from usuarios where id = 4;

-- UPDATE (Alterar todos os dados de um usuário específico)
update usuarios set usuario = 'Giovana Gio', login = 'giovana.gio', senha = '123@senac' where id = 4;
update usuarios set usuario = 'Higor Ribeiro', login = 'higor.ribeiro', senha = '123@senac' where id = 5;

-- DELETE (Excluir um usuário específico)
delete from usuarios where id = 6;

-- Inserir senha criptografada com md5
insert into usuarios (usuario, login, senha)
values('Robson Vaamonde','vaamonde',md5('123@senac'));

-- Excluir tabela
drop table usuarios;

-- Adicionar novo campo no final da tabela
alter table usuarios add column perfil varchar(250);




