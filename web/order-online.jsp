<%@page import="java.util.ArrayList"%>
<%@page import="entity.Food"%>
<%@page import="java.util.List"%>
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
    <link rel="stylesheet" href="./assets/font/stylesheet.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sora:wght@100..800&display=swap" rel="stylesheet">

    <!-- SCSS -->
    <link rel="stylesheet" href="./assets/css/main.css">

    <!-- Fontawesome -->
    <link rel="stylesheet" href="./assets/fontawesome/css/all.min.css">

    <!-- Script -->
    <script src="./assets/js/script.js"></script>
    <title>Order online</title>
</head>

<body>
    <!-- Header -->
    <header id="header" class="header"></header>
    <script>
        load("#header", "./templates/header.jsp");
    </script>

    <main class="order">

        <!-- Hero -->
        <section class="hero">
            <h1 class="section__heading--main about__heading">Our menu</h1>
            <span class="order__sub-heading section__heading white">SEE OUR OFFER WITH DELIVERY TO YOUR DOOR</span>
        </section>

        <!-- Menu -->
        <section class="menu">
            <div class="container">
                <div class="menu__inner">
                    <div class="menu__content">
                        <!-- Query database to get food category -->
                        <ul class="category__list">
                            <li class="category__item">
                                <a href="#appetizers" class="category__link">Appetizers</a>
                            </li>
                            <li class="category__item">
                                <a href="#maincourse" class="category__link">Main courses</a>
                            </li>
                            <li class="category__item">
                                <a href="#pizza" class="category__link">Pizza</a>
                            </li>
                            <li class="category__item">
                                <a href="#desserts" class="category__link">Desserts</a>
                            </li>
                            <li class="category__item">
                                <a href="#drinks" class="category__link">Drinks</a>
                            </li>
                        </ul>

                        <!-- Food List -->
                        <div class="food__menu">
                            <!-- Food list 1 -->
                            <div id="appetizers" class="food__menu--item">
                                <h3 class="food__menu--title">Appetizers</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> appetizers = (ArrayList<Food>)request.getAttribute("appetizers");
                                        for(Food food : appetizers) {
                                    %>
                                    <li class="food__item">
                                        <article food-id="<%= food.getFood_id() %>" class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <span class="food__price">$<span class="food__price--value" ><%= food.getPrice()%></span>.00</span>
                                                        <button class="btn add-to-card__btn">Order</button>
                                                    </div>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                            <!-- Food list 2 -->
                            <div id="maincourse" class="food__menu--item">
                                <h3 class="food__menu--title">Main courses</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> maincourses = (ArrayList<Food>)request.getAttribute("maincourses");
                                        for(Food food : maincourses) {
                                    %>
                                    <li class="food__item">
                                        <article food-id="<%= food.getFood_id() %>" class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <span class="food__price">$<span class="food__price--value" ><%= food.getPrice()%></span>.00</span>
                                                        <button class="btn add-to-card__btn">Order</button>
                                                    </div>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                            <!-- Food list 3 -->
                            <div id="pizza" class="food__menu--item">
                                <h3 class="food__menu--title">Pizza</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> pizza = (ArrayList<Food>)request.getAttribute("pizza");
                                        for(Food food : pizza) {
                                    %>
                                    <li class="food__item">
                                        <article food-id="<%= food.getFood_id() %>" class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <span class="food__price">$<span class="food__price--value" ><%= food.getPrice()%></span>.00</span>
                                                        <button class="btn add-to-card__btn">Order</button>
                                                    </div>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                            <!-- Food list 4 -->
                            <div id="desserts" class="food__menu--item">
                                <h3 class="food__menu--title">Desserts</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> desserts = (ArrayList<Food>)request.getAttribute("desserts");
                                        for(Food food : desserts) {
                                    %>
                                    <li class="food__item">
                                        <article food-id="<%= food.getFood_id() %>" class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <span class="food__price">$<span class="food__price--value" ><%= food.getPrice()%></span>.00</span>
                                                        <button class="btn add-to-card__btn">Order</button>
                                                    </div>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                            <!-- Food list 5 -->
                            <div id="drinks" class="food__menu--item">
                                <h3 class="food__menu--title">Drinks</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> drinks = (ArrayList<Food>)request.getAttribute("drinks");
                                        for(Food food : drinks) {
                                    %>
                                    <li class="food__item">
                                        <article food-id="<%= food.getFood_id() %>" class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <span class="food__price">$<span class="food__price--value" ><%= food.getPrice()%></span>.00</span>
                                                        <button class="btn add-to-card__btn">Order</button>
                                                    </div>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="menu__sidebar">
                        <article class="order-cart">
                            <span class="order-cart__title">Your order</span>
                            <div class="order-cart__content empty">
                                <div class="order-cart__empty">
                                    <div class="order-cart__wrapper">
                                        <img src="./assets/images/cart.png" alt="Loading" class="order-cart__icon">
                                    </div>
                                    <p class="order-cart__text">Cart is empty. Add menu items.</p>
                                </div>
                                <div class="order-cart__notempty">
                                    <ul class="order__detail">
                                    </ul>
                                    <div class="order__cart--row">
                                        <span class="order__cart--title">TOTAL</span>
                                        <span class="order__cart--price">$<span class="order__cart--price-value" >0</span>.00</span>
                                    </div>
                                </div>
                            </div>
                            <a href="check-out.jsp" class="btn order-cart__btn">Go to checkout</a>
                        </article>
                    </div>
                </div>
            </div>
        </section>

    </main>

    <!-- Footer -->
    <footer id="footer" class="footer"></footer>
    <script>
        load('#footer', "./templates/footer.jsp");
    </script>
</body>

</html>