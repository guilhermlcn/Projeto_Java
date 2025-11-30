package service;

import exception.EntityNotFoundException;
import entity.Relatorio;
import repository.RelatorioRepository;

import java.util.List;

public class RelatorioService {

    private final RelatorioRepository relatorioRepository;

    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Relatorio cadastrar(Relatorio relatorio) {
        return relatorioRepository.salvar(relatorio);
    }

    public List<Relatorio> listar() {
        return relatorioRepository.listar();
    }

    public Relatorio buscar(Long id) {
        Relatorio relatorio = relatorioRepository.buscarPorId(id);

        if (relatorio == null) {
            throw new EntityNotFoundException("Relatório com ID " + id + " não encontrado.");
        }

        return relatorio;
    }

    public void remover(Long id) {
        buscar(id);
        relatorioRepository.remover(id);
    }
}
