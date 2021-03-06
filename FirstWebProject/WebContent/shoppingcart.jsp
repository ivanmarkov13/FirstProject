<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="users.User"%>
<%@page import="onlineShop.Product"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ShoppingCart</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

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
        	<h1>Shopping Cart</h1>
        	<table width="680px" cellspacing="0" cellpadding="5">
                 	<tr bgcolor="#ddd">
	                     	<th width="220" align="left">Image </th> 
	                     	<th width="180" align="left">Description </th> 
	                    	<th width="100" align="center">Quantity </th> 
	                     	<th width="60" align="right">Price </th> 
	                     	<th width="60" align="right">Total </th>
	            			<th width="90"> </th>
                	</tr>
					
					<%User u = (User)session.getAttribute("user");%>
					<%HashMap<Product, Integer> prod = u.getShoppingCart();%>
					
					<%if(!prod.isEmpty()){%>
					
						<%for(Entry<Product, Integer> e : prod.entrySet()){ %>
							<%double totalPrice = e.getKey().getPrice() * e.getValue();%>
							<tr>
					                <td><img src="images/product/01.jpg" alt="image 1" /></td> 
					                <td><%=e.getKey().getDescription()%></td> 
					                <td align="center"><input type="text" value="<%=e.getValue()%>" style="width: 20px; text-align: right" /> </td>
					                <td align="right">$<%=e.getKey().getPrice()%> </td> 
					            	<td align="right">$ 100 </td>
					            	<form action="removeProduct" method="post">
					            		<input type="hidden" name="product_id" value="<%=e.getKey().getProduct_id()%>" name="product_id"/>
					        			
										<td align="center"> <button align="center" type="submit"/> <a href="#"><img src="images/remove_x.gif" alt="remove" /><br />Remove</a>  </td>
									</form>
									
							</tr>         
							           	
						
						<%} %>
					<%}
					else{%>
						<h1>Your shopping cart is empty at the moment</h1>
					<%}%>
					
			</table>
			
			



			


               

			
            <div style="float:right; width: 215px; margin-top: 20px;">
                    
            <p><a href="javascript:history.back()">Continue shopping</a></p>
                    	
            </div>
			</div>
        <div class="cleaner"></div>
     </div> <!-- END of templatemo_main --> 
    
    <div id="templatemo_footer">
    	<p><a href="index.jsp">Home</a> | <a href="products.jsp">Products</a> 
		</p>	
    </div> <!-- END of templatemo_footer -->
    
 </div> <!-- END of templatemo_wrapper -->
 </div> <!-- END of templatemo_body_wrapper -->

</body>
</html>