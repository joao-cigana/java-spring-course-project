package com.joaocigana.springproject.repositories;

import com.joaocigana.springproject.entities.Product;
import com.joaocigana.springproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
