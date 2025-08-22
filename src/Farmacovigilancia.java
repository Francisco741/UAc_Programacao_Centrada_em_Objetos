import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code Farmacovigilancia} representa uma entidade reguladora da indústria farmacêutica.
 * Cada farmacovigilância possiu um número de telefone.
 * 
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Farmacovigilancia {
    @SerializedName("Surveillance")
    private String contacto;

    public Farmacovigilancia() {
        this("");
    }

    /**
     * Contrói uma nova farmacovigilância com o número de telefone especificados.
     * 
     * @param contacto o número de telefone da farmacovigilância
     */
    public Farmacovigilancia(String contacto) {
        this.contacto = contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
