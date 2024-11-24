package animais.animais;
import java.time.LocalDate;
import java.io.Serializable;

public abstract class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    private int ID; 
    private double peso;
    private int idade;
    private LocalDate dataChegada; 
    private int IDlote;
  
    public int getID(){
        return ID;
    }

    public void setID(int ID){
            this.ID=ID;
    }

    public double getPeso(){
        return peso;
    }

    public void setPeso(double peso){
        this.peso=peso;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade=idade;
    }

    public LocalDate getDataChegada(){
        return dataChegada;
    }

    public void setDataChegada(LocalDate dataChegada){
        this.dataChegada=dataChegada;
    }

     public void setIDlote(int IDlote) {
        this.IDlote = IDlote;
    }
    
    public int getIDlote(){
     return IDlote;
   }
}
