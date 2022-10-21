package nguyenducthinh.DAO;

import java.util.List;

import nguyenducthinh.Models.ProductModel;

public interface IProductDAO {
	List<ProductModel> findAll();
	ProductModel find(int productId);
	List<ProductModel> findCheapest();
}
