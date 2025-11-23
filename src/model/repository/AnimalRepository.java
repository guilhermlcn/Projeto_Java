package repository;

import entity.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {

    private List<Animal> animais = new ArrayList<>();
    private Long id = 1L;

    public Animal salvar(Animal animal) {
        animal.setId(id++);
        animais.add(animal);
        return animal;
    }

    public List<Animal> listar() {
        return animais;
    }

    public Animal buscarPorId(Long id) {
        for (Animal animal : animais) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    public void remover(Long id) {
        animais.removeIf(a -> a.getId().equals(id));
    }
}
