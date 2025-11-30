package repository;

import entity.Vacina;
import java.util.ArrayList;
import java.util.List;

public class VacinaRepository {

    private final List<Vacina> vacinas = new ArrayList<>();
    private Long proximoId = 1L;

    public Vacina salvar(Vacina vacina) {
        vacina.setId(proximoId++);
        vacinas.add(vacina);
        return vacina;
    }

    public Vacina buscarPorId(Long id) {
        return vacinas.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean remover(Long id) {
        return vacinas.removeIf(v -> v.getId().equals(id));
    }

    public List<Vacina> listar() {
        return vacinas;
    }
}
