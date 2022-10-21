package nguyenducthinh.DAO;

import java.util.List;
import nguyenducthinh.Models.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel find(int cateId);
	void insertCategory(CategoryModel category);
	void deleteCategory(int cateId);
	void editCategory(CategoryModel category);
}
