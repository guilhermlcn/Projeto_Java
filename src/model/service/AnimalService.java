package service;

import exception.BusinessException;
import exception.EntityNotFoundException;
import entity.Vacina;
import repository.AnimalRepository;
import entity.Animal;

import java.time.LocalDate;
import java.util.List;

public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public Animal cadastrar(Animal animal) {
        animal.setDataCadastro(LocalDate.now());
        animal.setAdotado(false);

        return animalRepository.salvar(animal);
    }


    public List<Animal> listar() {
        return animalRepository.listar();
    }


    public Animal buscarPorId(Long id) {
        Animal animal = animalRepository.buscarPorId(id);

        if (animal == null) {
            throw new EntityNotFoundException("Animal com ID " + id + " não encontrado.");
        }

        return animal;
    }


    public Animal adotar(Long id) {
        Animal animal = buscarPorId(id);

        if (animal.isAdotado()) {
            throw new BusinessException("O animal já está adotado.");
        }

        animal.setAdotado(true);
        return animal;
    }


    public Animal adicionarVacina(Long idAnimal, Vacina vacina) {
        Animal animal = buscarPorId(idAnimal);

        animal.getVacinas().add(vacina);
        return animal;
    }


    public void remover(Long id) {
        buscarPorId(id); // garante que existe
        animalRepository.deletar(id);
    }

}
