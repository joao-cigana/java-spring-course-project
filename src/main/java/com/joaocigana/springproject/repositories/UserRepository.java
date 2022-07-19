package com.joaocigana.springproject.repositories;

import com.joaocigana.springproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
