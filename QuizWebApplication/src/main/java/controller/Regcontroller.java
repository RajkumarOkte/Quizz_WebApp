package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import Model.Reg;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Regcontroller")
public class Regcontroller extends HttpServlet {
 private static final long serialVersionUID = 1L;
      
   
   public Regcontroller() {
       super();
       // TODO Auto-generated constructor stub
   }

 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO Auto-generated method stub
   response.getWriter().append("Served at: ").append(request.getContextPath());
 }

 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO Auto-generated method stub
   doGet(request, response);
   PrintWriter out = response.getWriter();
   
   try
   {
     String email = request.getParameter("email");
     String pass = request.getParameter("pwd");
     String uname = request.getParameter("uname");
     String mobile = request.getParameter("mobile");
     
     Reg r = new Reg(email, pass, uname, mobile);
     r.InsertReg();
     HttpSession session = request.getSession();
     session.setAttribute("uname", uname);
     session.setAttribute("email", email);
     response.sendRedirect("Welcome.jsp");// Dynamic coding se new page pe jaana
   }
   catch(Exception ex)
   {
     out.println(ex);
   }
   
 }

}