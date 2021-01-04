package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.DateTreatment;

import java.sql.Date;
import java.sql.Time;

public class Transport extends DateTreatment {

    protected Long id;
    protected int burden;
    protected int liter;
    protected int note;
    protected int ticket;
    protected String carPlate;
    protected Date dateEntry;
    protected Date dateExit;
    protected Time timeEntry;
    protected Time timeExit;
    protected AnalyzeTruck analyzeTruck;
    protected Driver driver;
    protected Product product;
    protected Provider provider;
    protected Tank tank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBurden() {
        return burden;
    }

    public void setBurden(int burden) {
        this.burden = burden;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public Date getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(java.util.Date dateEntry) {
        this.dateEntry = convertDateSql(dateEntry);
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(java.util.Date dateExit) {
        this.dateExit = convertDateSql(dateExit);
    }

    public Time getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(Time timeEntry) {
        this.timeEntry = timeEntry;
    }

    public Time getTimeExit() {
        return timeExit;
    }

    public void setTimeExit(Time timeExit) {
        this.timeExit = timeExit;
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
