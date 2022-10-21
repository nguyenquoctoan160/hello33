package nguyenducthinh.Controller.Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenducthinh.Services.Impl.CategoryServicesImpl;

@WebServlet(urlPatterns= {"/admin/category/delete"})
public class CategoryDeleteController extends HttpServlet{
	CategoryServicesImpl categoryServicesImpl = new CategoryServicesImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int cateId = Integer.parseInt(req.getParameter("cateId"));
			categoryServicesImpl.deleteCategory(cateId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		
	}

	private static final long serialVersionUID = 1L;
	
	
}
