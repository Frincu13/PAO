package ro.unibuc.fmi;

public class Barca extends Vehicle{
    private int lungime;
    public Barca(int pret, int combustibil, int an_fabricatie,int tiuprile,int lungime) {
        super(pret, combustibil, an_fabricatie,tiuprile);
        this.lungime=lungime;
    }

    public void setLungime(int lungime) {
        this.lungime=lungime;
    }
    public int getLungime() {
        return lungime;
    }
    @Override
    public void Buna()
    {
        System.out.println("Sunt BARCA de lungime:"+lungime+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAn_fabricatie());
    }
}
