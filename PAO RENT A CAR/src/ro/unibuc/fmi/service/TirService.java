package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Tir;
import ro.unibuc.fmi.repository.TirRepository;

public class TirService {

    private static TirService instance;

    private final TirRepository tirRepository = TirRepository.getInstance();

    private TirService() {
    }

    public static TirService getInstance() {
        if (instance == null) {
            instance = new TirService();
        }

        return instance;
    }

    public Tir saveTir(Tir tir) {


        return tirRepository.saveTir(tir);
    }

    public Tir findTir(int nrUnic) {
        return tirRepository.findTir(nrUnic);
    }

    public Tir updateTir(Tir tir) {
        return tirRepository.updateTir(tir);
    }

    public boolean deleteTir(int nrUnic) {
        return tirRepository.deleteTir(nrUnic);
    }

}