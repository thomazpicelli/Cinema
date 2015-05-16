package com.br.lp2.cinema.controller;

import com.br.lp2.cinema.model.DAO.GenericDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Funcionario;
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
@WebServlet(name = "BuscaUsuarioController", urlPatterns = {"/BuscaUsuarioController"})
public class BuscaUsuarioController extends HttpServlet {
    private String nome;

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
            
            ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
            GenericDAO atendenteDAO = new AtendenteDAOconcreto();
            GenericDAO gerenteDAO = new GerenteDAOconcreto();
            
            if(request.getParameter("atendente")!= null)
                lista.addAll(atendenteDAO.read());
            if(request.getParameter("gerente") != null)
                lista.addAll(gerenteDAO.read());
            if(lista.isEmpty()){
                if(request.getParameter("nome") != null){
                    nome = request.getParameter("nome");
                    Funcionario f = (Funcionario)atendenteDAO.readByNome(nome);
                    if(f == null){
                        f = (Funcionario) gerenteDAO.readByNome(nome);
                    }
                    lista.add(f);
                }
            }
            
            request.getSession().setAttribute("buscaUsuario", lista);
                       
            response.sendRedirect("manter_usuario.jsp#1");	  
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
