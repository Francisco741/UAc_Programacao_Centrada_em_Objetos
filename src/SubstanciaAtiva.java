import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code SubstanciaAtiva} representa uma substância ou mistura de substâncias destinada ao uso na produção de um medicamento.
 * Cada substância ativa possiu um nome.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class SubstanciaAtiva {
    @SerializedName("Substance")
    private String nome;

    public SubstanciaAtiva(){
        this("");
    }

    /**
     * Contrói uma nova substância ativa com nome especificado.
     * 
     * @param nome o nome da substância ativa
     */
    public SubstanciaAtiva(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
