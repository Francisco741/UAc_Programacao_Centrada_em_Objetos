/**
 * A classe {@code Administrador} representa um utiilizador com o cargo de administrador.
 * Cada administrador possiu um nome, password e email.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Administrador extends Utilizador {
    public Administrador() {
        this("nome", "password", "email");
    }

/**
 * Contrói um novo administrador com nome, password e email especificados.
 * 
 * @param nome o nome do administrador
 * @param password a password do administrador
 * @param email o email do administrador
 */
    public Administrador(String nome, String password, String email) {
        super(nome, password, email, "administrador");
    }
}
