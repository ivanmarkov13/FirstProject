package controller;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

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
				System.out.println(req.getParameter("name") == null);
				String name = req.getParameter("name");
				System.out.println(req.getParameter("description") == null);
				String description = req.getParameter("description");
//				double price = Double.valueOf(req.getParameter("price"));
				System.out.println(req.getParameter("price") == null);
				double price = Double.parseDouble(req.getParameter("price"));
				
				int quantity = Integer.valueOf(req.getParameter("quantity"));
				String bdate = req.getParameter("birthdate");
				String category = req.getParameter("category");
				User u = (User) req.getSession().getAttribute("user");
				System.out.println((u==null)+"*******");
				Product p = new Product(name, description, price, quantity, (int)u.getUser_id(), ProductCategory.ADVENTURE);
				ProductDAO.getInstance().addProduct(p, u);
				HttpSession session = req.getSession();
				session.setAttribute("product", p);
				
				resp.sendRedirect("addProductImage.html");
				
				
				
}


}
