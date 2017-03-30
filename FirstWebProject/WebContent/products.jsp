<%@page import="java.time.LocalDate"%>
<%@page import="users.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Products</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css" href="css/ddsmoothmenu.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ddsmoothmenu.js">

/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

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

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="#">Offers for everyone</a></h1></div>
        <div id="header_right">
        	<p>
	        <a href="profile.html">My Profile</a> | <a href="shoppingcart.html">My Cart</a> | <a href="regis.html">Log In / Registration</a></p>
            <p>
            	<font color="#FFFFFF"> Shopping Cart:  ( </font> <a href="shoppingcart.html">Show Cart</a> <font color="#FFFFFF"> ) </font>
			</p>
		</div>
        <div class="cleaner"></div>
    </div> <!-- END of templatemo_header -->
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="products.jsp" class="selected">Products</a>
                    <ul>
                        <li><a href="#submenu1">Sub menu 1</a></li>
                        <li><a href="#submenu2">Sub menu 2</a></li>
                        <li><a href="#submenu3">Sub menu 3</a></li>
                        <li><a href="#submenu4">Sub menu 4</a></li>
                        <li><a href="#submenu5">Sub menu 5</a></li>
                  </ul>
                </li>
            </ul>
            <br style="clear: left" />
        </div> <!-- end of ddsmoothmenu -->
        
    </div> <!-- END of templatemo_menubar -->
    
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categories</h3>   
                <div class="content"> 
                	<ul class="sidebar_list">
                    	<li class="first"><a href="#">Sed eget purus</a></li>
                        <li><a href="#">Vestibulum eleifend</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li><a href="#">Nulla odio ipsum</a></li>
                        <li><a href="#">Suspendisse posuere</a></li>
                        <li><a href="#">Nunc a dui sed</a></li>
                        <li><a href="#">Curabitur ac mauris</a></li>
                        <li><a href="#">Mauris nulla tortor</a></li>
                        <li><a href="#">Nullam ultrices</a></li>
                        <li class="last"><a href="#">Sed eget purus</a></li>
                    </ul>
                </div>
            </div>
           
        </div>
        <div id="content" class="float_r">
        	<h1> Products</h1>
        	<!-- <div class="cleaner"></div> -->
                   	
                   	
            
            
            <% for(int i=0;i<10;i++){ %>
    		<%!User user = new  User("vankata","dasds","das",LocalDate.now(),"das","2121",5.1);%>
      		<div class="product_box">
            <h3>Ut eu feugiat</h3>
           	<a href="productdetail.html"><img src="images/product/01.jpg" alt="Shoes 1" /></a>
            <p><%=user.getMoney()%></p>
            <p class="product_price">$ <%=user.getMoney()%>  </p>
            <a href="shoppingcart.html" class="addtocart"></a>
            <a href="productdetail.html" class="detail"></a>
			</div> 
    
			<%}%>
            
            ${user}<input name="${user.getName()}" type="text" />
			<input name="<%=user.getMoney()%>" type="text" />
			
            
              
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