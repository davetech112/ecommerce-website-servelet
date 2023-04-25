package com.david.ecommwebsiteservelet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "register", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String umobile = request.getParameter("contact");
        Connection con = null;
        RequestDispatcher dispatcher = null;

        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_ecommerce?useSSL=false","root","Decagon123?");
                PreparedStatement pst = con.prepareStatement("insert into users(uname,uemail,upwd,umobile) values(?,?,?,?)");
                pst.setString(1, uname);
                pst.setString(2, uemail);
                pst.setString(3, upwd);
                pst.setString(4, umobile);


                int rowCount = pst.executeUpdate();
                dispatcher = request.getRequestDispatcher("registration.jsp");

                if(rowCount > 0){
                    request.setAttribute("status","success");
                }  else{
                    request.setAttribute("status","failed");
                }
                dispatcher.forward(request, response);

        } catch (ClassNotFoundException  | SQLException e) {
                e.printStackTrace();
        }   finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
