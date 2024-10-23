package um;

public class Gato extends Animal {

    public Gato(String nome){             

        setNome(nome);
    }
    
    @Override
    public String toString(){
        return "Sou uma Gato, meu nome é " + getNome();
    }

    @Override
    public void fazerSom(){
        System.out.println("Miau!");
    }

}
