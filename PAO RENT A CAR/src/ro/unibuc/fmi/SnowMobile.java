package ro.unibuc.fmi;

public class SnowMobile extends Vehicle{
    private String varsta;
    public SnowMobile(int pret, int combustibil, int an_fabricatie,int tiuprile,String varsta) {
        super(pret, combustibil, an_fabricatie,tiuprile);
        this.varsta=varsta;
    }

    public void setVarsta(String varsta) {
        this.varsta=varsta;
    }
    public String getVarsta() {
        return varsta;
    }

    @Override
    public void Buna()
    {
        System.out.println("Sunt SNOEMOBIL de :"+varsta+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAn_fabricatie());
    }
}

