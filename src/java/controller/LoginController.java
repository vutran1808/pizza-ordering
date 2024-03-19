/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginController extends HttpServlet {

    private UserRepository UserRepository = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if ((username.equals("admin")) && (password.equals("admin123"))) {
            req.getRequestDispatcher("admin.jsp").forward(req, resp);
        }
        User user = UserRepository.checkLogin(username, password);
        if (user != null) {
            session.setAttribute("isSigned", true);
            session.setAttribute("user_id", user.getUser_id());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            session.setAttribute("isSigned", false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req, resp);
        }
    }
}
