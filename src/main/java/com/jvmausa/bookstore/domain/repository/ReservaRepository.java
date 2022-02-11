package com.jvmausa.bookstore.domain.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jvmausa.bookstore.domain.model.Reserva;

@Repository
public interface ReservaRepository extends CustomJpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva> {

}
