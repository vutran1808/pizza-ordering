/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Food;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.FoodRepository;

/**
 *
 * @author ASUS
 */
@WebServlet("/order-online")

public class OrderOnlineServlet extends HttpServlet {

    private FoodRepository FoodRepository = new FoodRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> appetizers = FoodRepository.getFoodbyMenu(1);
        List<Food> maincourses = FoodRepository.getFoodbyMenu(2);
        List<Food> pizza = FoodRepository.getFoodbyMenu(3);
        List<Food> desserts = FoodRepository.getFoodbyMenu(4);
        List<Food> drinks = FoodRepository.getFoodbyMenu(5);

        req.setAttribute("appetizers", appetizers);
        req.setAttribute("maincourses", maincourses);
        req.setAttribute("pizza", pizza);
        req.setAttribute("desserts", desserts);
        req.setAttribute("drinks", drinks);
        req.getRequestDispatcher("pizza-ordering/order-online.jsp").forward(req, resp);
    }

}
