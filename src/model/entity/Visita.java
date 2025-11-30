package entity;

import java.time.LocalDate;

public class Visita {

    private Long id;
    private Long adotanteId;
    private Long animalId;
    private LocalDate data;
    private String dia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdotanteId() {
        return adotanteId;
    }

    public void setAdotanteId(Long adotanteId) {
        this.adotanteId = adotanteId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public LocalDate getDataVisita() {
        return data;
    }

    public void setDataVisita(LocalDate dataVisita) {
        this.data = dataVisita;
    }

    public void setData(LocalDate now) {
    }

    public void setDescricao(String s) {
    }

    public void setAnimal(Animal a1) {
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}