import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code Medicamento} representa um medicamento produzido pela indústria farmacêutica.
 * Cada medicamento possiu um nome, forma farmacêutica e dosagem.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Medicamento {
    @SerializedName("Name")
    private String nome;

    @SerializedName("Form")
    private String formaFarmaceutica;

    @SerializedName("Dosage")
    private String dosagem;

    @SerializedName("Laboratory")
    private String industriaFarmaceutica;

    @SerializedName("Substances")
    private String substanciaAtiva;


    public Medicamento() {
        this("", "", "", "", "");
    }

    /**
     * Contrói um novo medicamento com nome, forma farmacêutica e dosagem especificados.
     * 
     * @param nome o nome do medicamento
     * @param formaFarmacêutica a forma farmacêutica do medicamento
     * @param dosagem a dosagem do medicamento
     */
    public Medicamento(String nome,
                        String formaFarmaceutica,
                        String dosagem,
                        String industriaFarmaceutica,
                        String substanciaAtiva
                    ) 
    {
        this.nome = nome;
        this.formaFarmaceutica = formaFarmaceutica;
        this.dosagem = dosagem;
        this.industriaFarmaceutica = industriaFarmaceutica;
        this.substanciaAtiva = substanciaAtiva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getIndustriaFarmaceutica() {
        return industriaFarmaceutica;
    }

    public void setIndustriaFarmaceutica(String industriaFarmaceutica) {
        this.industriaFarmaceutica = industriaFarmaceutica;
    }

    public String getSubstanciaAtiva() {
        return substanciaAtiva;
    }

    public void setSubstanciaAtiva(String substanciaAtiva) {
        this.substanciaAtiva = substanciaAtiva;
    }
}
