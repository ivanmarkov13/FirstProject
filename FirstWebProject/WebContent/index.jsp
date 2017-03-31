<%@page import="java.util.HashSet"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="daoObjs.ProductDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="onlineShop.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="users.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TakeMe</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "top_nav", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})

</script>

</head>

<body>

         <%@ include file="/menu.jsp" %>
         
        <div id="content" class="float_r">
        	<div id="slider-wrapper">
                <div id="slider" class="nivoSlider">
                    <img src="images/slider/02.jpg" alt="" />
                    <a href="#"><img src="images/slider/01.jpg" alt="" title="Products of the day" /></a>
                    <img src="images/slider/03.JPG" alt="" />
                    <img src="images/slider/04.jpg" alt="" title="#htmlcaption" />
                </div>
                <div id="htmlcaption" class="nivo-html-caption">
                 <!--    <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>.   -->
                </div>
            </div>
            <script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
            <script type="text/javascript" src="js/jquery.nivo.slider.pack.js"></script>
            <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
            </script>
        	</div>
        <div id="content" class="float_r">
        	<h1> Products</h1>
        	<!-- <div class="cleaner"></div> -->

            
           <%!ArrayList<Product> products = new ArrayList(); %>	
            <%!HashMap<Long, Product> productFromDao = ProductDAO.getInstance().getAllProducts();%>

            <% 
            	for(Entry<Long, Product> e : productFromDao.entrySet()){
            		products.add(e.getValue());
            	}
            
            %>
            
            
            
            <%for(Product p : products){%>
            
            	<div class="product_box">
		            <h3><%=p.getName()%></h3>
	            	<a href="productdetail.jsp" ><input type = hidden = "<%=p.getName()%>"><img src="images/product/01.jpg" alt="Shoes 1" /></a>
	                <p><%=p.getDescription()%></p>
	                <p class="product_price">$ <%=p.getPrice()%></p>
	                <a href="shoppingcart.html" class="addtocart"></a>
	                <a href="productdetail.html" class="detail"></a>
            	</div>
            	
            <%}%>
            
     		<%products = new ArrayList();%>
            
              
        </div> 
        <div class="cleaner" ></div>
    </div> <!-- END of templatemo_main -->
    
    <div id="templatemo_footer">
    	<p><a href="index.jsp">Home</a> | <a href="products.jsp">Products</a> 
		</p>


    	 <!-- Credit: www.templatemo.com -->
    </div> <!-- END of templatemo_footer -->
    
</div> <!-- END of templatemo_wrapper -->
</div> <!-- END of templatemo_body_wrapper -->

</body>
</html>