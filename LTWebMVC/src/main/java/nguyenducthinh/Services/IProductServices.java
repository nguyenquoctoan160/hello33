package nguyenducthinh.Services;

import java.util.List;

import nguyenducthinh.Models.ProductModel;

public interface IProductServices {
	List<ProductModel> findAll();
	List<ProductModel> findCheapest();
	ProductModel find(int productId);
}
