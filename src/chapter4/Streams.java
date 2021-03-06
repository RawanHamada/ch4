/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 *
 * @author jit
 */
public class Streams extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
          Pane paneTableView = FXMLLoader.load(getClass().getResource("TableViewPane.fxml"));

  //Pane paneTextArea = FXMLLoader.load(getClass().getResource("TextAreaPane.fxml"));

        Map<String, Pane> mapPanes = new TreeMap<>();
       // mapPanes.put("textArea", paneTextArea);
       mapPanes.put("paneTable", paneTableView);
        Scene scene = new Scene(mapPanes.get("paneTable"));
        primaryStage.setTitle("Streams App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
