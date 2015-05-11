
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import com.br.lp2.cinema.model.DAO.GerenteDAO;
import com.br.lp2.cinema.model.DAO.GerenteDAOconcreto;
import com.br.lp2.cinema.model.DAO.SalaDAO;
import com.br.lp2.cinema.model.DAO.SalaDAOconcreto;
import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import com.br.lp2.cinema.model.javabeans.Filme;
import com.br.lp2.cinema.model.javabeans.Funcionario;
import com.br.lp2.cinema.model.javabeans.Gerente;
import com.br.lp2.cinema.model.javabeans.Sala;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cinema_DB {
    public static void main(String[] args) {
        
        boolean delete, insert = false;
        GerenteDAO gerenteDAO = new GerenteDAOconcreto();
        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();

        Funcionario funcionario = atendenteDAO.readAtendenteByNome("Maria");
        if(funcionario != null){
            System.out.println("aqqqqqqq");
            delete = atendenteDAO.deleteAtendente(funcionario.getNome());
           if(delete) insert = gerenteDAO.insertGerente(funcionario);
        }
        else{
            funcionario = gerenteDAO.readGerenteByNome("Maria");
            if(funcionario != null){
                delete = gerenteDAO.deleteGerente(funcionario.getNome());
                if(delete) insert = atendenteDAO.insertAtendente(funcionario);
            }
        }
            System.out.println(insert);
            
    }
}
