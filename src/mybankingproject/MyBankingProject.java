/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankingproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MWIGO-JON-MARK
 */
public class MyBankingProject extends Application
{
    
//    @Override
//    public void start(Stage primaryStage)
//    {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>()
//        {
//            
//            @Override
//            public void handle(ActionEvent event)
//            {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    
    Parent root;
    Scene scene;

    @Override
    public void init() throws IOException
    {
        DatabaseManager.dbCreate();
        root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        scene = new Scene(root);
    }

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Bank Management System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void stop()
    {
//        TO DO CODE HERE
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
