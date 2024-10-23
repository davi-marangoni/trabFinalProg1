package um;
public abstract class Animal {

    private String nome; //Evitar no atributo a visibilidade protected
    
    public void setNome(String nome) {
     
        if (nome == null || nome.trim().isEmpty()) {
           this.nome = "Sem nome";
        }
        else this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract void fazerSom();

    @Override
    public String toString(){
        return "Não sou nada!";
    }

}
