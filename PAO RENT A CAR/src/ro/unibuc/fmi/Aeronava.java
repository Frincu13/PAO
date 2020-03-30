package ro.unibuc.fmi;

public class Aeronava extends Vehicle{
    private String type;//Private Jet, Elicopter...
    public Aeronava(int pret, int combustibil, int an_fabricatie,int tiuprile,String type ){
        super(pret, combustibil, an_fabricatie,tiuprile);
        this.type=type;
    }

    public void setType(String type) {
        this.type=type;
    }
    public String getType() {
        return type;
    }
    @Override
    public void Buna()
    {
        System.out.println("Sunt "+type+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAn_fabricatie());
    }

}
