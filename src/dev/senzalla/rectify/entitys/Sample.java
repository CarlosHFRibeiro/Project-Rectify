package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Sample extends DateTreatment {
    private Long idSample;
    private int petrobrasSample;
    private int clientSample;
    private int factorySample;
    private int auctionNumber;
    private Date dateSampleCollection;
    private Provider provider;

    public Long getIdSample() {
        return idSample;
    }

    public void setIdSample(Long idSample) {
        this.idSample = idSample;
    }

    public int getPetrobrasSample() {
        return petrobrasSample;
    }

    public void setPetrobrasSample(int petrobrasSample) {
        this.petrobrasSample = petrobrasSample;
    }

    public int getClientSample() {
        return clientSample;
    }

    public void setClientSample(int clientSample) {
        this.clientSample = clientSample;
    }

    public int getFactorySample() {
        return factorySample;
    }

    public void setFactorySample(int factorySample) {
        this.factorySample = factorySample;
    }

    public int getAuctionNumber() {
        return auctionNumber;
    }

    public void setAuctionNumber(int auctionNumber) {
        this.auctionNumber = auctionNumber;
    }

    public Date getDateSampleCollection() {
        return dateSampleCollection;
    }

    public void setDateSampleCollection(java.util.Date dateSampleCollection) {
        this.dateSampleCollection = convertDateSql(dateSampleCollection);
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return String.valueOf(getAuctionNumber());
    }
}
