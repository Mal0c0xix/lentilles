package fr.larive.pascal.lentilles.vue.fxml.vue;

import java.util.List;

import fr.larive.pascal.lentilles.controleur.Manager;
import fr.larive.pascal.lentilles.modele.metier.Lentille;
import fr.larive.pascal.lentilles.utilitaires.Conversion;
import fr.larive.pascal.lentilles.vue.fxml.FXMLApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
	@FXML
	private ComboBox matiereBox;
	@FXML
	private ComboBox segmentBox;
	@FXML
	private ComboBox periodiciteBox;
	@FXML
	private ComboBox prixBox;
    @FXML
    private Button filterButton;
	

    private Boolean mat, seg, per, pri;

    private String parts[];

    private ObservableList<LentilleFXML> masterData = FXCollections.observableArrayList();
	
	private FXMLApp app;
	
	public LentilleOverviewController() {
		List<Lentille> tmp = Manager.getInstance().getInfos();
		for(Lentille l : tmp)
			masterData.add(Conversion.lentilleToFXML(l));
		
		mat = seg = per = pri = false;
	}
	
	@FXML
	private void initialize()
	{
		referenceColumn.setCellValueFactory(cellData->cellData.getValue().referenceProperty());
		matiereColumn.setCellValueFactory(cellData->cellData.getValue().matiereProperty());
		segmentColumn.setCellValueFactory(cellData->cellData.getValue().segmentProperty());
		periodiciteColumn.setCellValueFactory(cellData->cellData.getValue().periodiciteProperty());
		prixColumn.setCellValueFactory(cellData->cellData.getValue().prixProperty());
		
		//Wrap the ObservableList in a FilteredList (initially display all data)
        FilteredList<LentilleFXML> filteredData = new FilteredList<>(masterData, p -> true);

        //Set the filter Predicate whenever the filter change
        filterButton.setOnAction(event -> {
            String filtre = matiereBox.getValue().toString() + "-" + segmentBox.getValue().toString() + "-" + periodiciteBox.getValue().toString() + "-" +
                    prixBox.getValue().toString();

            parts = filtre.split("-");

            filteredData.setPredicate(lentille -> {
                // If filter text is empty, display all lens.
                if (filtre.isEmpty()) {
                    return true;
                }

                mat = parts[0].equals("Matière") || lentille.getMatiere().toLowerCase().equals(parts[0].toLowerCase());

                seg = parts[1].equals("Segment") || lentille.getSegment().toLowerCase().equals(parts[1].toLowerCase());

                per = parts[2].equals("Périodicité") || lentille.getPeriodicite().toLowerCase().equals(parts[2].toLowerCase());

                pri = parts[3].equals("Prix") || lentille.getPrix().toLowerCase().equals(parts[3].toLowerCase());

                return  (mat && seg && per && pri);


            });
        });

        //Wrap the FilteredList in a SortedList
        SortedList<LentilleFXML> sortedData = new SortedList<>(filteredData);

        //Bind the SortedList comparator to the TableView Comparator
        sortedData.comparatorProperty().bind(lentilleTable.comparatorProperty());

        //Add sorted (and filtered) data to the table
        lentilleTable.setItems(sortedData);
	}

	public void setFXMLApp(FXMLApp fxmlApp) {
		this.app = fxmlApp;
	}
	

}
