/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monthlybudgtplanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
   
    @FXML
    private TextField entertainmentField;
    @FXML
    private TextField othersField;
    @FXML
    private TextField totalField;
    @FXML
    private TextField differenceField;
    @FXML
    private TextField incomeField;
    @FXML
    private TextField houseRentField;
    @FXML
    private TextField EatingField;
    
    @FXML
    private TextField TransportField;
    @FXML
    private TextField CellField;
    
    int number1 = 0;
    int number2 = 0;
    int number3 = 0;
    int number4 = 0;
    int number5 = 0;
    int number6 = 0;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void handleTotalAction(ActionEvent event) {
        
     
       number1 = Integer.parseInt(houseRentField.getText());
       number2 = Integer.parseInt(EatingField.getText());
       number3 = Integer.parseInt(TransportField.getText());
       number4 = Integer.parseInt(CellField.getText());
       number5 = Integer.parseInt(entertainmentField.getText());
       number6 = Integer.parseInt(othersField.getText());
       
       int total = number1 + number2 + number3 + number4 + number5 + number6;
       totalField.setText("" + total);
        
                
                }               
    @FXML
    private void handleDifferenceAction(ActionEvent event) {
        number1 = Integer.parseInt(incomeField.getText());
        number2 = Integer.parseInt(totalField.getText());
        int result = number1 - number2;
        differenceField.setText("" + result);
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        entertainmentField.setText("");
        othersField.setText("");
        totalField.setText("");
        differenceField.setText("");
        incomeField.setText("");
        houseRentField.setText("");
        EatingField.setText("");
        TransportField.setText("");
        CellField.setText("");
    }
    
}
