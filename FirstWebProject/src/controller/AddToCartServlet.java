package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoObjs.ProductDAO;
import onlineShop.Product;
import users.User;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
	
	
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long product_id =  Long.parseLong(request.getParameter("product_id"));
		Product p = ProductDAO.getInstance().allProducts.get(product_id);
		
		p.incrementSoldPieces();
		
		User u = (User) request.getSession().getAttribute("user");
		
	
		u.addToCart(p);
		
		
		response.sendRedirect("products.jsp");
	}

}
