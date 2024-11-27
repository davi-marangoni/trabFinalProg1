package Lote;

import java.util.*;
import java.io.Serializable;
import animais.animais.*;

/**
 * Essa classe foi criada para armazenar, deletar e visualizar objetos de classes diferentes,  no contexto 
 * são as classes Suino, Bovino ou Ave. Além de associar o código de indetificação a classe animal. 
 * Inicialmente foi desenvolvida pelo Willian, mas alterada pelo Davi devido as necessidades para o 
 * o programa principal.
 * @author Davi Morangoni
 * @author Willian Gonçalves
 */

public class Lote<T> implements Iterable<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private List<T> lista; 
    private int cdlote; 
    private int tipoAnimal; 
    private int removerLote = 0;

   
    /**Construtor da classe que cria um array para adição dos objetos.
     * @author Willian Gonçalves
     */
    public Lote() {
        lista = new ArrayList<>(); 
    }

    
    /**Método que atribui um código de identificação ao lote.
     * @author Davi Morangoni
     * @param idLote
     */
    public void setIdLote(int idLote) {
        this.cdlote = idLote;
    }

    
    /**Método que retorna o código de identificação do lote
     * @author Davi Morangoni
     * @return int - código identificação do lote
     */
    public int getIdLote() {
        return cdlote;
    }


    /**Método que atribui o tipo de animal que o lote irá possuir.
     * 1-Bovino
     * 2-Ave
     * 3-Suino
     * @author Davi Morangoni
     * @param tipoAnimal
     */
    public void setTipoAnimal(int tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }


    /**Método que retorna o tipo do animal.
     * 1-Bovino
     * 2-Ave
     * 3-Suino
     * @author Davi Morangoni
     * @return int - tipo do animal 
     */
    public int getTipoAnimal() {
        return tipoAnimal;
    }


    /**Método que adiciona um objeto ao lote de acordo com o tipo de animal identificado e o código de identificaçao do lote.
     * @author Davi Morangoni
     * @author Willian Gonçalves
     * @param objeto
     * @param tipoAnimal
     * @param IDlote
     */
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


    /**Método que remove um lote da lista e seta o lote do objeto como 0
     * @author Davi Morangoni
     * @author Willian Gonçalves
     * @param IDlote
     */
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


    /**Método que remove o animal, especificado pelo código dele, do lote
     * @author Davi Morangoni
     * @author Willian Gonçalves
     * @param IDanimal
     * @return boolean - se o animal foi deletado
     */
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


    /**Método que imprime alguns atributos do objeto que está armazenado no lote.
     * O atributos são o código de indentifcação do lote e do objeto, além de identificar o tipo do animal armazenado.
     * @author Davi Morangoni
     * @author Willian Gonçalves
     */
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
    

    /**Método que retorna um lote de acordo com o código identificador do lote.
     * Inicialmente o lote que o Willian fez tinha a ideia de armazenar o ojeto e associar o código do lote ao objeto, por
     * isso tem esse método, pois um único objeto do tipo lote teria animais com diferentes códigos de lote
     * (seriam de lotes diferentes). Mas, foi planejado que cada lote teria apenas um tipo de animal armazenado.
     * @author Willian Gonçalves
     * @param IDlote
     */
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


    /**Método que retorna o tamanho do lote (quantidade de elementos no lote).
     * @return int tamanho do lote
     */
    public int tamanho() {
        if (lista != null) {
            return lista.size();
        } else {
            return 0;
        }
    }

   
    /**Retorna um iterador para os objetos armazenado no lote.
     * Com o iterador é possível percorrer os objetos do lote.
     * @autho Willian Gonçalves
     */
    @Override
    public Iterator<T> iterator() {
        return lista.iterator(); 
    }    
}
