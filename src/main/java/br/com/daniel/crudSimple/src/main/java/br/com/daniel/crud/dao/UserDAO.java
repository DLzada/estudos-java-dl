package br.com.daniel.crud.dao;

import br.com.daniel.crud.exception.UserNotFoundException;
import br.com.daniel.crud.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private log nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model){
        model.setId(nextId++);
        model.add(model);
        return model;
    }

    public userModel update(final UserModel model){
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id){
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id){
        var message = String.format("Não existe com o id %s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }

    public List<UserModel> findAll(){
        return models;
    }
}
