package com.jvmausa.bookstore.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jvmausa.bookstore.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("from Cliente c left join fetch c.reserva where c.id = :id")
	Optional<Cliente> findById(Long id);
	
	
}
