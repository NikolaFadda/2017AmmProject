/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm;

import amm.classi.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nikola
 */
@WebServlet(urlPatterns = {"/Homepage"})
public class Homepage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession(false);
        session.setAttribute("visitedUser", session.getAttribute("visitor"));
         
         if(session!=null && 
           session.getAttribute("loggedIn")!=null &&
           session.getAttribute("loggedIn").equals(true)){
        boolean trueFriends;
        String visitedUser; 
        Utente utente;     
        Utente visitor = UtenteFactory.getInstance().
                getUtenteByUsername(session.getAttribute("visitor").toString());
        
        if(request.getParameter("visitedUser")!=null){
            
            visitedUser= request.getParameter("visitedUser");
            utente = UtenteFactory.getInstance().getUtenteByUsername(visitedUser);
            session.setAttribute("visitedUser", visitedUser);
        }else{
            session.setAttribute("visitedUser", session.getAttribute("visitor"));
            visitedUser = session.getAttribute("visitedUser").toString();
            utente = UtenteFactory.getInstance().getUtenteByUsername(visitedUser);
        }
        
        if(utente !=null){
            request.setAttribute("user", utente);
            List<Post> posts = PostFactory.getInstance().getPostList(utente);
            request.setAttribute("posts",posts);
         
        
            if(UtenteFactory.getInstance().areFriends(utente.getUsername(), 
                    visitor.getUsername())){
            trueFriends = true;
            
        
        }else{
            trueFriends = false;
        }   
            
            request.setAttribute("trueFriends", trueFriends);
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
        }else{
            out.println("Non funziono");
        }
         
         }
         else{
             request.getRequestDispatcher("Login").forward(request, response);
         }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
