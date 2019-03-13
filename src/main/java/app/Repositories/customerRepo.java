package app.Repositories;

import app.Models.modelActor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepo extends CrudRepository<modelActor,Integer> {

}
