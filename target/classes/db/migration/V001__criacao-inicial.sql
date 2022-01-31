create table livro (
  id bigint not null auto_increment,
  nome varchar(60) not null,
  autor varchar(30) not null,
  editora varchar(30) not null,
  
  primary key (id)
) engine=innoDB;