package nguyenducthinh.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import nguyenducthinh.Models.CategoryModel;
import nguyenducthinh.Services.Impl.CategoryServicesImpl;
import nguyenducthinh.Utils.Constant;

@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryEditController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel categoryNew = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
				servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("categoryId")) {
					categoryNew.setCateId(Integer.parseInt(item.getString()));
				}
				else if (item.getFieldName().equals("categoryName")) {
					categoryNew.setCateName(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("status")) {
					categoryNew.setStatus(Integer.parseInt(item.getString()));
				}
				else if (item.getFieldName().equals("images")) {
					if (item.getSize() > 0) {// neu co file d
						String originalFileName = item.getName();
						int index = originalFileName.lastIndexOf(".");
						String ext = originalFileName.substring(index + 1);
						String fileName = System.currentTimeMillis() + "." + ext;
						File file = new File(Constant.DIR + "/category/" + fileName);
						item.write(file);
						categoryNew.setImages("category/" + fileName);
					} 
					else {
						categoryNew.setImages(null);
					}
				}
				
			}
			categoryServicesImpl.editCategory(categoryNew);
		} 
		catch (FileUploadException e) { e.printStackTrace();} 
		catch (Exception e) { e.printStackTrace();}
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
				
		/*
		 * categoryNew.setCateId(Integer.parseInt(req.getParameter("categoryId")));
		 * categoryNew.setCateName(req.getParameter("categoryName"));
		 * categoryNew.setStatus(Integer.parseInt(req.getParameter("status")));
		 */	
	}
	

	private static final long serialVersionUID = 1L;
	
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cateId = Integer.parseInt(req.getParameter("cateId"));
		CategoryModel categoryToEdit =  categoryServicesImpl.find(cateId);
		req.setAttribute("category", categoryToEdit);
		RequestDispatcher rd = req.getRequestDispatcher("/views/edit-category.jsp");
		rd.forward(req, resp);
	}
}
