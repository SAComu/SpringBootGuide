package app.Controller;

import app.Repositories.customerRepo;
import app.Models.modelActor;
import app.Service.webServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    //GET:
    // - Find All                               (DONE)
    // - Find By ID                             (DONE)
    // - Find by Filtering string or ID
    // - Filtering by list
    //
    //POST: - (POST is NOT idempotent)
    // - Create new row (general use)
    // - Update row
    //
    //PUT - (PUT replaces an existing entity. If only a subset of data elements are provided, the rest will be replaced with empty or null.) (POST is idempotent)
    // - Create new row
    // - Update row (general use)
    //
    //PATCH (depreciated? + unsafe)
    // - Alter row/update row
    //
    //DELETE
    // - Delete by ID
    //
    // --------------------------
    // - Extra Info of responses: -
    //Status codes indicate the result of the HTTP request.
    //
    //1XX - informational
    //2XX - success
    //3XX - redirection
    //4XX - client error
    //5XX - server error
    @Autowired
    private customerRepo repo;

    @Autowired
    private webServices service;

    //Get - FIND ALL
    @GetMapping(path = "/findall")
    public @ResponseBody Iterable<modelActor> getAllUser() {
        return repo.findAll();
//        return service.findAllService();
    }

    //GET - FIND BY ID
    @GetMapping(path = "/findbyid/{id}")
    public @ResponseBody modelActor getById(@PathVariable Integer id) {
        return repo.findById(id).get();
//        return service.findByIdService(id);
    }
    //Post
    @PostMapping(path = "/postmap")
    public @ResponseBody modelActor postactor(@RequestBody modelActor mActor){
        return repo.save(mActor);
    }

    //PUT
    @PutMapping(path = "/puttingbyid/{id}")
    public @ResponseBody modelActor putbyid(@PathVariable Integer id, @RequestBody modelActor mActor){
        return repo.findById(id)
                .map(modelActor -> {
                    modelActor.setFirst_name(mActor.getFirst_name());
                    modelActor.setLast_name(mActor.getLast_name());
                    modelActor.setLast_update(mActor.getLast_update());
                    return repo.save(modelActor);
                }).orElseGet(()->{
                    mActor.setActor_id(id);
                    return repo.save(mActor);
                });
    }
    // DELETE - delete by id
    @DeleteMapping(value = "/deletebyid/{id}")
    void deleteActor(@PathVariable Integer id){
        repo.deleteById(id);
    }
//    public void deleteActor


}
