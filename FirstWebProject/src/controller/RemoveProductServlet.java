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
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/removeProduct")
public class RemoveProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long product_id = Long.parseLong(request.getParameter("product_id"));
		Product p = ProductDAO.getInstance().allProducts.get(product_id);
		User u = (User) request.getSession().getAttribute("user");
				 
		u.removeProduct(p);
		
		
		response.sendRedirect("shoppingcart.jsp");
		
	}

}
