package com.salon;

import com.salon.util.FileHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        
        // Initialise database files and directories
        FileHandler.initialize();

        // Load Splash Screen first
        Parent root = loadFXML("view/fxml/SplashScreen.fxml");
        Scene scene = new Scene(root, 1100, 700);
        
        // Apply global salon-theme stylesheet
        scene.getStylesheets().add(getClass().getResource("salon-theme.css").toExternalForm());
        
        stage.setTitle("SmartSalon - Premium Salon Experience");
        stage.setScene(scene);
        stage.setResizable(true); // Make window resizable
        stage.setMinWidth(900);  // Set minimum width
        stage.setMinHeight(600); // Set minimum height
        stage.show();
    }

    public static void setRoot(String fxmlPath) {
        try {
            Parent root = loadFXML(fxmlPath);
            stage.getScene().setRoot(root);
        } catch (IOException e) {
            System.err.println("Failed to load FXML: " + fxmlPath + ". Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static FXMLLoader getLoader(String fxmlPath) {
        return new FXMLLoader(MainApp.class.getResource(fxmlPath));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
