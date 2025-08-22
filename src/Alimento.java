import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code Alimento} representa um alimento, que junto com uma substância ativa origina uma interação alimentar.
 * Cada alimento possiu um nome.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Alimento {
    @SerializedName("Type")
    private String nome;

    public Alimento() {
        this("");
    }

    /**
     * Contrói um novo alimento com nome especificado.
     * 
     * @param nome o nome do alimento
     */
    public Alimento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
