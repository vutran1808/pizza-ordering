/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Food;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "orderServlet", urlPatterns = {"/orderServlet"})

public class OrderOnlineServlet extends HttpServlet {

    private FoodRepository FoodRepository = new FoodRepository();
    List<Food> appetizers = new ArrayList<>();
    List<Food> maincourses = new ArrayList<>();
    List<Food> pizza = new ArrayList<>();
    List<Food> desserts = new ArrayList<>();
    List<Food> drinks = new ArrayList<>();

    @Override

    public void init() throws ServletException {
        appetizers = FoodRepository.getFoodbyMenu(1);
        maincourses = FoodRepository.getFoodbyMenu(2);
        pizza = FoodRepository.getFoodbyMenu(3);
        desserts = FoodRepository.getFoodbyMenu(4);
        drinks = FoodRepository.getFoodbyMenu(5);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("appetizers", appetizers);
        req.setAttribute("maincourses", maincourses);
        req.setAttribute("pizza", pizza);
        req.setAttribute("desserts", desserts);
        req.setAttribute("drinks", drinks);
        req.getRequestDispatcher("order-online.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

}
