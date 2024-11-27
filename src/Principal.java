import utils.Teclado;
import animais.animais.*;
import Lote.*;
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class Principal {
    private static List<Lote<Animal>> listaLotes = new ArrayList<>();
    private static final String LOTES_FILE = "lotes.ser";


    /**
     * Metodo principal da aplicação. 
     * Carrega os dados iniciais, apresenta o menu principal e controla o fluxo do programa.
     */
    public static void main(String[] args) {
        carregarDados();
        boolean continuar = true;

        while (continuar) {
            menuGeral();
            int opcao = Teclado.readInt("Qual sua opcao?");
            switch (opcao) {
                case 1:
                    gerenciarLote();
                    break;

                case 2:
                    gerenciarAnimal();
                    break;

                case 3:
                    salvarDados();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente!");
            }
        }
    }

    /**
     * Exibe o menu principal com as opções disponiveis para o usuario.
     */
    public static void menuGeral() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Gerenciar Lotes.");
        System.out.println("2 - Gerenciar Animais.");
        System.out.println("3 - Sair e Salvar.");
    }

    /**
     * Gerencia as operacoes relacionadas a lotes, apresentando um menu especifico.
     */
    public static void gerenciarLote() {
        menuLote();
        int opcao = Teclado.readInt("Escolha uma opcao:");
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
                System.out.println("Opcao invalida.");
        }
    }

    /**
     * Gerencia as operacoes relacionadas a animais, apresentando um menu especifico.
     */
    public static void gerenciarAnimal() {
        menuAnimal();
        int opcao = Teclado.readInt("Escolha uma opcao:");
        switch (opcao) {
            case 1:
                System.out.println("Escolha o tipo de animal que deseja cadastrar:");
                System.out.println("1 - Bovino");
                System.out.println("2 - Ave");
                System.out.println("3 - Suíno");
                int opcaoAnimal = Teclado.readInt("Escolha uma opcao:");

                if (opcaoAnimal == 1) {
                    cadastrarAnimal(new Bovino(0, 0, 0, LocalDate.now(), "", 0, 0));
                } else if (opcaoAnimal == 2) {
                    cadastrarAnimal(new Ave(0, 0, 0, LocalDate.now(), ""));
                } else if (opcaoAnimal == 3) {
                    cadastrarAnimal(new Suino(0, 0, 0, LocalDate.now(), 0));
                } else {
                    System.out.println("Opcao invalida.");
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
                System.out.println("Opcao invalida.");
        }
    }

    /**
     * Exibe o menu especifico para gerenciamento de lotes.
     */
    public static void menuLote() {
        System.out.println("\n===== GERENCIAR LOTE =====");
        System.out.println("1 - Cadastrar Lote");
        System.out.println("2 - Excluir Lote");
        System.out.println("3 - Listar Lotes");
        System.out.println("4 - Listar Lote");
        System.out.println("5 - Remover Animal de Lote");
        System.out.println("6 - Sair");
    }

    /**
     * Exibe o menu especifico para gerenciamento de animais.
     */
    public static void menuAnimal() {
        System.out.println("\n===== GERENCIAR ANIMAL =====");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Visualizar Animal");
        System.out.println("3 - Editar Animal");
        System.out.println("4 - Sair");
    }

    /**
     * Exclui um lote com base no ID informado pelo usuario.
     */
    public static void excluirLote() {
        try {
            int idLote = Teclado.readInt("Digite o ID do lote a excluir:");
            boolean loteRemovido = listaLotes.removeIf(lote -> lote.getIdLote() == idLote);

            if (!loteRemovido) {
                throw new LoteNaoExisteException("Lote nao encontrado.");
            }

            System.out.println("Lote excluido com sucesso!");
        } catch (LoteNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao excluir lote: " + e.getMessage());
        }
    }

    /**
     * Lista todos os lotes cadastrados.
     */
    public static void listarLotes() {
        if (listaLotes.isEmpty()) {
            System.out.println("Nenhum lote cadastrado.");
            return;
        }
        for (Lote<Animal> lote : listaLotes) {
            lote.imprimirLotes();
        }
    }

    /**
     * Lista informacoes de um lote especifico com base no ID informado pelo usuario.
     */
    public static void listarLote() {
        try {
            int idLote = Teclado.readInt("Digite o ID do lote a listar:");
            for (Lote<Animal> lote : listaLotes) {
                if (lote.getIdLote() == idLote) {
                    lote.imprimirLote(idLote);
                    return;
                }
            }
            throw new LoteNaoExisteException("Lote nao encontrado.");
        } catch (LoteNaoExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao listar lote: " + e.getMessage());
        }
    }

    /**
     * Remove um animal de um lote com base no ID informado pelo usuusuarioário.
     */
    public static void removerAnimalDeLote() {
        try {
            int idAnimal = Teclado.readInt("Digite o ID do animal a remover:");
            boolean encontrado = false;

            for (Lote<Animal> lote : listaLotes) {
                if (lote.removerAnimalote(idAnimal)) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                throw new AnimalNaoEncontradoException("Animal nao encontrado.");
            }

            System.out.println("Animal removido com sucesso.");
        } catch (AnimalNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao remover animal: " + e.getMessage());
        }
    }

    /**
     * Cadastra um novo lote com base nos dados fornecidos pelo usuario.
     */
    public static void cadastrarLote() {
        try {
            int idLote = Teclado.readInt("Digite o ID do lote:");

            for (Lote<Animal> lote : listaLotes) {
                if (lote.getIdLote() == idLote) {
                    throw new LoteJaExisteException("Erro: Ja existe um lote com o ID " + idLote);
                }
            }

            int tipoAnimal = 0;
            while (tipoAnimal < 1 || tipoAnimal > 3) {
                System.out.println("Escolha o tipo de animal para este lote:");
                System.out.println("1 - Bovino");
                System.out.println("2 - Ave");
                System.out.println("3 - Suino");
                tipoAnimal = Teclado.readInt("Digite o numero correspondente ao tipo:");

                if (tipoAnimal < 1 || tipoAnimal > 3) {
                    System.out.println("\nErro: Tipo de animal invalido. Tente novamente.\n");
                }
            }

            Lote<Animal> novoLote = new Lote<>();
            novoLote.setIdLote(idLote);
            novoLote.setTipoAnimal(tipoAnimal);
            listaLotes.add(novoLote);

            System.out.println("Lote cadastrado com sucesso!");
        } catch (LoteJaExisteException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar lote: " + e.getMessage());
        }
    }


    /**
     * Salva os dados do programa em um arquivo.
     */
    public static void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LOTES_FILE))) {
            oos.writeObject(listaLotes);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    /**
     * Carrega os dados do programa de um arquivo, se disponivel.
     */
    @SuppressWarnings("unchecked")
    public static void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LOTES_FILE))) {
            listaLotes = (List<Lote<Animal>>) ois.readObject();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado encontrado para carregar");
        }
    }

    /**
     * Busca um animal pelo ID em todos os lotes cadastrados.
     * 
     * @param id O ID do animal a ser buscado.
     * @return O objeto Animal correspondente ao ID fornecido, ou null caso não seja encontrado.
     */
    public static Animal buscarAnimalPorID(int id) {
        for (Lote<Animal> lote : listaLotes) {
            for (Animal animal : lote) {
                if (animal.getID() == id) {
                    return animal;
                }
            }
        }
        return null;
    }

    /**
     * Excecao lancada quando se tenta cadastrar um animal com um ID ja existente.
     */
    public static class AnimalJaExisteException extends Exception {
        public AnimalJaExisteException(String message) {
            super(message);
        }
    }

    /**
     * Excecao lancada quando um lote solicitado nao existe.
     */
    public static class LoteNaoExisteException extends Exception {
        public LoteNaoExisteException(String message) {
            super(message);
        }
    }

    /**
     * Excecao lancada quando se tenta cadastrar um lote com um ID ja existente.
     */
    public static class LoteJaExisteException extends Exception {
        public LoteJaExisteException(String message) {
            super(message);
        }
    }

    /**
     * Cadastra um novo animal em um lote existente.
     * 
     * @param tipoAnimal O objeto Animal que sera cadastrado.
     *                   Deve ser uma instancia de Bovino, Suino ou Ave.
     */
    public static void cadastrarAnimal(Animal tipoAnimal) {
        try {
            int id = Teclado.readInt("Digite o ID do animal:");
            Animal animal = buscarAnimalPorID(id);

            if (animal != null) {
                throw new AnimalJaExisteException("ID ja cadastrado. Tente novamente.");
            }

            double peso = Teclado.readDouble("Digite o peso do animal:");
            int idade = Teclado.readInt("Digite a idade do animal (em dias):");
            LocalDate data = Teclado.readDate("Digite a data de chegada (AAAA-MM-DD):");
            int idLote = Teclado.readInt("Digite o ID do lote para associar:");

            int tipoAnimalInt = 0;
            if (tipoAnimal instanceof Bovino) {
                String raca = Teclado.readString("Digite a raça do bovino:");
                double percentualMusculo = Teclado.readDouble("Digite o percentual de musculo:");
                double percentualGordura = Teclado.readDouble("Digite o percentual de gordura:");
                tipoAnimal = new Bovino(id, peso, idade, data, raca, percentualMusculo, percentualGordura);
                tipoAnimalInt = 1; // Bovino
            } else if (tipoAnimal instanceof Suino) {
                double percentualCarneMagra = Teclado.readDouble("Digite o percentual de carne magra:");
                tipoAnimal = new Suino(id, peso, idade, data, percentualCarneMagra);
                tipoAnimalInt = 3; // Suíno
            } else if (tipoAnimal instanceof Ave) {
                String tipoFrango = Teclado.readString("Digite o tipo de frango:");
                tipoAnimal = new Ave(id, peso, idade, data, tipoFrango);
                tipoAnimalInt = 2; // Ave
            }

            tipoAnimal.setIDlote(idLote);

            boolean loteEncontrado = false;
            for (Lote<Animal> lote : listaLotes) {
                if (lote.getIdLote() == idLote) {
                    lote.adicionarLote(tipoAnimal, tipoAnimalInt, idLote);
                    loteEncontrado = true;
                    break;
                }
            }

            if (!loteEncontrado) {
                throw new LoteNaoExisteException("Lote nao encontrado. Animal nao cadastrado.");
            }

        } catch (AnimalJaExisteException | LoteNaoExisteException e) {
            System.out.println("Erro ao cadastrar animal: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar animal: " + e.getMessage());
        }
    }

    /**
     * Excecao lancada quando um animal nao e encontrado.
     */
    public static class AnimalNaoEncontradoException extends Exception {
        public AnimalNaoEncontradoException(String message) {
            super(message);
        }
    }

    /**
     * Visualiza as informacoes de um animal especifico com base no ID fornecido.
     */
    public static void visualizarAnimal() {
        try {
            int id = Teclado.readInt("Digite o ID do animal que deseja visualizar:");
            Animal animal = buscarAnimalPorID(id);

            if (animal == null) {
                throw new AnimalNaoEncontradoException("Animal com ID " + id + " nao encontrado");
            }
            
            System.out.println("Informações do Animal:");
            System.out.println("ID: " + animal.getID());
            System.out.println("Peso: " + animal.getPeso());
            System.out.println("Idade (em dias): " + animal.getIdade());
            System.out.println("Data de Chegada: " + animal.getDataChegada());
            System.out.println("Lote ID: " + animal.getIDlote());

            if (animal instanceof Bovino) {
                Bovino bovino = (Bovino) animal;
                System.out.println("Raca: " + bovino.getRacaBoi());
                System.out.println("Percentual de Musculo: " + bovino.getPercentualMusculo());
                System.out.println("Percentual de Gordura: " + bovino.getPercentualGordura());
            } else if (animal instanceof Suino) {
                Suino suino = (Suino) animal;
                System.out.println("Percentual de Carne Magra: " + suino.getPercentualCarneMagra());
            } else if (animal instanceof Ave) {
                Ave ave = (Ave) animal;
                System.out.println("Tipo de Frango: " + ave.getTipoFrango());
            }

        } catch (AnimalNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao visualizar animal: " + e.getMessage());
        } 
    }

    /**
     * Edita as informacoes de um animal existente com base no ID fornecido.
     */
    public static void editarAnimal() {
        try {
            int id = Teclado.readInt("Digite o ID do animal que deseja editar:");
            Animal animal = buscarAnimalPorID(id);

            if (animal == null) {
                throw new AnimalNaoEncontradoException("Animal com ID " + id + " nao encontrado");
            }

            System.out.println("Editando o animal com ID " + id);

            double novoPeso = Teclado.readDouble("Digite o novo peso do animal:");
            int novaIdade = Teclado.readInt("Digite a nova idade do animal (em dias):");
            LocalDate novaData = Teclado.readDate("Digite a nova data de chegada (AAAA-MM-DD):");
            animal.setPeso(novoPeso);
            animal.setIdade(novaIdade);
            animal.setDataChegada(novaData);

            if (animal instanceof Bovino) {
                Bovino bovino = (Bovino) animal;
                String novaRaca = Teclado.readString("Digite a nova raca do bovino:");
                double novoPercentualMusculo = Teclado.readDouble("Digite o novo percentual de musculo:");
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

        } catch (AnimalNaoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao editar animal: " + e.getMessage());
        }
    }
}
