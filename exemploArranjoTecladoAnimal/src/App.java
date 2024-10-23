
import dois.*;
import um.*;
import utilitarios.Teclado;

public class App {
    public static void main(String[] args) {

        Arranjo<Animal> zoo; //definição da referência com diamante referenciando o tipo mais upcasting.

        zoo = new Arranjo<>(); //construtor com o tipo conforme definido acima.     

        System.out.printf("Tamanho do arranjo %d\n", zoo.tamanho()); //vazio

        //Armazenando animais, de várias formas
        Animal umAnimal;        
        umAnimal = new Cachorro("Totó"); //Downcasting, upcasting
        zoo.adicionar(umAnimal);        

        zoo.adicionar(new Gato("Mimi"));  //Sem casting, diretamente, upcasting implícito
        
        zoo.adicionar((Animal) new Galinha("Mary Loo")); //Casting, upcasting
        
        zoo.adicionar((Animal) new Pardal("Pixel"));

        Python amarelinha;
        amarelinha = new Python("Amarelinha"); //Sem casting
        zoo.adicionar((Animal)amarelinha); //Upcasting

        System.out.printf("Tamanho do arranjo %d\n", zoo.tamanho()); //Novo tamanho
        zoo.imprimir();
        //varrendo o código e fazendo o som
        
        for (Animal elemento : zoo) { // For each possível fora da classe pelo Upcasting de ArrayList para List, devido Iterator
            elemento.fazerSom();
            if (elemento instanceof Cachorro) { //quando precisamos fazer algo especícifo com uma instância X, que só ela tem
                ((Cachorro)elemento).abanarRabo(); 
            }
        }    
        
        //loop de criação via usuário
        boolean continuar = true;
        String nome;
        int opcao;

        do { 
            menuOpcoes();            
            opcao = Teclado.readInt("Qual sua Opção?");
            switch (opcao) {
                case 1 : {
                     nome = Teclado.readString("Informe o nome do Animal");
                     zoo.adicionar((Animal) new Cachorro(nome));
                }
                break;
                case 2 : {
                    nome = Teclado.readString("Informe o nome do Animal");
                    zoo.adicionar((Animal) new Gato(nome));

                }
                break;
                case 3 : {
                    nome = Teclado.readString("Informe o nome do Animal");
                    zoo.adicionar((Animal) new Pardal(nome));
                }
                break;
                case 4 : {
                    nome = Teclado.readString("Informe o nome do Animal");
                    zoo.adicionar((Animal) new Python(nome));
                }
                break;
                case 5 : {
                    nome = Teclado.readString("Informe o nome do Animal");
                    zoo.adicionar((Animal) new Galinha(nome));
                }
                break;

                default:
                  continuar = false;
            }

        } while (continuar); //flag

        zoo.imprimir();

    }

    public static void menuOpcoes (){

           System.out.println("Opções\n");           
           System.out.println("1- Inserir um Cachorro.\n");
           System.out.println("2- Inserir um Gato.\n");
           System.out.println("3- Inserir um Pardal\n");
           System.out.println("4- Inserir uma Cobra Python\n");
           System.out.println("5- Inserir uma Galinha\n");      
           System.out.println("6- Sair");

    }
}
