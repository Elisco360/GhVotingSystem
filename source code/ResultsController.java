package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    //Graphic element to allow selection of polling station
    @FXML private ComboBox<PollingStation> stations;

    //Graphic element to display the corresponding district of the selected polling station
    @FXML private TextField districts;

    //Graphic element to display the corresponding region of the selected polling station
    @FXML private TextField regions;

    //Graphic element to indicate the eligibility of the user to vote
    @FXML private Circle status;

    //Sets the list of polling stations to be displayed on the user interface
    ObservableList<PollingStation> pollingStations = FXCollections.observableArrayList(Admin.pollingStations);

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (DashboardController.trackVoter().hasVoted()){
            status.setFill(Color.rgb(255,0,0));
            status.setStroke(Color.rgb(255,0,0));
        }
        stations.setItems(pollingStations);
    }

    /**
     * Called to set the district and region fields to the corresponding polling station
     */
    public void handleStations(){
        PollingStation pollingStation = stations.getValue();
        districts.setText(pollingStation.getDistrict().getDistrictName());
        regions.setText(pollingStation.getDistrict().getRegion().getRegionName());
        DashboardController.trackVoter().setViewChoice(pollingStation);
    }

    /**
     * Called to display the result window
     * @param e represents an action performed by the user(clicking)
     * @throws IOException to catch any input and output errors
     */
    public void handleViewResults(ActionEvent e) throws IOException {
        if(stations.getValue() != null){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("displayResults.fxml"));
            stage.setTitle("Results");
            stage.setScene(new Scene(root));
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
        }else {
            //Prompt the user to select a polling station
            alert();
        }

    }

    /**
     * An alert to prompt the user to choose a polling station before they can access the results
     */
    private void alert(){
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setTitle("Null Selection");
        a.setHeaderText("No Polling Station Selected");
        a.setContentText("Kindly select a polling station to enable access to results.");
        a.showAndWait();
    }
}
