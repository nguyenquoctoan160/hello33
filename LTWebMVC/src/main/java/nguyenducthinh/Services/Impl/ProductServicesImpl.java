package nguyenducthinh.Services.Impl;

import java.util.List;

import nguyenducthinh.DAO.Impl.ProductDAOImpl;
import nguyenducthinh.Models.ProductModel;
import nguyenducthinh.Services.IProductServices;

public class ProductServicesImpl implements IProductServices{
	
	ProductDAOImpl productDAO = new ProductDAOImpl();
	
	@Override
	public List<ProductModel> findAll() {
		return productDAO.findAll();
	}

	@Override
	public ProductModel find(int productId) {
		return productDAO.find(productId);
	}

	@Override
	public List<ProductModel> findCheapest() {
		return productDAO.findCheapest();
	}
	
}
