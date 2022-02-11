set foreign_key_checks = 0;

delete from livro;
delete from cliente;
delete from reserva;


alter table livro auto_increment = 1;
alter table cliente auto_increment = 1;
alter table reserva auto_increment = 1;


insert into livro (id, nome, autor, editora, preco, status) values (1, 'Tripulação de Esqueletos', 'Stephen King', 'Ponto de Leitura', 23.90, 'EMPRESTADO');
insert into livro (id, nome, autor, editora, preco, status) values (2, 'O Ladrão de Raios', 'Rick Riordan', 'intrínseca', 13.90, 'EMPRESTADO');
insert into livro (id, nome, autor, editora, preco, status) values (3, 'O Mar de Monstros', 'Rick Riordan', 'intrínseca', 12.90, 'EMPRESTADO');
insert into livro (id, nome, autor, editora, preco, status) values (4, 'A Maldição do Titã', 'Rick Riordan', 'intrínseca', 15.90, 'EMPRESTADO');
insert into livro (id, nome, autor, editora, preco, status) values (5, 'A Batalha do Labirinto', 'Rick Riordan', 'intrínseca', 17.90, 'EMPRESTADO');
insert into livro (id, nome, autor, editora, preco, status) values (6, 'O Último Olimpiano', 'Rick Riordan', 'intrínseca', 100, 'DISPONÍVEL');



insert into reserva (id, id_livro, data_reserva, status_reserva) values (1, 1, utc_timestamp, 'PENDENTE');
insert into reserva (id, id_livro, data_reserva, status_reserva) values (2, 3, '2022-01-30 18:51:40', 'PENDENTE');
insert into reserva (id, id_livro, data_reserva, data_devolucao, status_reserva) values (3, 4, '2021-12-28 18:51:40', '2022-02-01 17:50:35', 'PAGO');



insert into cliente (id, nome, id_reserva) values (1, 'Pedro', null);
insert into cliente (id, nome, id_reserva) values (2, 'João', 1);
insert into cliente (id, nome, id_reserva) values (3, 'Paulo', 3);
insert into cliente (id, nome, id_reserva) values (4, 'José', 2);
insert into cliente (id, nome, id_reserva) values (5, 'Maria', null);

set foreign_key_checks = 1;