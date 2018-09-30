/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.database;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author USER-PC
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField cgpaField;
    
    private ObservableList<Student> studentList;
    
    private int currentIndex;
    @FXML
    private ListView<Student> studentListView;
    @FXML
    private Label noticeBoard;
    @FXML
    private ComboBox<Student> comboBox;
    @FXML
    private TextField searchField;
    @FXML
    private Label label;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> studentIdColumn;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, Number> cgpaColumn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentIndex=0;
        studentList=FXCollections.observableArrayList();
        
        final String DBNAME="Studentinfodb";
        final String USERNAME="root";
        final String HOSTNAME="127.0.0.1";
        final String PASSWORD="1614";
        final String DBURL="jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        studentListView.setItems(studentList);
        comboBox.setItems(studentList);
        tableView.setItems(studentList);
        
        studentIdColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentId()));
        studentNameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStudentName()));   
        cgpaColumn.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCgpa()));
        
       try {
           Connection connection=DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
           Statement statement=connection.createStatement();
           String query="select * from studentinfo;";
           statement.executeQuery(query);
           ResultSet resultSet=statement.executeQuery(query);
           
           while(resultSet.next()){
               Student student=new Student(resultSet.getString("studentId"),
               resultSet.getString("studentName"),
               resultSet.getDouble("cgpa"));
               studentList.add(student);
          
           }
           if(studentList.size()>0){
               display(currentIndex);
             }
           System.out.println("Connected");
           statement.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }    
    
    private void reset(){
        idField.setText(null);
        nameField.setText(null);
        cgpaField.setText(null);
        noticeBoard.setText(null);
        searchField.setText(null);
    }
    
    private void display(int currentIndex){
         idField.setText(studentList.get(currentIndex).getStudentId());
         nameField.setText(studentList.get(currentIndex).getStudentName());
         cgpaField.setText("" + studentList.get(currentIndex).getCgpa());
       
    }

    @FXML
    private void handleSaveAction(ActionEvent event)  {
        
        String id=idField.getText();
        String name=nameField.getText();
        double cgpa=Double.parseDouble(cgpaField.getText());
        
        final String DBNAME="Studentinfodb";
        final String USERNAME="root";
        final String HOSTNAME="127.0.0.1";
        final String PASSWORD="1614";
        final String DBURL="jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        
       try {
           Connection connection=DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
           Statement statement=connection.createStatement();
           String query="insert into studentinfo values('"+ id +"','" + name +"'," + cgpa + ");";
           statement.executeUpdate(query);
           System.out.println("Connected");
           statement.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
       }
       reset();
       noticeBoard.setText("Item Saved");
    }

    @FXML
    private void handlePreviousAction(ActionEvent event) {
        if(currentIndex>0){
        currentIndex--;
        noticeBoard.setText("Current Index: " + (currentIndex+1));
        }
        else{
            noticeBoard.setText("We are at the beggining.");
        }
        display(currentIndex);
        
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
        if(currentIndex<studentList.size()-1){
        currentIndex++;
        noticeBoard.setText("Current Index: " + (currentIndex+1));
        }
        else{
            noticeBoard.setText("We are at the end.");
        }
        display(currentIndex);
           }

    @FXML
    private void handleResetAction(ActionEvent event) {
        reset();
    }

    @FXML
    private void handleComboBoxAction(ActionEvent event) {
      currentIndex=comboBox.getSelectionModel().getSelectedIndex();
      display(currentIndex);
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
        String key=searchField.getText();
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getStudentId().equals(key)){
                currentIndex=i;
                noticeBoard.setText("Item found at index " + (currentIndex+1) );
                break;
            }
            else{
                noticeBoard.setText("Item is not found.");
            }
        }
        display(currentIndex);
        
    }

    @FXML
    private void handleDeleteAction(ActionEvent event) {
        String id=idField.getText();
        
        final String DBNAME="Studentinfodb";
        final String USERNAME="root";
        final String HOSTNAME="127.0.0.1";
        final String PASSWORD="1614";
        final String DBURL="jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        
        try {
            Connection connection=DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            Statement statement=connection.createStatement();
            String query="delete from studentinfo where studentId = "+id+" ";
            statement.executeUpdate(query);
            
            reset();
            noticeBoard.setText("Item deleted");
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         }

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        currentIndex=studentListView.getSelectionModel().getSelectedIndex();
        display(currentIndex);
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());

        final String HOSTNAME = "127.0.0.1";
        final String DBNAME = "studentinfodb";
        final String USERNAME = "root";
        final String PASSWORD = "1614";
        final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;
        
        try {
            Connection connection=DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            Statement statement=connection.createStatement();
            String query="update studentinfo set studentName= '"+name+"',cgpa="+cgpa+" where studentId="+id+";";
            statement.executeUpdate(query);
            
            Student student=new Student(id,name,cgpa);
            studentList.set(currentIndex, student);
            
             } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
