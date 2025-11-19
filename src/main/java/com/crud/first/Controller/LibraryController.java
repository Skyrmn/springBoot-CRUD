package com.crud.first.Controller;


import com.crud.first.Service.LibraryService;
import com.crud.first.entity.LibraryEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Library")
public class LibraryController {
    private final LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @PostMapping
    public LibraryEntity create(@RequestBody LibraryEntity entity){
        return (LibraryEntity) service.create(entity);

    }

    @GetMapping("/{id}")
    public LibraryEntity findBgId(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public LibraryEntity update(@PathVariable Long id, @RequestBody LibraryEntity DATA){
        return service.update(id, DATA);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return service.delete(id) ? "DELETED" : "NOT FOUND 404";
    }



}
