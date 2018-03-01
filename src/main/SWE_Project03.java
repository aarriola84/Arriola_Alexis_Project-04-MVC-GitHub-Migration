package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parking_citation.CitationController;
import parking_citation.CitationModel;
import parking_citation.CitationView;

/**
 *
 * @author Alexis Arriola
 */
public class SWE_Project03 extends Application 
{
    CitationView citationView = new CitationView();
    CitationModel citationModel = new CitationModel();
    CitationController cc = new CitationController(citationModel, citationView);

    public void start(Stage primaryStage) 
    {
        Scene scene = new Scene(citationView, 600, 500);
        
        primaryStage.setTitle("Citation Sytem MVC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
