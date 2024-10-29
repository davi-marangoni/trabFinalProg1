import utils.Teclado;

public class Principal {
    public static void main(String[] args) {
        boolean continuar = true;
        int opcao, opcaoLote, opcaoBovino, opcaoSuino, opcaoAve;
        do { 
            menuGeral();            
            opcao = Teclado.readInt("Qual sua Opção?");
            switch (opcao) {
                case 1 : {
                    menuLote();
                    opcaoLote = Teclado.readInt("Qual sua Opção?");
                    switch (opcaoLote) {
                        case 1: {
                            //Chamada da Funcao Cadastrar Lote
                            break;
                        }
                        case 2: {
                            //Chamada da Funcao Excluir Lote
                            break;
                        }
                        case 3: {
                            //Chamada da Funcao Ver Lote
                            break;
                        }
                        case 4: {
                            //Chamada da Funcao Remover Animal do Lote
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                break;
                case 2: {
                    menuBoi();
                    opcaoBovino = Teclado.readInt("Qual sua Opção?");
                    switch (opcaoBovino) {
                        case 1: {
                            //Chamada da Funcao Cadastrar bovino
                            break;
                        }
                        case 2: {
                            //Chamada da Funcao Editar bovino
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                break;
                case 3: {
                    menuFrango();
                    opcaoAve = Teclado.readInt("Qual sua Opção?");
                    switch (opcaoAve) {
                        case 1: {
                            //Chamada da Funcao Cadastrar ave
                            break;
                        }
                        case 2: {
                            //Chamada da Funcao Editar ave
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                break;
                case 4: {
                    menuPorco();
                    opcaoSuino = Teclado.readInt("Qual sua Opção?");
                    switch (opcaoSuino) {
                        case 1: {
                            //Chamada da Funcao Cadastrar Suino
                            break;
                        }
                        case 2: {
                            //Chamada da Funcao Editar Suino
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
                break;

                default:
                  continuar = false;

            }
        }
        while (continuar);
        
    }

    public static void menuGeral() {

        System.out.println("Opções Gerais:\n");           
        System.out.println("1 - Lote.\n");
        System.out.println("2 - Bovino.\n");
        System.out.println("3 - Suino.\n");
        System.out.println("4 - Ave\n"); 
        System.out.println("5 - Sair");

    }

    public static void menuLote() {
        System.out.println("Opções do Lote:\n");
        System.out.println("1 - Cadastrar lote.\n");
        System.out.println("2 - Excluir lote.\n");
        System.out.println("3 - Ver lote.\n");
        System.out.println("4 - Remover animal do lote.\n");
    }

    public static void menuBoi() {
        System.out.println("Opções do Boi:\n");
        System.out.println("1 - Cadastrar bovino.\n");
        System.out.println("2 - Editar bovino.\n");
    }

    public static void menuFrango() {
        System.out.println("Opções da Ave:\n");
        System.out.println("1 - Cadastrar ave.\n");
        System.out.println("2 - Editar ave.\n");
    }

    public static void menuPorco() {
        System.out.println("Opções do Suino:\n");
        System.out.println("1 - Cadastrar Suino.\n");
        System.out.println("2 - Editar Suino.\n");
    }

}