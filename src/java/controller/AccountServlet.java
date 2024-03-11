/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.UserInfo;
import java.io.IOException;
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
@WebServlet(name = "accountServlet", urlPatterns = {"/accountServlet"})
public class AccountServlet extends HttpServlet {

    UserRepository UserRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = session.getAttribute("username").toString();
        UserInfo userinfo = UserRepository.getUserByUsername(username);
        session.setAttribute("firstname", userinfo.getFirstname());
        session.setAttribute("lastname", userinfo.getLastname());
        session.setAttribute("city", userinfo.getCity());
        session.setAttribute("street", userinfo.getStreet());
        session.setAttribute("phone", userinfo.getPhone());
        req.getRequestDispatcher(req.getContextPath()).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
