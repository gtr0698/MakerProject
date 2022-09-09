create table produtos(
	id bigint not null auto_increment,
    quantidade int not null,
    descricao varchar(255),
    marca varchar(60) not null,
    departamento varchar(60) not null,

    primary key(id)
);