package um;

public class Galinha extends Animal {
    
    public Galinha(String nome){             

        setNome(nome);
    }
          
    @Override
    public String toString(){
        return "Sou uma Galinha, meu nome é "  + getNome();
    }

    @Override
    public void fazerSom(){
        System.out.println("Cocóricó!");
    }

}
