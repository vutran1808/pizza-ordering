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
        int user_id = (Integer) sesssion.getAttribute("user_id");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        String phone = req.getParameter("phone");
        UserRepository.updateUserInfo(user_id, firstname, lastname, city, street, phone);

//        req.setAttribute("firstname", firstname);
//        req.setAttribute("lastname", lastname);
//        req.setAttribute("city", city);
//        req.setAttribute("street", street);
//        req.setAttribute("phone", phone);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
