package ro.unibuc.fmi;

public class Motocicleta extends Vehicle{
    private int putere;//500cc...
    public Motocicleta(int pret, int combustibil, int an_fabricatie,int tiuprile,int putere,int nrUnic) {
        super(pret, combustibil, an_fabricatie,tiuprile,nrUnic);
        this.putere=putere;
    }

    public void setPutere(int putere) {
        this.putere=putere;
    }
    public int getPutere() {
        return putere;
    }

    @Override
    public void Buna()
    {
        System.out.println("Sunt MOTOCICLETA de putere:"+putere+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAnFabricatie()+", Numar unic= " + super.getNrUnic());
    }
}
