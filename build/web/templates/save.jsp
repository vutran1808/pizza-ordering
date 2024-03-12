<%-- 
    Document   : save
    Created on : Mar 11, 2024, 10:55:56 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <!-- Food list 2 -->
                            <div id="maincourse" class="food__menu--item">
                                <h3 class="food__menu--title">Main courses</h3>
                                <ul class="food__list">
                                    <%
                                        List<Food> maincourses = (ArrayList<Food>)request.getAttribute("maincourses");
                                        for(Food food : maincourses) {
                                    %>
                                    <li class="food__item">
                                        <article class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                <form action="orderCartServlet">
                                                    <div class="food__content--top">
                                                    <input type="hidden" name="food_title" value="<%= food.getFood_name() %>" />
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <input type="hidden" name="food_price" value="<%= food.getPrice() %>" />
                                                        <span class="food__price">$<%= food.getPrice()%>.00</span>
                                                        <button type="submit" class="btn add-to-card__btn">Order</button>
                                                    </div>
                                                </form>
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
                                        <article class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                <form action="orderCartServlet">
                                                    <div class="food__content--top">
                                                    <input type="hidden" name="food_title" value="<%= food.getFood_name() %>" />
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <input type="hidden" name="food_price" value="<%= food.getPrice() %>" />
                                                        <span class="food__price">$<%= food.getPrice()%>.00</span>
                                                        <button type="submit" class="btn add-to-card__btn">Order</button>
                                                    </div>
                                                </form>
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
                                        <article class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                <form action="orderCartServlet" >
                                                    <div class="food__content--top">
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <input type="hidden" name="food_id" value="<%= food.getFood_id() %>" />
                                                        <span class="food__price">$<%= food.getPrice()%>.00</span>
                                                        <button type="submit" class="btn add-to-card__btn">Order</button>
                                                    </div>
                                                </form>
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
                                        <article class="food__card">
                                            <!-- Image -->
                                            <div class="food__wrapper">
                                                <img src=<%= food.getFood_img() %> alt="Loading" class="food__wrapper--img">
                                            </div>
                                            <!-- Content -->
                                            <div class="food__content">
                                                <form action="orderCartServlet" >
                                                    <div class="food__content--top">
                                                    <input type="hidden" name="food_title" value="<%= food.getFood_name() %>" />
                                                    <h4 class="food__title"><%= food.getFood_name() %></h4>
                                                    </div>
                                                    <div class="food__content--bottom">
                                                        <input type="hidden" name="food_price" value="<%= food.getFood_id()%>" />
                                                        <span class="food__price">$<%= food.getPrice()%>.00</span>
                                                        <button type="submit" class="btn add-to-card__btn">Order</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </article>
                                    </li>
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
</html>
