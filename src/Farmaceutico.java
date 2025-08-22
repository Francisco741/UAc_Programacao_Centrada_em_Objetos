/**
 * A classe {@code Farmaceutico} representa um utiilizador com o cargo de farmacêutico.
 * Cada farmacêutico possiu um nome, password e email.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Farmaceutico extends Utilizador {
    public Farmaceutico() {
        this("", "", "");
    }

    /**
     * Contrói um novo farmacêutico com nome, password e email especificados.
     * 
     * @param nome o nome do farmacêutico
     * @param password a password do farmacêutico
     * @param email o email do farmacêutico
     */
    public Farmaceutico(String nome, String password, String email) {
        super(nome, password, email, "farmaceutico");
    }
}