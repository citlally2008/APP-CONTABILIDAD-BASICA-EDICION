package com.libreria.libreria.repository;

import com.libreria.libreria.entity.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}