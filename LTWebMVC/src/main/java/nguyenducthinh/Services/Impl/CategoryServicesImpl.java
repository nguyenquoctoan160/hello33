package nguyenducthinh.Services.Impl;

import java.util.List;

import nguyenducthinh.DAO.Impl.CategoryDAOImpl;
import nguyenducthinh.Models.CategoryModel;
import nguyenducthinh.Services.ICategoryServices;

public class CategoryServicesImpl implements ICategoryServices{

	CategoryDAOImpl cateDAO = new CategoryDAOImpl();
	public List<CategoryModel> findAll() {
		return cateDAO.findAll();
	}

	public void insertCategory(CategoryModel category) {
		cateDAO.insertCategory(category);
	}

	public void deleteCategory(int cateId) {
		cateDAO.deleteCategory(cateId);
	}

	@Override
	public void editCategory(CategoryModel category) {
		cateDAO.editCategory(category);
	}

	@Override
	public CategoryModel find(int cateId) {
		return cateDAO.find(cateId);
	}

	@Override
	public CategoryModel find() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
