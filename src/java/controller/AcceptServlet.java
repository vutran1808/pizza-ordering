/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mail.Mail;
import repository.UserRepository;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "acceptServlet", urlPatterns = {"/acceptServlet"})
public class AcceptServlet extends HttpServlet {

    private UserRepository UserRepository = new UserRepository();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int user_id = (Integer) session.getAttribute("user_id");
        User user = UserRepository.getUserById(user_id);
        Mail mail = new Mail();
        mail.sendEmail(user.getUsername(), System.currentTimeMillis() + "", "Đây là phần nội dung!");
        resp.sendRedirect("admin.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
