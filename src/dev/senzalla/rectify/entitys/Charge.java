package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Charge extends TreatmentDate {
    private Long idCharge;
    private int noteCharge;
    private int ticketCharge;
    private int burdenCharge;
    private int literCharge;
    private String carPlateCharge;
    private Date dateEntryCharge;
    private Date dateExitCharge;
    private Time timeEntryCharge;
    private Time timeExitCharge;
    private Tank tank;
    private Provider provider;
    private Product product;
    private AnalyzeTruck analyzeTruck;
    private Driver driver;

    public Long getIdCharge() {
        return idCharge;
    }

    public void setIdCharge(Long idCharge) {
        this.idCharge = idCharge;
    }

    public int getNoteCharge() {
        return noteCharge;
    }

    public void setNoteCharge(int noteCharge) {
        this.noteCharge = noteCharge;
    }

    public int getTicketCharge() {
        return ticketCharge;
    }

    public void setTicketCharge(int ticketCharge) {
        this.ticketCharge = ticketCharge;
    }

    public int getBurdenCharge() {
        return burdenCharge;
    }

    public void setBurdenCharge(int burdenCharge) {
        this.burdenCharge = burdenCharge;
    }

    public int getLiterCharge() {
        return literCharge;
    }

    public void setLiterCharge(int literCharge) {
        this.literCharge = literCharge;
    }

    public String getCarPlateCharge() {
        return carPlateCharge;
    }

    public void setCarPlateCharge(String carPlateCharge) {
        this.carPlateCharge = carPlateCharge;
    }

    public Date getDateEntryCharge() {
        return dateEntryCharge;
    }

    public void setDateEntryCharge(java.util.Date dateEntryCharge) {
        this.dateEntryCharge = convertDateSql(dateEntryCharge);
    }

    public Date getDateExitCharge() {
        return dateExitCharge;
    }

    public void setDateExitCharge(java.util.Date dateExitCharge) {
        this.dateExitCharge = convertDateSql(dateExitCharge);
    }

    public Time getTimeEntryCharge() {
        return timeEntryCharge;
    }

    public void setTimeEntryCharge(Time timeEntryCharge) {
        this.timeEntryCharge = timeEntryCharge;
    }

    public Time getTimeExitCharge() {
        return timeExitCharge;
    }

    public void setTimeExitCharge(Time timeExitCharge) {
        this.timeExitCharge = timeExitCharge;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AnalyzeTruck getanalyzeTruck() {
        return analyzeTruck;
    }

    public void setanalyzeTruck(AnalyzeTruck analyzeTruck) {
        this.analyzeTruck = analyzeTruck;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
