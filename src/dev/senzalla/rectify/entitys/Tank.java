package dev.senzalla.rectify.entitys;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */

public class Tank {
    private Long idTank;
    private int capacityTank;
    private String nameTank;

    public Long getIdTank() {
        return idTank;
    }

    public void setIdTank(Long idTank) {
        this.idTank = idTank;
    }

    public int getCapacityTank() {
        return capacityTank;
    }

    public void setCapacityTank(int capacityTank) {
        this.capacityTank = capacityTank;
    }

    public String getNameTank() {
        return nameTank;
    }

    public void setNameTank(String nameTank) {
        this.nameTank = nameTank;
    }

    @Override
    public String toString() {
        return getNameTank();
    }
}
