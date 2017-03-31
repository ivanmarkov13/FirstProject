<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Menu</title>
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

<div id="templatemo_body_wrapper">
<div id="templatemo_wrapper">

	<div id="templatemo_header">
    	<div id="site_title"><h1><a href="#">Offers for everyone</a></h1></div>
        <div id="header_right">
        	<p>
        	<%
	         	if(!(Boolean)session.getAttribute("logged")){ %>
	        	  <a href="regis.html">My Profile</a>
	         	<%}
	         	else{ %>
	         		<a href="profile.jsp">My Profile</a>
	         	<%}
	         %>
	       
	         |<a href="shoppingcart.jsp">My Cart</a> 
	         
	         |<%
	         	if((Boolean)session.getAttribute("logged")){ %>
	        	 <a href="wrongClickLogin.html">Log In / Registration</a>
	         	<%}
	         	else{ %>
	         		<a href="regis.html">Log In / Registration</a>
	         	<%}
	         %>
	        </p>
            <p>
            	<font color="#FFFFFF"> Shopping Cart:  ( </font> <a href="shoppingcart.jsp">Show Cart</a> <font color="#FFFFFF"> ) </font>
			</p>
		</div>
        <div class="cleaner"></div>
    </div> 
    
    <div id="templatemo_menubar">
    	<div id="top_nav" class="ddsmoothmenu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="products.jsp">Products</a>
                    <ul>
                        <li><a href="#submenu1">Beauty</a></li>
                        <li><a href="#submenu2">Spa</a></li>
                        <li><a href="#submenu3">Trip</a></li>
                        <li><a href="#submenu4">Food</a></li>
                        <li><a href="#submenu5">Adventure</a></li>
                        <li><a href="#submenu4">Second Hand</a></li>
                        <li><a href="#submenu5">Brand New</a></li>
                  </ul>
                </li>
             </ul>
            <br style="clear: left" />
        </div> 

    </div> 
     
    <div id="templatemo_main">
    	<div id="sidebar" class="float_l">
        	<div class="sidebar_box"><span class="bottom"></span>
            	<h3>Categories</h3>   
                <div class="content"> 
                	<ul class="sidebar_list">
                    	<li class="first"><a href="#">Beauty</a></li>
                        <li><a href="#">Spa</a></li>
                        <li><a href="#">Trip</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Second Hand</a></li>
                        <li class="last"><a href="#">Brand New</a></li>
                    </ul>
                </div>
            </div>
            
        </div>


</body>
</html>