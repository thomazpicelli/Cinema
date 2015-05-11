package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class SalaCommand implements Command{
    private int codigo;
    private int numero;
    private int lotacao;
    private int especial;
    private String situacao;
    private Sala.Situacao si;
    private boolean resultado;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
        situacao = request.getParameter("situacao");
        if(situacao != null){
            switch (situacao) {
                case "Manutencao":
                    si = Sala.Situacao.MANUTENÇÃO;
                    break;
                case "Exibicao":
                    si = Sala.Situacao.EXIBICAO;
                    break;
                case "Espera":
                    si = Sala.Situacao.ESPERA;
                    break;
            }
        }
        switch(operacao){
            case "Cria":
                numero = Integer.parseInt(request.getParameter("numero"));
                lotacao = Integer.parseInt(request.getParameter("lotacao"));
                especial = Integer.parseInt(request.getParameter("especial"));
                resultado = Cria();
                break;
            case "Muda": 
                codigo = Integer.parseInt(request.getParameter("codigo"));
                numero = Integer.parseInt(request.getParameter("numero"));
                lotacao = Integer.parseInt(request.getParameter("lotacao"));
                especial = Integer.parseInt(request.getParameter("especial"));
                resultado = Muda();
                break;
            case "Deleta":
                numero = Integer.parseInt(request.getParameter("numero"));
                resultado = Deleta();
                if(!resultado)
                    request.getSession().setAttribute("verificaSessao", "sim");
                break;
            case "Busca":
                break;
            case "MudaSituacao":
                numero = Integer.parseInt(request.getParameter("numero"));                
                resultado = Situacao();
                break;
            default:
                try { response.sendRedirect("manter_sala.jsp");
                } catch (IOException ex) { ex.getMessage(); }
                break;
        }   
        
        try { 
            if(resultado)
                response.sendRedirect("sucesso.html");
            else
                response.sendRedirect("manter_sala.jsp");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private boolean Cria() {
        SalaDAO salaDAO = new SalaDAOconcreto();
        boolean insert = salaDAO.insertSala(new Sala(numero, lotacao, especial, si));
        return insert;
    }

    private boolean Muda() {
        SalaDAO salaDAO = new SalaDAOconcreto();
        boolean update = salaDAO.updateSala(codigo, new Sala(numero, lotacao, especial, si));
        return update;
    }

    private boolean Deleta() {
        boolean delete = false;
        SalaDAO salaDAO = new SalaDAOconcreto();
        Sala s = salaDAO.readSalaByNumero(numero);
        if(s != null){ 
            SessaoDAO sessaoDAO = new SessaoDAOconcreto();
            Sessao sessao = sessaoDAO.readSessaoBySala(s.getPk());
            if(sessao == null)
                delete = salaDAO.deleteSala(s.getPk());
        }
        return delete;
    }

    private boolean Situacao() {
        SalaDAO salaDAO = new SalaDAOconcreto();
        Sala sala = salaDAO.readSalaByNumero(numero);
        
        boolean update = salaDAO.updateSala(sala.getPk(), new Sala(sala.getNumero(), sala.getLotacao(), sala.getEspecial(), si));
        return update;
    }
}