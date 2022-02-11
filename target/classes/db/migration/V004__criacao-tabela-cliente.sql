create table cliente (
  id bigint not null auto_increment,
  nome varchar(60) not null,

  id_reserva bigint,

  primary key (id),
  
  constraint fk_id_reserva foreign key (id_reserva) references reserva(id)
  
) engine=innoDB;
