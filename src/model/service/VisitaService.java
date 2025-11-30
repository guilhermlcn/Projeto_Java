package service;

import exception.EntityNotFoundException;
import entity.Visita;
import repository.VisitaRepository;

import java.util.List;

public class VisitaService {

    private final VisitaRepository visitaRepository;

    public VisitaService(VisitaRepository visitaRepository) {
        this.visitaRepository = visitaRepository;
    }

    public Visita cadastrar(Visita visita) {
        return visitaRepository.salvar(visita);
    }

    public List<Visita> listar() {
        return visitaRepository.listar();
    }

    public Visita buscar(Long id) {
        Visita visita = visitaRepository.buscarPorId(id);

        if (visita == null) {
            throw new EntityNotFoundException("Visita com ID " + id + " não encontrada.");
        }

        return visita;
    }

    public void remover(Long id) {
        buscar(id);
        visitaRepository.remover(id);
    }
}
