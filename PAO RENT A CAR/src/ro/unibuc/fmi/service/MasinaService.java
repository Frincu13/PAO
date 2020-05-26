package ro.unibuc.fmi.service;

import ro.unibuc.fmi.Masina;
import ro.unibuc.fmi.repository.MasinaRepository;

public class MasinaService {

    private static MasinaService instance;

    private final MasinaRepository masinaRepository = MasinaRepository.getInstance();

    private MasinaService() {
    }

    public static MasinaService getInstance() {
        if (instance == null) {
            instance = new MasinaService();
        }

        return instance;
    }

    public Masina saveMasina(Masina masina) {


        return masinaRepository.saveMasina(masina);
    }

    public Masina findMasina(int nrUnic) {
        return masinaRepository.findMasina(nrUnic);
    }

    public Masina updateMasina(Masina masina) {
        return masinaRepository.updateMasina(masina);
    }

    public boolean deleteMasina(int nrUnic) {
        return masinaRepository.deleteMasina(nrUnic);
    }

}