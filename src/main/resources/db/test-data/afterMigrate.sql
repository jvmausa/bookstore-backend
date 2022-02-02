set foreign_key_checks = 0;

delete from livro;
delete from cliente;
delete from reserva;
delete from item_reserva;

set foreign_key_checks = 1;

alter table livro auto_increment = 1;
alter table cliente auto_increment = 1;


insert into livro (id, nome, autor, editora, preco, status) values (1, 'Tripulação de Esqueletos', 'Stephen King', 'Ponto de Leitura', 23.90, 'DISPONÍVEL');
insert into livro (id, nome, autor, editora, preco, status) values (2, 'O Ladrão de Raios', 'Rick Riordan', 'intrínseca', 13.90, 'DISPONÍVEL');
insert into livro (id, nome, autor, editora, preco, status) values (3, 'O Mar de Monstros', 'Rick Riordan', 'intrínseca', 12.90, 'DISPONÍVEL');
insert into livro (id, nome, autor, editora, preco, status) values (4, 'A Maldição do Titã', 'Rick Riordan', 'intrínseca', 15.90, 'DISPONÍVEL');
insert into livro (id, nome, autor, editora, preco, status) values (5, 'A Batalha do Labirinto', 'Rick Riordan', 'intrínseca', 17.90, 'DISPONÍVEL');
insert into livro (id, nome, autor, editora, preco, status) values (6, 'O Último Olimpiano', 'Rick Riordan', 'intrínseca', 19.90, 'DISPONÍVEL');

insert into cliente (id, nome) values (1, 'Pedro');
insert into cliente (id, nome) values (2, 'João');
insert into cliente (id, nome) values (3, 'Paulo');
insert into cliente (id, nome) values (4, 'José');
insert into cliente (id, nome) values (5, 'Maria');


insert into reserva (id, id_cliente, data_reserva, valor_total, status_reserva) values (1, 2, utc_timestamp, 37.80, 'PENDENTE');
insert into reserva (id, id_cliente, data_reserva, valor_total, status_reserva) values (2, 1, '2022-01-30 18:51:40', 17.90, 'PENDENTE');
insert into reserva (id, id_cliente, data_reserva, valor_total, data_devolucao, status_reserva) values (3, 3, '2021-12-28 18:51:40', 12.90, '2022-02-01 17:50:35', 'PAGO');

insert into item_reserva (id, id_reserva, id_livro, preco_livro) values (1, 1, 1, 23.90);
insert into item_reserva (id, id_reserva, id_livro, preco_livro) values (2, 1, 4, 13.90);
insert into item_reserva (id, id_reserva, id_livro, preco_livro) values (5, 1, 5, 17.90);
insert into item_reserva (id, id_reserva, id_livro, preco_livro) values (3, 2, 2, 17.90);
insert into item_reserva (id, id_reserva, id_livro, preco_livro) values (4, 3, 3, 12.90);