<%@page import="entity.Food"%>
<%@page import="entity.OrderDetail"%>
<%@page import="entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="repository.OrderRepository"%>
<%@page import="repository.FoodRepository"%>
<h2 class="content__title">Task list</h2>
<div class="task__container">
    <div class="order__wrapper">
        <form action="acceptServlet" method="GET">
            <ul class="order__list">
                <%
                    FoodRepository foodRepository = new FoodRepository();
                    OrderRepository orderRepository = new OrderRepository();
                    List<OrderDetail> listOrderDetail = orderRepository.getAllOrder();
                    for (OrderDetail o : listOrderDetail) {
                        Food food = foodRepository.getFoodById(o.getFood_id());
                %>
                <li class="order__list--item">
                    <div class="food__card">
                        <h4 class="food__card--title"><%= food.getFood_name() %></h4>
                        <span class="food__card--quantity"><%= o.getQuantity()%></span>
                        <span class="food__card--price">$<%=  food.getPrice() * o.getQuantity() %>.00</span>
                    </div>
                </li>
                <%
                    }
                %>
            </ul>
            <button type="submit" class="accept__order btn">Accept</button>
        </form>

    </div>
</div>