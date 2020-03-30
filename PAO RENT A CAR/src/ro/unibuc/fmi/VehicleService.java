package ro.unibuc.fmi;

import java.util.*;

public class VehicleService {//service prelucarea masini

    private LinkedList<Vehicle> vehicles;
    private int size;

    public VehicleService() {
        this.size = 0;
        this.vehicles = new LinkedList<>();
    }


    public VehicleService(LinkedList<Vehicle> vehicles,int size) {
        this.vehicles = vehicles;
        this.size=size;
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }

    /*public List<Vehicle> sortVehicles() {
        return Collections.sort(vehicles);
    }*/
    public int getSize() {
        return size;
    }
    public void increaseSize() {
        this.size++;
    }

    public void decreaseSize() {
        this.size--;
    }
}