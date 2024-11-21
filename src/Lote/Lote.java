package Lote;

import java.util.*;

import Animais.Animal;

public class Lote<T> implements Iterable<T> {

    private List<T> lista; 
    private int cdlote;
    private int removerLote = 0;
   
    public Lote() {
        lista = new ArrayList<>(); 
    }

    public int mostraridlote(){
        return cdlote;
    }


    //Aqui é usado tipoAnimal para identificação da classe para casting correto. 
    public void adicionarLote(T objeto, int tipoAnimal, int IDlote) {
        if (lista != null) {
           switch (tipoAnimal) {
            case 1:
                if(objeto instanceof Animais.Bovino){
                    lista.add(objeto);
                    ((Animais.Bovino)objeto).setIDlote(IDlote);
                } else{
                    System.out.println("Animal não corresponde ao tipo informado.");
                }
            break;
            case 2:
                if(objeto instanceof Animais.Ave){
                    lista.add(objeto);
                    ((Animais.Ave)objeto).setIDlote(IDlote);
                } else{
                    System.out.println("Animal não corresponde ao tipo informado.");
                }
            break;
            case 3:
                if(objeto instanceof Animais.Suino){
                    lista.add(objeto);
                    ((Animais.Suino)objeto).setIDlote(IDlote);
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
            if (elemento instanceof Animais.Suino && ((Animais.Suino) elemento).getIDlote() == IDlote) {
                ((Animais.Suino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof Animais.Ave && ((Animais.Ave) elemento).getIDlote() == IDlote) {
                ((Animais.Ave) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof Animais.Bovino && ((Animais.Bovino) elemento).getIDlote() == IDlote) {
                ((Animais.Bovino) elemento).setIDlote(0);
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
            if (elemento instanceof Animais.Suino && ((Animais.Suino) elemento).getID() == IDanimal) {
                ((Animais.Suino) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof Animais.Ave && ((Animais.Ave) elemento).getID() == IDanimal) {
                ((Animais.Ave) elemento).setIDlote(0);
                removerLote = 1;
                return true; 
            }
            if (elemento instanceof Animais.Bovino && ((Animais.Bovino) elemento).getID() == IDanimal) {
                ((Animais.Bovino) elemento).setIDlote(0);
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
        System.out.println("Lote:          Tipo Animal:         ID Animal:");
        for (T elemento : lista) { 
            if(elemento instanceof Animais.Suino){
                      System.out.println(((Animais.Suino)elemento).getIDlote()+"              Suino                "+((Animais.Suino)elemento).getID());  
            } else{
                      if(elemento instanceof Animais.Bovino){
                          System.out.println(((Animais.Bovino)elemento).getIDlote()+"              Bovino               "+((Animais.Bovino)elemento).getID());  
                      } else{
                         if(elemento instanceof Animais.Ave){
                                     System.out.println(((Animais.Ave)elemento).getIDlote()+"              Ave                  "+((Animais.Ave)elemento).getID());  
                         } else{
                                     System.out.println("Tipo de animal não encontrado.");
                         }
                   }
           } 
       }
   }


   public void imprimirLote(int IDlote) {
    int verificaLote = 0;
    System.out.println("Lote:          Tipo Animal:         ID Animal:");
    for (T elemento : lista) { 
        if(elemento instanceof Animais.Suino){
                 if (((Animais.Suino) elemento).getIDlote() == IDlote) {
                    System.out.println(((Animais.Suino)elemento).getIDlote()+"              Suino                "+((Animais.Suino)elemento).getID());
                    verificaLote = 1;
                 }
                    
        } else{
                  if(elemento instanceof Animais.Bovino){
                       if (((Animais.Bovino)elemento).getIDlote() == IDlote){
                            System.out.println(((Animais.Bovino)elemento).getIDlote()+"              Bovino               "+((Animais.Bovino)elemento).getID());
                            verificaLote = 1;
                        }  
                  } else{
                     if(elemento instanceof Animais.Ave){
                           if (((Animais.Ave)elemento).getIDlote() == IDlote){
                                   System.out.println(((Animais.Ave)elemento).getIDlote()+"              Ave                  "+((Animais.Ave)elemento).getID());  
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





