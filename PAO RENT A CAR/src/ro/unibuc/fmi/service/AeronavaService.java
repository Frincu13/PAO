package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Aeronava;
import ro.unibuc.fmi.repository.AeronavaRepository;

public class AeronavaService {

    private static AeronavaService instance;

    private final AeronavaRepository aeronavaRepository = AeronavaRepository.getInstance();

    private AeronavaService() {
    }

    public static AeronavaService getInstance() {
        if (instance == null) {
            instance = new AeronavaService();
        }

        return instance;
    }

    public Aeronava saveAeronava(Aeronava aeronava) {


        return aeronavaRepository.saveAeronava(aeronava);
    }

    public Aeronava findAeronava(int nrUnic) {
        return aeronavaRepository.findAeronava(nrUnic);
    }

    public Aeronava updateAeronava(Aeronava aeronava) {
        return aeronavaRepository.updateAeronava(aeronava);
    }

    public boolean deleteAeronava(int nrUnic) {
        return aeronavaRepository.deleteAeronava(nrUnic);
    }

}