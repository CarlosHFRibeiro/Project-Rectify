package dev.senzalla.rectify.entitys;

import dev.senzalla.rectify.treatments.TreatmentDate;

import java.sql.Date;
import java.sql.Time;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class Discharge extends TreatmentDate {
    private Long idDcharge;
    private int noteDcharge;
    private int ticketDcharge;
    private int burdenDcharge;
    private int literDcharge;
    private String boardDcharge;
    private Date dtOfDcharge;
    private Date dtUpDcharge;
    private Time hrOfDcharge;
    private Time hrUpDcharge;
    private Tank tank;
    private Provider provider;
    private Product product;
    private AnalyzeTruck analyzeTruck;
    private Driver driver;

    public Long getIdDcharge() {
        return idDcharge;
    }

    public void setIdDcharge(Long idDcharge) {
        this.idDcharge = idDcharge;
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

    public String getBoardDcharge() {
        return boardDcharge;
    }

    public void setBoardDcharge(String boardDcharge) {
        this.boardDcharge = boardDcharge;
    }

    public Date getDtOfDcharge() {
        return dtOfDcharge;
    }

    public void setDtOfDcharge(java.util.Date dtOfDcharge) {
        this.dtOfDcharge = convertDateSql(dtOfDcharge);
    }

    public Date getDtUpDcharge() {
        return dtUpDcharge;
    }

    public void setDtUpDcharge(java.util.Date dtUpDcharge) {
        this.dtUpDcharge = convertDateSql(dtUpDcharge);
    }

    public Time getHrOfDcharge() {
        return hrOfDcharge;
    }

    public void setHrOfDcharge(Time hrOfDcharge) {
        this.hrOfDcharge = hrOfDcharge;
    }

    public Time getHrUpDcharge() {
        return hrUpDcharge;
    }

    public void setHrUpDcharge(Time hrUpDcharge) {
        this.hrUpDcharge = hrUpDcharge;
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
