package nguyenducthinh.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenducthinh.Models.CategoryModel;
import nguyenducthinh.Services.Impl.CategoryServicesImpl;


@WebServlet(urlPatterns= {"/admin/category/list"})
public class CategoryListController extends HttpServlet{
	
	CategoryServicesImpl cateService = new CategoryServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> cateList = cateService.findAll();
		req.setAttribute("categoryList", cateList);
		RequestDispatcher rq = req.getRequestDispatcher("/views/list-category.jsp");
		rq.forward(req, resp);
	}

	private static final long serialVersionUID = 1L;
	
	
	
}
