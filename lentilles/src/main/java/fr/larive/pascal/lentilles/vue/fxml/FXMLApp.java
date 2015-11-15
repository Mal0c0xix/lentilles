package fr.larive.pascal.lentilles.vue.fxml;

import java.io.IOException;
import java.util.List;

import fr.larive.pascal.lentilles.controleur.Manager;
import fr.larive.pascal.lentilles.modele.metier.Lentille;
import fr.larive.pascal.lentilles.utilitaires.Conversion;
import fr.larive.pascal.lentilles.vue.fxml.vue.LentilleFXML;
import fr.larive.pascal.lentilles.vue.fxml.vue.LentilleOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXMLApp extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<LentilleFXML> lentilleData = FXCollections.observableArrayList();
    
    public FXMLApp() {
		
    	List<Lentille> tmp = Manager.getInstance().getInfos();
    	for(Lentille l : tmp)
    		lentilleData.add(Conversion.lentilleToFXML(l));
    	
	}
    
    public ObservableList<LentilleFXML> getLentilleData()
    {
    	return lentilleData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Lentilles");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("LentillesOverview.fxml"));
            AnchorPane lentillesOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(lentillesOverview);
            
            LentilleOverviewController controller = loader.getController();
            controller.setFXMLApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
