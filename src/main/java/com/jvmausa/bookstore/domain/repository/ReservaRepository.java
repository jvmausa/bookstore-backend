package com.jvmausa.bookstore.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jvmausa.bookstore.domain.model.Reserva;

@Repository
public interface ReservaRepository extends CustomJpaRepository<Reserva, Long>, JpaSpecificationExecutor<Reserva>{
	
	
	@Query("select distinct r from Reserva r left join fetch r.livros left join fetch r.cliente")
	List<Reserva> findAll();

}
