
import com.br.lp2.cinema.model.DAO.FilmeDAO;
import com.br.lp2.cinema.model.DAO.FilmeDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import com.br.lp2.cinema.model.javabeans.Filme;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cinema_DB {
    public static void main(String[] args) {

        FilmeDAO sessaoDAO = new FilmeDAOconcreto();
        boolean resultado = sessaoDAO.updateFilme(2, new Filme(null, null, null, null, null, 333, 333, 3333, Filme.tiposituacao.CARTAZ, "aaaaaa"));
        System.out.println(resultado);
    }
}
