package service;

import exception.EntityNotFoundException;
import entity.Vacina;
import repository.VacinaRepository;

import java.util.List;

public class VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaService(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina cadastrar(Vacina vacina) {
        return vacinaRepository.salvar(vacina);
    }

    public List<Vacina> listar() {
        return vacinaRepository.listar();
    }

    public Vacina buscar(Long id) {
        Vacina vacina = vacinaRepository.buscarPorId(id);

        if (vacina == null) {
            throw new EntityNotFoundException("Vacina com ID " + id + " não encontrada.");
        }

        return vacina;
    }

    public void remover(Long id) {
        buscar(id);
        vacinaRepository.remover(id);
    }
}
