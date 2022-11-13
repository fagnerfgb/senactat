/**
 * Projeto de um sistema para gestão de estoque
 * @author Fagner Geraldes Braga
 * @version 1.0
*/

-- Comandos de verificação
show databases;
use estoque;
show tables;
describe usuarios;
describe fornecedores;
select * from usuarios;
select * from fornecedores;

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

-- CRUD

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

-- Criação da tabela de fornecedores
create table fornecedores (
idFor int primary key auto_increment,
razaoSocial varchar(60) not null,
fantasia varchar(60) not null,
cnpj varchar(20) unique,
ie varchar(20) unique,
cep varchar(10) not null,
endereco varchar(50) not null,
numero varchar(6) not null,
complemento varchar(20),
bairro varchar(50) not null,
cidade varchar(50) not null,
uf char(2) not null,
nomeContato varchar(30) not null,
fone1 varchar(15) not null,
fone2 varchar(15),
email varchar(50) not null,
site varchar(50),
obs varchar(250)
);

-- CRUD

-- CREATE
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D AR CONDICIONADO COMERCIO DE ELETRODOMESTICOS LTDA','3D AR','07.818.410/0001-93','593353358432','14096385','AV COSTABILE ROMANO','2789','','RIBEIRANIA','RIBEIRÃO PRETO','SP','Frederico Bosco','(16) 44162-7898','(16) 44162-7899','frederico.bosco@3dar.com.br','https://www.3dar.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D AR CONDICIONADO INSTALACAO E TRATAMENTO TERMICO EIRELI','3D AR','74.315.292/0001-98','85148684154','14095440','AVENIDA ANTONIO GOMES DA SILVA JUNIOR','826','','PARQ RESIDENCIAL LAGOINHA','RIBEIRÃO PRETO','SP','Renato Guimaraes','(16) 33454-2171','(16) 33454-2172','renato.guimaraes@3d-ar.com.br','https://www.3d-ar.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D CONSTRUÇÕES E PROJETOS INDUSTRIAIS LTDA','3D CONSTRUÇÕES','07.197.566/0001-02','841731284869','14026210','RUA ANTONIO DELLOIAGONO ','500','','JARDIM ANA MARIA','RIBEIRÃO PRETO','SP','Antenor Paiva','(16) 61178-6649','(16) 61178-6650','antenor.paiva@3d-construcoes.com.br','https://www.3d-construcoes.com.br','Atendimento de segunda a sexta das 09h às 16h');
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D CRIAR FABRICACAO DIGITAL LTDA - EPP','3D CRIAR','22.072.135/0001-03','118275856340','5350000','AV ESCOLA POLITECNICA','S/N','','RIO PEQUENO','SÃO PAULO','SP','Escobar Castilho','(11) 68287-2125','(11) 68287-2126','escobar.castilho@3dcriar.com.br','https://www.3dcriar.com.br','Atendimento de segunda a sexta das 09h às 16h');
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D DIGITAL GRAPHIC LTDA','3D DIGITAL','33.715.105/0001-86','78704646402','4071012','AV. DOS BANDEIRANTES','5583','','PLANALTO PAULISTA','SÃO PAULO','SP','Jorge Barbosa','(11) 44687-8490','(11) 44687-8491','jorge.barbosa@3ddigital.com.br','https://www.3ddigital.com.br','Atendimento de segunda a sexta das 09h às 16h');
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D INDUSTRIA DE ACRILICO LTDA','3D INDÚSTRIA','00.580.359/0001-85','224519328','89219500','HANS DIETER SCHMIDT','1673','TERREO','ZONA INDUSTRIAL NORTE','JOINVILLE','SC','Leandro Correia','(47) 43174-9018','(47) 43174-9019','leandro.correia@3dindustria.com.br','https://www.3dindustria.com.br','Atendimento de segunda a sexta das 09h às 16h');
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D INFORMATICA LTDA ME','3D INFORMÁTICA','04.384.128/0001-57','207822596154','1039000','AV. IPIRANGA','1251','CJ 104','CENTRO','SÃO PAULO','SP','Isabel Correia','(11) 36793-1436','(11) 36793-1437','isabel.correia@3dinformatica.com.br','https://www.3dinformatica.com.br','Atendimento de segunda a sexta das 09h às 16h');
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D MIDIA BALOES LTDA ME','3D MÍDIA','17.215.343/0001-76','325014790618','7084385','RUA ANALIA FRANCO ','130','','PARQUE CONTINENTAL II','GUARULHOS','SP','Amanda Falcao','(11) 80113-6751','(11) 80113-6752','amanda.falcao@3dmidia.com.br','https://www.3dmidia.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D PRINT COMUNICAÇÃO VISUAL LTDA - EPP','3D PRINT','18.341.490/0001-55','7582742084','2510040','RUA DR. MELLO NOGUEIRA','105','SALA 326','VILA BARUEL','SÃO PAULO','SP','Zilda Rosario','(11) 24317-1442','(11) 24317-1443','zilda.rosario@3dprint.com.br','https://www.3dprint.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D PROJETOS E ASSESSORIA EM INFORMÁTICA LTDA EPP','3D PROJETOS','07.766.048/0001-54','07804823001-00','70720610','SHCGN CR QD. ','702','BL. A LJ 47 PT B','ASA NORTE','BRASÍLIA','DF','Mariana Vargas','(61) 17622-7495','(61) 17622-7496','mariana.vargas@3dprojetos.com.br','https://www.3dprojetos.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SERVIÇOS DE INSTALAÇÃO E MANUTENÇÃO LTDA','3D','22.427.208/0001-24','961524008595','13503019','AVENIDA 12','2356','','JARDIM SÃO PAULO','RIO CLARO','SP','Aline Furtado','(19) 42693-7355','(19) 42693-7356','aline.furtado@3d.com.br','https://www.3d.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SERVIÇOS ESPECIALIZADOS LTDA.','3D','17.030.814/0001-71','219662144430','9770080','RUA SERGIPE','206','','JARDIM NOVA PETROPOLIS','SÃO BERNARDO DO CAMPO','SP','Juliana Caetano','(11) 26929-2804','(11) 26929-2805','juliana.caetano@3dservicos.com.br','https://www.3dservicos.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SIGN COMÉRCIO E COMUNICAÇÃO VISUAL LTDA-EPP','3D SIGN','04.990.213/0001-69','546874675875','2542000','EPAMINONDAS MELO DO AMARAL','1110','','CASA VERDE ALTA','SÃO PAULO','SP','Leandro Correia','(11) 82821-9735','(11) 82821-9736','leandro.correia@3dsign.com.br','https://www.3dsign.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SIGN COMUNICAÇÃO VISUAL LTDA','3D SIGN','33.046.047/0001-45','537404536776','2535001','RUA VALDEMAR MARTINS','1074','','PARQUE PERUCHE','SÃO PAULO','SP','Jorge Barbosa','(11) 50925-6513','(11) 50925-6514','jorge.barbosa@3dsigncomunicacao.com.br','https://www.3dsigncomunicacao.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SOLAR TECNOLOGIA LTDA.','3D SOLAR','27.690.799/0001-41','280248308180','3203020','RUA ORLANDO','256','','VILA BELA','SÃO PAULO','SP','Escobar Castilho','(11) 12496-4024','(11) 12496-4025','escobar.castilho@3dsolar.com.br','https://www.3dsolar.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3D SYSTEMS INDUSTRIA E COMERCIO LTDA','3D SYSTEMS','02.995.134/0001-15','280821434202','9912190','AVENIDA RIACHUELO','92','','VILA CONCEIÇÃO','DIADEMA','SP','Antenor Paiva','(11) 20203-8229','(11) 20203-8230','antenor.paiva@3dsystems.com.br','https://www.3dsystems.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3DCRIAR CONSULTORIA E COMERCIO DE SOLUÇÕES DIGITAI','3DCRIAR','08.068.098/0001-20','587532760088','5508000','AV. PROFESSOR LINEU PRESTES ','2243','','BUTANTA','SÃO PAULO','SP','Renato Guimaraes','(11) 73558-2441','(11) 73558-2442','renato.guimaraes@3dcriarsolucoes.com.br','https://www.3dcriarsolucoes.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3DERAS MANUFATURA DIGITAL LTDA','3DERAS','38.267.731/0001-70','513487590','88048300','ROD DR ANTONIO LUIZ MOURA GONZAGA','3994','SALA 01','RIO TAVARES','FLORIANÓPOLIS','SC','Frederico Bosco','(48) 41225-7822','(48) 41225-7823','frederico.bosco@3deras.com.br','https://www.3deras.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3DK COMUNICAÇÃO VISUAL E FACILITIES','3DK','35.938.578/0001-78','67560578010','5329020','RUA MONTE VERDE','95','','JAGUARE','SÃO PAULO','SP','Tereza Pimentel','(11) 80203-1705','(11) 80203-1706','tereza.pimentel@3dk.com.br','https://www.3dk.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3DLOPES – ARTIGOS PARA IMPRESSORAS 3D LTDA .- ME','3DLOPES','20.599.596/0001-03','863.249.590/4375','30140072','RUA DOS AIMORES','1451','','LOURDES','BELO HORIZONTE','MG','Daiana Bosco','(31) 37236-6097','(31) 37236-6098','daiana.bosco@3dlopes.com.br','https://www.3dlopes.com.br','Atendimento de segunda a sexta das 09h às 16h'
);
insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values ('3DM PECAS E MANUTENCAO EIRELI ME','3DM PEÇAS E MANUTENÇÃO','18.256.403/0001-61','881865148643','7021160','AV ANTONIO IERVOLINO','318','SALA 09','VILA AUGUSTA','GUARULHOS','SP','Cassia Batista','(11) 35945-2101','(11) 35945-2102','cassia.batista@3dm.com.br','https://www.3dm.com.br','Atendimento de segunda a sexta das 09h às 16h'
);

-- CRUD JAVA

-- Create
-- Usuários
-- insert into usuarios (usuario, login, senha, perfil) values (?, ?, md5(?), ?) where id = ?;

-- Fornecedores
-- insert into fornecedores (razaoSocial, fantasia, cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone1, fone2, email, site, obs) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) where idFor = ?; 






