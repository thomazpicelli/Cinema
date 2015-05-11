package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.DAO.ListaIngressosDAO;
import com.br.lp2.cinema.model.DAO.ListaIngressosDAOconcreto;
import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.ListaIngressos;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
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
@WebServlet(name = "SessaoController", urlPatterns = {"/SessaoController"})
public class SessaoController extends HttpServlet {

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
            
            ArrayList<Sessao> lista1 = new ArrayList<Sessao>();
            SessaoDAO sessao = new SessaoDAOconcreto();
            lista1 = sessao.readSessao();
            request.getSession().setAttribute("sessoes", lista1);

            ArrayList<Filme> lista2 = new ArrayList<Filme>();
            FilmeDAO filme = new FilmeDAOconcreto();
            lista2 = filme.readFilme();
            request.getSession().setAttribute("filmes", lista2);
            
            ArrayList<Sala> lista3 = new ArrayList<Sala>();
            SalaDAO sala = new SalaDAOconcreto();
            lista3 = sala.readSala();
            request.getSession().setAttribute("salas", lista3);
            
            ArrayList<ListaIngressos> lista4 = new ArrayList<ListaIngressos>();
            ListaIngressosDAO listaIngressosDAO = new ListaIngressosDAOconcreto();
            lista4 = listaIngressosDAO.readListaIngressos();
            request.getSession().setAttribute("ingressos", lista4);
            
            response.sendRedirect("manter_sessao.jsp");	
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