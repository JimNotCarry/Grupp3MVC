package com.grupp3.grupp3mvc;

import com.grupp3.grupp3mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDRepository extends JpaRepository<Product, Integer> {
}
//Product står för våran pojo och kopplar vi till våran databas