package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEster {
    private Long idEster;
    private int reactEster;
    private int amountEster;
    private int foreseenEster;
    private int trashEster;
    private int producedEster;
    private Tank tank;
    private MatterEster matterEster;
    private ReactEster reactEsters;

    public Long getIdEster() {
        return idEster;
    }

    public void setIdEster(Long idEster) {
        this.idEster = idEster;
    }

    public int getReactEster() {
        return reactEster;
    }

    public void setReactEster(int reactEster) {
        this.reactEster = reactEster;
    }

    public int getAmountEster() {
        return amountEster;
    }

    public void setAmountEster(int amountEster) {
        this.amountEster = amountEster;
    }

    public int getForeseenEster() {
        return foreseenEster;
    }

    public void setForeseenEster(int foreseenEster) {
        this.foreseenEster = foreseenEster;
    }

    public int getTrashEster() {
        return trashEster;
    }

    public void setTrashEster(int trashEster) {
        this.trashEster = trashEster;
    }

    public int getProducedEster() {
        return producedEster;
    }

    public void setProducedEster(int producedEster) {
        this.producedEster = producedEster;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public MatterEster getMatterEster() {
        return matterEster;
    }

    public void setMatterEster(MatterEster matterEster) {
        this.matterEster = matterEster;
    }

    public ReactEster getReactEsters() {
        return reactEsters;
    }

    public void setReactEsters(ReactEster reactEsters) {
        this.reactEsters = reactEsters;
    }
    
}
