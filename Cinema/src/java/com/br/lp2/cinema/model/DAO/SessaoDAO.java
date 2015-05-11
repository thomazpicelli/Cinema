package com.br.lp2.cinema.model.DAO;

import com.br.lp2.cinema.model.javabeans.Sessao;
import com.br.lp2.cinema.model.javabeans.Sala;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface SessaoDAO {
                
    //CREATE
    public boolean insertSessao(Sessao sessao);
    
    //READ
    public ArrayList<Sessao> readSessao();
    public Sessao readSessaoById(int id);
    public Sessao readSessaoBySala(int id);
    
    //UPDATE
    public boolean updateSessao(int id, Sessao sessao);
    
    //DELETE
    public boolean deleteSessao(int id);
    public boolean deleteSessao(Sessao sessao);
}
