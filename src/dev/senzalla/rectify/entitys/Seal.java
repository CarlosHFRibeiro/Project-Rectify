package dev.senzalla.rectify.entitys;

import java.util.Date;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class Seal {
    private Long idSeal;
    private int saleSeal;
    private int clientSeal;
    private int factorySeal;
    private int brSeal;
    private Date dtSeal;
    private Provider provider;

    public Long getIdSeal() {
        return idSeal;
    }

    public void setIdSeal(Long idSeal) {
        this.idSeal = idSeal;
    }

    public int getSaleSeal() {
        return saleSeal;
    }

    public void setSaleSeal(int saleSeal) {
        this.saleSeal = saleSeal;
    }

    public int getClientSeal() {
        return clientSeal;
    }

    public void setClientSeal(int clientSeal) {
        this.clientSeal = clientSeal;
    }

    public int getFactorySeal() {
        return factorySeal;
    }

    public void setFactorySeal(int factorySeal) {
        this.factorySeal = factorySeal;
    }

    public int getBrSeal() {
        return brSeal;
    }

    public void setBrSeal(int brSeal) {
        this.brSeal = brSeal;
    }

    public Date getDtSeal() {
        return dtSeal;
    }

    public void setDtSeal(Date dtSeal) {
        this.dtSeal = dtSeal;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
