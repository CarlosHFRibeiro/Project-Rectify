package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Discharge extends DateTreatment {
    private Long idDcharge;
    private int burdenDcharge;
    private int literDcharge;
    private int noteDcharge;
    private int ticketDcharge;
    private String carPlateDcharge;
    private Date dateEntryDcharge;
    private Date dateExitDcharge;
    private Time timeEntryDcharge;
    private Time timeExitDcharge;
    private AnalyzeTruck analyzeTruck;
    private Driver driver;
    private Product product;
    private Provider provider;
    private Tank tank;

    public Long getIdDcharge() {
        return idDcharge;
    }

    public void setIdDcharge(Long idDcharge) {
        this.idDcharge = idDcharge;
    }

    public int getBurdenDcharge() {
        return burdenDcharge;
    }

    public void setBurdenDcharge(int burdenDcharge) {
        this.burdenDcharge = burdenDcharge;
    }

    public int getLiterDcharge() {
        return literDcharge;
    }

    public void setLiterDcharge(int literDcharge) {
        this.literDcharge = literDcharge;
    }

    public int getNoteDcharge() {
        return noteDcharge;
    }

    public void setNoteDcharge(int noteDcharge) {
        this.noteDcharge = noteDcharge;
    }

    public int getTicketDcharge() {
        return ticketDcharge;
    }

    public void setTicketDcharge(int ticketDcharge) {
        this.ticketDcharge = ticketDcharge;
    }

    public String getCarPlateDcharge() {
        return carPlateDcharge;
    }

    public void setCarPlateDcharge(String carPlateDcharge) {
        this.carPlateDcharge = carPlateDcharge;
    }

    public Date getDateEntryDcharge() {
        return dateEntryDcharge;
    }

    public void setDateEntryDcharge(java.util.Date dateEntryDcharge) {
        this.dateEntryDcharge = convertDateSql(dateEntryDcharge);
    }

    public Date getDateExitDcharge() {
        return dateExitDcharge;
    }

    public void setDateExitDcharge(java.util.Date dateExitDcharge) {
        this.dateExitDcharge = convertDateSql(dateExitDcharge);
    }

    public Time getTimeEntryDcharge() {
        return timeEntryDcharge;
    }

    public void setTimeEntryDcharge(Time timeEntryDcharge) {
        this.timeEntryDcharge = timeEntryDcharge;
    }

    public Time getTimeExitDcharge() {
        return timeExitDcharge;
    }

    public void setTimeExitDcharge(Time timeExitDcharge) {
        this.timeExitDcharge = timeExitDcharge;
    }

    public AnalyzeTruck getAnalyzeTruck() {
        return analyzeTruck;
    }

    public void setAnalyzeTruck(AnalyzeTruck analyzeTruck) {
        this.analyzeTruck = analyzeTruck;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
