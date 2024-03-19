<%@page import="entity.Food"%>
<%@page import="repository.FoodRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Edit Dish</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            .container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h2 {
                margin-bottom: 20px;
                text-align: center;
            }

            form {
                margin-top: 20px;
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            input[type="text"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            .back-link {
                display: block;
                text-align: center;
                margin-top: 20px;
                color: #666;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Edit Dish</h2>
            <%-- Lấy thông tin của sản phẩm từ request --%>
            <%
                FoodRepository foodRe = new FoodRepository();
                Food food = new Food();
                int idFood = Integer.parseInt(request.getParameter("idFood"));
                food = foodRe.getFoodById(idFood);
            %>
            <form action="update-product" method="post">
                <input type="hidden" name="food-id" value="<%=idFood%>">
                <!-- Điền thông tin sản phẩm vào các trường chỉnh sửa -->
                <label for="title">Name</label>
                <input type="text" id="food-name" name="food-name" value="<%= food.getFood_name()%>">
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" value="<%= food.getPrice()%>">

                <label for="image">Image URL:</label>
                <input type="text" id="food-img" name="food-img" value="<%= food.getFood_img()%>">

                <label for="menu-id">Menu</label>
                <input type="number" id="menu-id" name="menu-id" value="<%= food.getMenu_id()%>">
                <input type="submit" value="Update Food"/>
            </form>
            <!-- Các liên kết hoặc nút để quay lại trang danh sách nếu cần -->
            <a href="admin.jsp" class="back-link">Back to List</a>
        </div>
    </body>
</html>