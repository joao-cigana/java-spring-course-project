package com.joaocigana.springproject.services;

import com.joaocigana.springproject.entities.User;
import com.joaocigana.springproject.repositories.UserRepository;
import com.joaocigana.springproject.resources.exceptions.DatabaseException;
import com.joaocigana.springproject.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        try{
        repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
