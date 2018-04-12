package com.ex.dao;

import java.io.Serializable;
import java.util.List;

import com.ex.bgt.domain.SubCategory;

public interface SubCategoryDao {
	
	public SubCategory getSubCategoryById(int id);
	
	public SubCategory getSubCategoryByName(String name);

	public List<SubCategory> getAllSubCategories();
	
	public Serializable saveSubCategory(SubCategory subcategory);
	
	public void deleteSubCategory(SubCategory subcategory);
	
	public void updateSubCategory(SubCategory subcategory);
	
}
