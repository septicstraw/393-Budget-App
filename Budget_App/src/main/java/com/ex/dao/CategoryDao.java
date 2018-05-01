package com.ex.dao;

import java.io.Serializable;
import java.util.List;

import com.ex.bgt.domain.Category;

public interface CategoryDao {

	public Category getCategoryById(int id);
	
	public Category getCategoryByID(int id);
	
	public Category getCategoryByName(String name);

	public List<Category> getAllCategories();
	
	public Serializable saveCategory(Category category);
	
	public void updateCategory(Category category);
	
	public void deleteCategory(Category category);

}
