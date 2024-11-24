import utils.Teclado;
import animais.animais.*;
import Lote.*;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Principal {
    private static List<Lote<Animal>> listaLotes = new ArrayList<>();
    private static final String LOTES_FILE = "lotes.ser";

    public static void main(String[] args) {
        carregarLotes(); // Carregar os lotes salvos no início
        boolean continuar = true;

        while (continuar) {
            menuGeral();
            int opcao = Teclado.readInt("Qual sua opção?");
            switch (opcao) {
                case 1:
                    gerenciarLote();
                    break;

                case 2:
                    gerenciarAnimal();
                    break;

                case 3:
                    salvarLotes();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        }
    }

    public static void menuGeral() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Gerenciar Lotes.");
        System.out.println("2 - Gerenciar Animais.");
        System.out.println("3 - Sair e Salvar.");
    }

    public static void gerenciarLote() {
        menuLote();
        int opcao = Teclado.readInt("Escolha uma opção:");
        switch (opcao) {
            case 1:
                cadastrarLote();
                break;
            case 2:
                excluirLote();
                break;
            case 3:
                listarLotes();
                break;
            case 4:
                listarLote();
                break;
            case 5:
                removerAnimalDeLote();
                break;
            case 6:
                System.out.println("Saindo do gerenciamento de lotes.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

        public static void gerenciarAnimal() {
        menuAnimal();
        int opcao = Teclado.readInt("Escolha uma opção:");
        switch (opcao) {
            case 1:
                System.out.println("Escolha o tipo de animal que deseja cadastrar:");
                System.out.println("1 - Bovino");
                System.out.println("2 - Ave");
                System.out.println("3 - Suíno");
                int opcaoAnimal = Teclado.readInt("Escolha uma opção:");

                if (opcaoAnimal == 1) {
                    cadastrarAnimal(new Bovino(0, 0, 0, LocalDate.now(), "", 0, 0));
                }
                else if (opcaoAnimal == 2) {
                    cadastrarAnimal(new Ave(0, 0, 0, LocalDate.now(), ""));
                }
                else if (opcaoAnimal == 3) {
                    cadastrarAnimal(new Suino(0, 0, 0, LocalDate.now(), 0));
                }  
                else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 2:
                visualizarAnimal();
                break;
            case 3:
                editarAnimal();
                break;
            case 4:
                System.out.println("Saindo do gerenciamento de animais.");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuLote() {
        System.out.println("\n===== GERENCIAR LOTE =====");
        System.out.println("1 - Cadastrar Lote");
        System.out.println("2 - Excluir Lote");
        System.out.println("3 - Listar Lotes");
        System.out.println("4 - Listar Lote");
        System.out.println("5 - Remover Animal de Lote");
        System.out.println("6 - Sair");
    }

    public static void menuAnimal() {
        System.out.println("\n===== GERENCIAR ANIMAL =====");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Visualizar Animal");
        System.out.println("3 - Editar Animal");
        System.out.println("4 - Sair");
    }

    public static void excluirLote() {
        int idLote = Teclado.readInt("Digite o ID do lote a excluir:");
        listaLotes.removeIf(lote -> lote.getIdLote() == idLote);
        System.out.println("Lote excluído com sucesso!");
    }

    public static void listarLotes() {
        for (Lote<Animal> lote : listaLotes) {
            lote.imprimirLotes();
        }
    }

    public static void listarLote() {
        int idLote = Teclado.readInt("Digite o ID do lote a listar:");
        for (Lote<Animal> lote : listaLotes) {
            if (lote.getIdLote() == idLote) {
                lote.imprimirLotes();
                return;
            }
        }
        System.out.println("Lote não encontrado.");
    }

    public static void removerAnimalDeLote() {
        int idAnimal = Teclado.readInt("Digite o ID do animal a remover:");
        for (Lote<Animal> lote : listaLotes) {
            lote.removerAnimalote(idAnimal);
        }
    }

public static void cadastrarAnimal(Animal tipoAnimal) {
        int id = Teclado.readInt("Digite o ID do animal:");

        Animal animal = buscarAnimalPorID(id);

        if (animal != null) {
            System.out.println("ID já cadastrado. Tente novamente.");
            return;
        }

        double peso = Teclado.readDouble("Digite o peso do animal:");
        int idade = Teclado.readInt("Digite a idade do animal:");
        LocalDate data = Teclado.readDate("Digite a data de chegada (AAAA-MM-DD):");
        int idLote = Teclado.readInt("Digite o ID do lote para associar:");

        int tipoAnimalInt = 0; // Determinar o tipo de animal
        if (tipoAnimal instanceof Bovino) {
            String raca = Teclado.readString("Digite a raça do bovino:");
            double percentualMusculo = Teclado.readDouble("Digite o percentual de músculo:");
            double percentualGordura = Teclado.readDouble("Digite o percentual de gordura:");
            tipoAnimal = new Bovino(id, peso, idade, data, raca, percentualMusculo, percentualGordura);
            tipoAnimalInt = 1; // Bovino
        } else if (tipoAnimal instanceof Suino) {
            double percentualCarneMagra = Teclado.readDouble("Digite o percentual de carne magra:");
            tipoAnimal = new Suino(id, peso, idade, data, percentualCarneMagra);
            tipoAnimalInt = 3; // Suino
        } else if (tipoAnimal instanceof Ave) {
            String tipoFrango = Teclado.readString("Digite o tipo de frango:");
            tipoAnimal = new Ave(id, peso, idade, data, tipoFrango);
            tipoAnimalInt = 2; // Ave
        }

        tipoAnimal.setIDlote(idLote);

        for (Lote<Animal> lote : listaLotes) {
            if (lote.getIdLote() == idLote) {
                lote.adicionarLote(tipoAnimal, tipoAnimalInt, idLote);
                System.out.println("Animal cadastrado com sucesso!");
                return;
            }
        }
        System.out.println("Lote não encontrado. Animal não cadastrado.");
    }


    public static void cadastrarLote() {
        int idLote = Teclado.readInt("Digite o ID do lote:");

        // Verifica se já existe um lote com o ID informado
        for (Lote<Animal> lote : listaLotes) {
            if (lote.getIdLote() == idLote) {
                System.out.println("Erro: Já existe um lote com o ID " + idLote + ". Cadastro cancelado.");
                return;
            }
        }

        // Solicita o tipo de animal com validação
        int tipoAnimal = 0;
        while (tipoAnimal < 1 || tipoAnimal > 3) {
            System.out.println("Escolha o tipo de animal para este lote:");
            System.out.println("1 - Bovino");
            System.out.println("2 - Ave");
            System.out.println("3 - Suíno");
            tipoAnimal = Teclado.readInt("Digite o número correspondente ao tipo:");

            if (tipoAnimal < 1 || tipoAnimal > 3) {
                System.out.println("\nErro: Tipo de animal inválido. Tente novamente.\n");
            }
        }

        // Cria o lote e adiciona à lista
        Lote<Animal> novoLote = new Lote<>();
        novoLote.setIdLote(idLote);
        novoLote.setTipoAnimal(tipoAnimal);
        listaLotes.add(novoLote);

        System.out.println("Lote cadastrado com sucesso!");
    }


    public static void salvarLotes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LOTES_FILE))) {
            oos.writeObject(listaLotes);
            System.out.println("Lotes salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os lotes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void carregarLotes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LOTES_FILE))) {
            listaLotes = (List<Lote<Animal>>) ois.readObject();
            System.out.println("Lotes carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum lote encontrado para carregar");
        }
    }

    public static Animal buscarAnimalPorID(int id) {
        for (Lote<Animal> lote : listaLotes) {
            for (Animal animal : lote) {
                if (animal.getID() == id) {
                    return animal;
                }
            }
        }
        return null; // Retorna null se não encontrar o animal
    }

    public static void visualizarAnimal() {
        int id = Teclado.readInt("Digite o ID do animal que deseja visualizar:");
        Animal animal = buscarAnimalPorID(id);

        if (animal != null) {
            System.out.println("Informações do Animal:");
            System.out.println("ID: " + animal.getID());
            System.out.println("Peso: " + animal.getPeso());
            System.out.println("Idade: " + animal.getIdade());
            System.out.println("Data de Chegada: " + animal.getDataChegada());
            System.out.println("Lote ID: " + animal.getIDlote());

            if (animal instanceof Bovino) {
                Bovino bovino = (Bovino) animal;
                System.out.println("Raça: " + bovino.getRacaBoi());
                System.out.println("Percentual de Músculo: " + bovino.getPercentualMusculo());
                System.out.println("Percentual de Gordura: " + bovino.getPercentualGordura());
            } else if (animal instanceof Suino) {
                Suino suino = (Suino) animal;
                System.out.println("Percentual de Carne Magra: " + suino.getPercentualCarneMagra());
            } else if (animal instanceof Ave) {
                Ave ave = (Ave) animal;
                System.out.println("Tipo de Frango: " + ave.getTipoFrango());
            }
        } else {
            System.out.println("Animal com ID " + id + " não encontrado.");
        }
    }

    public static void editarAnimal() {
        int id = Teclado.readInt("Digite o ID do animal que deseja editar:");
        Animal animal = buscarAnimalPorID(id);

        if (animal != null) {
            System.out.println("Editando o animal com ID " + id);

            double novoPeso = Teclado.readDouble("Digite o novo peso do animal:");
            int novaIdade = Teclado.readInt("Digite a nova idade do animal:");
            LocalDate novaData = Teclado.readDate("Digite a nova data de chegada (AAAA-MM-DD):");
            animal.setPeso(novoPeso);
            animal.setIdade(novaIdade);
            animal.setDataChegada(novaData);

            if (animal instanceof Bovino) {
                Bovino bovino = (Bovino) animal;
                String novaRaca = Teclado.readString("Digite a nova raça do bovino:");
                double novoPercentualMusculo = Teclado.readDouble("Digite o novo percentual de músculo:");
                double novoPercentualGordura = Teclado.readDouble("Digite o novo percentual de gordura:");
                bovino.setRacaBoi(novaRaca);
                bovino.setPercentualMusculo(novoPercentualMusculo);
                bovino.setPercentualGordura(novoPercentualGordura);
            } else if (animal instanceof Suino) {
                Suino suino = (Suino) animal;
                double novoPercentualCarneMagra = Teclado.readDouble("Digite o novo percentual de carne magra:");
                suino.setPercentualCarneMagra(novoPercentualCarneMagra);
            } else if (animal instanceof Ave) {
                Ave ave = (Ave) animal;
                String novoTipoFrango = Teclado.readString("Digite o novo tipo de frango:");
                ave.setTipoFrango(novoTipoFrango);
            }

            System.out.println("Animal atualizado com sucesso!");
        } else {
            System.out.println("Animal com ID " + id + " não encontrado");
        }
    }


}
