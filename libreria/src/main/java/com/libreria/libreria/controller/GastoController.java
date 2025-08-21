package com.libreria.libreria.controller;

import com.libreria.libreria.entity.Gasto;
import com.libreria.libreria.service.GastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                 // 1) Indica que esta clase responde HTTP y devuelve JSON
@RequestMapping("/gastos")      // 2) Prefijo de todas las rutas: /gastos
@CrossOrigin(origins = "*")     // 3) Permite llamadas desde cualquier origen (útil para pruebas)
public class GastoController {

    private final GastoService gastoService;

    // 4) Constructor: inyecta el service (forma recomendada)
    public GastoController(GastoService gastoService) {
        this.gastoService = gastoService;
    }

    // 5) GET /gastos -> devuelve la lista completa
    @GetMapping
    public ResponseEntity<List<Gasto>> listarTodos() {
        List<Gasto> lista = gastoService.getAllGastos();
        return ResponseEntity.ok(lista); // 200 OK con la lista en JSON
    }

    // 6) POST /gastos -> guarda un nuevo gasto. Body debe ser JSON.
    @PostMapping
    public ResponseEntity<Gasto> crearGasto(@RequestBody Gasto gasto) {
        Gasto guardado = gastoService.saveGasto(gasto);
        return ResponseEntity.ok(guardado); // devuelve el gasto con id asignado
    }

    // 7) DELETE /gastos/{id} -> eliminar por id (opcional)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarGasto(@PathVariable Long id) {
        gastoService.deleteGasto(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
