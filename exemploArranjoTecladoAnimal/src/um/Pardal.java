package um;

public class Pardal extends Animal{

    public Pardal(String nome){             

        setNome(nome);
    }
       
    @Override
    public String toString(){
        return "Sou uma Pardal, meu nome é " + getNome();
    }

    @Override
    public void fazerSom(){
        System.out.println("Piu-piu!");
    }

}
