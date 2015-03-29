package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.Sessao;
import com.br.lp2.model.javabeans.Sala;
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
    public Sessao readSessaoBySala(Sala sala);
    
    //UPDATE
    public boolean updateSessao(int id, Sessao sessao);
    
    //DELETE
    public boolean deleteSessao(int id);
    public boolean deleteSessao(Sala sala);
}
