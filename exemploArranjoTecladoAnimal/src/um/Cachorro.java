package um;

public class Cachorro extends Animal {

    public Cachorro(String nome){
        setNome(nome);
    }
    
    @Override
    public String toString(){
        return "Sou um cachorro, meu nome é " + getNome();
    }

    @Override
    public void fazerSom(){
        System.out.println("Au au!");
    }

    public void abanarRabo(){
        System.out.println("Estou abanando o rabo!!!");
    }

}
