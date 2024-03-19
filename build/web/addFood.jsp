<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Food Product</title>
    <!-- Link đến CSS của Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Add Food Product</h1>
        <form action="add-product" method="post">
            <div class="form-group">
                <label for="food-name">Food Name:</label>
                <input type="text" class="form-control" id="food-name" name="food-name">
            </div>
            <div class="form-group">
                <label for="food-img">Food Image URL:</label>
                <input type="text" class="form-control" id="food-img" name="food-img">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="text" class="form-control" id="price" name="price">
            </div>
            <div class="form-group">
                <label for="menu-id">Menu ID:</label>
                <input type="text" class="form-control" id="menu-id" name="menu-id">
            </div>
            <button type="submit" class="btn btn-primary">Add Food</button>
        </form>
    </div>
    <!-- Link đến các script của Bootstrap -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>