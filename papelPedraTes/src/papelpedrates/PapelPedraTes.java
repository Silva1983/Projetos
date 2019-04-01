/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papelpedrates;

/**
 *
 * @author ssilv
 */
import java.util.Scanner;
public class PapelPedraTes {

    /**
     * @param args the command line arguments
     */
    public static Scanner ler = new Scanner (System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        int dinheiro = 500;
        jogador(dinheiro);
    }
    public static void jogador(int dinheiro){
        if (dinheiro >0){
            System.out.printf("Dinheiro: " + dinheiro);
            System.out.println("\n\nQuantos queres apostar???");
            int aposta = ler.nextInt();
            while(aposta > dinheiro || aposta <0)  {
                System.out.println("Aposta inválida!! Faça outra aposta");
                aposta = ler.nextInt();
            }
            System.out.println("\n\n1 - Papel"
                    + "\n2 - Pedra"
                    + "\n3 - Tesoura");
            int jog = ler.nextInt();
            System.out.println("\n************************************************************************\n");
            System.out.print("Jogador: ");
            switch(jog){
                case 1: 
                    System.out.print("Papel");
                    break;
                case 2:
                    System.out.print("Pedra");
                    break;
                case 3:
                    System.out.print("Tesoura");
                    break;
            }
            while(jog<1 || jog>3){
                System.out.println("\nJogada inválida!");
                pausa();
                System.out.println("\n1 - Papel"
                    + "\n2 - Pedra"
                    + "\n3 - Tesoura");
                jog = ler.nextInt();
                System.out.println("Jogador: ");
                switch(jog){
                    case 1: 
                        System.out.print("Papel");
                        break;
                    case 2:
                        System.out.print("Pedra");
                        break;
                    case 3:
                        System.out.print("Tesoura");
                        break;
                }
            }
            
            cpu(jog, dinheiro, aposta);
        }else 
            System.exit(0);
    }
    public static void pausa(){
        ler.nextLine();
        System.out.println("\n==============================================================");
        System.out.println("Pressione Enter para continunar");
        ler.nextLine();
        ler.nextLine();
    }
    
    public static void cpu(int jog, int dinheiro, int aposta){
        int max = 3;
        int min = 1;
        int range = max - min + 1;
        
        int cp = (int)(Math.random()* range) + min;
        System.out.print("\nCPU: ");
        switch(cp){
            case 1:
                System.out.print("Papel");
                break;
            case 2:
                System.out.print("Pedra");
                break;
            case 3:
                System.out.print("Tesoura");
                break;
           
        }
        System.out.println("\n\n*********************************************************************\n");
        jogada(cp, jog, dinheiro, aposta);
    }
    
    public static void jogada(int cp, int jog, int dinheiro, int aposta){
        if (jog == cp){
            ler.nextLine();
            empate(dinheiro, aposta);
            
        }else
            if(jog == 1 && cp == 2){
                ler.nextLine();
                ganhar(dinheiro, aposta);
            }else
                if ( jog == 1 && cp == 3){
                    ler.nextLine();
                    perder(dinheiro, aposta);
                }else 
                    if (jog == 2 && cp == 1){
                        ler.nextLine();
                        perder(dinheiro, aposta);
                    }else
                        if (jog == 2 && cp == 3){
                            ler.nextLine();
                            ganhar(dinheiro, aposta);
                        }else
                            if (jog == 3 && cp == 1){
                                ler.nextLine();
                                ganhar(dinheiro, aposta);
                            }else 
                                if (jog == 3 && cp == 2){
                                    ler.nextLine();
                                    perder(dinheiro, aposta);
                                }
    }
    public static void empate (int dinheiro, int aposta) {
        System.out.println("*********************EMPATE!!*********************");
        jogador(dinheiro);
        ler.nextLine();
        pausa();
        
    }
    
    public static void ganhar(int dinheiro, int aposta){
        System.out.println("*********************GANHASTE!!*********************");
        dinheiro = dinheiro + aposta;
        jogador(dinheiro);
        ler.nextLine();
        pausa();
    }
    
    public static void perder(int dinheiro, int aposta){
        System.out.println("*********************PERDESTE!!*********************");
        dinheiro = dinheiro - aposta;
        jogador(dinheiro);
        ler.nextLine();
        pausa();
    }
}
