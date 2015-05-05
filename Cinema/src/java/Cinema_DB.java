
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
        
        ArrayList<Filme> generos = new ArrayList<Filme>();
        FilmeDAO sessaoDAO = new FilmeDAOconcreto();
        generos = sessaoDAO.readFilmeByGenero("ação");
        for (Filme genero : generos) {
            System.out.println(genero.getPk() + " " + genero.getDuracao() + " " + genero.getSituacao().toString());
        }
    }
}
