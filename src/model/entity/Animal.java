package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Animal {

    private Long id;
    private String nome;
    private String especie;
    private Integer idade;
    private String saude;
    private boolean adotado;
    private LocalDate dataCadastro;

    private List<Vacina> vacinas = new ArrayList<>();

    // GETTERS e SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSaude() {
        return saude;
    }

    public void setSaude(String saude) {
        this.saude = saude;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void adicionarVacina(Vacina vacina) {
        this.vacinas.add(vacina);
    }

    @Override
    public String toString() {
        return "Animal{id=" + id + ", nome='" + nome + "'}";
    }
}
