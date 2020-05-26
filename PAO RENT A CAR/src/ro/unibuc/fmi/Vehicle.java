package ro.unibuc.fmi;

public abstract class Vehicle implements Comparable {
    private int nrUnic;
    private int tip;
    private int pret;
    private int combustibil;
    private int anFabricatie;
    private boolean disponibilitate;

    public Vehicle() {
        this.nrUnic=0;
        this.tip = 0;
        this.pret = 0;
        this.combustibil = 0;
        this.anFabricatie=0;
        this.disponibilitate=false;
        if (combustibil > 0) {
            this.disponibilitate = true;
        }
    }

    public Vehicle(int pret, int combustibil, int anFabricatie, int tip,int nrUnic) {
        this.nrUnic=nrUnic;
        this.tip = tip;
        this.pret = pret;
        this.combustibil = combustibil;
        this.anFabricatie=anFabricatie;
        this.disponibilitate=false;
        if (combustibil > 0) {
            this.disponibilitate = true;
        }
    }


    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setAnfabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public void setCombustibil(int combustibil) {
        this.combustibil = combustibil;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    public void setTiuprile(int tip) {
        this.tip = tip;
    }

    public int getPret() {
        return pret;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public int getCombustibil() {
        return combustibil;
    }

    public boolean getDisponibilitate() {
        return disponibilitate;
    }

    public int getTiuprile() {
        return tip;
    }

    public int getNrUnic() {
        return nrUnic;
    }

    public void setNrUnic(int nrUnic) {
        this.nrUnic = nrUnic;
    }

    public abstract void Buna();

    @Override
    public int compareTo(Object o) {
        return this.pret - ((Vehicle) o).getPret();
    }


}