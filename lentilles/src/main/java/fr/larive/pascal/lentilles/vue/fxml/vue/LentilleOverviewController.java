package fr.larive.pascal.lentilles.vue.fxml.vue;

import fr.larive.pascal.lentilles.vue.fxml.FXMLApp;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LentilleOverviewController {

	@FXML
	private TableView<LentilleFXML> lentilleTable;
	@FXML
	private TableColumn<LentilleFXML, String> referenceColumn;
	@FXML
	private TableColumn<LentilleFXML, String> matiereColumn;
	@FXML
	private TableColumn<LentilleFXML, String> segmentColumn;
	@FXML
	private TableColumn<LentilleFXML, String> periodiciteColumn;
	@FXML
	private TableColumn<LentilleFXML, String> prixColumn;
	
	private FXMLApp app;
	
	public LentilleOverviewController() {
		
	}
	
	@FXML
	private void initialize()
	{
		referenceColumn.setCellValueFactory(cellData->cellData.getValue().referenceProperty());
		matiereColumn.setCellValueFactory(cellData->cellData.getValue().matiereProperty());
		segmentColumn.setCellValueFactory(cellData->cellData.getValue().segmentProperty());
		periodiciteColumn.setCellValueFactory(cellData->cellData.getValue().periodiciteProperty());
		prixColumn.setCellValueFactory(cellData->cellData.getValue().prixProperty());
	}
	
	public void setFXMLApp(FXMLApp app)
	{
		this.app = app;
		
		lentilleTable.setItems(app.getLentilleData());
	}

}
