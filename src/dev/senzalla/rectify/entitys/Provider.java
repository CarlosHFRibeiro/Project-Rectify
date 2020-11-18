package dev.senzalla.rectify.entitys;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class Provider {
    private Long idProvider;
    private String cnpjProvider;
    private String phoneProvider;
    private String nameProvider;

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public String getCnpjProvider() {
        return cnpjProvider;
    }

    public void setCnpjProvider(String cnpjProvider) {
        this.cnpjProvider = cnpjProvider;
    }

    public String getPhoneProvider() {
        return phoneProvider;
    }

    public void setPhoneProvider(String phoneProvider) {
        this.phoneProvider = phoneProvider;
    }

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }
}
