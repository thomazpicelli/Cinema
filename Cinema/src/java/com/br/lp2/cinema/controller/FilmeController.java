package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.DiretorDAO;
import com.br.lp2.cinema.model.DAO.DiretorDAOconcreto;
import com.br.lp2.cinema.model.DAO.DistribuidoraDAO;
import com.br.lp2.cinema.model.DAO.DistribuidoraDAOconcreto;
import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import com.br.lp2.cinema.model.DAO.ListaAtoresDAO;
import com.br.lp2.cinema.model.DAO.ListaAtoresDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Diretor;
import com.br.lp2.cinema.model.javabeans.Distribuidora;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.javabeans.ListaAtores;
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
            DiretorDAO diretor = new DiretorDAOconcreto();
            lista1 = diretor.readDiretor();
            request.getSession().setAttribute("diretores", lista1);
            
            ArrayList<Genero> lista2 = new ArrayList<Genero>();
            GeneroDAO genero = new GeneroDAOconcreto();
            lista2 = genero.readGenero();
            request.getSession().setAttribute("generos", lista2);
            
            ArrayList<Distribuidora> lista3 = new ArrayList<Distribuidora>();
            DistribuidoraDAO distribuidora = new DistribuidoraDAOconcreto();
            lista3 = distribuidora.readDistristribuidora();
            request.getSession().setAttribute("distribuidoras", lista3);
  
            ArrayList<ListaAtores> lista4 = new ArrayList<ListaAtores>();
            ListaAtoresDAO la = new ListaAtoresDAOconcreto();
            lista4 = la.readListaAtores();
            request.getSession().setAttribute("latores", lista4);

            ArrayList<Filme> lista = new ArrayList<Filme>();
            FilmeDAO filme = new FilmeDAOconcreto();
            lista = filme.readFilme();
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
