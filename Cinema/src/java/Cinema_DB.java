
import com.br.lp2.cinema.model.javabeans.Genero;
import com.br.lp2.cinema.model.DAO.GeneroDAO;
import com.br.lp2.cinema.model.DAO.GeneroDAOconcreto;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author thomazpicelli
 */
public class Cinema_DB {
    public static void main(String[] args) {
        GeneroDAO generoDAO = new GeneroDAOconcreto();
        
        ArrayList<Genero> listaGenero = generoDAO.readGenero();
        for (Genero listaGenero1 : listaGenero){
            System.out.println(listaGenero1.getPk()+ " - " + listaGenero1.getNome());
        }
    }
}
