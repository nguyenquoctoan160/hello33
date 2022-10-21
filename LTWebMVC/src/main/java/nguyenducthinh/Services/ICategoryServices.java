package nguyenducthinh.Services;

import java.util.List;

import nguyenducthinh.Models.CategoryModel;

public interface ICategoryServices {
	List<CategoryModel> findAll();
	CategoryModel find(int cateId);
	void insertCategory(CategoryModel category);
	void deleteCategory(int cateId);
	void editCategory(CategoryModel category);
	CategoryModel find();
	
}
