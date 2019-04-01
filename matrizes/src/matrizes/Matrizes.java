/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizes;

import static matrizes.matrizMenus.abrirMatriz;
import static matrizes.matrizMenus.abrirMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import static matrizes.matrizMenus.menu2;


public class Matrizes {

   
    public static Scanner ler = new Scanner (System. in);
    
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        matrizMenus.abrirMenu();
    }
    
    
    /**
     * Criação da matriz manualmente
     * @param linhas - número de linhas da matriz introduzidas pelo utilizador
     * @param colunas - número de colunas da matriz introduzidas pelo utilizador
     * @return matriz - retorna uma matriz com os elementos já introduzidos
     * @throws FileNotFoundException 
     */
    public static int [][]criarMatriz(int linhas, int colunas)throws FileNotFoundException{
        int [][]matriz= new int[linhas][colunas];
        try{
            for(int i =0; i<matriz.length; i++){
                for(int j =0; j<matriz[i].length; j++){
                    System.out.println("Introduza o valor da linha " + i +" coluna "+ j);
                    matriz[i][j] = ler.nextInt();
                }
            }
        }catch(InputMismatchException e){
            System.out.println("Valor inválido, introduza nova matriz");
            ler.nextLine();
            matrizMenus.abrirMatriz();
        }
        
        return matriz;
    }
    /**
     * Ver a matriz criada pelo utilizador ou a matriz carregada a partir de um ficheiro txt
     * @param matriz - já com os seus elementos introduzidos
     * @param linhas - número de linhas da matriz
     * @param colunas - número de colunas da matriz
     * @throws FileNotFoundException 
     */
    public static int verMatriz(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                System.out.print("\t" + matriz[i][j] );
            }
            System.out.println("");
        }
        return 0;
    }
    
    /**
     * Ordenação crescente da matriz completa
     * @param matriz - matriz com os seus elementos introduzidos
     * @return matriz ordenada
     */
    public static int [][]ordemCrescente(int [][]matriz){
        for(int x= 0; x<matriz.length; x++){
            for (int z= 0; z< matriz[x].length; z++){
                for(int i = 0; i<matriz.length; i++){
                    for(int j= 0; j<matriz[i].length; j++){
                        if ( matriz[x][z] < matriz[i][j]){
                            int temp = matriz[x][z];
                            matriz[x][z] = matriz[i][j];
                            matriz[i][j] = temp;
                        }
                    }
                }
            }
        }
        return matriz;
    } 
    
    /**
     * Ordenação decrescente da matriz completa
     * @param matriz - matriz completa
     * @return matriz ordenada decrescentemente
     * @throws FileNotFoundException 
     */
    public static int [][]ordemDecrescente (int [][]matriz)throws FileNotFoundException{
        for( int x=0; x<matriz.length; x++){
            for(int z = 0; z<matriz[x].length; z++){
                for( int i=0; i<matriz.length; i++){
                    for(int j = 0; j<matriz[i].length; j++){
                        if(matriz[x][z] > matriz[i][j]){
                            int temp = matriz[x][z];
                            matriz[x][z] = matriz[i][j];
                            matriz[i][j] = temp;
                        }
                    }
                }
            }
        }
        return matriz;
    }
    
    
    /**
     * Cria uma matriz transposta a partir da matriz original
     * @param matriz - matriz completa
     * @param linhas - número de linhas da matriz
     * @param colunas - número de colunas da matriz
     * @throws FileNotFoundException 
     */
    public static void matrizTransposta(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int [][]matrizTransposta = new int [colunas][linhas];
        
        for (int i= 0; i <colunas; i++){
            for(int j = 0; j<linhas; j++){
                matrizTransposta[i][j] = matriz[j][i];
            }
        }
        int temp = linhas;
        linhas = colunas;
        colunas = temp;
        matrizMenus.menu2(matrizTransposta, linhas, colunas);
    }
