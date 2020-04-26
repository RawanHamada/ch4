/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jit
 */
public class RegisterController implements Initializable {

  
    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtCourseId;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonClear;
    @FXML
    private TextField txtSemester;

    Statement statement;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =
               DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/user-friendly?serverTimezone=UTC",
                        "root", "");
            this.statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }    

    @FXML
    private void buttonRegisterHandle(ActionEvent event) throws Exception {
         Integer studentId = Integer.parseInt(txtStudentId.getText());
        Integer courseId = Integer.parseInt(txtCourseId.getText());
        String semester = txtSemester.getText();
        
        String sql = "Insert Into Registration values(" + studentId + ",'" +courseId + "','" 
                + semester + ")";
               this.statement.executeUpdate(sql);
               resetControls();
    }

    @FXML
    private void buttonClearHandle(ActionEvent event) {
        resetControls();
    }
    private void resetControls(){
        txtStudentId.setText("");
        txtCourseId.setText("");
        txtSemester.setText("");
      
    }

    
    
}
