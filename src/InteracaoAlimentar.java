import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code InteracaoAlimentar} representa uma interação entre medicamentos e alimentos.
 * Cada interação alimentar possiu uma explicação, efeito e bibliografia.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class InteracaoAlimentar {

    @SerializedName("Explanation")
    private String explicacao;

    @SerializedName("Effect")
    private String efeito;

    @SerializedName("Bibliography")
    private String bibliografia;

    @SerializedName("Substances")
    private String substanciaAtiva;

    @SerializedName("Food")
    private String alimento;


    public InteracaoAlimentar() {
        this("",
        "",
        "",
        "",
        ""
        );
    }

    /**
     * Contrói uma nova interação alimentar com explicação, efeito e bibliografica especificados.
     * 
     * @param explicacao a explicação da interação alimentar
     * @param efeito o efeito da interação alimentar
     * @param bibliografia a bibliografia da interação alimentar
     * @param bibliografia substância ativa que interage com o alimento
     * @param bibliografia alimento que interage com a substância ativa
     */
    public InteracaoAlimentar(
        String explicacao,
        String efeito,
        String bibliografia,
        String substanciaAtiva,
        String alimento
        ) 
    {
        this.explicacao = explicacao;
        this.efeito = efeito;
        this.bibliografia = bibliografia;
        this.substanciaAtiva = substanciaAtiva;
        this.alimento = alimento;
    }

    public String getExplicacao() {
        return explicacao;
    }

    public void setExplicacao(String explicacao) {
        this.explicacao = explicacao;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getSubstanciaAtiva() {
        return substanciaAtiva;
    }

    public void setSubstanciaAtiva(String substanciaAtiva) {
        this.substanciaAtiva = substanciaAtiva;
    }

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
}