/**
 * Cálculo da soma das linhas e das colunas da matriz
 * Cálculo da soma total da matriz
 * @param matriz - Matriz completa e preenchida
 * @param linhas - número de linhas da matriz
 * @param colunas - número de colunas da matriz
 * @throws FileNotFoundException 
 */
    public static void somaMatriz (int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int soma;
        System.out.println("\tSoma das linhas:");
        for(int i = 0; i<linhas; i++){
            soma = 0;
            for(int j = 0; j<colunas; j++){
                soma = soma + matriz[i][j];
            }
            System.out.print("\t\t" +soma +"\n");
        }
        System.out.println("");
        pausa();
        soma = 0;
        ler.nextLine();
        
        System.out.println("\tSoma das colunas:");
        int temp = 0;
        if ( linhas >colunas){
            temp = linhas - colunas;
            for(int i = 0; i<matriz.length-temp; i++){
                for(int j = 0; j<matriz[i].length+temp; j++){
                    soma = soma+matriz[j][i];
                }
                System.out.print("\t" + soma+ "\t");
                soma = 0;
            }
           
        }else {
            temp = 0;
            if ( colunas > linhas){
                temp = colunas - linhas;
                for(int i = 0; i<matriz.length+temp; i++){
                    for(int j = 0; j<matriz.length; j++){
                        soma = soma+matriz[j][i];
                    }
                    System.out.print("\t\t" + soma+ "\t");
                    soma = 0;
                }        
            
           
            
            } else{
                temp = 0;
                if (linhas == colunas){
                    for(int i = 0; i<matriz.length; i++){
                        for(int j = 0; j<matriz[i].length; j++){
                            soma = soma+matriz[j][i];
                        }
                        System.out.print("\t\t" + soma+ "\t");
                        soma = 0;
                    }
                }
            }
            
        }
        pausa();
        soma = 0;
        System.out.println("\t\tSoma total: ");
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                soma = soma+matriz[i][j];
            }
        }
        System.out.println("\t\t\t" + soma);
        matrizMenus.menu3(matriz, linhas, colunas);
    }
    /**
     * Cálculo da média total da matriz, das linhas e colunas
     * @param matriz - preenchida
     * @param linhas - número de linhas da matriz
     * @param colunas - número de colunas da matriz
     * @throws FileNotFoundException 
     */
    public static void mediaMatriz(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        double media = 0;
        double soma;
        
        System.out.println("\t\tMédia das linhas:");
        for(int i = 0; i<matriz.length; i++){
            soma = 0;
            for(int j= 0; j<matriz[i].length; j++){
                soma = soma + matriz[i][j];   
            }
            media = soma / colunas;
            System.out.println("\t\t" + media);
        }
        
        pausa();
        soma = 0;
        ler.nextLine();
        
        System.out.println("\t\tMédia das colunas:");
       
        int temp=0;
        if ( linhas >colunas){
             temp = linhas - colunas;
            for(int i = 0; i<matriz.length-temp; i++){
                for(int j = 0; j<matriz[i].length+temp; j++){
                    soma = soma+matriz[j][i];
                }
                media = soma / linhas;
                System.out.print("\t\t" + media+ "\t");
                soma = 0;
            }
        }else {
            if ( colunas > linhas){
                temp = colunas - linhas;
                for(int i = 0; i<matriz.length+temp; i++){
                    for(int j = 0; j<matriz.length; j++){
                        soma = soma+matriz[j][i];
                    }
                    media = soma / linhas;
                    System.out.print("\t\t" + media+ "\t");
                    soma = 0;
                }        
            } else{
                if (linhas == colunas){
                    for(int i = 0; i<matriz.length; i++){
                        for(int j = 0; j<matriz[i].length; j++){
                            soma = soma+matriz[j][i];
                        }
                        media = soma / linhas;
                        System.out.print("\t\t" + media+ "\t");
                        soma = 0;
                    }
                }
            }
            
        }
        pausa();
        soma = 0;
        temp = 0;
        
        System.out.println("\t\tMédia total: ");
        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                soma = soma+matriz[i][j];
                temp++;
            }
        }
        media = soma / temp;
        System.out.println("\t\t\t" + media);
        matrizMenus.menu3(matriz, linhas, colunas);
    }
    public static void pausa(){
        
        System.out.println("\n====================================================================================================================");
        System.out.println("Pressione Enter para continuar");
        
        ler.nextLine();
    }
    /**
     * Rotação da matriz no sentido contrário aos ponteiros do relógio
     * @param matriz - preenchida
     * @param linhas - número de linhas da matriz
     * @param colunas - número de colunas da matriz
     * @return matriz rodada
     */
    public static int [][]rodarMatriz(int [][]matriz, int linhas, int colunas){
        if (linhas == colunas){
            // Consider all squares one by one 
            for ( int x = 0; x<linhas/2; x++){
                // Consider elements in group of 4 in  
                // current square 
                for(int y = x; y<linhas-x-1; y++){
                    // store current cell in temp variable
                    int temp = matriz[x][y];
                    // move values from right to top 
                    matriz[x][y] = matriz[y][linhas-1-x]; 
                    // move values from bottom to right 
                    matriz[y][linhas-1-x] = matriz[linhas-1-x][linhas-1-y];
                    // move values from left to bottom 
                    matriz[linhas-1-x][linhas-1-y] = matriz[linhas-1-y][x]; 
                    // assign temp to left 
                    matriz[linhas-1-y][x] = temp; 
                }
            }
        }else
            System.out.println("Impossível rodar, não é uma matriz quadrada");
        return matriz;
    }
    /*public static int [][]rodar180 (int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        // Function to Rotate the 
        // matrix by 180 degree 
        int [][]temp = new int[linhas][colunas];
        if (linhas == colunas){
            // Simply print from last 
            // cell to first cell.
            for (int i = linhas-1; i >= 0; i--) { 
                for (int j = linhas- 1; j >= 0; j--){
                    System.out.print(matriz[i][j]+"\t");
                }
                System.out.println("");
            }
    }else
            System.out.println("Não é possível rodar matriz");
        return temp;
    }*/
    /**
     * Cálculo da soma da diagonal principal
     * @param matriz
     * @param linhas
     * @param colunas
     * @throws FileNotFoundException 
     */
    public static void somaDiagonal(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int soma = 0;
        if (linhas==colunas){
            System.out.println("\tSoma da diagona principal: ");
            for(int i = 0; i<matriz.length; i++){
                soma = soma + matriz[i][i];
                for(int j = 0; j<matriz[i].length; j++){

                }
            }
            System.out.println("\t\t" + soma);
        }else{
            System.out.println("Não é possível calcular diagonal, não é matriz quadrada");
            matrizMenus.menu3(matriz, linhas, colunas);
        }
        pausa();
        diagonalSecundaria(matriz, linhas, colunas);  
    }
    /**
     * Cálculo da soma da diagonal secundária
     * @param matriz
     * @param linhas
     * @param colunas
     * @throws FileNotFoundException 
     */
    public static void diagonalSecundaria(int [][]matriz, int linhas, int colunas) throws FileNotFoundException {
        int soma = 0;
        if (linhas == colunas){
            System.out.println("\tSoma da diagonal secundária: ");
            for(int i = 0; i<matriz.length; i++){
                for(int j = 0; j<matriz[i].length; j++){
                    if ((i+j) ==(colunas-1)){
                        soma = soma + matriz[i][j];
                    }
                }
            }
            System.out.println("\t\t" +soma);
        }else
            System.out.println("Não é possível calcular a diagonal, não é uma matriz quadrada");
        matrizMenus.menu3(matriz, linhas, colunas);
    }
    /**
     * Ordena a matriz crescentemente por coluna
     * @param matriz
     * @param linhas
     * @param colunas
     * @return matriz
     */
    public static int [][] crescenteColunas(int [][]matriz, int linhas, int colunas){
        for(int i = 0 ; i<matriz.length; i++){
            for(int j = i+1; j<matriz.length; j++){
                for(int k=0; k<matriz[i].length; k++){
                    if (matriz[i][k] > matriz[j][k]){
                        int temp = matriz[i][k];
                        matriz[i][k] = matriz[j][k];
                        matriz[j][k] = temp;
                        
                    }
                }
            }
        }
        return matriz;
    }
    
    /**
     * Ordena crescentemente a matriz por linha
     * @param matriz
     * @param linhas
     * @param colunas
     * @return matriz
     */
    public static int [][]crescenteLinhas(int [][]matriz, int linhas, int colunas){
        for(int i =0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                for (int k = j+1; k<matriz[0].length; k++){
                    if (matriz[i][k] < matriz[i][j]){
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[i][k];
                        matriz[i][k] = temp;
                    }
                }
            }
        }
        return matriz;
    }
    
    /**
     * Ordena descrentemente a matriz por linha
     * @param matriz
     * @return 
     */
    public static int [][]decrescenteLinhas (int [][]matriz){
        for(int i =0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                for (int k = j+1; k<matriz[0].length; k++){
                    if (matriz[i][k] > matriz[i][j]){
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[i][k];
                        matriz[i][k] = temp;
                    }
                }
            }
        }
        return matriz;
    }
    
    public static int [][]decrescenteColunas(int [][]matriz){
        for(int i = 0 ; i<matriz.length; i++){
            for(int j = i+1; j<matriz.length; j++){
                for(int k=0; k<matriz[i].length; k++){
                    if (matriz[i][k] < matriz[j][k]){
                        int temp = matriz[i][k];
                        matriz[i][k] = matriz[j][k];
                        matriz[j][k] = temp;
                        
                    }
                }
            }
        }
        return matriz;
    }
}