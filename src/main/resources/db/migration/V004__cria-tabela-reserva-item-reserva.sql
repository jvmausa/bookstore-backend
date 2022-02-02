create table reserva (
	id bigint not null auto_increment,
    id_cliente bigint not null,
    data_reserva datetime not null,
    data_devolucao datetime,
    valor_total decimal(10,2) not null,
    status_reserva varchar(15) not null,
    
    primary key(id),
    
    constraint fk_reserva_cliente foreign key (id_cliente) references cliente(id)
)engine=InnoDB default charset=utf8;

create table item_reserva (
	id bigint not null auto_increment,
    id_livro bigint not null,
    id_reserva bigint not null,
    preco_livro decimal(10,2) not null,
    
    primary key(id),
    
    constraint fk_reserva_id foreign key (id_reserva) references reserva(id),
    constraint fk_livro_id foreign key (id_livro) references livro(id)
)engine=InnoDB default charset=utf8;

