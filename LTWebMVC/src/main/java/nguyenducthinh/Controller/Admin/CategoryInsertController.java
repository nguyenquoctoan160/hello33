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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import nguyenducthinh.Models.CategoryModel;
import nguyenducthinh.Services.Impl.CategoryServicesImpl;
import nguyenducthinh.Utils.Constant;

@WebServlet(urlPatterns = {"/admin/category/insert"})
public class CategoryInsertController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");			
		try {
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html");
				resp.setCharacterEncoding("utf-8");
				
				
				List<FileItem> items = servletFileUpload.parseRequest(req);
				for (FileItem item : items) {
				if (item.getFieldName().equals("categoryName")) {
						category.setCateName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("categoryImage")) {
					//phuong thuc getName la cua input type file
					String originalFileName = item.getName();
					//xu ly ten file name
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() + "." + ext;
					File file = new File(Constant.DIR + "/category/" + fileName);
					item.write(file);
					category.setImages("category/" + fileName);
					category.setStatus(1);
				} 
			}
			categoryServicesImpl.insertCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath()+"/admin/category/list");
	}
	private static final long serialVersionUID = 1L;
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();

}
