package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is responsible for providing functionality of the window that displays the results
 */
public class ResultsDisplayControl implements Initializable {
    @FXML private PieChart pollingStation;  //Represents the graphic element for a polling station pie chart
    @FXML private PieChart district;        //Represents the graphic element for a district pie chart
    @FXML private PieChart regional;        //Represents the graphic element for a regional pie chart
    @FXML private PieChart national;        //Represents the graphic element for a national pie chart
    PollingStation ps = DashboardController.trackVoter().getViewChoice();  //Represents the polling station the user wants to view

    //Generating a list of the results of the respective political parties at the polling station level
    ObservableList<PieChart.Data> pollingStationData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getNppResults(), ps.getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getNdcResults(),ps.getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getGumResults(),ps.getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getCppResults(),ps.getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getPppResults(),ps.getPppResults()),
                    new PieChart.Data("APC"+":"+ps.getApcResults(),ps.getApcResults())
            );
    //Generating a list of the results of the respective political parties at the district level
    ObservableList<PieChart.Data> districtData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getDistrict().getNppResults(),ps.getDistrict().getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getDistrict().getNdcResults(),ps.getDistrict().getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getDistrict().getGumResults(),ps.getDistrict().getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getDistrict().getCppResults(),ps.getDistrict().getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getDistrict().getPppResults(),ps.getDistrict().getPppResults()),
                    new PieChart.Data("APC"+":"+ps.getDistrict().getApcResults(),ps.getDistrict().getApcResults())
            );
    //Generating a list of the results of the respective political parties at the regional level
    ObservableList<PieChart.Data> regionalData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getDistrict().getRegion().getNppResults(),ps.getDistrict().getRegion().getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getDistrict().getRegion().getNdcResults(),ps.getDistrict().getRegion().getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getDistrict().getRegion().getGumResults(),ps.getDistrict().getRegion().getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getDistrict().getRegion().getCppResults(),ps.getDistrict().getRegion().getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getDistrict().getRegion().getPppResults(),ps.getDistrict().getRegion().getPppResults()),
                    new PieChart.Data("APC"+":"+ps.getDistrict().getRegion().getApcResults(),ps.getDistrict().getRegion().getApcResults())
            );
    //Generating a list of the results of the respective political parties at the national level
    ObservableList<PieChart.Data> nationalData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+National.getNppResults(),National.getNppResults()),
                    new PieChart.Data("NDC"+":"+National.getNdcResults(),National.getNdcResults()),
                    new PieChart.Data("GUM"+":"+National.getGumResults(),National.getGumResults()),
                    new PieChart.Data("CPP"+":"+National.getCppResults(),National.getCppResults()),
                    new PieChart.Data("PPP"+":"+National.getPppResults(),National.getPppResults()),
                    new PieChart.Data("APC"+":"+National.getApcResults(),National.getApcResults())
            );


    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pollingStation.setData(pollingStationData);
        district.setData(districtData);
        regional.setData(regionalData);
        national.setData(nationalData);
    }

}
