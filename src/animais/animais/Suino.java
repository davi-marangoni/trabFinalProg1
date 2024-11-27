package animais.animais;

import java.time.LocalDate;

public class Suino extends Animal {
    private static final long serialVersionUID = 1L;
    private double percentualCarneMagra;


     public Suino(int ID, double peso, int idade, LocalDate dataChegada, double percentualCarneMagra){
        setID(ID);
        setPeso(peso);
        setIdade(idade);
        setDataChegada(dataChegada);
        setPercentualCarneMagra(percentualCarneMagra);
    }

    public double getPercentualCarneMagra(){
        return percentualCarneMagra;
    }

    public void setPercentualCarneMagra(double percentualCarneMagra){
        this.percentualCarneMagra=percentualCarneMagra;
    }


}
