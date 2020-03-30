package ro.unibuc.fmi;
import java.util.*;

public class Sediu {//Service pentru firma
    private VehicleService vehicleService;
    private LinkedList<Vehicle> tot = new LinkedList<>();
    private Set<Customer> customers;

    public Sediu() {
        this.vehicleService= new VehicleService();
        this.customers = new HashSet<>();
    }

    public Sediu(VehicleService vehicleService , Set<Customer> customer ) {
        this.vehicleService = vehicleService;
        this.customers = customer;

    }
    public Set<Customer> getCustomer() {
        return customers;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }


    public void addCustomer(String nume,int spend)
    {
        Customer newCustomer=new Customer(spend,nume);
        int ok=0;
        for (Customer customer : customers)
            if(customer.getName().equals(newCustomer.getName()))
            {customer.setSpend(customer.getSpend()+newCustomer.getSpend());
                ok=1;}
        if(ok==0)
            this.customers.add(newCustomer);
    }
    public void displayBestCustomers() {
        Customer newCustomer=new Customer(0,".");
        for (Customer customerul : customers)
            if(newCustomer.getSpend()<customerul.getSpend())
                newCustomer=customerul;
        System.out.println("Clientul nostru cel mai bun:"+newCustomer.getName()+" a cheltuit:"+newCustomer.getSpend()+" de dolarei");
        System.out.println();
    }

    public void displayCustomers() {
        for (Customer customerul : customers)
            System.out.println("Clientul:"+customerul.getName()+" a cheltuit:"+customerul.getSpend());
        System.out.println();
    }


    public void addVehicle(Vehicle newVehicle) {
        this.vehicleService.increaseSize();
        this.vehicleService.getVehicles().add(newVehicle);
    }


    public void displayVehicles() {
        tot=vehicleService.getVehicles();
        Collections.sort(tot);
        for (Vehicle vehicle : vehicleService.getVehicles())
            vehicle.Buna();
    }

    public void displayEmptyVehicles() {
        int ok=0;
        for (Vehicle vehicle : vehicleService.getVehicles())
            if(!vehicle.getDisponibilitate())
            {vehicle.Buna();
            ok=1;}
        if(ok==0)
        System.out.println("Nu exista vehicule fara combustibil");
    }

    public void displayBilzerianVehicles() {
        Vehicle vscump=new Masina(0,0,0,1,".",".");
        System.out.println("Ce este perfect pentru Domnul Bilzerian:");
        for (Vehicle vehicle : vehicleService.getVehicles())
            if(vscump.getPret()<vehicle.getPret())
                vscump=vehicle;

        vscump.Buna();

    }

    public void displayGatesVehicles() {
        int pret=0;
        System.out.println("Inchiriare completa costa:");
        for (Vehicle vehicle : vehicleService.getVehicles())
            pret=pret+vehicle.getPret();

        System.out.println(pret);

    }

