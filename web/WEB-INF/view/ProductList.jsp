<%-- 
    Document   : productList
    Created on : May 29, 2023, 5:42:16 AM
    Author     : djamel

<!DOCTYPE html>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./css/productList.css">
        
        <script type="text/javascript" src="./js/productList.js"></script>
       
    </head>
    <body>
      
         
      <div class="container">
  <div class="row">
    <div class="search">
      <label>Search for user</label>
      <input type="search" data-search="data-search" placeholder="Search..."/>
      <div class="recent-search">
      
        <div class="recent-search__list">  
        </div>
      </div>
    </div>
</div>
  <div class="list" id="list" data-searchable="data-searchable">
        <c:forEach items="${products}" var="product">

                     <div class="list-item" href="#" style="display: flex;"  >  
                          <div class="list-item__avatar">
                              <img src="images/${product.image}" alt="${product.name} Image"width="100" height="100" style="background-color: transparent; border: none;background-size: cover ">
			  </div>
			  <div class="list-item__content">
                              <strong class="list-item__name">${product.id} : Product : ${product.name}</strong>
                                <span class="list-item__info"> Price : ${product.selling_price}<br>
                                <span class="list-item__info"> Quantity : ${product.quantity}<br>

			  </div>
                                <c:if test="${user eq 'buyer'}">
              <a href="?action=ajouter&id=${product.id}" type="button" class="list-item__button "style="width: 40px;height: 40px;"> 
                              
  <svg class="feather feather-cart" xmlns="http://www.w3.org/2000/svg" width="28" height="28" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true">
    <circle cx="9" cy="21" r="1" />
    <circle cx="20" cy="21" r="1" />
    <path d="M1 1h4l2.68 13.39a2 2 0 0 0 1.92 1.61h11.64a2 2 0 0 0 1.92-1.61L23 6H6" />
</svg>




			  </a>
                                </c:if>
        <!-- Add other fields as needed -->
                      </div>


                  
        </c:forEach>
         </div>
      </div>
         
    </body>
</html>