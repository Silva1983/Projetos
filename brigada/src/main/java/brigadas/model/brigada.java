/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brigadas.model;

/**
 *
 * @author ssilv
 */

public class brigada {
    private int calculo25;
    private int calculo50;
    
    public static float N1valor25 = 13.55f;
    public static float N1valor50 = 26.10f;
    public static float N2valor50 = 28.70f;
    public static float N2valor25 = -41.85f;
    public static float N1valor100 = -50.2f;
    public static float N2valor100 = 43.39f;
    
    public static float deducao = -40.77f;
    
    private static int CALCULOS25_POR_OMISSAO = 0;
    private static int CALCULOS50_POR_OMISSAO = 0;
    
    public brigada(){
        this.calculo25 = CALCULOS25_POR_OMISSAO;
        this.calculo50 = CALCULOS50_POR_OMISSAO;
    }
    public brigada(int  calculo25, int calculo50 ){
        this.calculo25 = calculo25;
        this.calculo50 = 0;
    }

    public int getCalculo25() {
        return calculo25;
    }

    public void setCalculo25(int calculo25) {
        this.calculo25 = calculo25;
    }

    public int getCalculo50() {
        return calculo50;
    }

    public void setCalculo50(int calculo50) {
        this.calculo50 = calculo50;
    }
    
    
    public float calcularN1Brigada25(int calculo25, float N1valor25){
        return calculo25 * N1valor25;
    }
    
    public float calcularN1Brigada50(int calculo50, float N1valor50){
        return  calculo50 * N1valor50;
    }
    
    public float calcularN2Brigada25 (int calculo25, float N2valor25){
        return calculo25 * N2valor25;
    }
    
    public float calcularN2Brigada50(int calculo50, float N2valor50){
        return calculo50 * N2valor50;
    }
    
    public float calcularN1Brigada100(int calculo100, float N1valor100){
        return calculo100 * N1valor100;
    }
    
    public float calcularN2Brigada100(int calculo100, float N2valor100){
        return calculo100 * N2valor100;
    }
    
    public float calcularSubsidio(int calculo50, float deducao){
      
        return calculo50 * deducao;
    }
    public float getTotal(){
        return this.calcularN1Brigada100(calculo50, N1valor100) + this.calcularN1Brigada25(calculo50, N1valor25) + this.calcularN1Brigada50(calculo50, N1valor50) + this.calcularN2Brigada100(calculo50, N2valor100) + this.calcularN2Brigada25(calculo50, N2valor25)+ this.calcularN2Brigada50(calculo50, N2valor50) + this.calcularSubsidio(calculo50, deducao);
    }
}

