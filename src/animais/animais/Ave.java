package animais.animais;

import java.time.LocalDate;
import java.io.Serializable;

public class Ave extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tipoFrango;

    public Ave(int ID, double peso, int idade, LocalDate dataChegada, String tipoFrango){
        setID(ID);
        setPeso(peso);
        setIdade(idade);
        setDataChegada(dataChegada);
        setTipoFrango(tipoFrango);
    }

    public String getTipoFrango(){
        return tipoFrango;
    }
    public void setTipoFrango(String tipoFrango){
        this.tipoFrango=tipoFrango;
    }
}
