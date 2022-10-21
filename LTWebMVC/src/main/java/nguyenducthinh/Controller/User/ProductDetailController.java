package nguyenducthinh.Controller.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nguyenducthinh.Models.ProductModel;
import nguyenducthinh.Services.Impl.ProductServicesImpl;

@WebServlet(urlPatterns = {"/user/product"})
public class ProductDetailController extends HttpServlet{
	
	ProductServicesImpl productServicesImpl = new ProductServicesImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId = Integer.parseInt(req.getParameter("productId"));
		ProductModel product = productServicesImpl.find(productId);
		req.setAttribute("product", product);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/product.jsp");
		rd.forward(req, resp);
		
	}

	private static final long serialVersionUID = 1L;

}
