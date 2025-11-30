package service;

import exception.EntityNotFoundException;
import entity.Adotante;
import repository.AdotanteRepository;

import java.util.List;

public class AdotanteService {

    private final AdotanteRepository adotanteRepository;

    public AdotanteService(AdotanteRepository adotanteRepository) {
        this.adotanteRepository = adotanteRepository;
    }

    public Adotante cadastrar(Adotante adotante) {
        return adotanteRepository.salvar(adotante);
    }

    public List<Adotante> listar() {
        return adotanteRepository.listar();
    }

    public Adotante buscar(Long id) {
        Adotante adotante = adotanteRepository.buscarPorId(id);

        if (adotante == null) {
            throw new EntityNotFoundException("Adotante com ID " + id + " não encontrado.");
        }

        return adotante;
    }

    public void remover(Long id) {
        buscar(id);
        adotanteRepository.remover(id);
    }
}
