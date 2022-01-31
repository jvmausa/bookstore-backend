delete from livro;
delete from cliente;

alter table livro auto_increment = 1;
alter table cliente auto_increment = 1;


insert into livro (id, nome, autor, editora) values (1, 'Tripulação de Esqueletos', 'Stephen King', 'Ponto de Leitura');
insert into livro (id, nome, autor, editora) values (2, 'O Ladrão de Raios', 'Rick Riordan', 'intrínseca');
insert into livro (id, nome, autor, editora) values (3, 'O Mar de Monstros', 'Rick Riordan', 'intrínseca');
insert into livro (id, nome, autor, editora) values (4, 'A Maldição do Titã', 'Rick Riordan', 'intrínseca');
insert into livro (id, nome, autor, editora) values (6, 'A Batalha do Labirinto', 'Rick Riordan', 'intrínseca');
insert into livro (id, nome, autor, editora) values (7, 'O Último Olimpiano', 'Rick Riordan', 'intrínseca');

insert into cliente (id, nome) values (1, 'Pedro');
insert into cliente (id, nome) values (2, 'João');
insert into cliente (id, nome) values (3, 'Paulo');
insert into cliente (id, nome) values (4, 'José');
insert into cliente (id, nome) values (5, 'Maria');


