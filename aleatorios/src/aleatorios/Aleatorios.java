/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorios;

/**
 *
 * @author ssilv
 */
import java.util.Scanner;
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int []vec = new int [10];
        
        //definir intervalo dos números aleatórios entre [1,  50]
        int max = 50;
        int min = 1;
        int range = max - min + 1;
        int num = 0;
        
        //vetor com número aleatórios entre [1,  50] todos diferentes
        vec = geraNum(vec, range, min, max, num);
        
        System.out.print("Array: ");
        verVetor(vec);
        
        System.out.print("\nValor a pesquisar: ");
        int valor = ler.nextInt();
        int cont = contNum(vec, valor);
        //Se criar um vetor com números todos diferentes, o contador só vai ter valores entre 1 e 0
        System.out.println("\nO número "+ valor + " foi encontrado "+ cont+ " vezes");
    } 
    //gerar números aleatórios entre 1 e 50
    public static int []geraNum(int []vec, int range, int min, int max, int num){
        for (int i = 0; i<vec.length; i++){
            num = (int)(Math.random()* range)+ min;
            /*while (verificaNum (vec, i, num)){
                num = (int)(Math.random()* range)+ min;
            }*/
            vec[i] = num;
        }
        return vec;
    }
    
    //Verifica se o número já se encontra no array
    /*private static boolean verificaNum(int []vec, int numPercorrido, int num){
        for (int i = 0; i<numPercorrido; i++){
            if (vec[i] == num){
                return true;
            }
        }
        return false;
    }
    */
    //ver Vetor preenchido
    public static void verVetor(int []vec){
        for (int i = 0; i<vec.length; i++){
            System.out.print(vec[i] + "\t");
        }
    }
    
    //Contar número de valores repetidos
    public static int contNum(int []vec, int valor){
        int cont = 0;
        for ( int i=0; i<vec.length; i++){
            if (valor == vec[i]){
                cont++;
            }
        }
        return cont;
    }
}
