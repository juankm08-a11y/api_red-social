package api.red_social.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import api.red_social.models.Publicacion;

public interface PublicacionRepository extends MongoRepository<Publicacion, String> {
    List<Publicacion> findByAutorId(String autorId);
}
