package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class StartView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Thread.currentThread().getName());
        primaryStage.setTitle("HelloJavaFXWorld");
        Button btn = new Button("Start Swing");
        btn.setOnAction(e-> {
            SwingUtilities.invokeLater(()->new HelloSwingWorldApp());
            primaryStage.hide();
        });
        StackPane root=new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }
}
