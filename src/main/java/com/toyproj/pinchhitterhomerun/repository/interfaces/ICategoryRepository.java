package com.toyproj.pinchhitterhomerun.repository.interfaces;

import com.toyproj.pinchhitterhomerun.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findByName(String name);
    Category findById(Long id);
}