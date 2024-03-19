<%@page import="repository.FoodRepository"%>
<%@page import="entity.Food"%>
<%@page import="java.util.List"%>

<h2 class="content__title">Menu</h2>
<div class="task__container">
    <a href="addFood.jsp" class="btn">Add</a>
    <div class="order__wrapper">
        <ul class="order__list">
                <%
                    FoodRepository foodRepository = new FoodRepository();
                    List<Food> listFood = foodRepository.getFoodAll();
                    for(Food f : listFood){
                %>
                <li class="order__list--item">
                    <div class="food__card">
                        <img src="<%= f.getFood_img() %>" alt="" class="food__card--img">
                        <h4 class="food__card--title"><%= f.getFood_name()%></h4>
                        <span class="food__card--price">$<%= f.getPrice()%>.00</span>
                    </div>
                    <button class="btn remove__btn"><a href="delete-product?idFood=<%= f.getFood_id() %>">Delete</a></button>
                    <button class="btn update__btn"><a href="updateFood.jsp?idFood=<%= f.getFood_id() %>">Update</a></button>
                </li>
                <%
                    }
                %>
        </ul>
    </div>
</div>
        