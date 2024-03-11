/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet {

    private UserRepository UserRepository = new UserRepository();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String confirm_password = req.getParameter("confirm-password");
        if(password.equals(confirm_password)){
            UserRepository.createUser(username, password);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

}
