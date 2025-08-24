package com



    // 7) DELETE /gastos/{id} -> eliminar por id (opcional)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarGasto(@PathVariable Long id) {
        gastoService.deleteGasto(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
