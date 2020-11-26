package dev.senzalla.rectify.entitys;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTrans {
    private Long idTrans;
    private int reactTrans;
    private int amountTrans;
    private int foreseenTrans;
    private int trashTrans;
    private int producedTrans;
    private Tank tank;
    private MatterTrans matterTrans;
    private ReactTrans reactTranss;

    public Long getIdTrans() {
        return idTrans;
    }

    public void setIdTrans(Long idTrans) {
        this.idTrans = idTrans;
    }

    public int getReactTrans() {
        return reactTrans;
    }

    public void setReactTrans(int reactTrans) {
        this.reactTrans = reactTrans;
    }

    public int getAmountTrans() {
        return amountTrans;
    }

    public void setAmountTrans(int amountTrans) {
        this.amountTrans = amountTrans;
    }

    public int getForeseenTrans() {
        return foreseenTrans;
    }

    public void setForeseenTrans(int foreseenTrans) {
        this.foreseenTrans = foreseenTrans;
    }

    public int getTrashTrans() {
        return trashTrans;
    }

    public void setTrashTrans(int trashTrans) {
        this.trashTrans = trashTrans;
    }

    public int getProducedTrans() {
        return producedTrans;
    }

    public void setProducedTrans(int producedTrans) {
        this.producedTrans = producedTrans;
    }

    public Tank getTank() {
        return tank;
    }

    public MatterTrans getMatterTrans() {
        return matterTrans;
    }

    public void setMatterTrans(MatterTrans matterTrans) {
        this.matterTrans = matterTrans;
    }

    public ReactTrans getReactTranss() {
        return reactTranss;
    }

    public void setReactTranss(ReactTrans reactTranss) {
        this.reactTranss = reactTranss;
    }

    public void setTank(Tank tank) {
        this.tank = tank;

    }
}
