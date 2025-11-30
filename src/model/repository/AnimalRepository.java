package repository;

import entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    private List<Animal> animais = new ArrayList<>();
    private Long contadorId = 1L;


    public Animal salvar(Animal animal) {
        if (animal.getId() == null) {
            animal.setId(contadorId++);
        }
        animais.add(animal);
        return animal;
    }


    public Animal buscarPorId(Long id) {
        return animais.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public List<Animal> listar() {
        return animais;
    }


    public boolean deletar(Long id) {
        return animais.removeIf(a -> a.getId().equals(id));
    }
}
