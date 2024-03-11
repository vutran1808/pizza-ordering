/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
        if (UserRepository.getUserbyAccount(username, password)) {
            session.setAttribute("isSigned", true);
            session.setAttribute("username", username);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            session.setAttribute("isSigned", false);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req, resp);
        }
    }

}
