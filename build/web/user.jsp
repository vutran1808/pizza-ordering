<%@page import="java.util.ArrayList"%>
<%@page import="entity.UserInfo"%>
<%@page import="repository.UserRepository"%>
<%@page import="repository.FoodRepository"%>
<%@page import="entity.Food"%>
<%@page import="java.util.List"%>

<h2 class="content__title">Menu</h2>
<div class="task__container">
    <a href="" class="btn">Add</a>
    <div class="order__wrapper">
        <ul class="order__list">
                <%
                    UserRepository userRepository = new UserRepository();
                    List<UserInfo> listUser = userRepository.getUserAll();
                    for(UserInfo u : listUser){
                %>
                <li class="order__list--item">
                    <div class="food__card">
                        <h4 class="food__card--title"><%= u.getFirstname() + " " + u.getLastname() %></h4>
                        <span class="food__card--price"><%= u.getPhone() %></span>
                    </div>
                    <button class="btn remove__btn"><a href="delete-user?user_id=<%= u.getUser().getUser_id()%>">Delete</a></button>
                </li>
                <%
                    }
                %>
        </ul>
    </div>
</div>
