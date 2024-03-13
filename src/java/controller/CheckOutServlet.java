/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Food;
import entity.Order;
import entity.OrderDetail;
import entity.Payment;
import entity.User;
import entity.UserInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.FoodRepository;
import repository.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "checkOutServlet", urlPatterns = {"/checkOutServlet"})
public class CheckOutServlet extends HttpServlet {

    private FoodRepository FoodRepository = new FoodRepository();
    private UserRepository UserRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String payment__type = req.getParameter("payment__type");
        String order__type = req.getParameter("order__type");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String[] input = req.getParameterValues("food_id");
        String[] quantity = req.getParameterValues("food_quantity");

        List<OrderDetail> listOrderDetail = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setFood_id(Integer.parseInt(input[i]));
            orderDetail.setQuantity(Integer.parseInt(quantity[i]));
            listOrderDetail.add(orderDetail);
        }
        int user_id = (Integer) session.getAttribute("user_id");
        Order order = new Order(user_id, order__type);
        order.setOrderList(listOrderDetail);

        int amount = calAmount(listOrderDetail);

        User user = UserRepository.getUserById(user_id);
        UserInfo userInfo = new UserInfo(user, firstname, lastname, email, address, phone);
        if (payment__type.equals("pickup")) {
        }
        Payment payment = new Payment(user_id, order, amount, payment__type);
        req.setAttribute("orderList", listOrderDetail);
        req.setAttribute("order_type", order__type);
        req.setAttribute("amount", amount);
        req.setAttribute("payment_type", payment__type);
        req.setAttribute("cus_name", firstname + " " + lastname);
        req.setAttribute("cus_phone", phone);
        req.setAttribute("cus_email", email);

        req.getRequestDispatcher("confirmation.jsp").forward(req, resp);
    }

    public int calAmount(List<OrderDetail> orderList) {
        int sum = 0;
        for (OrderDetail od : orderList) {
            Food food = FoodRepository.getFoodbyId(od.getFood_id());
            sum += food.getPrice() * od.getQuantity();
        }
        return sum;
    }

}