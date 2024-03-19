/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Food;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.FoodRepository;
import repository.UserRepository;

public class ProductAdminServlet extends HttpServlet {

    private FoodRepository foodR = new FoodRepository();
    private UserRepository userR = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/list-product":
                showAll(request, response);
                break;
            case "/add-product":
                add(request, response);
                break;
            case "/update-product":
                update(request, response);
                break;
            case "/delete-product":
                deleteDish(request, response);
                break;
            case "/delete-user":
                deleteUser(request, response);
                break;
//            case "/search-product":
//                listByName(request, response);
             //   break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/add-product":
                add(request, response);
                break;
            case "/update-product":
                update(request, response);
                break;
//            case "/search-product":
//                listByName(request, response);
//                break;
            default:
                break;
        }
    }

    // ADD PRODUCT
    private void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        int idUser = Integer.parseInt((String) session.getAttribute("user_id"));
//        UserInfo userInfo = new UserInfo();
//        if (userInfo.getUser().getUser_id() == idUser) {
//            if (userInfo.getUser().getRole_id() == 1) {
        List<Food> foodList = foodR.getFoodAll();
//        request.setAttribute("food_list", foodList);
//        
//        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
//        dispatcher.forward(request, response);
        if (foodList == null) {
            foodList = new ArrayList<>();
        }

        int pageSize = 3;
        int totalStudents = foodList.size();
        int totalPages = (int) Math.ceil((double) totalStudents / pageSize);
        int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalStudents);
        List<Food> currentPageStudents = foodList.subList(startIndex, endIndex);

        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("food_list", currentPageStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
//            } else {
//                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//                dispatcher.forward(request, response);
//            }
//        }

    }

//    private void listByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
//        List<Food> foodList = foodR.getFoodbyName(request.getParameter("food-name"));
//        request.setAttribute("food_list", foodList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("menu-list.jsp");
//        dispatcher.forward(request, response);
//
//    }
    private void deleteDish(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idFood"));
        foodR.deleteFood(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-product");
        dispatcher.forward(request, response);
    }
//

    private void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Food food = new Food(
                request.getParameter("food-name"),
                request.getParameter("food-img"),
                Integer.parseInt(request.getParameter("price")),
                Integer.parseInt(request.getParameter("menu-id"))
        );
        foodR.addFood(food);
        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Food food = new Food(
                Integer.parseInt(request.getParameter("food-id")),
                request.getParameter("food-name"),
                request.getParameter("food-img"),
                Integer.parseInt(request.getParameter("price")),
                Integer.parseInt(request.getParameter("menu-id"))
        );
        foodR.update(food);
        showAll(request, response);

    }
    
    public void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUser = Integer.parseInt(request.getParameter("user_id"));
        userR.deleteUserById(idUser);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
