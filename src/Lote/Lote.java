package Lote;

import java.util.*;
import java.io.Serializable;
import animais.animais.*;

public class Lote<T> implements Iterable<T>, Serializable {

    private static final long serialVersionUID = 1L;
    private List<T> lista; 
    private int cdlote;
    private int tipoAnimal; // Tipo de animal permitido (1=Bovino, 2=Ave, 3=Suino)
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


    //Aqui é usado tipoAnimal para identificação da classe para casting correto. 
    public void adicionarLote(T objeto, int tipoAnimal, int IDlote) {

        if (this.tipoAnimal != tipoAnimal) {
            System.out.println("Erro: Animal nao eh do tipo esperado pelo lote");
            return;
        }

        if (lista != null) {
           switch (tipoAnimal) {
            case 1:
                if(objeto instanceof animais.animais.Bovino){
                    lista.add(objeto);
                    ((animais.animais.Bovino)objeto).setIDlote(IDlote);
                } else{
                    System.out.println("Animal não corresponde ao tipo informado.");
                }
            break;
            case 2:
                if(objeto instanceof animais.animais.Ave){
                    lista.add(objeto);
                    ((animais.animais.Ave)objeto).setIDlote(IDlote);
                } else{
                    System.out.println("Animal não corresponde ao tipo informado.");
                }
            break;
            case 3:
                if(objeto instanceof animais.animais.Suino){
                    lista.add(objeto);
                    ((animais.animais.Suino)objeto).setIDlote(IDlote);
                } else{
                    System.out.println("Animal não corresponde ao tipo informado.");
                }
            break;
           
            default:
                System.out.println("O tipo de animal não existe no cadastro.");
            break;
           }
          
        }
    }
 
    public void removerLote(int IDlote) {
        lista.removeIf(elemento -> {
            if (elemento instanceof animais.animais.Suino && ((animais.animais.Suino) elemento).getIDlote() == IDlote) {
                ((animais.animais.Suino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof animais.animais.Ave && ((animais.animais.Ave) elemento).getIDlote() == IDlote) {
                ((animais.animais.Ave) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof animais.animais.Bovino && ((animais.animais.Bovino) elemento).getIDlote() == IDlote) {
                ((animais.animais.Bovino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            return false;
        });

        if(removerLote==1){
            System.out.println("Lote removido.");
        } else{
            System.out.println("Lote não encontrado.");
        }
    
}


    public void removerAnimalote(int IDanimal) {
        lista.removeIf(elemento -> {
            if (elemento instanceof animais.animais.Suino && ((animais.animais.Suino) elemento).getID() == IDanimal) {
                ((animais.animais.Suino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof animais.animais.Ave && ((animais.animais.Ave) elemento).getID() == IDanimal) {
                ((animais.animais.Ave) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof animais.animais.Bovino && ((animais.animais.Bovino) elemento).getID() == IDanimal) {
                ((animais.animais.Bovino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            return false;
        });

        if(removerLote == 1){
            System.out.println("Lote animal removido.");
        } else{
            System.out.println("Lote não encontrado.");
        }
    }



    public void imprimirLotes() {
        if (lista.isEmpty()) {
            System.out.println("Lote: " + cdlote + " está vazio.");
        } else {
            System.out.println("Lote:          Tipo Animal:         ID Animal:");
            for (T elemento : lista) { 
                if(elemento instanceof animais.animais.Suino){
                        System.out.println(((animais.animais.Suino)elemento).getIDlote()+"              Suino                "+((animais.animais.Suino)elemento).getID());  
                } else {
                    if(elemento instanceof animais.animais.Bovino){
                        System.out.println(((animais.animais.Bovino)elemento).getIDlote()+"              Bovino               "+((animais.animais.Bovino)elemento).getID());  
                    } else{
                        if(elemento instanceof animais.animais.Ave){
                                    System.out.println(((animais.animais.Ave)elemento).getIDlote()+"              Ave                  "+((animais.animais.Ave)elemento).getID());  
                        } else{
                                    System.out.println("Tipo de animal não encontrado.");
                        }
                    }
                } 
            }
        }
   }


   public void imprimirLote(int IDlote) {
    int verificaLote = 0;
    System.out.println("Lote:          Tipo Animal:         ID Animal:");
    for (T elemento : lista) { 
        if(elemento instanceof animais.animais.Suino){
                 if (((animais.animais.Suino) elemento).getIDlote() == IDlote) {
                    System.out.println(((animais.animais.Suino)elemento).getIDlote()+"              Suino                "+((animais.animais.Suino)elemento).getID());
                    verificaLote = 1;
                 }
                    
        } else{
                  if(elemento instanceof animais.animais.Bovino){
                       if (((animais.animais.Bovino)elemento).getIDlote() == IDlote){
                            System.out.println(((animais.animais.Bovino)elemento).getIDlote()+"              Bovino               "+((animais.animais.Bovino)elemento).getID());
                            verificaLote = 1;
                        }  
                  } else{
                     if(elemento instanceof animais.animais.Ave){
                           if (((animais.animais.Ave)elemento).getIDlote() == IDlote){
                                   System.out.println(((animais.animais.Ave)elemento).getIDlote()+"              Ave                  "+((animais.animais.Ave)elemento).getID());  
                                   verificaLote = 1;
                           }
                     } else{
                                 System.out.println("Tipo de animal não encontrado.");
                     }
               }
       } 
   }

   if(verificaLote==0){
            System.err.println("Lote "+IDlote+" inexistente");
   }
}



   public int tamanho() {
    if (lista != null) {
       return lista.size();
    } else return 0;
  }


    
    @Override
    public Iterator<T> iterator() {
        return lista.iterator(); 
    }    
  
}





