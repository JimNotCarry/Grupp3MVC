package com.grupp3.grupp3mvc;

import com.grupp3.grupp3mvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDRepository extends JpaRepository<Product, Integer> {
}
