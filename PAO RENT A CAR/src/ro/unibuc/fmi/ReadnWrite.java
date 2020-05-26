package ro.unibuc.fmi;

import java.io.*;


public class ReadnWrite {
    private static ReadnWrite single_instance = null;

    // private constructor restricted to this class itself
    private ReadnWrite() {
        System.out.println("Reading database...");
    }

    public static ReadnWrite getInstance() {
        if (single_instance == null)
            single_instance = new ReadnWrite();
        return single_instance;
    }

    public void readVehiclesFromFile(Sediu sediu) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("persistence.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                int t2;
                t2 = Integer.parseInt(dataFields[0]);
                int pret = Integer.parseInt(dataFields[1]);
                int combustibil = Integer.parseInt(dataFields[2]);
                int an_fabricatie = Integer.parseInt(dataFields[3]);
                int nrUnic = Integer.parseInt(dataFields[4]);
                switch (t2) {
                    case 1:
                        String marca = dataFields[5];
                        String model = dataFields[6];
                        Masina newMasina = new Masina(pret, combustibil, an_fabricatie, t2, marca, model,nrUnic);
                        sediu.addVehicle(newMasina);
                        break;
                    case 2:
                        int capacitate = Integer.parseInt(dataFields[5]);
                        Tir newTir = new Tir(pret, combustibil, an_fabricatie, t2, capacitate,nrUnic);
                        sediu.addVehicle(newTir);
                        break;
                    case 3:
                        String tipul = dataFields[5];
                        Aeronava newAeronava = new Aeronava(pret, combustibil, an_fabricatie, t2, tipul,nrUnic);
                        sediu.addVehicle(newAeronava);
                        break;
                    case 4:
                        int lungime = Integer.parseInt(dataFields[5]);
                        Barca newBarca = new Barca(pret, combustibil, an_fabricatie, t2, lungime,nrUnic);
                        sediu.addVehicle(newBarca);
                        break;
                    case 5:
                        int putere = Integer.parseInt(dataFields[5]);
                        Motocicleta newMotocicleta = new Motocicleta(pret, combustibil, an_fabricatie, t2, putere,nrUnic);
                        sediu.addVehicle(newMotocicleta);
                        break;
                    case 6:
                        String persoana = dataFields[5];
                        SnowMobile newSnow = new SnowMobile(pret, combustibil, an_fabricatie, t2, persoana,nrUnic);
                        sediu.addVehicle(newSnow);
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println("Could not read data from file: ");
            return;
        }
        System.out.println("Successfully read ");
    }

    public void writeVehiclesToFile(VehicleService coletie) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("persistence.csv"))) {
            for (Vehicle vehicle : coletie.getVehicles()) {
                bufferedWriter.write(vehicle.getTiuprile() + "," + vehicle.getPret() + "," + vehicle.getCombustibil() + "," + vehicle.getAnFabricatie()+"," + vehicle.getNrUnic());
                switch (vehicle.getTiuprile()) {
                    case 1:
                        Masina masina = (Masina) vehicle;
                        bufferedWriter.write("," + masina.getMarca() + "," + masina.getModel());
                        break;
                    case 2:
                        Tir tir = (Tir) vehicle;
                        bufferedWriter.write("," + tir.getCapacitate());
                        break;
                    case 3:
                        Aeronava aeronava = (Aeronava) vehicle;
                        bufferedWriter.write("," + aeronava.getType());
                        break;
                    case 4:
                        Barca barca = (Barca) vehicle;
                        bufferedWriter.write("," + barca.getLungime());
                        break;
                    case 5:
                        Motocicleta motocicleta = (Motocicleta) vehicle;
                        bufferedWriter.write("," + motocicleta.getPutere());
                        break;
                    case 6:
                        SnowMobile snowMobile = (SnowMobile) vehicle;
                        bufferedWriter.write("," + snowMobile.getVarsta());
                        break;
                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file");
            return;
        }
        System.out.println("Successfully wrote ");
    }


}