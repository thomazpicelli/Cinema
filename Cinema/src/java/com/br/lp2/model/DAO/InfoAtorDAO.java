package com.br.lp2.model.DAO;

import com.br.lp2.model.javabeans.InfoAtor;
import java.util.ArrayList;

/**
 *
 * @author thomazpicelli
 */
public interface InfoAtorDAO {
                
    //CREATE
    public boolean insertInfoAtor(InfoAtor infoAtor);
    
    //READ
    public ArrayList<InfoAtor> readInfoAtor();
    public InfoAtor readInfoAtorById(int id);
    public InfoAtor readInfoAtorByPapel(String nome);
    
    //UPDATE
    public boolean updateInfoAtor(int id, InfoAtor infoAtor);
    
    //DELETE
    public boolean deleteInfoAtor(int id);
    public boolean deleteInfoAtor(InfoAtor infoAtor);    
}
