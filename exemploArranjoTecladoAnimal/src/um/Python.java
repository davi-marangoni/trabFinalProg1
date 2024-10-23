package um;

public class Python extends Animal{

    public Python(String nome){
        setNome(nome);
    }
    
   
    @Override
    public void fazerSom(){
        System.out.println("Ssssss!");
    }

    //Sem override de:
    /*
    @Override
    public String toString(){
        return "Sou uma Python, meu nome é " + getNome();
    }
    */
}
