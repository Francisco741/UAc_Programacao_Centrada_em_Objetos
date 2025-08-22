import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

/**
 * A classe {@code Main} serve como ponto de entrada para o programa
 *
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String jsonDatasetPath = "src/dataset.json";
        String jsonUsersPath = "src/utilizadores.json";
        try {
            Sistema sistema = gson.fromJson(new FileReader(jsonDatasetPath), Sistema.class);
            HandlerUtilizadores handlerUtilizadores = gson.fromJson(new FileReader(jsonUsersPath), HandlerUtilizadores.class);
            Menu.menuInicial(sistema, handlerUtilizadores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}