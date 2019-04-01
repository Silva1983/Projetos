/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizes;


import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import static matrizes.Matrizes.criarMatriz;
import static matrizes.Matrizes.ler;
import static matrizes.matrizCarregar.gravarFicheiro;
import java.io.File;

/**
 *
 * @author ssilv
 */
public class matrizMenus {
    
 
    /**
     * Primeiro menu da aplicação
     * Opção de abrir matriz e saír da aplicação
     *
     * @throws FileNotFoundException 
     */
    public static void abrirMenu()throws FileNotFoundException{
        int op= 0;
        do{
            try{
                System.out.println("\n1 - Abrir matriz"
                        + "\n0 - Saír");
                op = ler.nextInt();

                switch(op){
                    case 1:
                        abrirMatriz();
                        break;
                    case 0:
                        File file = new File("temp.txt");
                        file.delete();
                        System.exit(0);
                        break;
                    //default : System.out.println("Opção inválida!");
                }
            }catch(InputMismatchException e){
                System.out.println("Opção inválida! Introduza opção válida");
                ler.nextLine();
                abrirMenu();
            }
        }while(op <0 || op >1);
    }
    
    /**
     * Segundo menu da aplicação
     * Carregar matriz a partir de ficheiro, ou criar uma manualmente
     * @throws FileNotFoundException 
     */
    public static void abrirMatriz()throws FileNotFoundException{
        int op=0;
        do{
            try{
                System.out.println("\n1 - Introduzir matriz manualmente"
                        + "\n2 - Carregar matriz a partir de ficheiro"
                        + "\n3 - Voltar");
                op = ler.nextInt();

                switch(op){
                    case 1:
                        System.out.println("Introduza o número de linhas da matriz");
                        int linhas = ler.nextInt();
                        System.out.println("Introduza o número de colunas da matriz");
                        int colunas = ler.nextInt();
                        int [][] matriz = criarMatriz(linhas, colunas);
                        menu2(matriz, linhas, colunas);
                        break;
                    case 2:
                        linhas = 0;
                        colunas = 0;
                        ler.nextLine();
                        System.out.println("Introduza o nome da matriz que quer carregar");
                        String ficheiro = ler.nextLine();
                        matrizCarregar.carregarMatriz(ficheiro, linhas, colunas);
                        
                    case 3:
                        abrirMenu();
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Opção invalida! Introduza opção válida");
                ler.nextLine();
                abrirMatriz();
            }
        }while(op<1 || op >3);
    }
    /**
     * Terceiro menu da aplicação
     * Opção de ordenar crescentemente, decrescentemente, criar matriz transposta
     * Gravar matriz para ficheiro txt e abrir menu de calculos
     * @param matriz
     * @param linhas
     * @param colunas
     * @throws FileNotFoundException 
     */
    public static void menu2(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op = 0;
        String ficheiro= "temp";
        gravarFicheiro(matriz, ficheiro);
        do{
            try{
                System.out.println("\n1 - Ver Matriz"
                        + "\n2 - Ordenar crescentemente"
                        + "\n3 - Ordenar decrescentemente"
                        + "\n4 - Matriz transposta"
                        + "\n5 - Cálculos"
                        +"\n6 - Rodar Matriz"
                        +"\n7 - Gravar para ficheiro"
                        +"\n8 - Voltar");
                op = ler.nextInt();
                switch(op){
                    case 1:
                        int x =Matrizes.verMatriz(matriz, linhas, colunas);
                        menu2(matriz, linhas, colunas);
                        break;
                    case 2:
                        ordenarMenu(matriz, linhas, colunas);
                        break;
                    case 3:
                        decescenteMenu(matriz, linhas, colunas);
                        break;
                    case 4:
                       Matrizes.matrizTransposta(matriz, linhas, colunas);
                        break;
                    case 5:
                        menu3(matriz, linhas, colunas);
                        break;
                    case 6:
                        menuRotacao(matriz, linhas, colunas);
                        break;
                    case 7:
                        System.out.println("Introduza o nome do ficheiro para a sua matriz");
                        ler.nextLine();
                        ficheiro = ler.nextLine();
                        matrizCarregar.gravarFicheiro(matriz, ficheiro);
                        menu2(matriz, linhas, colunas);
                        break;
                    case 8:
                        menuAbrir2(matriz, linhas, colunas);
                        break;
                    default: System.out.println("Opção inválida! Introduza opção válida");
                }
            }catch (InputMismatchException e){
                System.out.println("Opção inválida! Introduza opção válida");
                ler.nextLine();
                menu2(matriz, linhas, colunas);
            }
        }while(op < 1 || op > 8);
    }
    /**
     * Menu de cálculos da matriz
     * Cálculo da soma e média de cada linha, coluna e soma e média total da matriz
     * @param matriz
     * @param linhas
     * @param colunas
     * @throws FileNotFoundException 
     */
    public static void menu3(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op = 0;
        do{
            try{
        
                System.out.println("\n1 - Soma"
                + "\n2 - Médias"
                + "\n3 - Diagonais"
                + "\n4 - Voltar");
                op = ler.nextInt();
                switch(op){
                    case 1:
                        Matrizes.somaMatriz(matriz, linhas, colunas);
                        break;
                    case 2:
                        Matrizes.mediaMatriz(matriz, linhas, colunas);
                        break;
                    case 3:
                        Matrizes.somaDiagonal(matriz, linhas, colunas);
                        break;
                    case 4: menu2(matriz, linhas, colunas);
                        break;
                    default:
                        System.out.println("Opção inválida! Introduza uma opção válida");
                }
            }catch (InputMismatchException e){
                System.out.println("Erro! Introduza uma opção válida");
                ler.nextLine();
                menu3(matriz, linhas, colunas);
            }
        }while(op<1 || op > 4);
    }
    public static void menuRotacao(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op = 0;
        do{
            try{
                System.out.println("\n1 - Ver Matriz"
                        + "\n2 - Rodar matriz para a direita"
                        + "\n3 - Rodar matriz para a esquerda"
                        + "\n4 - Rodar 180º"
                        + "\n5 - Voltar");
                op = ler.nextInt();
                switch(op){
                    case 1:
                        int x =Matrizes.verMatriz(matriz, linhas, colunas);
                        menuRotacao(matriz, linhas, colunas);
                        break;
                    case 2:
                        if (linhas != colunas){
                            System.out.println("Impossível rodar matriz, porque não é uma matriz quadrada");
                            menuRotacao(matriz, linhas, colunas);
                        }else{
                            matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                            matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                            matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                            menuRotacao(matriz, linhas, colunas);
                        }
                        break;
                    case 3:
                        matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                        menuRotacao(matriz, linhas, colunas);
                        break;
                    case 4:
                        if (linhas != colunas){
                            System.out.println("Impossível rodar matriz, porque não é uma matriz quadrada");
                            menuRotacao(matriz, linhas, colunas);
                        }else{
                            matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                            matriz= Matrizes.rodarMatriz(matriz, linhas, colunas);
                            menuRotacao(matriz, linhas, colunas);
                        }
                        break;
                    
                    case 5:
                        menu2(matriz, linhas, colunas);
                    break;
                    default:
                        System.out.println("Opção inválida! Introduza uma opção válida");
                }
            }catch(InputMismatchException e){
                System.out.println("Erro! Introduza uma opção válida");
                ler.nextLine();
                menuRotacao(matriz, linhas, colunas);
                
            }
        }while(op<1 || op >5);
    }
    public static void ordenarMenu(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op = 0;
        do{
            try{
                System.out.println("\n1 - Ver Matriz"
                        + "\n2 - Ordenar por coluna"
                        + "\n3 - Ordenar por linha"
                        + "\n4 - Ordenar matriz completa"
                        + "\n5 - Voltar");
                op = ler.nextInt();
                switch(op){
                    case 1:
                        int x =Matrizes.verMatriz(matriz, linhas, colunas);
                        ordenarMenu(matriz, linhas, colunas);
                        break;
                    case 2:
                        matriz = Matrizes.crescenteColunas(matriz, linhas, colunas);
                        ordenarMenu(matriz, linhas, colunas);
                        break;
                    case 3:
                        matriz = Matrizes.crescenteLinhas(matriz, linhas, colunas);
                        ordenarMenu(matriz, linhas, colunas);
                        break;
                    case 4:
                        matriz = Matrizes.ordemCrescente(matriz);
                        ordenarMenu(matriz, linhas, colunas);
                        break;
                    case 5:
                        menu2(matriz, linhas, colunas);
                        break;
                        
                    default : System.out.println("Opção inválida! Introduza uma opção válida");
                }
            }catch (InputMismatchException e){
                System.out.println("Erro! Introduza uma opção válida");
                ler.nextLine();
                ordenarMenu(matriz, linhas, colunas);
            }
        }while(op<1 || op>5);
    }
    
    public static void decescenteMenu(int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op = 0;
            do{
                try{
                    System.out.println("\n1 - Ver Matriz"
                            + "\n2 - Ordenar por coluna"
                            + "\n3 - Ordenar por linha"
                            + "\n4 - Ordenar matriz completa"
                            + "\n5 - Voltar");
                    op = ler.nextInt();
                    switch(op){
                        case 1:
                            int x =Matrizes.verMatriz(matriz, linhas, colunas);
                            decescenteMenu(matriz, linhas, colunas);
                            break;
                        case 2:
                            matriz = Matrizes.decrescenteColunas(matriz);
                            decescenteMenu(matriz, linhas, colunas);
                            break;
                        case 3:
                            matriz = Matrizes.decrescenteLinhas(matriz);
                            decescenteMenu(matriz, linhas, colunas);
                            break;
                        case 4:
                            matriz = Matrizes.ordemDecrescente(matriz);
                            decescenteMenu(matriz, linhas, colunas);
                            break;
                        case 5:
                            menu2(matriz, linhas, colunas);
                            break;

                        default : System.out.println("Opção inválida! Introduza uma opção válida");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Erro! Introduza uma opção válida");
                    ler.nextLine();
                    ordenarMenu(matriz, linhas, colunas);
                }
            }while(op<1 || op>5);
        }
     
    public static void menuAbrir2 (int [][]matriz, int linhas, int colunas)throws FileNotFoundException{
        int op= 0;
        do{
            try{
                System.out.println("\n1 - Abrir matriz"
                        + "\n2 - Avançar"
                        + "\n3 - Guardar matriz"
                        + "\n0 - Saír");
                op = ler.nextInt();

                switch(op){
                    case 1:
                        abrirMatriz();
                        break;
                    case 2:
                        menu2(matriz, linhas, colunas);
                        break;
                    case 3:
                        System.out.println("Introduza o nome do ficheiro para a sua matriz");
                        ler.nextLine();
                        String ficheiro = ler.nextLine();
                        matrizCarregar.gravarFicheiro(matriz, ficheiro);
                        break;
                    case 0:
                        File file = new File("temp.txt");
                        file.delete();
                        System.exit(0);
                        break;
                    //default : System.out.println("Opção inválida!");
                }
            }catch(InputMismatchException e){
                System.out.println("Opção inválida! Introduza opção válida");
                ler.nextLine();
                abrirMenu();
            }
        }while(op <0 || op >3);
    }
    
    public static void abrirMatriz2()throws FileNotFoundException{
        int op=0;
        int tmp = 0;
        do{
            try{
                System.out.println("\n1 - Introduzir matriz manualmente"
                        + "\n2 - Carregar matriz a partir de ficheiro"
                        + "\n3 - Voltar");
                op = ler.nextInt();

                switch(op){
                    case 1:
                        System.out.println("Introduza o número de linhas da matriz");
                        int linhas = ler.nextInt();
                        System.out.println("Introduza o número de colunas da matriz");
                        int colunas = ler.nextInt();
                        int [][] matriz = criarMatriz(linhas, colunas);
                        menu2(matriz, linhas, colunas);
                        break;
                    case 2:
                        linhas = 0;
                        colunas = 0;
                        ler.nextLine();
                        System.out.println("Introduza o nome da matriz que quer carregar");
                        String ficheiro = ler.nextLine();
                        matrizCarregar.carregarMatriz(ficheiro, linhas, colunas);
                        
                    case 3:
                        abrirMenu();
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Opção invalida! Introduza opção válida");
                ler.nextLine();
                abrirMatriz();
            }
        }while(op<1 || op >3);
    }
}