package com.libreria.libreria.service;

import com.libreria.libreria.entity.Gasto;
import com.libreria.libreria.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    public List<Gasto> listarTodos() {
        return gastoRepository.findAll();
    }

    public Gasto guardar(Gasto gasto) {
        return gastoRepository.save(gasto);
    }
}