package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import daoObjs.ProductDAO;
import onlineShop.Product;

/**
 * Servlet implementation class AddProductImageServlet
 */
@WebServlet("/UploadPhotoServlet")
public class UploadPhotoServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if(!ServletFileUpload.isMultipartContent(request)){
			out.println("Nothing to upload.");
			return;
		}
		
		FileItemFactory itemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemFactory);
		try{
			java.util.List<FileItem> items = upload.parseRequest(new ServletRequestContext(request));
			for (FileItem item : items) {
				
				String contentType = item.getContentType();
				if(!contentType.equals("image/png")){
					out.println("only png format is accepted!");
					continue;
				}
//				String sep = File.pathSeparator;
				File uploadDir = new File("E:\\UploadedFiles");
				File file =  File.createTempFile("product", ".png", uploadDir);
				
				item.write(file);
				String fileName = file.getName();
				HttpSession session = request.getSession();
				ProductDAO.getInstance().addImgPath((Product) session.getAttribute("product"), fileName);
			}
		}
		catch (FileUploadException e) {
			out.println("can't upload file " + e.getMessage());
		}
		catch (Exception e) {
			out.println("can't save to file " + e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("uploadPhotoUser.html");
	}
	
}

