package ro.unibuc.fmi;

public class Aeronava extends Vehicle{
    private String type;//Private Jet, Elicopter...
    public Aeronava(){
        super();
        this.type="";
    }
    public Aeronava(int pret, int combustibil, int an_fabricatie,int tiuprile,String type,int nrUnic){
        super(pret, combustibil, an_fabricatie,tiuprile,nrUnic);
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
        System.out.println("Sunt "+type+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAnFabricatie()+", Numar unic= " + super.getNrUnic());
    }

}
