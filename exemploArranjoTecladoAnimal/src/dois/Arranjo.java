package dois;

import java.util.*; //Para as coleções

public class Arranjo<T> implements Iterable<T> {
    //Para que funcione o For Each fora da classe, com a implementação de Iterable, 
    //É preciso fazer upcasting na referência e downcasting na instanciação - Iterator funciona no List
    //Isso possibilita o for each fora da classe, necessário devido métodos não hierárquicos e específicos

    private List<T> lista; //Ao invés de List

    // Construtor inicializa o ArrayList
    public Arranjo() {
        lista = new ArrayList<>(); //downcasting na instância, excolhendo qual coleção, neste caso ArrayList
    }

    // Método para adicionar um objeto ao ArrayList
    public void adicionar(T objeto) {
        if (lista != null) {
           lista.add(objeto);
        }
    }

    // Método para remover um objeto do ArrayList
    public void remover(T objeto) {
        if (lista != null) {
           lista.remove(objeto);
        }
    }

    // Método para obter o tamanho do ArrayList
    public int tamanho() {
        if (lista != null) {
           return lista.size();
        } else return 0;
    }
    
    // Implementação do método iterator() da interface Iterable para funcionar o For Each
    @Override
    public Iterator<T> iterator() {
        return lista.iterator(); // Usando o iterator interno do Vector
    }  

    // Método para imprimir todos os elementos do ArrayList
    public void imprimir() {
        for (T elemento : lista) { // For each
            System.out.println(elemento);  //To string
        }
    }   
       
     
}