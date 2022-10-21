package nguyenducthinh.Controller.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenducthinh.Models.ProductModel;
import nguyenducthinh.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns= {"/user/home"})
public class HomeController extends HttpServlet{

	ProductServicesImpl productService = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductModel> productList = productService.findAll();
		List<ProductModel> top4CheapestProducts = productService.findCheapest();
		req.setAttribute("productList", productList);
		req.setAttribute("top4CheapestProducts", top4CheapestProducts);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}

	private static final long serialVersionUID = 1L;

}
