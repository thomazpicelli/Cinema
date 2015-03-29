Drop table Sessao;
Drop table Filme;
Drop table ListaAtores;
Drop table InfoAtor;
Drop table Ator;
Drop table ListaIngressos;
Drop table Ingresso;
Drop table Atendente;
Drop table Cliente;
Drop table Diretor;
Drop table Distribuidora;
Drop table Genero;
Drop table Gerente;
Drop table Sala;

Create table Atendente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    login varchar(15),
    senha varchar(15)
);

Create table Ator(
    id int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(20),
    nacionalidade varchar(20),
    datanasc date
);

Create table Cliente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(30),
    anoNasc int,
    tipo varchar(15)
);

Create table Diretor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    codigo int,
    nome varchar(30)
);

Create table Distribuidora(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(50)
);

Create table Filme(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_diretor int,
    id_genero int,
    id_listaAtores int,
    id_distribuidora int,
    nome varchar(50),
    classificacao int,
    ano int,
    duracao int,
    situacao varchar(15),
    idioma varchar(20)
);

Create table Genero(
    pk int not null primary key generated always as identity(start with 1, increment by 1), 
    nome varchar(20)
);

Create table Gerente(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    nome varchar(40),
    login varchar(15),
    senha varchar(15)
);

Create table InfoAtor(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ator int,
    papel varchar(50),
    part varchar(50)
);

Create table Ingresso(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id int,
    inteira boolean,
    tipo varchar(20)
);

Create table ListaAtores(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_infoator int
);

Create table ListaIngressos(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_ingresso int
);

Create table Sala(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    numero int,
    lotacao int,
    especial int,
    situacao varchar(15)
);

Create table Sessao(
    pk int not null primary key generated always as identity(start with 1, increment by 1),
    id_filme int,
    id_sala int,
    horario time,
    legendado boolean,
    id_listaIngressos int
);

alter table filme add FOREIGN KEY(id_diretor) references Diretor(pk);
alter table filme add FOREIGN KEY(id_genero) references genero(pk);
alter table filme add FOREIGN KEY(id_listaAtores) references listaAtores(pk);
alter table filme add FOREIGN KEY(id_distribuidora) references distribuidora(pk);
alter table infoator add FOREIGN KEY(id_ator) references ator(id);
alter table ListaAtores add FOREIGN KEY(id_infoator) references infoator(pk);
alter table ListaIngressos add FOREIGN KEY(id_ingresso) references ingresso(pk);
alter table Sessao add FOREIGN KEY(id_filme) references filme(pk);
alter table Sessao add FOREIGN KEY(id_sala) references sala(pk);
alter table Sessao add FOREIGN KEY(id_listaIngressos) references listaingressos(pk);

Insert into Atendente(nome, login, senha) values('Maria','mariasilva','senha'),('Silvia','silviacosta','senha');
Insert into Ator(nome, nacionalidade, datanasc) values('Brad Pitt','americano','1963-12-18'),('Christoph Waltz','austríaco','1956-10-04'),('Michael Fassbender','alemão','1977-04-02'),('Christian Bale','britânico','1974-01-30'),('Michael Caine','britanico','1936-03-14'),('Gary Oldman','britânico','1958-03-28'),('Chris Prat','americano','1979-07-21'),('Bryce Dallas Howard','americana','1991-03-02'),('Irrfan Khan','indiano','1962-11-30'),('Vera Miles','americana','1930-08-23'),('Anthony Perkins','americano','1932-04-04'),('Janet Leigh','americana','1927-07-06'),('John Travolta','americano','1954-02-18'),('Samuel L. Jackson','americano','1948-12-21'),('Uma Thurman','americana','1970-04-29');
Insert into Cliente(nome, anoNasc, tipo) values('Maria',1987,'geral'),('Joao',1997,'obeso'),('Andre',1978,'geral');
Insert into Diretor(codigo, nome) values(3672,'Quentin Tarantino'),(3243,'Steven Spielberg'),(4243,'Pedro Almodóvar'),(53532,'Alfred Hitchcock'),(3232,'Roman Polanski'),(3232,'Woody Allen'),(3232,'Stanley Kubrick'),(322,'Ingmar Bergman'),(3232,'Christopher Nolan');
Insert into Distribuidora(nome) values('Warner Bros. Pictures'),('Disney'),('Sony Pictures'),('Universal Studios'),('Paramount Pictures'), ('Miramax Films');
Insert into Genero(nome) values('ação'),('Animação'),('Comédia'),('Cult'),('Dança'),('Documentário'),('Drama'),('Erótico'),('Fantasma'),('Faroeste'),('Ficção Cientifica'),('Guerra'),('Musical'),('Filme Noir'),('Policial'),('Romance'),('Suspense'),('Terror'),('Trash');
Insert into Gerente(nome, login, senha) values('Mario','mariosuzuki','senha'),('Sueli','suelivieira','senha');
Insert into InfoAtor(id_ator, papel, part) values(1,'Tenente Aldo Raine','protagonista'),(2,'Coronel Hans Landa','protagonista'),(3,'Tenente Archie Hicox','coadjuvante'),(4,'Bruce Wayne/Batman','protagonista'),(5,' Alfred Pennyworth','coadjuvante'),(6,'James Gordon','protagonista'),(7,'Owen Grady','protagonista'),(8,'Claire Dearing','protagonista'),(9,'Simon Masrani','coadjuvante'),(10,'Lila Crane','protagonista'),(11,'Norman Bates','protagonista'),(12,'Marion Crane','protagonista'),(13,'Vincent Vega','protagonista'),(14,'Jules Winnfield','protagonista'),(15,'Lila Crane','coadjuvante');
Insert into Ingresso(id, inteira, tipo) values(1, true, 'GERAL'),(2, true, 'OBESO'),(3, true, 'CADEIRANTE'),(4, false, 'GERAL'),(5, false, 'OBESO'),(6, false, 'CADEIRANTE');
Insert into ListaAtores(id_infoator) values(1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15);
Insert into ListaIngressos(id_ingresso) values(1),(2),(3),(4),(5),(6);
Insert into Sala(numero, lotacao, especial, situacao) values(1, 400, 50, 'EXIBICAO'), (2, 200, 20, 'EXIBICAO'),(3, 200, 20, 'EXIBICAO'),(4, 150, 15, 'MANUTENÇÃO'),(5, 150, 17, 'ESPERA'),(6, 60, 5, 'ESPERA');
Insert into Filme(id_diretor, id_genero, id_listaatores, id_distribuidora, nome, classificacao, ano, duracao, situacao, idioma) values(1, 1, 1, 4, 'Bastardos Inglórios', 18, 2009, 153, 'CARTAZ', 'inglês'),(8, 1, 2, 1, 'Batman - O Cavaleiro das Trevas', 14, 2008, 152, 'CARTAZ', 'inglês'),(3, 18, 1, 4, 'Jurassic World', 10, 2015, 150, 'ESTREIA', 'inglês'),(4, 18, 1, 5, 'Psicose', 18, 1960, 109, 'CARTAZ', 'inglês'),(1, 1, 3, 6, 'Pulp Fiction', 18, 1994, 154, 'CARTAZ', 'inglês');
Insert into Sessao(id_filme, id_sala, horario, legendado, id_listaIngressos) values(1, 3, '22:00', true, 1),(2, 4, '20:30', true, 2),(3, 1, '16:00', false, 3),(4, 6, '21:00', true, 4),(5, 2, '19:30', false, 5);