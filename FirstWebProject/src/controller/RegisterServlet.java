package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoObjs.UserDAO;
import users.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//TODO validacia ako validaciqta na frontend nivo spre ili ako ima veche takuv registriran potrebitel
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String bdate = req.getParameter("birthdate");
		String email = req.getParameter("email");
		String phoneNum = req.getParameter("phonenumber");
		Double money = Double.valueOf(req.getParameter("money"));
		User u = new User(username, password, name,	LocalDate.parse(bdate), email, phoneNum, money);
		UserDAO.getInstance().addUser(u);
		//TODO index page
		resp.sendRedirect("regis.html");
	}

}
