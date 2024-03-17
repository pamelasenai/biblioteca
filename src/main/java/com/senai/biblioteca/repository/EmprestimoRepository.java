package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
