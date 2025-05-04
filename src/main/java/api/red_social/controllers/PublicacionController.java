package api.red_social.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.red_social.models.Publicacion;
import api.red_social.services.PublicacionService;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService service;

    @Autowired
    public PublicacionController(PublicacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Publicacion> getAll() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> getById(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicacion create(@RequestBody Publicacion publicacion) {
        return service.crear(publicacion);
    }

    @PutMapping("/id")
    public Publicacion update(@PathVariable String id, @RequestBody Publicacion publicacion) {
        return service.actualizar(id, publicacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