    public void displayPretBarcaSaracie() {
        int pret,ok=0;
        System.out.println("Inchiriare cea mai ieftina barca:");
        Barca barca=new Barca(999999,0,0,2,0);
        for (Vehicle vehicle : vehicleService.getVehicles())
            if(vehicle instanceof Barca)
                if(vehicle.getPret()<barca.getPret())
                {barca=((Barca)vehicle);
                ok=1;}

       if(ok==1)
        System.out.println(barca.getPret());
       else
        System.out.println("Nu avem barci disponibile momentan");
    }
    public void IncarcaVehicles(int km) {
        System.out.println("Realimentam:");
        for (Vehicle vehicle : vehicleService.getVehicles())
            if(!vehicle.getDisponibilitate()) {
                vehicle.setCombustibil(vehicle.getCombustibil()+km);
                vehicle.Buna();
            }
            System.out.println();
    }
    Scanner scan = new Scanner(System.in);
    public  void Inchiriaza(int tip,int km,String nume)
    {
        System.out.println("Inchiriem:");
        System.out.println("Ce an?");
        int an = scan.nextInt();
        switch (tip) {
            case 1:
                System.out.println("Ce marca este?");
                String marca = scan.next();
                System.out.println("Ce model este?");
                String model = scan.next();
                int oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                         if(vehicle.getCombustibil()>=km)
                            if(((Masina) vehicle).getMarca().equals(marca))
                                if(((Masina) vehicle).getModel().equals(model)) {
                                    addCustomer(nume,vehicle.getPret());
                                    oke=1;
                                    System.out.println("S-a gasit masina potrivita");
                                    vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                    if(vehicle.getCombustibil()==0)
                                        vehicle.setDisponibilitate(false);

                                }
                if(oke==0)
                System.out.println("Nu s-a gasit masina potrivita");
                break;
            case 2:
                System.out.println("Ce capacitate are?(tone)");
                int capacitate = scan.nextInt();
                oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                            if(vehicle.getCombustibil()>=km)
                                if(((Tir) vehicle).getCapacitate()==capacitate)
                                     {
                                         addCustomer(nume,vehicle.getPret());
                                         oke=1;
                                        System.out.println("S-a gasit Tir-ul potrivita");
                                        vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                        if(vehicle.getCombustibil()==0)
                                            vehicle.setDisponibilitate(false);

                                    }
                if(oke==0)
                    System.out.println("Nu s-a gasit Tirul potrivita");
                break;

            case 3:
                System.out.println("Ce tip este?");
                String tipul = scan.next();
                oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                            if(vehicle.getCombustibil()>=km)
                                if(((Aeronava) vehicle).getType().equals(tipul))
                                {
                                    addCustomer(nume,vehicle.getPret());
                                    oke=1;
                                    System.out.println("S-a gasit Aeronava potrivita");
                                    vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                    if(vehicle.getCombustibil()==0)
                                        vehicle.setDisponibilitate(false);

                                }
                if(oke==0)
                    System.out.println("Nu s-a gasit Aeronava potrivita");
                break;

            case 4:
                System.out.println("Ce lungime are are?(metri)");
                int lungime = scan.nextInt();
                oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                            if(vehicle.getCombustibil()>=km)
                                if(((Barca) vehicle).getLungime()==lungime)
                                {
                                    addCustomer(nume,vehicle.getPret());
                                    oke=1;
                                    System.out.println("S-a gasit Barca potrivita");
                                    vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                    if(vehicle.getCombustibil()==0)
                                        vehicle.setDisponibilitate(false);

                                }
                if(oke==0)
                    System.out.println("Nu s-a gasit Barca potrivita");
                break;

            case 5:
                System.out.println("Ce putere are?(cc)");
                int putere = scan.nextInt();
                oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                            if(vehicle.getCombustibil()>=km)
                                if(((Motocicleta) vehicle).getPutere()==putere)
                                {
                                    addCustomer(nume,vehicle.getPret());
                                    oke=1;
                                    System.out.println("S-a gasit Motocicleta potrivita");
                                    vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                    if(vehicle.getCombustibil()==0)
                                        vehicle.setDisponibilitate(false);

                                }
                if(oke==0)
                    System.out.println("Nu s-a gasit motocicleta potrivita");
                break;
            case 6:{
                System.out.println("Pentru cine este?(Copil sau Adult)");
                String persoana = scan.next();
                oke=0;
                for (Vehicle vehicle : vehicleService.getVehicles())
                    if(vehicle.getDisponibilitate())
                        if(vehicle.getAn_fabricatie()==an)
                            if(vehicle.getCombustibil()>=km)
                                if(((SnowMobile) vehicle).getVarsta().equals(persoana))
                                {
                                    addCustomer(nume,vehicle.getPret());
                                    oke=1;
                                    System.out.println("S-a gasit Snowmobil-ul potrivita");
                                    vehicle.setCombustibil(vehicle.getCombustibil() - km);
                                    if(vehicle.getCombustibil()==0)
                                        vehicle.setDisponibilitate(false);

                                }
                if(oke==0)
                    System.out.println("Nu s-a gasit snowmobil-ul potrivita");
                break;}



        }
    }


}

