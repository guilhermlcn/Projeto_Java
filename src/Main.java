import entity.Vacina;
import entity.Adotante;
import entity.Visita;
import entity.Animal;

import repository.AnimalRepository;
import repository.VacinaRepository;
import repository.AdotanteRepository;
import repository.VisitaRepository;

import service.AnimalService;
import service.VacinaService;
import service.AdotanteService;
import service.VisitaService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        AnimalRepository animalRepo = new AnimalRepository();
        VacinaRepository vacinaRepo = new VacinaRepository();
        AdotanteRepository adotanteRepo = new AdotanteRepository();
        VisitaRepository visitaRepo = new VisitaRepository();

        AnimalService animalService = new AnimalService(animalRepo);
        VacinaService vacinaService = new VacinaService(vacinaRepo);
        AdotanteService adotanteService = new AdotanteService(adotanteRepo);
        VisitaService visitaService = new VisitaService(visitaRepo);

        int opcao = 0;


        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarAnimal(animalService);
                    break;
                case 2:
                    listarAnimais(animalService);
                    break;
                case 3:
                    cadastrarAdotante(adotanteService);
                    break;
                case 4:
                    listarAdotantes(adotanteService);
                    break;
                case 5:
                    cadastrarVacina(vacinaService);
                    break;
                case 6:
                    listarVacinas(vacinaService);
                    break;
                case 7:
                    agendarVisita(visitaService, animalService);
                    break;
                case 8:
                    adotarAnimal(animalService);
                    break;
                case 9:
                    aplicarVacinaAnimal(animalService, vacinaService);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println("----------------------------------------");

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE ADOÇÃO DE PETS ===");
        System.out.println("1. Cadastrar Animal");
        System.out.println("2. Listar Animais");
        System.out.println("3. Cadastrar Adotante");
        System.out.println("4. Listar Adotantes");
        System.out.println("5. Cadastrar Vacina (Genérica)");
        System.out.println("6. Listar Vacinas");
        System.out.println("7. Agendar Visita");
        System.out.println("8. Adotar Animal");
        System.out.println("9. Aplicar Vacina ao Animal");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }


    private static void cadastrarAnimal(AnimalService service) {
        System.out.println("\n--- Novo Animal ---");
        Animal a = new Animal();

        System.out.print("Nome: ");
        a.setNome(scanner.nextLine());

        System.out.print("Espécie (Cachorro/Gato): ");
        a.setEspecie(scanner.nextLine());

        System.out.print("Idade: ");

        try {
            a.setIdade(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            a.setIdade(0);
        }

        a.setSaude("Boa");
        a.setAdotado(false);
        a.setDataCadastro(LocalDate.now());

        service.cadastrar(a);
        System.out.println("Animal cadastrado com sucesso!");
    }

    private static void listarAnimais(AnimalService service) {
        System.out.println("\n--- Lista de Animais ---");
        service.listar().forEach(System.out::println);
    }

    private static void cadastrarAdotante(AdotanteService service) {
        System.out.println("\n--- Novo Adotante ---");
        Adotante ad = new Adotante();

        System.out.print("Nome: ");
        ad.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        ad.setTelefone(scanner.nextLine());

        service.cadastrar(ad);
        System.out.println("Adotante cadastrado com sucesso!");
    }

    private static void listarAdotantes(AdotanteService service) {
        System.out.println("\n--- Lista de Adotantes ---");
        service.listar().forEach(System.out::println);

    }

    private static void cadastrarVacina(VacinaService service) {
        System.out.println("\n--- Nova Vacina ---");
        Vacina v = new Vacina();

        System.out.print("Nome da Vacina: ");
        v.setNome(scanner.nextLine());
        v.setData(LocalDate.now());

        service.cadastrar(v);
        System.out.println("Vacina registrada no sistema!");
    }

    private static void listarVacinas(VacinaService service) {
        System.out.println("\n--- Lista de Vacinas ---");
        service.listar().forEach(System.out::println);
    }

    private static void agendarVisita(VisitaService visitaService, AnimalService animalService) {
        System.out.println("\n--- Agendar Visita ---");

        System.out.print("Digite o ID do Animal para visita: ");
        Long idAnimal = Long.parseLong(scanner.nextLine());

        Animal animalEncontrado = animalService.buscarPorId(idAnimal);

        if (animalEncontrado != null) {
            Visita visita = new Visita();
            visita.setAnimal(animalEncontrado);
            visita.setData(LocalDate.now());

            System.out.print("Descrição da visita: ");
            visita.setDescricao(scanner.nextLine());

            System.out.print("Dia da visita(ex: 30/01: ");
            visita.setDia(scanner.nextLine());

            visitaService.cadastrar(visita);
            System.out.println("Visita agendada para o animal: " + animalEncontrado.getNome());
            System.out.println("Para o dia : " + visita.getDia());
        } else {
            System.out.println("Animal não encontrado com o ID: " + idAnimal);
        }

    }

    private static void adotarAnimal(AnimalService animalService) {
        System.out.println("\n--- Adotar Animal ---");


        listarAnimais(animalService);

        System.out.print("Digite o ID do Animal que será adotado: ");

        try {
            Long idAnimal = Long.parseLong(scanner.nextLine());

            Animal animalAdotado = animalService.adotar(idAnimal);

            System.out.println("\n✅ SUCESSO! O animal '" + animalAdotado.getNome() + "' foi adotado!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Erro: O ID deve ser um número válido.");

        } catch (RuntimeException e) {
            System.out.println("❌ Erro ao adotar: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("❌ Erro desconhecido: " + e.getMessage());
        }
    }


    private static void aplicarVacinaAnimal(AnimalService animalService, VacinaService vacinaService) {
        System.out.println("\n--- Aplicar Vacina ---");

        listarAnimais(animalService);
        listarVacinas(vacinaService);

        try {
            System.out.print("Digite o ID do Animal: ");
            Long idAnimal = Long.parseLong(scanner.nextLine());

            System.out.print("Digite o ID da Vacina para aplicar: ");
            Long idVacina = Long.parseLong(scanner.nextLine());

            Vacina vacinaEncontrada = vacinaService.buscar(idVacina);

            if (vacinaEncontrada == null) {
                System.out.println("❌ Erro: Vacina com ID " + idVacina + " não encontrada.");
                return;
            }

            animalService.adicionarVacina(idAnimal, vacinaEncontrada);

            System.out.println("✅ Vacina '" + vacinaEncontrada.getNome() +
                    "' adicionada ao Animal de ID " + idAnimal + " com sucesso!");

        } catch (NumberFormatException e) {
            System.out.println("❌ Erro: O ID deve ser um número válido.");
        } catch (Exception e) {
            System.out.println("❌ Erro ao aplicar vacina: " + e.getMessage());
        }
    }
}