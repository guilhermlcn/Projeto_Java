package repository;

import entity.Visita;
import java.util.ArrayList;
import java.util.List;

public class VisitaRepository {

    private List<Visita> visitas = new ArrayList<>();
    private Long id = 1L;

    public Visita salvar(Visita visita) {
        visita.setId(id++);
        visitas.add(visita);
        return visita;
    }

    public List<Visita> listar() {
        return visitas;
    }

    public Visita buscarPorId(Long id) {
        for (Visita v : visitas) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public void remover(Long id) {
        visitas.removeIf(v -> v.getId().equals(id));
    }


}
