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
    private String boardCharge;
    private Date dtOfCharge;
    private Date dtUpCharge;
    private Time hrOfCharge;
    private Time hrUpCharge;
    private Tank tank;
    private Provider provider;
    private Product product;
    private LabCar labCar;
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

    public String getBoardCharge() {
        return boardCharge;
    }

    public void setBoardCharge(String boardCharge) {
        this.boardCharge = boardCharge;
    }

    public Date getDtOfCharge() {
        return dtOfCharge;
    }

    public void setDtOfCharge(java.util.Date dtOfCharge) {
        this.dtOfCharge = convertDateSql(dtOfCharge);
    }

    public Date getDtUpCharge() {
        return dtUpCharge;
    }

    public void setDtUpCharge(java.util.Date dtUpCharge) {
        this.dtUpCharge = convertDateSql(dtUpCharge);
    }

    public Time getHrOfCharge() {
        return hrOfCharge;
    }

    public void setHrOfCharge(Time hrOfCharge) {
        this.hrOfCharge = hrOfCharge;
    }

    public Time getHrUpCharge() {
        return hrUpCharge;
    }

    public void setHrUpCharge(Time hrUpCharge) {
        this.hrUpCharge = hrUpCharge;
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
