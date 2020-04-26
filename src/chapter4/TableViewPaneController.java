/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jit
 */
public class TableViewPaneController implements Initializable {

  @FXML
    private TextField txtFieldID;
    @FXML
    private TextField txtFieldName;
   @FXML
    private TextField txtFieldMajor;
    @FXML
    private TextField txtFieldGrade;
    @FXML
    private TableColumn<Student, Integer> tcID;
    @FXML
    private TableColumn<Student, String> tcName;
    
    @FXML
    private Button buttonView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonReset;
    @FXML
    private TableView<Student> tableView;
    
    Statement statement;
    @FXML
    private TableColumn<Student, String> tcMajor;
    @FXML
    private TableColumn<Student, Double> tcGrade;
    

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
        tcID.setCellValueFactory(new PropertyValueFactory("id"));
        tcName.setCellValueFactory(new PropertyValueFactory("name"));
        tcMajor.setCellValueFactory(new PropertyValueFactory("Major"));
        tcGrade.setCellValueFactory(new PropertyValueFactory("grade"));
        tableView.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent());
    }    

    @FXML
    private void buttonViewHandle(ActionEvent event) throws Exception{
        ResultSet rs = this.statement.executeQuery("Select * From Employee");
        tableView.getItems().clear();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMajor(rs.getString("major"));
            student.setGrade(rs.getDouble("grade"));
            tableView.getItems().add(student);
        }
    }

    @FXML
    private void buttonAddHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Insert Into Employee values(" + id + ",'" +name + "','" 
                + major + "'," + grade + ")";
        this.statement.executeUpdate(sql);
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String sql = "delete from student where id = " + id + "";
        this.statement.executeUpdate(sql);
        buttonResetHandle(event);
        buttonViewHandle(event);
    }

    @FXML
    private void buttonResetHandle(ActionEvent event) {
        resetControls();
    }
    private void resetControls(){
        txtFieldID.setText("");
        txtFieldName.setText("");
        txtFieldMajor.setText("");
        txtFieldGrade.setText("");
        tableView.getItems().clear();
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) throws Exception{
        Integer id = Integer.parseInt(txtFieldID.getText());
        String name = txtFieldName.getText();
        String major = txtFieldMajor.getText();
        Double grade = Double.parseDouble(txtFieldGrade.getText());
        String sql = "Update Employee Set name='" + name + "', department='" + 
                major + "', salary=" + grade + " Where id=" +id;
        this.statement.executeUpdate(sql);
        
    }
    private void showSelectedStudent(){
        Student student = tableView.getSelectionModel().getSelectedItem();
        if(student != null){
        txtFieldID.setText(String.valueOf(student.getId()));
        txtFieldName.setText(student.getName());
        txtFieldMajor.setText(student.getMajor());
        txtFieldGrade.setText(String.valueOf(student.getGrade()));
        }

    }
    
}
