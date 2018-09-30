/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
    double firstNumber;
    double secondNumber;
    String operation;
    
   @FXML
    private TextField textField;
    @FXML
    private Label label;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleOneAction(ActionEvent event) {
        String oldText=textField.getText();
        String newText=oldText+"1";
        textField.setText(newText);
    }

    @FXML
    private void handleDigitAction(ActionEvent event) {
 //       int a=(int)2.56;   type casting.
        Button button=(Button) event.getSource();
        String digit=button.getText();
        String oldText=textField.getText();
        String newText=oldText+digit;
        textField.setText(newText);
        
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        textField.setText("");
    }

    @FXML
    private void handleAClearAction(ActionEvent event) {
        textField.setText("");
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        firstNumber=Double.parseDouble(textField.getText());
        operation="ADD";
        textField.setText("");
    }

    @FXML
    private void handleEqualAction(ActionEvent event) {
        double result=0.0;
        secondNumber=Double.parseDouble(textField.getText());
        
        if(operation.equals("ADD"))
            result=firstNumber+secondNumber;
        if(operation.equals("SUB"))
            result=firstNumber-secondNumber;
        if(operation.equals("VAAG"))
            result=firstNumber/secondNumber;
        if(operation.equals("MULTIPLY"))
            result=firstNumber*secondNumber;
        textField.setText(""+result);
    }

    @FXML
    private void handleSubAction(ActionEvent event) {
        firstNumber=Double.parseDouble(textField.getText());
        operation="SUB";
        textField.setText("");
    }

    @FXML
    private void handleMAction(ActionEvent event) {
         firstNumber=Double.parseDouble(textField.getText());
        operation="MULTIPLY";
        textField.setText("");
   
    }

    @FXML
    private void handleVagAction(ActionEvent event) {
         firstNumber=Double.parseDouble(textField.getText());
        operation="VAAG";
        textField.setText("");
   
    }

    @FXML
    private void HandleOaction(ActionEvent event) {
        String oldText=textField.getText();
        String newText=oldText+"0";
        textField.setText(newText);
    }

    @FXML
    private void handleDotAction(ActionEvent event) {
        String oldText=textField.getText();
        String newText=oldText+".";
        textField.setText(newText);
    }
    
}
