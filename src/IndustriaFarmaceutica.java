import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code IndustriaFarmaceutica} representa uma indústria farmacêutica responsável por produzir medicamentos.
 * Cada indústria farmacêutica possiu um nome, password, email e uma farmacovigilância associada.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class IndustriaFarmaceutica extends Utilizador {
    @SerializedName("Surveillance")
    private String contactoFarmaco;

    public IndustriaFarmaceutica() {
        this("", "", "", "");
    }

    /**
     * Contrói uma nova indústria farmacêutica com nome, password, email e farmacovigilância especificados.
     * 
     * @param nome o nome da indústria farmacêutica
     * @param password a password da indústria farmacêutica
     * @param email o email da indústria farmacêutica
     * @param contactoFarmaco contacto da farmacovigilância associada à indústria farmacêutica
     */
    public IndustriaFarmaceutica(String nome, String password, String email, String contactoFarmaco) {
        super(nome, password, email, "industria");
        this.contactoFarmaco = contactoFarmaco;
    }

    public IndustriaFarmaceutica(String nome, String password, String email) {
        super(nome, password, email, "industria");
    }

    public String getContactoFarmaco() {
        return contactoFarmaco;
    }

    public void setContactoFarmaco(String contactoFarmaco) {
        this.contactoFarmaco = contactoFarmaco;
    }
}
