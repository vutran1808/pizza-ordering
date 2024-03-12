/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.User;
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession sesssion = req.getSession();
        UserInfo userInfo = new UserInfo();
        User user = new User();
        user.setUser_id((Integer) sesssion.getAttribute("user_id"));
        userInfo.setUser(user);
        userInfo.setFirstname(req.getParameter("firstname"));
        userInfo.setLastname(req.getParameter("lastname"));
        userInfo.setCity(req.getParameter("city"));
        userInfo.setStreet(req.getParameter("street"));
        userInfo.setPhone(req.getParameter("phone"));
        UserRepository.updateUserInfo(userInfo);

        req.setAttribute("userInfo", userInfo);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
