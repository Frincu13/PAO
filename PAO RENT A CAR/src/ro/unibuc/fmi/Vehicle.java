package ro.unibuc.fmi;

public abstract class Vehicle implements Comparable{
    private int tiuprile;
    private int pret;
    private int combustibil;
    private int an_fabricatie;
    private boolean disponibilitate;

    public Vehicle(int pret, int combustibil, int an_fabricatie,int tiuprile) {
        this.tiuprile=tiuprile;
        this.pret = pret;
        this.combustibil = combustibil;
        this.an_fabricatie = an_fabricatie;
        if(combustibil>0)
         this.disponibilitate=true;
        else
            this.disponibilitate=false;
    }


    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie =an_fabricatie ;
    }

    public void setCombustibil(int combustibil) {
        this.combustibil=combustibil;
    }

    public void setDisponibilitate(boolean disponibilitate) {
        this.disponibilitate=disponibilitate;
    }

    public void setTiuprile(int tiuprile) {
        this.tiuprile =tiuprile ;
    }

    public int getPret() {
        return pret;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public int getCombustibil() {
        return combustibil;
    }

    public boolean getDisponibilitate() {
        return disponibilitate;
    }

    public int getTiuprile() { return tiuprile;
    }

    public abstract void Buna();

    @Override
    public int compareTo(Object o) {
        return this.pret - ((Vehicle) o).getPret();
    }


}