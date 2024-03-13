<%@page import="entity.Food"%>
<%@page import="repository.FoodRepository"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entity.OrderDetail"%>
<%@page import="entity.Payment"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="./assets/favicon/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="./assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="./assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="./assets/favicon/site.webmanifest">
    <meta name="msapplication-TileColor" content="#da532c">
    <meta name="theme-color" content="#ffffff">

    <!-- Embed Font -->
    <link rel="stylesheet" href="assets/font/stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sora:wght@100..800&display=swap" rel="stylesheet">

    <!-- SCSS -->
    <link rel="stylesheet" href="./assets/css/main.css">

    <!-- Fontawesome -->
    <link rel="stylesheet" href="./assets/fontawesome/css/all.min.css">

    <!-- Script -->
    <script src="./assets/js/script.js"></script>
    <title>Confirmation</title>
</head>

<body>
    <main class="check-out">
        <div class="breadcrumbs">
            <div class="container">
                <ul class="breadcrumbs__list">
                    <li class="breadcrumbs__item active">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">1</div>
                            <span class="breadcrumbs__title">Order</span>
                        </div>
                    </li>
                    <li class="breadcrumbs__item line active">
                        <div class="breadcrumbs__line"></div>
                    </li>
                    <li class="breadcrumbs__item active">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">2</div>
                            <span class="breadcrumbs__title">Confirmation</span>
                        </div>
                    </li>
                    <li class="breadcrumbs__item line">
                        <div class="breadcrumbs__line"></div>
                    </li>
                    <li class="breadcrumbs__item">
                        <div class="breadcrumbs__content">
                            <div class="breadcrumbs__number">3</div>
                            <span class="breadcrumbs__title">Ready</span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="check-out__content">
            <div class="container">
                <article class="payment-cart">
                    <div class="payment-cart__inner">
                        <div class="confirmation__inner">
                            <img src="./assets/images/hourglass.svg" alt="hourglass" class="hourglass-img">
                            <div>
                                <span class="confirmation__title">Sent to the restaurant</span>
                                <p class="confirmation__text">Wait until we confirm it</p>
                            </div>
                        </div>
                        </div>
                </article>
                <article class="payment-cart">
                    <div class="payment-cart__inner">
                        <div class="confirmation__content">
                            <div class="confirmation__order--detail">
                                <span class="payment-cart__title">Your order</span>
                                <ul class="order__detail--list">
                                    <%
                                        FoodRepository foodRepository = new FoodRepository();
                                        List<OrderDetail> orderList = (ArrayList<OrderDetail>)request.getAttribute("orderList");
                                        if(!orderList.isEmpty()) {
                                            for(OrderDetail or : orderList) {
                                                Food food = foodRepository.getFoodbyId(or.getFood_id());
                                    %>
                                        <li class="order__detail--item">
                                            <span class="order__item--title"><%= or.getQuantity() %> x <%= food.getFood_name() %></span>
                                            <p class="order__item--price">$<%= or.getQuantity() * food.getPrice() %>.00</p>
                                        </li>
                                    <%
                                        }}
                                    %>
                                </ul>
                                <span class="order__detail--item">
                                    <span class="order__item--title">Menu items cost</span>
                                    <span class="order__total--price">$<%= (Integer)request.getAttribute("amount") %>.00</span>
                                </span>
                            </div>
                            <div class="confirmation__user--detail">
                                <div class="confirmation__column">
                                    <span class="order__item--title">Order type</span>
                                    <span class="order__item--title">Payment</span>
                                    <span class="order__item--title">Customer</span>
                                </div>
                                <div class="confirmation__column">
                                    <span class="order__item--title"><%= request.getAttribute("order_type") %></span>
                                    <span class="order__item--title"><%= request.getAttribute("payment_type") %></span>
                                    <div class="customer__info">
                                        <span class="customer__info--text"><%= request.getAttribute("cus_name") %></span>
                                        <span class="customer__info--text">+<%= request.getAttribute("cus_phone") %></span>
                                        <span class="customer__info--text"><%= request.getAttribute("cus_email") %></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
            </div>
        </div>
    </main>
</body>

</html>