package ro.unibuc.fmi;
import ro.unibuc.fmi.service.MasinaService;
import ro.unibuc.fmi.service.TirService;
import ro.unibuc.fmi.service.AeronavaService;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("Alex Rent A Vehicle.SRL");
        Sediu sediu = new Sediu();
        ReadnWrite readnWrite = ReadnWrite.getInstance();
        readnWrite.readVehiclesFromFile(sediu);
        Audit audit= Audit.getInstance();
        Scanner scan = new Scanner(System.in);
        MasinaService masinaService =MasinaService.getInstance();
        TirService tirService =TirService.getInstance();
        AeronavaService aeronavaService=AeronavaService.getInstance();
        System.out.println("Ce doriti sa faceti?\n" +
                "1) Adauga vehicul\n" +
                "2) Arata toate vehiculele in ordine crescatoare a preturilor\n" +
                "3) Afla ce vehicule trebuie realimentate\n" +
                "4) Incarca vehiculele si alege de cat sa bagi benzina\n" +
                "5) Inchiriaza vehicul unui client\n" +
                "6) Arata clientii\n" +
                "7) Arata cel mai fidel client de astazi pentru a-l recompensa \n" +
                "8) A venit Dan Bilzerian,doreste cel mai scump vehicul,care este?\n" +
                "9) A venit Bill Porti si vrea sa inchirieze totul,cat il costa?(Nu il adauga la clienti,nu are nevoie sa fie recompensat) \n" +
                "10)Cineva vrea sa inchireze o barca,dar bugetul nu-l ajuta,care este cea mai iefina?\n" +
                "11)Un client a busit masina,prin urmare este banat pe viata\n"+
                "12)Vehicul dauna totala\n"+
                "13)Meniu\n"+
                "0) Inchide\n");
        int t,t2;
        do {

            t = scan.nextInt();

            switch (t) {
                case 1:
                    audit.writePersonsToFile("Am adaugat o masina");
                    System.out.println("Ce vehicul vreti sa adaugam?\n" +
                            "1) Masina\n" +
                            "2) Tir\n" +
                            "3) Aeronava\n" +
                            "4) Barca\n" +
                            "5) Motocicleta\n" +
                            "6) Snowmobil\n"
                    );
                    t2 = scan.nextInt();
                    int tip = t2;
                    System.out.println("nr_unic: ");
                    int nrUnic = scan.nextInt();
                    System.out.println("Pret inchiriere($): ");
                    int pret = scan.nextInt();
                    System.out.println("Cat combustibil mai are(km): ");
                    int combustibil = scan.nextInt();
                    System.out.println("Anul de Fabricatie: ");
                    int an_fabricatie = scan.nextInt();

                    switch (t2) {
                        case 1:
                            System.out.println("Ce marca este?");
                            String marca = scan.next();
                            System.out.println("Ce model este?");
                            String model = scan.next();
                            Masina newMasina = new Masina(pret, combustibil, an_fabricatie, tip, marca, model,nrUnic);
                            sediu.addVehicle(newMasina);
                            masinaService.saveMasina(newMasina);
                            break;
                        case 2:
                            System.out.println("Ce capacitate are?(tone)");
                            int capacitate = scan.nextInt();
                            Tir newTir = new Tir(pret, combustibil, an_fabricatie, tip,capacitate,nrUnic);
                            sediu.addVehicle(newTir);
                            tirService.saveTir(newTir);
                            break;
                        case 3:
                            System.out.println("Ce tip este?(Elicoper,PrivateJet...)");
                            String tipul = scan.next();
                            Aeronava newAeronava = new Aeronava(pret, combustibil, an_fabricatie, tip,tipul,nrUnic);
                            sediu.addVehicle(newAeronava);
                            aeronavaService.saveAeronava(newAeronava);
                            break;
                        case 4:
                            System.out.println("Ce lungime are?(metri)");
                            int lungime = scan.nextInt();
                            Barca newBarca = new Barca(pret, combustibil, an_fabricatie, tip,lungime,nrUnic);
                            sediu.addVehicle(newBarca);
                            break;
                        case 5:
                            System.out.println("Ce putere are?(cc)");
                            int putere = scan.nextInt();
                            Motocicleta newMotocicleta = new Motocicleta(pret, combustibil, an_fabricatie, tip,putere,nrUnic);
                            sediu.addVehicle(newMotocicleta);
                            break;
                        case 6:
                            System.out.println("Pentru cine este?(Copil sau Adult)");
                            String persoana = scan.next();
                            SnowMobile newSnow = new SnowMobile(pret, combustibil, an_fabricatie, tip,persoana,nrUnic);
                            sediu.addVehicle(newSnow);
                            break;
                    }
                    break;
                case 2:
                    audit.writePersonsToFile("Am afisat vehiculele");
                    sediu.displayVehicles();
                    break;
                case 3:
                    audit.writePersonsToFile("Am afisat vehiculele ce trebuie realimentate");
                    sediu.displayEmptyVehicles();
                    break;
                case 4:
                    audit.writePersonsToFile("Am alimentat vehiculele");
                    System.out.println("Cu cati km alimentam? ");
                    int km = scan.nextInt();
                    sediu.IncarcaVehicles(km);
                    break;
                case 5:
                    audit.writePersonsToFile("Am avut un client");
                    System.out.println("Numele clientului: ");
                    String nume=scan.next();
                    System.out.println("Cati km doreste sa mearga: ");
                    int kilo=scan.nextInt();

                    System.out.println("Ce vehicul vrea?\n" +
                            "1) Masina\n" +
                            "2) Tir\n" +
                            "3) Aeronava\n" +
                            "4) Barca\n" +
                            "5) Motocicleta\n" +
                            "6) Snowmobil\n"
                    );
                    int t3=scan.nextInt();
                    sediu.Inchiriaza(t3,kilo,nume);
                    break;
                case 6:
                    audit.writePersonsToFile("Am vizualizat clientii");
                    sediu.displayCustomers();
                    break;
                case 7:
                    audit.writePersonsToFile("Am cautat clientul cel mai loial");
                    sediu.displayBestCustomers();
                    break;
                case 8:
                    audit.writePersonsToFile("Am afisat cel mai scump vehicul");
                    sediu.displayBilzerianVehicles();
                    break;
                case 9:
                    audit.writePersonsToFile("Am afisat valoarea flotei");
                    sediu.displayGatesVehicles();
                    break;
                case 10:
                    audit.writePersonsToFile("Am afisat cea m ai ieftina barca");
                    sediu.displayPretBarcaSaracie();
                    break;
                case 11:sediu.deleteCustomer();
                case 12:
                    System.out.println("Ce vehicul trebuie sters din sistem?\n" +
                            "1) Masina\n" +
                            "2) Tir\n" +
                            "3) Aeronava\n" +
                            "4) Barca\n" +
                            "5) Motocicleta\n" +
                            "6) Snowmobil\n"
                    );
                    t2 = scan.nextInt();
                    switch (t2) {
                        case 1:sediu.deleteMasina();
                        case 2:sediu.deleteTir();
                        case 3:sediu.deleteAeronava();

                    }

                case 13:
                    System.out.println("Ce doriti sa faceti?\n" +
                            "1) Adauga vehicul\n" +
                            "2) Arata toate vehiculele in ordine crescatoare a preturilor\n" +
                            "3) Afla ce vehicule trebuie realimentate\n" +
                            "4) Incarca vehiculele si alege de cat sa bagi benzina\n" +
                            "5) Inchiriaza vehicul unui client\n" +
                            "6) Arata clientii\n" +
                            "7) Arata cel mai fidel client pentru a-l recompensa \n" +
                            "8) A venit Dan Bilzerian,doreste cel mai scump vehicul,care este?\n" +
                            "9) A venit Bill Porti si vrea sa inchirieze totul,cat il costa?(Nu il adauga la clienti,nu are nevoie sa fie recompensat) \n" +
                            "10) Cineva vrea sa inchireze o barca,dar bugetul nu-l ajuta,care este cea mai iefina?\n" +
                            "11)Meniu\n"+
                            "0) Quit the application\n");
                    break;


            }

            System.out.println("Finished\n");


        }while (t!=0) ;
        sediu.displayVehicles();
        readnWrite.writeVehiclesToFile(sediu.colectie());
    }
}
