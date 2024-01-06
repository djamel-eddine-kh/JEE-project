<%-- 
    Document   : AddArticleForm
    Created on : May 27, 2023, 10:11:48 PM
    Author     : djamel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
          <body>
     <!--   <h1>Add an article</h1>
        <form action="AddArticle" method="post">
        <div class="textbox">   <input type="text" name="Article_name" placeholder="Article name" required></div>
                <div class="textbox">   <input type="text" name="Quantity" placeholder="Quantity" required></div>
        <div class="textbox">   <input type="text" name="Selling_price" placeholder="Selling_price" required></div>

        <input id="btn22" type="submit" value="ADD "style="width: 70%;
  background: none;
  border:black;
  cursor: pointer;">
    </form>-->
       <div class="card" style="margin-top: 40px;">
                    <div class="card-body">
                        <h3 class="card-title">Add an article </h3>
                        <p class="card-description">

                        </p>
                           
                        <form class="forms-sample" action="AddProduct" method="post"  enctype="multipart/form-data">
                            
                          
                            <div class="form-group row" >
                                <label name="" class="col-sm-2 col-form-label">Product name</label>
                                <div class="col-sm-9">
                                    <input type="text" name="Product_name" placeholder="Product name" required class="form-control" >
                                </div>
                            </div>
                             <div class="form-group row">
                                <label name="" class="col-sm-2 col-form-label">Product quantity</label>
                                <div class="col-sm-9">
                                    <input type="text" name="Quantity" placeholder="Quantity" required class="form-control" >
                                </div>
                            </div>
                              <div class="form-group row">
                                <label name="" class="col-sm-2 col-form-label">Sellign price</label>
                                <div class="col-sm-9">
                                    <input type="text" name="Selling_price" placeholder="Selling_price" required class="form-control" >
                                </div>
                            </div>
                            <div class="form-group row">
<label for="image" class="col-sm-2 col-form-label">Image:</label>
<div class="col-sm-9">
<input type="file" class="form-control" id="image" name="image" required>
  </div>
</div>
                            <button type="submit " class="btn btn-primary me-2 ">Submit</button>
                            <button class="btn btn-light ">Cancel</button>

                        </form>
                    </div>
                </div>
      
    </body>
</html>
