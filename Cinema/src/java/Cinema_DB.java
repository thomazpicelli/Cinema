
import com.br.lp2.model.DAO.*;
import com.br.lp2.model.javabeans.*;
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
