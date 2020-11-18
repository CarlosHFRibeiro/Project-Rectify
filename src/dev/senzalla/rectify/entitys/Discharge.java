package dev.senzalla.rectify.entitys;

import java.sql.Time;
import java.util.Date;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class Discharge {
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
    private LabCar labCar;
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

    public void setDtOfDcharge(Date dtOfDcharge) {
        this.dtOfDcharge = dtOfDcharge;
    }

    public Date getDtUpDcharge() {
        return dtUpDcharge;
    }

    public void setDtUpDcharge(Date dtUpDcharge) {
        this.dtUpDcharge = dtUpDcharge;
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

    public LabCar getLabCar() {
        return labCar;
    }

    public void setLabCar(LabCar labCar) {
        this.labCar = labCar;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
