/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizes;

import javax.swing.undo.UndoManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import static matrizes.matrizMenus.abrirMenu;
import static matrizes.matrizMenus.menu2;

/**
 *
 * @author ssilv
 */
public class matrizCarregar {
    
    /**
     * Carregar matriz a partir de um ficheiro
     * os números da matriz são separados por virgula
     * @param ficheiro - nome do ficheiro que o programa vai carregar
     * @param linhas - número de linhas da matriz
     * @param colunas - número de colunas da matriz
     * @throws FileNotFoundException 
     */
   
    
    public static void carregarMatriz (String ficheiro, int linhas, int colunas)throws FileNotFoundException{
        try{
            Scanner s1 = new Scanner (new File(ficheiro + ".txt"));
            while(s1.hasNextLine()){
                String linha = s1.nextLine();
                linhas++;
                String []vecLinha = linha.split(",");
                colunas = vecLinha.length;           
            } 
            Scanner s2 = new Scanner (new File(ficheiro+".txt")); 
            int [][]matriz = new int[linhas][colunas];
            while(s2.hasNextLine()){
                    for(int i = 0; i<linhas; i++){
                        String []vec = s2.nextLine().trim().split(",");
                        for ( int j = 0; j<colunas; j++){
                            matriz[i][j] = Integer.parseInt(vec[j]);
                        }
                    }
            }
            s2.close();
            ficheiro = "temp";
            gravarFicheiro(matriz, ficheiro);
            menu2(matriz, linhas, colunas);
        }catch(Exception e){
            System.out.println("Ficheiro com erros, não carregado!");
            abrirMenu();
        }
    }
    /**
     * Grava matriz para ficheiro txt com o nome que o utilizador escolher
     * @param matriz - Matriz criada e com as resptivas alterações que o utilizador fez
     * @param ficheiro - Nome do ficheiro da matriz
     * @throws FileNotFoundException 
     */
    public static void gravarFicheiro(int [][]matriz, String ficheiro)throws FileNotFoundException{
        
        
        Formatter outputFile = new Formatter(new File(ficheiro+".txt"));
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j< matriz[i].length; j++){
                outputFile.format(matriz[i][j] + ",");
            }
            outputFile.format("%n");
        }
        outputFile.close();
    }
}
