package com.libreria.libreria.service;

import com.libreria.libreria.entity.Venta;
import com.libreria.libreria.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public List<Venta> listarTodos() {
        return ventaRepository.findAll();
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }
}