package Lote;

import java.util.*;
import java.io.Serializable;
import animais.animais.*;

public class Lote<T> implements Iterable<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private List<T> lista; 
    private int cdlote; 
    private int tipoAnimal; 
    private int removerLote = 0;
   
    public Lote() {
        lista = new ArrayList<>(); 
    }

    public void setIdLote(int idLote) {
        this.cdlote = idLote;
    }

    public int getIdLote() {
        return cdlote;
    }

    public void setTipoAnimal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public int getTipoAnimal() {
        return tipoAnimal;
    }

    public void adicionarLote(T objeto, int tipoAnimal, int IDlote) {

        if (this.tipoAnimal != tipoAnimal) {
            System.out.println("Erro: Animal nao eh do tipo esperado pelo lote");
            return;
        }

        if (lista != null) {
            if (tipoAnimal == 1 && objeto instanceof Bovino) {
                lista.add(objeto);
                ((Bovino) objeto).setIDlote(IDlote);
            } else if (tipoAnimal == 2 && objeto instanceof Ave) {
                lista.add(objeto);
                ((Ave) objeto).setIDlote(IDlote);
            } else if (tipoAnimal == 3 && objeto instanceof Suino) {
                lista.add(objeto);
                ((Suino) objeto).setIDlote(IDlote);
            } else {
                System.out.println("Erro: Tipo de animal não corresponde ao esperado.");
            }
        }
        System.out.println("Animal cadastrado com sucesso!");
    }

    public void removerLote(int IDlote) {
        lista.removeIf(elemento -> {
            if (elemento instanceof Animal && ((Animal) elemento).getIDlote() == IDlote) {
                ((Animal) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            return false;
        });

        if (removerLote == 1) {
            System.out.println("Lote removido.");
        } else {
            System.out.println("Lote não encontrado.");
        }
    }

    public boolean removerAnimalote(int IDanimal) {
        boolean encontrado = false;
        Iterator<T> iterator = lista.iterator();
        while (iterator.hasNext()) {
            T elemento = iterator.next();
            if (elemento instanceof Animal && ((Animal) elemento).getID() == IDanimal) {
                ((Animal) elemento).setIDlote(0);
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public void imprimirLotes() {
        if (lista.isEmpty()) {
            System.out.println("Lote: " + cdlote + " está vazio.");
        } else {
            System.out.println("Lote:          Tipo Animal:         ID Animal:");
            for (T elemento : lista) { 
                if (elemento instanceof Suino) {
                    System.out.println(((Suino) elemento).getIDlote() + "              Suino                " + ((Suino) elemento).getID());  
                } else if (elemento instanceof Bovino) {
                    System.out.println(((Bovino) elemento).getIDlote() + "              Bovino               " + ((Bovino) elemento).getID());  
                } else if (elemento instanceof Ave) {
                    System.out.println(((Ave) elemento).getIDlote() + "              Ave                  " + ((Ave) elemento).getID());  
                } else {
                    System.out.println("Tipo de animal não encontrado.");
                }
            }
        }
    }

    public void imprimirLote(int IDlote) {
        int verificaLote = 0;
        System.out.println("Lote:          Tipo Animal:         ID Animal:");
        for (T elemento : lista) { 
            if (elemento instanceof Animal && ((Animal) elemento).getIDlote() == IDlote) {
                if (elemento instanceof Suino) {
                    System.out.println(((Suino) elemento).getIDlote() + "              Suino                " + ((Suino) elemento).getID());
                } else if (elemento instanceof Bovino) {
                    System.out.println(((Bovino) elemento).getIDlote() + "              Bovino               " + ((Bovino) elemento).getID());
                } else if (elemento instanceof Ave) {
                    System.out.println(((Ave) elemento).getIDlote() + "              Ave                  " + ((Ave) elemento).getID());
                }
                verificaLote = 1;
            }
        }

        if (verificaLote == 0) {
            System.err.println("Lote " + IDlote + " inexistente");
        }
    }

    public int tamanho() {
        if (lista != null) {
            return lista.size();
        } else {
            return 0;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return lista.iterator(); 
    }    
}
