package nguyenducthinh.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nguyenducthinh.Connection.DBConnection;
import nguyenducthinh.DAO.ICategoryDAO;
import nguyenducthinh.Models.CategoryModel;

public class CategoryDAOImpl extends DBConnection implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {		
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		String sql = "Select * From Category";
		
		try {
			//getConnetion ket noi db
			Connection conn = super.getConnection();
			//ném câu sql vào để thực thi
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCateId(rs.getInt(1));
				category.setCateName(rs.getString(2));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				categories.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public void insertCategory(CategoryModel category) {
		String sql = "Insert Into Category(categoryName,images,status) Values(?,?,?)";
		try {
			Connection conn = super.getConnection();//getConnetion ket noi db
			PreparedStatement ps = conn.prepareStatement(sql);//ném câu sql vào để thực thi
			ps.setString(1, category.getCateName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(int cateId) {
		String sql = "Delete From Category Where categoryId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Integer.toString(cateId));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public CategoryModel find(int cateId) {
		String sql = "Select * From category Where categoryId = ? ";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cateId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCateId(rs.getInt(1));			
				category.setCateName(rs.getString(2));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt(4));
				return category;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void editCategory(CategoryModel category) {
		String sql = "Update category Set categoryName = ?,images= ?,status = ? Where categoryId = ?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//dua cac tham so can thiet vao ps
			ps.setString(1, category.getCateName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCateId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
