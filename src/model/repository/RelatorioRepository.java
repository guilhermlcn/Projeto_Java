package repository;

import entity.Relatorio;
import java.util.ArrayList;
import java.util.List;

public class RelatorioRepository {

    private final List<Relatorio> relatorios = new ArrayList<>();
    private Long proximoId = 1L;

    public Relatorio salvar(Relatorio relatorio) {
        relatorio.setId(proximoId++);
        relatorios.add(relatorio);
        return relatorio;
    }

    public Relatorio buscarPorId(Long id) {
        return relatorios.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean remover(Long id) {
        return relatorios.removeIf(r -> r.getId().equals(id));
    }

    public List<Relatorio> listar() {
        return relatorios;
    }
}
