package com.toyproj.pinchhitterhomerun.repository.interfaces;

import com.toyproj.pinchhitterhomerun.entity.Brand;

import java.util.List;

public interface IBrandRepository {
    List<Brand> findAll();
    List<Brand> findByCategoryId(Long categoryId);
    Brand findByName(String name);
    Brand findById(Long id);
}
