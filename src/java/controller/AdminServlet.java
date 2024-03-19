/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Order;
import entity.OrderDetail;
import entity.Payment;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "adminServlet", urlPatterns = {"/adminServlet"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            Object order = session.getAttribute("payment");
            Payment payment = new Payment();

            Field user_id = order.getClass().getDeclaredField("user_id");
            user_id.setAccessible(true);
            int id_val = (Integer) user_id.get(order);
            payment.setUser_id(id_val);

            String order_type = (String) req.getAttribute("order_type");
            List<OrderDetail> orderList = (ArrayList<OrderDetail>) req.getAttribute("orderList");
            Order od = new Order(id_val, order_type);
            od.setOrderList(orderList);
            payment.setOrder(od);

            Field amount = order.getClass().getDeclaredField("amount");
            amount.setAccessible(true);
            int amount_val = (Integer) amount.get(order);
            payment.setAmount(amount_val);

            Field payment_type = order.getClass().getDeclaredField("payment_type");
            payment_type.setAccessible(true);
            String payment_type_val = (String) payment_type.get(order);
            payment.setPayment_type(payment_type_val);
            
            
        } catch (NoSuchFieldException ex) {
        } catch (SecurityException ex) {
        } catch (IllegalArgumentException ex) {
        } catch (IllegalAccessException ex) {
        }

    }

}
