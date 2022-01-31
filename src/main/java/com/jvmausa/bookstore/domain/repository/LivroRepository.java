package com.jvmausa.bookstore.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvmausa.bookstore.domain.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
