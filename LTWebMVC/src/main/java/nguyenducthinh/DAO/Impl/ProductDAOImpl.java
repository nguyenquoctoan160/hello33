package nguyenducthinh.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nguyenducthinh.Connection.DBConnection;
import nguyenducthinh.DAO.IProductDAO;
import nguyenducthinh.Models.ProductModel;

public class ProductDAOImpl extends DBConnection implements IProductDAO{

	public List<ProductModel> findAll() {
		List<ProductModel> products = new ArrayList<ProductModel>();
		String sql = "Select * From Product";
		
		//cột nào là số thì mặc định là 0
		//cột nào là String hoặc Date thì mặc định là null
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getNString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getNString("images"));
				products.add(product);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public ProductModel find(int productId) {
		String sql = "Select * From Product Where productId = ?";		
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getNString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getNString("images"));
				return product;				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		ProductDAOImpl tao = new ProductDAOImpl();
		for(ProductModel pro : tao.findAll()) {
			System.out.println(pro);
		}
		//để test
		/* tao.findAll(); */
		/*
		 * System.out.println(tao.find(3));
		 */		
	}

	@Override
	public List<ProductModel> findCheapest() {
		List<ProductModel> cheapestProducts= new ArrayList<ProductModel>();
		String sql = "Select Top 4 * From  Product Order By price";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ProductModel product = new ProductModel();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getNString("productName"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setDescription(rs.getNString("description"));
				product.setPrice(rs.getFloat("price"));
				product.setAmount(rs.getInt("amount"));
				product.setStock(rs.getInt("stock"));
				product.setImages(rs.getNString("images"));
				cheapestProducts.add(product);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cheapestProducts;
	}

}
