<%-- 
    Document   : CartList
    Created on : Nov 16, 2023, 2:24:00 AM
    Author     : djamel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
          <link rel="stylesheet" href="./css/invoice.css">
         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
    
.list-item__avatar img {
  border: 1px solid #cacfd9;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  background-color: #e1e4ea;
}
</style>
    </head>
  <body>
   

    <div class="modal-body" id="invoiceLineModalBody">
    <h2 class="clearfix"><small><span>DATE :</span>2023-11-16</small> <br/>Product</h2>
    <table>
      <thead>
        <tr>
          <th class="service">Product id</th>
          <th class="desc">Product</th>
          <th>QTY</th>
          <th>PRICE</th>
          <th>TOTAL</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${products}" var="product">
          <tr>
              
            <td class="service">${product.id}</td>
            <td class="desc">${product.name}
             <div class="list-item__avatar">
                              <img src="images/${product.image}" alt="${product.name} Image"width="100" height="100" style="background-color: transparent; border: none;background-size: 50px 50px ">
			  </div></td>
            <td class="unit">${product.quantity}</td>
            <td class="qty">${product.selling_price}</td>
            <td class="total">${product.total_price}</td>
          </tr>
        </c:forEach>
        <tr>
          <td colspan="4" class="grand total">GRAND TOTAL</td>
          <td class="grand total">${grandtotal}</td>
        </tr>
      </tbody>
    </table>
    <div id="details" class="clearfix">
      <div id="project">
          
        <div class="arrow">
          <div class="inner-arrow"><span>Payment :</span></div>
        </div>
        <br>
        <div class="arrow">
          <div class="inner-arrow"><span>Seller :</span> ${product.buyer}</div>
        </div>
        <br>
     
      </div>
    </div>
  </div>
    </div>
  </div>
 
  <footer>
      <br>
      <br>
    Thank you for choosing us.
  </footer>
        
        <br>
</body>

</html>
