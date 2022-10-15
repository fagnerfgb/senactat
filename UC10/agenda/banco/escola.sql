create database escola;
use escola;
create table alunos(
ra	int primary key auto_increment,
nome varchar(50) not null,
nomePai varchar(50) not null,
nomeMae varchar(50) not null,
sexo char not null,
cidadeDeNascimento varchar(30) not null,
estadoDeNascimento varchar(2) not null,
dataDeNascimento varchar(10) not null,
enderecoResidencia varchar(50) not null,
numeroResidencia varchar(5) not null,
bairroResidencia varchar(30) not null,
cidadeDeResidencia varchar(30) not null,
telefoneContato1 varchar(15) not null,
telefoneContato2 varchar(15) not null,
certidaoDeNascimento varchar(10) not null,
livroCertidaoDeNascimento varchar(5) not null,
folhaCertidaoDeNascimento varchar(5) not null,
emissaoCertidaoDeNascimento varchar(10) not null,
distritoCertidaoDeNascimento varchar(30) not null,
comarcaCertidaoDeNascimento varchar(30) not null,
estadoCertidaoDeNascimento varchar(30) not null,
necessidadesEspeciais char not null,
email varchar(50)
);

