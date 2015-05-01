
import com.br.lp2.cinema.model.DAO.SessaoDAO;
import com.br.lp2.cinema.model.DAO.SessaoDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Sessao;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cinema_DB {
    public static void main(String[] args) {

        SessaoDAO sessaoDAO = new SessaoDAOconcreto();
        boolean resultado = sessaoDAO.deleteSessao(1);
        System.out.println(resultado);
    }
}
