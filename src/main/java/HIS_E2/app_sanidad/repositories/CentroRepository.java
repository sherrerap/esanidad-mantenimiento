package HIS_E2.app_sanidad.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import HIS_E2.app_sanidad.model.Centro;

@Repository
public interface CentroRepository extends MongoRepository<Centro, String> {
  @Query(value = "{ 'nombre' : ?0, 'localidad' : ?1}")
  Centro findByNombre(String nombreCentro, String localidadCentro);

}
