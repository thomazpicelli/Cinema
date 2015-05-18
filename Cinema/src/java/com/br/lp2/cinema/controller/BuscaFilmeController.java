package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
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
 * @author thomazpicelli
 */
@WebServlet(name = "BuscaFilmeController", urlPatterns = {"/BuscaFilmeController"})
public class BuscaFilmeController extends HttpServlet {
    private String busca;

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
            
            ArrayList<Filme> lista = new ArrayList<Filme>();
            FilmeDAOconcreto filme = new FilmeDAOconcreto();

            switch(busca){
                case "filme":
                    String todos = request.getParameter("todos");
                    if(todos != null)
                        lista = filme.read();
                    else
                        lista.add(filme.readById(Integer.parseInt(request.getParameter("filme"))));
                    break;
                case "genero":
                    lista = filme.readFilmeByGenero(Integer.parseInt(request.getParameter("genero")));
                    break;
                case "diretor":
                    lista = filme.readFilmeByDiretor(Integer.parseInt(request.getParameter("diretor")));
                    break;
                case "distribuidora":
                    lista = filme.readFilmeByDistribuidora(Integer.parseInt(request.getParameter("distribuidora")));
                    break;
                case "ator":
                    lista = filme.readFilmeByAtor(Integer.parseInt(request.getParameter("ator")));
                    break;
            }
            
            request.getSession().setAttribute("buscaFilme", lista);
            
            response.sendRedirect("manter_filme.jsp#b");	  
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
        busca = request.getParameter("busca");
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
