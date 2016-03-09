import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
/**
 * @author Leela Prabhu (S1471625)
 *
 */
public class MainProgram extends Application {

	public void start(Stage stage) {
		
		try {

			FXMLLoader fxmlLoader = new FXMLLoader();
			String viewerFxml = "WorldViewer.fxml"; //Name of the FXML file linked to viewer
			AnchorPane page = (AnchorPane) fxmlLoader.load(this.getClass().getResource(viewerFxml).openStream());
			Scene scene = new Scene(page);
			stage.setScene(scene);
			
			PhotoViewer viewer = (Viewer) fxmlLoader.getController();     
			PhotoController controller= new WorldController(viewer);
			viewer.initialise(controller); //Pass the controller to the viewer
			controller.Initialise(); // Initialize the controller

			stage.show(); //Display
        
		} catch (IOException ex) {
		   Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
		   System.exit(1);
		}
	}
	
    public static void main(String args[]) {
     	launch(args);
     	System.exit(0);
    }
}