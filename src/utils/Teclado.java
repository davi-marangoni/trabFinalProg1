package utils;


import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Essa classe foi criada para utilizar o Scanner. Cada método cria um objeto
 * para ler um tipo de dado que o método indica após a palavra readX, onde X é 
 * o tipo. Já é feito um try cath em cada método para caso o
 * usuário digite um valor que não corresponde ao tipo do Scanner. Importante
 * mencionar que não se fecha o scanner se não da erro ns entradas de dados.
 * Esta classe foi criado pelo Professor Lorenzon com este objetivo.
 * 
 * Para sua utilização, basta apenas salvar a mesma na pasta src de qualquer
 * aplicação App.java que você criar.
 */

public class Teclado {

    /**
     * Método que lê um inteiro. Caso o valor digitado não seja um inteiro,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return O valor inteiro dado de entrada
     */
    public static int readInt() {
        int valor = 0;
        Scanner ler = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            flag = false;
            try {
                valor = ler.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Tente novamente!");
                flag = true;
                ler.next();
            }
        }
        // ler.close(); //não fechar o scanner
        return valor;
    }

    /**
     * Sobrecarga do método que lê um inteiro. 
     * Possibilita indicar uma mensagem com argumento de entrada.
     * Caso o valor digitado não seja um inteiro,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return O valor inteiro dado de entrada
     */
    public static int readInt(String mensagem) {

        System.out.println("\n" + mensagem);
        return readInt();

    }

    /**
     * Método que lê uma String. Caso o valor digitado não seja uma string,
     * apresenta-se uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return o valor String dado de entrada.
     */
    public static String readString() {

        String valor = "";
        Scanner ler = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            flag = false;
            try {
                valor = ler.nextLine();
                if (valor.equals("")) {
                    throw new InputMismatchException("");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Tente novamente!");
                flag = true;
                ler.nextLine();
                ler = new Scanner(System.in);   
                //Mesmo assim dá anomalia de input             
            }
        }

        // ler.close();
        return valor;

    }

    /**
     * Sobrecarga do método que lê um String. 
     * Possibilita indicar uma mensagem com argumento de entrada.
     * Caso o valor digitado não seja um String,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return O valor String dado de entrada
     */
    public static String readString(String mensagem) {

        System.out.println("\n" + mensagem);
        return readString();

    }

     /**
     * Método que lê um double. Caso o valor digitado não seja um double,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return O valor double lido.
     */
    public static double readDouble()

    {
        double valor = 0;
        Scanner ler = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            flag = false;
            try {
                valor = ler.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Tente novamente!");
                flag = true;
                ler.next();
            }
        }
        return valor;
    }

    /**
     * Sobrecarga do método que lê um double. 
     * Possibilita indicar uma mensagem com argumento de entrada.
     * Caso o valor digitado não seja um double,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @return O valor double dado de entrada
     */
    public static double readDouble(String mensagem) {

        System.out.println("\n" + mensagem);
        return readDouble();

    }

    /**
     * Método que lê uma data no formato especificado (AAAA-MM-DD). 
     * Permite indicar uma mensagem com argumento de entrada para orientar o usuário.
     * Caso o valor digitado não esteja em um formato válido de data,
     * apresenta uma mensagem de erro e solicita que o valor seja digitado novamente.
     * 
     * @return A data lida no formato LocalDate.
     */
    public static LocalDate readDate() {
        LocalDate data = null;
        boolean dataValida = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (!dataValida) {
            try {
                String entrada = readString();
                data = LocalDate.parse(entrada, formatter);
                dataValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido! Certifique-se de usar o formato AAAA-MM-DD.");
            }
        }

        return data;
    }

    /**
     * Sobrecarga do método que lê uma data. 
     * Possibilita indicar uma mensagem com argumento de entrada.
     * Caso o valor digitado não seja uma String,
     * apresenta uma mensagem informando e pedindo para que seja digitado novamente.
     * 
     * @param mensagem A mensagem que será exibida ao usuário antes da entrada.
     * @return A data lida no dado de entrada
     */
    public static LocalDate readDate(String mensagem) {

        System.out.println("\n" + mensagem);
        return readDate();

    }

    //por que voce esta aqui?

}
