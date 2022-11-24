/**
 * Projeto de um sistema para gestão de estoque
 * @author Fagner Geraldes Braga
 * @version 1.0
*  @tabela usuarios	
*/

-- Comandos de verificação
show databases;
use estoque;
show tables;
describe usuarios;
select * from usuarios;

-- Criação do banco de dados
create database estoque;

-- Criação da tabela de usuários
create table usuarios(
	id int primary key auto_increment,
    usuario varchar(50) not null,
    -- unique - nao permite valores duplicados
    login varchar(20) not null unique,
    senha varchar(250) not null,
    perfil varchar(50) not null
);

-- CRUD USUARIOS

-- CREATE
insert into usuarios (usuario, login, senha, perfil) values ('Fagner Geraldes Braga', 'fagner.braga', md5('123@senac'), 'admin');
insert into usuarios (usuario, login, senha, perfil) values ('Allan Gomes', 'allan.gomes', md5('123@senac'), 'user');
insert into usuarios (usuario, login, senha, perfil) values ('Felipe Cachufi', 'felipe.cachufi',md5('123@senac'), 'user');
insert into usuarios (usuario, login, senha, perfil) values ('Higor Ribeiro', 'higor.ribeiro', md5('123@senac'),'user');
insert into usuarios (usuario, login, senha, perfil) values ('Giovana Gio', 'giovana.gio', md5('123@senac'),'user');
insert into usuarios (usuario, login, senha, perfil) values ('Pedro Henrique', 'pedro.henrique', md5('123@senac'),'user');

-- READ
-- Selecionar todos os usuários
select * from usuarios;
-- Selecionar um usuário específico por ID
select * from usuarios where id = 4;

-- UPDATE
-- Alterar todos os dados de um usuário específico
update usuarios set usuario = 'Higor Ribeiro', login = 'higor.ribeiro', senha = md5('123@senac'), perfil = 'admin' where id = 4;
update usuarios set usuario = 'Giovana Gio', login = 'giovana.gio', senha = md5('123@senac'), perfil = 'admin' where id = 5;

-- DELETE
-- Excluir um usuário específico
delete from usuarios where id = 6;

-- Excluir tabela
drop table usuarios;


-- Adicionar novo campo no final da tabela
alter table usuarios add column perfil varchar(250);

-- login (usuario e senha correspondente)
select * from usuarios where login='fagner.braga' and senha = md5('123456');