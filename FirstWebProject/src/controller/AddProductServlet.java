package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import daoObjs.ProductDAO;
import daoObjs.UserDAO;
import onlineShop.Product;
import onlineShop.Product.ProductCategory;
import users.User;


@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("addProduct.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//TODO validacia ako validaciqta na frontend nivo spre ili ako ima veche takuv registriran potrebitel
				String name = req.getParameter("name");
				String description = req.getParameter("description");
				Double price = Double.valueOf(req.getParameter("price"));
				Integer quantity = Integer.valueOf(req.getParameter("quantity"));
				String bdate = req.getParameter("birthdate");
				String category = req.getParameter("category");
				User u = (User) req.getSession().getAttribute("user");
				Product p = new Product(name, description, price, quantity, (int)u.getUser_id(), ProductCategory.ADVENTURE);
				ProductDAO.getInstance().addProduct(p, u);
				resp.sendRedirect("profile.html");
	}


}
