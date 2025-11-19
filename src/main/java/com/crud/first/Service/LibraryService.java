package com.crud.first.Service;

import com.crud.first.Repository.LibraryRepository;
import com.crud.first.entity.LibraryEntity;
import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepository repository;

    public LibraryEntity create(LibraryEntity entity){
            return repository.save(entity);
    }

    public LibraryEntity getById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Library with id: " + id + "doesn't exists"));
    }

    public LibraryEntity update(Long id, LibraryEntity DATA){
        if (!repository.existsById(id)){
            return null;
        }
        DATA.setId(id);
        return repository.save(DATA);
    }

    public Boolean delete(Long id){
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }



}
