set foreign_key_checks = 0;

create table reserva (
	id bigint not null auto_increment,
	id_livro bigint not null,
    data_reserva datetime not null,
    data_devolucao datetime,
    data_devolucao_prev datetime,
    status_reserva varchar(15) not null,
    valor_final decimal(10,2),
    atraso tinyint(1),
    
    primary key(id),
    
    constraint fk_livro_id foreign key (id_livro) references livro(id)
    
)engine=InnoDB default charset=utf8;

set foreign_key_checks = 1;