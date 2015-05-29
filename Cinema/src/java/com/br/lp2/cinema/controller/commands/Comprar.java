package com.br.lp2.cinema.controller.commands;

import com.br.lp2.cinema.model.DAO.ClienteDAOconcreto;
import com.br.lp2.cinema.model.DAO.IngressoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Cliente;
import com.br.lp2.cinema.model.javabeans.Ingresso;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thomazpicelli
 */
public class Comprar implements Command{
    private String nome;
    private int anonasc;
    private String tipocliente;
    private String tipoingresso;
    private Cliente.Especiais tipoc;
    private boolean tipoi;
    private int cadeira;
    private ArrayList<Integer> cadeiras;
    private int cad;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, String operacao) {
    
        switch(operacao){
            case "Ingresso":
                nome = request.getParameter("nome");
                anonasc = Integer.parseInt(request.getParameter("anonasc"));
                tipocliente = request.getParameter("tipocliente");
                cad = Integer.parseInt(request.getParameter("cad"));
                System.out.println(cad);
                switch(tipocliente){
                    case "GERAL":
                        tipoc = Cliente.Especiais.GERAL;
                        break;
                    case "CADEIRANTE":
                        tipoc = Cliente.Especiais.CADEIRANTE;
                        break;
                    case "IDOSO":
                        tipoc = Cliente.Especiais.OBESO;
                        break;
                }
                tipoingresso = request.getParameter("tipoingresso");
                if(tipoingresso.equals("INTEIRA"))
                    tipoi = true;
                else
                    tipoi = false;
                
                ClienteDAOconcreto cliente = new ClienteDAOconcreto();
                boolean b = cliente.insert(new Cliente(nome, anonasc, tipoc));
                IngressoDAOconcreto ingresso = new IngressoDAOconcreto();
                boolean c = ingresso.insert(new Ingresso(cad, tipoi, tipoc));
                if(b && c){
                    try{
                        response.sendRedirect("vender_sucesso.jsp");
                    }catch(IOException ex){
                        ex.getMessage();
                    }
                }
                else{
                    try{
                        response.sendRedirect("vender_ingresso.jsp");
                    }catch(IOException ex){
                        ex.getMessage();
                    }
                }
                break;
            case "Cadeira":
                if(cadeiras == null){
                    int qtd = Integer.parseInt(request.getParameter("quantidade"));
                    cadeiras = new ArrayList<Integer>();
                    for (int i = 0; i < qtd; i++) {
                        cadeiras.add(0);
                    }
                    request.getSession().setAttribute("cadeiras", cadeiras);
                }
                cadeira = Integer.parseInt(request.getParameter("cadeira"));
                if(cadeiras.get(cadeira) == 0)
                    cadeiras.set(cadeira, 1);
                else if(cadeiras.get(cadeira) ==1)
                    cadeiras.set(cadeira, 0);
                try{
                    response.sendRedirect("vender_ingresso.jsp#c");
                }catch(IOException ex){
                    ex.getMessage();
                }
                break;
            default:
        }
    }
}
