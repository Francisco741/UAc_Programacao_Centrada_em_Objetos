import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code HandlerUtilizadores} gere as operações relacionadas aos utilizadores, como autenticação, registo e salvamento em JSON.
 *
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2024-01-05
 */
public class HandlerUtilizadores {
    
    @SerializedName("listaUtilizadores")
    private List<Utilizador> listaUtilizadores = new ArrayList<>();

    /**
     * Constantes para os diferentes papéis dos utilizadores.
     */
    public static final String FARMACEUTICO = "farmaceutico";
    public static final String INDUSTRIA = "industria";
    public static final String ADMINISTRADOR = "administrador";

    /**
     * Scanner para entrada do utilizador.
     */
    public static final Scanner SCANNER = new Scanner(System.in);
    

    /**
     * UC01
     * Realiza a autenticação do utilizador com base no nome de utilizador e na password.
     * Retorna um String indicando as opções disponíveis para o papel do utilizador autenticado.
     * Se a autenticação falhar, retorna uma mensagem informando "Login Incorreto."
     */
    public String autenticarUtilizador() {
        String nome = indicarNomeLogin();
        String password = indicarPassLogin();
        for (Utilizador utilizador : listaUtilizadores) {
            if (utilizador.getNome().equalsIgnoreCase(nome) && utilizador.getPassword().equals(password)) {
                return switch (utilizador.getPapel()) {
                    case FARMACEUTICO -> "Opções para Farmacêutico.";
                    case INDUSTRIA -> "Opções para Indústria Farmacêutica.";
                    case ADMINISTRADOR -> "Opções para Administrador.";
                    default -> "Erro ao obter papel do utilizador.";
                };
            }
        }
        return "Login Incorreto.";
    }

    /**
     * Indica e retorna o nome de utilizador inserido pelo utilizador.
     */
    public String indicarNomeLogin() {
        System.out.print("Insira o seu nome de utilizador: ");
        return SCANNER.nextLine();
    }

    /**
     * Indica e retorna a password inserida pelo utilizador.
     */
    public String indicarPassLogin() {
        System.out.print("Insira a sua password: ");
        return SCANNER.nextLine();
    }


    /**
     * UC02
     * Registra um novo utilizador no sistema, solicitando informações como nome, password, email e papel. 
     * Dependendo do papel (Farmacêutico ou Indústria), cria instâncias correspondentes e solicita informações adicionais caso seja necessário.
     *
     * @return Uma mensagem indicando o resultado do registo.
     */
    public String registarUtilizador() {
        Utilizador u = new Utilizador();
        indicarNomeRegisto(u);
        indicarPassRegisto(u);
        indicarEmailRegisto(u);
        indicarPapelRegisto(u);
        Farmaceutico f = null;
        IndustriaFarmaceutica i = null;
        switch (u.getPapel()) {
            case FARMACEUTICO:
                f = new Farmaceutico(u.getNome(), u.getPassword(), u.getEmail());
                break;
            case INDUSTRIA:
                i = new IndustriaFarmaceutica(u.getNome(), u.getPassword(), u.getEmail());
                indicarContactoFarmacoRegisto(i);
                break;
            default:
                return "Papel do utilizador inválido.";
        }
        for (Utilizador utilizador : listaUtilizadores) {
            if (utilizador.getNome().equals(u.getNome())) {
                return "Utilizador com nome já existente.";
            }
            else if (utilizador.getEmail().equals(u.getEmail())) {
                return "Utilizador com email já existente.";
            }
        }
        String confirmacao;
        do {
            System.out.print("Confirma o registo do novo utilizador? [sim/nao]: ");
            confirmacao = SCANNER.nextLine().toLowerCase();
            switch (confirmacao) {
                case "sim":
                    if (u.getPapel().equals(FARMACEUTICO)) {
                        return confirmarNovoUtilizador(f);
                    } else return confirmarNovoUtilizador(i);
                case "nao":
                    return cancelarRegisto();
                default:
                    System.out.println("Resposta inválida. Por favor, insira 'sim' ou 'nao'.");
            }
        } while (!confirmacao.equals("sim") && !confirmacao.equals("nao"));
        return("");
    }

    /**
     * Indica o nome do novo utilizador durante o processo de registo.
     *
     * @param u O utilizador a ser registado.
     */
    public void indicarNomeRegisto(Utilizador u) {
        System.out.print("Insira o nome do novo utilizador: ");
        u.setNome(SCANNER.nextLine());
    }

    /**
     * Indica a password do novo utilizador durante o processo de registo.
     *
     * @param u O utilizador a ser registado.
     * 
     */
    public void indicarPassRegisto(Utilizador u) {
        System.out.print("Insira a password do novo utilizador: ");
        u.setPassword(SCANNER.nextLine());
    }

    /**
     * Indica o email do novo utilizador durante o processo de registo.
     *
     * @param u O utilizador a ser registado.
     */
    public void indicarEmailRegisto(Utilizador u) {
        System.out.print("Insira o email do novo utilizador: ");
        u.setEmail(SCANNER.nextLine());
    }

    /**
     * Indica o papel do novo utilizador durante o processo de registo.
     *
     * @param u O utilizador a ser registado.
     */
    public void indicarPapelRegisto(Utilizador u) {
        System.out.print("Insira o papel do novo utilizador (Farmaceutico ou Industria): ");
        u.setPapel(SCANNER.nextLine().toLowerCase());
    }

    /**
     * Indica o contacto da farmacovigilância para utilizadores da Indústria Farmacêutica durante o processo de registo.
     *
     * @param i A instância de IndústriaFarmaceutica a ser configurada.
     */
    public void indicarContactoFarmacoRegisto(IndustriaFarmaceutica i) {
        System.out.print("Insira o telefone da Farmacovigilância: ");
        while (!SCANNER.hasNextInt()) {
            System.out.print("Por favor, insira um número válido: ");
            SCANNER.nextLine();
        }
        i.setContactoFarmaco(SCANNER.nextLine());
    }

    /**
     * Confirma o registo do novo utilizador e adiciona-o à lista de utilizadores.
     *
     * @param u A instância de Utilizador a ser adicionada à lista.
     * @return Uma mensagem indicando o sucesso do registo.
     */
    public String confirmarNovoUtilizador(Utilizador u) {
        this.listaUtilizadores.add(u);
        return "Utilizador registado com sucesso.";
    }
    /**
     * Cancela o processo de registo do utilizador.
     *
     * @return Uma mensagem indicando o cancelamento do registo.
     */
    public String cancelarRegisto() {
        return "Registo do utilizador cancelado.";
    }

    /**
     * JSON
     * Converte a instância do objeto HandlerUtilizadores em formato JSON e salva num arquivo.
     * Utiliza a biblioteca Gson para realizar a conversão.
     */
    public void salvarUtilizadoresEmJSON() {
        Gson gson = new Gson();
        String jsonUsersPath = "src/utilizadores.json";
        try (FileWriter writer = new FileWriter(jsonUsersPath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
