package ro.unibuc.fmi;

public class Tir extends Vehicle{
    private int capacitate;//In tone
    public Tir() {
        super();
        this.capacitate=0;
    }
    public Tir(int pret, int combustibil, int an_fabricatie,int tiuprile,int capacitate,int nrUnic) {
        super(pret, combustibil, an_fabricatie,tiuprile,nrUnic);
        this.capacitate=capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate=capacitate;
    }
    public int getCapacitate() {
        return capacitate;
    }
    @Override
    public void Buna()
    {
        System.out.println("Sunt TIR cu capacitatea de: "+capacitate+"tone"+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAnFabricatie()+", Numar unic= " + super.getNrUnic());
    }
}
