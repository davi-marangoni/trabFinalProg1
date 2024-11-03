package animais;

import java.time.LocalDate;

public class Ave extends Animal {
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
