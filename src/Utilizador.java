import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code Utilizador} representa um utiilizador.
 * Cada utilizador possiu um nome, password, email e papel.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Utilizador {
    @SerializedName("Name")
    private String nome;
    private String password;
    private String email;
    private String papel;

    public Utilizador() {
        this("", "", "", "");
    }

    /**
     * Contrói um novo utilizador com nome, password, email e papel especificados.
     * 
     * @param nome o nome do utilizador
     * @param password a password do utilizador
     * @param email o email do utilizador
     * @param papel o papel do utilizador
     */
    public Utilizador(String nome, String password, String email, String papel) {
        this.nome = nome;
        this.password = password;
        this.email = email;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
