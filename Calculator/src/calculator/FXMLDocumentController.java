/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author USER-PC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField Number1Field;
    @FXML
    private TextField Number2Field;
    @FXML
    private TextField ResultField;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandlaAddAction(ActionEvent event) {
      double number1=Double.parseDouble(Number1Field.getText());
        double number2=Double.parseDouble(Number2Field.getText());  //int a = "10";
        double result=number1+number2;
        ResultField.setText("" + result);
        //concatenation..
    }

    @FXML
    private void handleSubtractAction(ActionEvent event) {
        double number1,number2,result;
        number1=Double.parseDouble(Number1Field.getText());
        number2=Double.parseDouble(Number2Field.getText());
        result=number1-number2;
        ResultField.setText("" + result);
    }

    @FXML
    private void handleMultiplyAction(ActionEvent event) {
        double number1,number2,result;
        number1=Double.parseDouble(Number1Field.getText());
        number2=Double.parseDouble(Number2Field.getText());
        result=number1*number2;
        ResultField.setText("" + result);
    }

    @FXML
    private void handleDevideAction(ActionEvent event) {
        double number1,number2,result;
        number1=Double.parseDouble(Number1Field.getText());
        number2=Double.parseDouble(Number2Field.getText());
        result=number1/number2;
         ResultField.setText("" + result);
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        Number1Field.setText("");
        Number2Field.setText("");
        ResultField.setText("");
    }
    
}
