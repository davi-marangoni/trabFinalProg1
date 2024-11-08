package animais;
import java.time.LocalDate;
public abstract class Animal {

    private int ID; 
    private double peso;
    private int idade;
    private LocalDate dataChegada; 
  
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
}
