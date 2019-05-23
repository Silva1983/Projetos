package com.mycompany.brigada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import brigadas.model.brigada;
import java.text.DecimalFormat;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class FXMLController implements Initializable {
    
    private Label label;
    @FXML
    private Button cmdCalcular;
    @FXML
    private Label lbl1N25;
    @FXML
    private Label lbl1N50;
    @FXML
    private Label lbl2N50;
    @FXML
    private Label lbl2N25;
    @FXML
    private Label lbldesconto;
    @FXML
    private TextField txtTotalBrigadas;
    @FXML
    private TextField txt1Nivel25;
    @FXML
    private TextField txt1Nivel50;
    @FXML
    private TextField txt2Nivel50;
    @FXML
    private TextField txt2Nivel25;
    @FXML
    private TextField txtSubsidio;
    @FXML
    private TextField txt1Nivel100;
    @FXML
    private TextField txt2Nivel100;
    @FXML
    private Button cmdLimpar;
    @FXML
    private Label lblTotal;
    @FXML
    private Label lbl1Nivel100;
    @FXML
    private Label lbl2Nivel100;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private brigada b1 = new brigada();
    
    @FXML
    private void cmdCalcular(ActionEvent event) {
        calcularValor();
    }

    @FXML
    private void lbl1N25(MouseEvent event) {
    }

    @FXML
    private void lbl1N50(MouseEvent event) {
    }

    @FXML
    private void lbl2N50(MouseEvent event) {
    }

    @FXML
    private void lbl2N25(MouseEvent event) {
    }

    @FXML
    private void lbldesconto(MouseEvent event) {
    }

    @FXML
    private void txtTotalBrigadas(ActionEvent event) {
    }

    @FXML
    private void txt1Nivel25(ActionEvent event) {
    }

    @FXML
    private void txt1Nivel50(ActionEvent event) {
    }

    @FXML
    private void txt2Nivel50(ActionEvent event) {
    }

    @FXML
    private void txt2Nivel25(ActionEvent event) {
    }

    @FXML
    private void txtSubsidio(ActionEvent event) {
    }

    @FXML
    private void txt1Nivel100(ActionEvent event) {
    }

    @FXML
    private void txt2Nivel100(ActionEvent event) {
        
    }

    @FXML
    private void cmdLimpar(ActionEvent event) {
        limparCampos();
        
    }

    @FXML
    private void lblTotal(MouseEvent event) {
    }

    @FXML
    private void lbl1Nivel100(MouseEvent event) {
    }

    @FXML
    private void lbl2Nivel100(MouseEvent event) {
    }
    
    private void calcularValor(){
       float total = 0;
       float valor = 0;
       
       
        if(!txt1Nivel100.getText().equals("")){ 
        b1.setCalculo50(Integer.parseInt(txt1Nivel100.getText()));
        b1.calcularN1Brigada100(b1.getCalculo50() , b1.N1valor100);
        valor =  b1.calcularN1Brigada100( b1.getCalculo50(), b1.N1valor100);
        //    System.out.println(valor);
        //lbl1Nivel100.setText("" + String.format("%.2f" ,valor));
        //lbl1Nivel100.setText(String.format("%.2f" , b1.calcularN1Brigada100( b1.getCalculo50(), b1.N1valor100)));
        lbl1Nivel100.setText("" + b1.calcularN1Brigada100( b1.getCalculo50(), b1.N1valor100));
        total = total + Float.parseFloat(lbl1Nivel100.getText());
       }
       
       if(!txt2Nivel100.getText().equals("")){
        b1.setCalculo50(Integer.parseInt(txt2Nivel100.getText()));
        b1.calcularN2Brigada100(b1.getCalculo50(), b1.N2valor100);
        lbl2Nivel100.setText("" + (b1.calcularN2Brigada100(b1.getCalculo50(), b1.N2valor100)));
        total = total + Float.parseFloat(lbl2Nivel100.getText());
       }
       
       if(!txt1Nivel25.getText().equals("")){
        b1.setCalculo50(Integer.parseInt(txt1Nivel25.getText()));
        b1.calcularN1Brigada25(b1.getCalculo50(), b1.N1valor25);
        lbl1N25.setText("" + b1.calcularN1Brigada25(b1.getCalculo50(), b1.N1valor25));
        total = total + Float.parseFloat(lbl1N25.getText());
       }
       if(!txt1Nivel50.getText().equals("")){
        b1.setCalculo50(Integer.parseInt(txt1Nivel50.getText()));
        b1.calcularN1Brigada50(b1.getCalculo50(), b1.N1valor50);
        lbl1N50.setText("" + b1.calcularN1Brigada50(b1.getCalculo50(), b1.N1valor50));
        total = total + Float.parseFloat(lbl1N50.getText());
       }
       
       if(!txt2Nivel50.getText().equals("")){
        b1.setCalculo50(Integer.parseInt(txt2Nivel50.getText()));
        b1.calcularN2Brigada50(b1.getCalculo50(), b1.N2valor50);
        lbl2N50.setText("" + b1.calcularN2Brigada50(b1.getCalculo50(), b1.N2valor50));
        total = total + Float.parseFloat(lbl2N50.getText());
       }
       
       if(!txt2Nivel25.getText().equals("")){
        b1.setCalculo50(Integer.parseInt(txt2Nivel25.getText()));
        b1.calcularN2Brigada25(b1.getCalculo50(), b1.N2valor25);
        lbl2N25.setText("" + b1.calcularN2Brigada25(b1.getCalculo50(), b1.N2valor25));
        total = total + Float.parseFloat(lbl2N25.getText());
       }
       
       if (!txtSubsidio.getText().equals("")){
           b1.setCalculo50(Integer.parseInt(txtSubsidio.getText()));
           b1.calcularSubsidio(b1.getCalculo50(), b1.deducao);
           
           lbldesconto.setText(""+  b1.calcularSubsidio(b1.getCalculo50(), b1.deducao));
           total = total + Float.parseFloat(lbldesconto.getText());
       }
       lblTotal.setText("" + total);
       
       int x = 0;
       if (!txt1Nivel100.getText().equals(""))
               x = x + Integer.parseInt(txt1Nivel100.getText());
        
       if (!txt2Nivel100.getText().equals(""))
           x = x + Integer.parseInt((txt2Nivel100.getText()));
       
       if (!txt1Nivel25.getText().equals(""))
           x = x + Integer.parseInt(txt1Nivel25.getText());
       
       if(!txt1Nivel50.getText().equals(""))
           x = x + Integer.parseInt(txt1Nivel50.getText());
       
       if(!txt2Nivel50.getText().equals(""))
           x = x + Integer.parseInt(txt2Nivel50.getText());
       
       if(!txt2Nivel25.getText().equals(""))
           x = x + Integer.parseInt(txt2Nivel25.getText());
       
       System.out.println(x);
       int y = 0;
       if ((txtTotalBrigadas.getText().equals("")))
           txtTotalBrigadas.setText("0");
       y = x - Integer.parseInt(txtTotalBrigadas.getText());
       
       if ( x != Integer.parseInt(txtTotalBrigadas.getText())){
           
           Alert alerta = new Alert(Alert.AlertType.INFORMATION);
           lbl1Nivel100.setText("");
            lbl2Nivel100.setText("");
            lbl1N25.setText("");
            lbl1N50.setText("");
            lbl2N50.setText("");
            lbl2N25.setText("");
            lbldesconto.setText("");
            lblTotal.setText("");
           alerta.setTitle("Aplicação");
           alerta.setHeaderText("Número de brigadas incorreto");
           if(y > 0)
                alerta.setContentText("Tem " + y + " brigadas a mais");
           else
               alerta.setContentText("Tem " + y * (-1) + " brigadas a menos");
           if (alerta.showAndWait().get() == ButtonType.OK){
               alerta.close();
           }
       }
    }
    
    private void limparCampos(){
        txtTotalBrigadas.clear();
        txt1Nivel25.clear();
        txt1Nivel50.clear();
        txt2Nivel50.clear();
        txt2Nivel25.clear();
        txtSubsidio.clear();
        txt1Nivel100.clear();
        txt2Nivel100.clear();
        lbl1Nivel100.setText("");
        lbl2Nivel100.setText("");
        lbl1N25.setText("");
        lbl1N50.setText("");
        lbl2N50.setText("");
        lbl2N25.setText("");
        lbldesconto.setText("");
        lblTotal.setText("");
    }
    
    private Alert criarAlertaErro(Exception ex) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setTitle("Aplicação");
        alerta.setHeaderText("Problemas no arranque da aplicação");
        alerta.setContentText(ex.getMessage());

        return alerta;
    }
}
