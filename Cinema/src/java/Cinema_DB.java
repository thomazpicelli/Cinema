
import com.br.lp2.cinema.model.DAO.AtendenteDAO;
import com.br.lp2.cinema.model.DAO.AtendenteDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Atendente;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cinema_DB {
    public static void main(String[] args) {

        AtendenteDAO atendenteDAO = new AtendenteDAOconcreto();
        atendenteDAO.insertAtendente(new Atendente("Sandra", "sandra", "senha"));
        
        atendenteDAO.updateAtendente(2, new Atendente("Marcio", "Marcio", "123"));
    }
}
