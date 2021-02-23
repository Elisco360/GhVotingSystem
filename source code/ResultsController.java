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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    @FXML private ComboBox<PollingStation> stations;
    @FXML private TextField districts;
    @FXML private TextField regions;
    @FXML private Circle status;
    private PollingStation pollingStation;
    ObservableList<PollingStation> pollingStations = FXCollections.observableArrayList(Admin.pollingStations);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (DashboardController.trackVoter().hasVoted()){
            status.setFill(Paint.valueOf(String.valueOf(Color.rgb(255,0,0))));
            status.setStroke(Paint.valueOf("RED"));
        }
        stations.setItems(pollingStations);
    }

    public void handleStations(){
        pollingStation = stations.getValue();
        districts.setText(pollingStation.getDistrict().getDistrictName());
        regions.setText(pollingStation.getDistrict().getRegion().getRegionName());
        DashboardController.trackVoter().setViewChoice(pollingStation);
    }

    public void handleViewResults(ActionEvent e) throws IOException {
        if(stations.getValue() != null){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("displayResults.fxml"));
            stage.setTitle("Results");
            stage.setScene(new Scene(root));
            stage.resizableProperty().setValue(Boolean.FALSE);
            stage.show();
        }else {
            alert();
        }

    }

    private void alert(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Null Selection");
        a.setHeaderText("No Polling Station Selected");
        a.setContentText("Kindly select a polling station to enable access to results.");
        a.showAndWait();
    }
}
