package ro.unibuc.fmi;


import java.awt.desktop.SystemSleepEvent;

public class Masina extends Vehicle{
    private String  marca;//Bmw,Audi...
    private String  model;//X6,A6...

    public Masina() {
        super();
        this.marca = "";
        this.model="";
    }
    public Masina(int pret, int combustibil, int an_fabricatie,int tiuprile,String marca,String model,int nrUnic) {
        super(pret, combustibil, an_fabricatie,tiuprile,nrUnic);
        this.marca = marca;
        this.model=model;
    }

    public void setMarca(String marca)
    {
        this.marca= marca;
    }
    public void setModel(String model) {

        this.model =model ;
    }
    public String getMarca() {

        return marca;
    }
    public String getModel()
    {
        return model;
    }

    @Override
    public void Buna()
    {
        System.out.println("Sunt MASINA marca:"+marca+" si model "+model+",pret= " + super.getPret() + ", combustibil= " + super.getCombustibil() + "km, An fabricatie= " + super.getAnFabricatie()+", Numar unic= " + super.getNrUnic());
    }
}
