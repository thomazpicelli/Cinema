package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.*;
import com.br.lp2.cinema.model.javabeans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thomaz
 */
@WebServlet(name = "FilmeController", urlPatterns = {"/FilmeController"})
public class FilmeController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            ArrayList<Diretor> lista1 = new ArrayList<>();
            GenericDAO diretor = new DiretorDAOconcreto();
            lista1 = diretor.read();
            request.getSession().setAttribute("diretores", lista1);
            
            ArrayList<Genero> lista2 = new ArrayList<Genero>();
            GenericDAO genero = new GeneroDAOconcreto();
            lista2 = genero.read();
            request.getSession().setAttribute("generos", lista2);
            
            ArrayList<Distribuidora> lista3 = new ArrayList<Distribuidora>();
            GenericDAO distribuidora = new DistribuidoraDAOconcreto();
            lista3 = distribuidora.read();
            request.getSession().setAttribute("distribuidoras", lista3);
  
            ArrayList<InfoAtor> lista4 = new ArrayList<InfoAtor>();
            GenericDAO ia = new InfoAtorDAOconcreto();
            lista4 = ia.read();
            request.getSession().setAttribute("latores", lista4);

            ArrayList<Filme> lista = new ArrayList<Filme>();
            GenericDAO filme = new FilmeDAOconcreto();
            lista = filme.read();
            request.getSession().setAttribute("filmes", lista);
            
            response.sendRedirect("manter_filme.jsp");
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
