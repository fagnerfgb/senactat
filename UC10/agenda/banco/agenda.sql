/**
* Agenda de Contatos
* @author Fagner Geraldes Braga
*/
-- Comando para verificar os bancos criados
show databases;

-- Comando para criar um novo banco de dados
create database agenda;

-- Comando usado para selecionar um banco de dados
use agenda;

-- Comando usado para excluir um banco de dados
drop database agenda;

-- Comando usado para criar uma tabela
-- int (inteiros)
-- primary key (chave primária - identificador)
-- auto_increment (numeração automática)
-- varchar(50) (tipo de dados string - 50 caracteres)
-- not null (campo obrigatório)
create table contatos(
id int primary key auto_increment,
nome varchar(50) not null,
fone varchar(15) not null,
email varchar(50)
);

CREATE TABLE contatos (
idcon int NOT NULL AUTO_INCREMENT,
nome varchar(50) NOT NULL,
fone varchar(15) NOT NULL,
email varchar(50) DEFAULT NULL,
PRIMARY KEY (idcon)
);

-- Verificar tabelas do banco de dados
show tables;

-- Descrever a tabela
describe contatos;

-- Alterar nome do campo (coluna)
alter table contatos change nome contato varchar(50) not null;

-- Adicionar novo campo no final da tabela
alter table contatos add column obs varchar(250);

-- Adicionar novo campo em local específico
alter table contatos add column fone2 varchar(15) after fone;

-- Modificar os atributos de um campo na tabela
alter table contatos modify column fone2 varchar(20);

-- Excluir uma coluna na tabela
alter table contatos drop column obs;

-- Excluir toda a tabela
drop table contatos;

/********** CRUD **********/

-- Create (Insert)
insert into contatos (nome, fone, email)
values ('Fagner Geraldes Braga', '96102-4801', 'fagner.fgb@gmail.com');

insert into contatos (nome, fone, email)
values ('Felipe Cachufi', '01234-5678', 'felipe@gmail.com');

insert into contatos (nome, fone, email)
values ('Fabio Vaz', '98765-4321', 'fabio@gmail.com');

insert into contatos (nome, fone, email)
values ('Fabiano Mendes', '78901-2345', 'fabiano@gmail.com');

insert into contatos (nome, fone, email)
values ('Frederico Novais', '45678-9012', 'frederico@gmail.com');

insert into contatos (nome, fone, email)
values ('Natalia Paz', '11111-2222', 'natalia@gmail.com');

insert into contatos (nome, fone)
values ('Isabel', '22222-3333');

-- Read (Select)
select * from contatos;

-- Criar apelidos aos campos;
select id as Código, nome as Contato, fone as Telefone, email as Email from contatos;

-- Selecionar campos específicos na tabela;
select nome, fone from contatos;

-- Ordenar os registros da tabela pelo nome
select * from contatos order by nome;

-- Ordenar os registros por nome de forma decrescente
select * from contatos order by nome desc;

-- Filtrar nomes específicos na tabela 
select * from contatos where nome like 'Fab%';

-- Selecionar utilizando critério específico
select * from contatos where nome = 'Fagner Geraldes Braga';
select * from contatos where id = 1;

-- Update (Update)

-- Alterar todos os registros do campo nome para Higor
-- Sempre utilizar o comando update junto com o where
update contatos set nome = 'Higor';

-- Alterar o nome do id = 4
update contatos set nome = 'Fabricio Mendes' where id = 4;

-- Alterar o e-mail do id = 7
update contatos set email = 'isabel@gmail.com' where id = 7;

-- Alterar todos os campos do id 3
update contatos set nome = 'Fabio Vaz Medeiros', fone = '66666-77777', email = 'fabio.medeiros@gmail.com' where id = 3;

update contatos set nome = 'Allan Richard Gomes', fone = '12345-6789', email = 'allan.gomesti@outlook.com' where id = 13; 

-- Delete (Delete)
-- Usar where
delete from contatos where id = 3;















