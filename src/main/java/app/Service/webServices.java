package app.Service;

import app.Models.modelActor;
import app.Repositories.customerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class webServices {

    @Autowired
    private customerRepo repo;

    public Iterable<modelActor> findAllService() {
        return repo.findAll();
    }

    public modelActor findByIdService(Integer id){
        return repo.findById(id).get();
    }
}
