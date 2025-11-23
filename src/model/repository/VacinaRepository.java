package repository;

import entity.Vacina;
import java.util.ArrayList;
import java.util.List;


public class VacinaRepository {

    private List<Vacina> vacinas = new ArrayList<>();
    private Long id = 1L;


    public Vacina salvar (Vacina vacina){
        vacina.setId(id++);
        vacinas.add(vacina);
        return vacina;
    }

    public List<Vacina> listar() {
        return vacinas;
    }

    public Vacina buscarporId(Long id){
        for (Vacina vacina : vacinas){
            if (vacina.getId().equals(id)){
                return vacina;
            }
        }
        return null;
    }
    public void remover(Long id) {
        vacinas.removeIf(v -> v.getId().equals(id));
    }
}


