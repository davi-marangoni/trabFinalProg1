package animais;

import java.time.LocalDate;

public class Bovino extends Animal{
    private String racaBoi;
    private double percentualMusculo;
    private double percentualGordura;

    public Bovino(int ID, double peso, int idade, LocalDate dataChegada, String racaBoi, double percentualMusculo, double percentualGordura){
        setID(ID);
        setPeso(peso);
        setIdade(idade);
        setDataChegada(dataChegada);
        setRacaBoi(racaBoi);
        setPercentualMusculo(percentualMusculo);
        setPercentualGordura(percentualGordura);
    }

    public String getRacaBoi(){
        return racaBoi;
    }

    public void setRacaBoi(String racaBoi){
        this.racaBoi=racaBoi;
    }

    public double getPercentualMusculo(){
        return percentualMusculo;
    }

    public void setPercentualMusculo(double percentualMusculo){
        this.percentualMusculo=percentualMusculo;
    }

    public double getPercentualGordura(){
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura){
        this.percentualGordura=percentualGordura;
    }
}
