package repository;

import entity.Adotante;
import java.util.ArrayList;
import java.util.List;

public class AdotanteRepository {


        private List<Adotante> adotantes = new ArrayList<>();
        private Long id = 1L;

        public Adotante salvar(Adotante adotante) {
            adotante.setId(id++);
            adotantes.add(adotante);
            return adotante;
        }

        public List<Adotante> listar() {
            return adotantes;
        }

        public Adotante buscarPorId(Long id) {
            for (Adotante a : adotantes) {
                if (a.getId().equals(id)) {
                    return a;
                }
            }
            return null;
        }

        public void remover(Long id) {
            adotantes.removeIf(a -> a.getId().equals(id));
        }

}
