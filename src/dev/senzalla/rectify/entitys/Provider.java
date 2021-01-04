package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Provider {
    private Long idProvider;
    private String cnpjProvider;
    private String nameProvider;
    private String phoneProvider;

    public Provider() {
    }

    public Provider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

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

    public String getNameProvider() {
        return nameProvider;
    }

    public void setNameProvider(String nameProvider) {
        this.nameProvider = nameProvider;
    }

    public String getPhoneProvider() {
        return phoneProvider;
    }

    public void setPhoneProvider(String phoneProvider) {
        this.phoneProvider = phoneProvider;
    }


    @Override
    public String toString() {
        return getNameProvider();
    }
}
