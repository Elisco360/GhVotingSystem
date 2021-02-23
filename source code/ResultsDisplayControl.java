package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultsDisplayControl implements Initializable {
    @FXML private PieChart pollingStation;
    @FXML private PieChart district;
    @FXML private PieChart regional;
    @FXML private PieChart national;
    PollingStation ps = DashboardController.trackVoter().getViewChoice();
    ObservableList<PieChart.Data> pollingStationData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getNppResults(), ps.getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getNdcResults(),ps.getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getGumResults(),ps.getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getCppResults(),ps.getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getPppResults(),ps.getPppResults())
            );
    ObservableList<PieChart.Data> districtData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getDistrict().getNppResults(),ps.getDistrict().getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getDistrict().getNdcResults(),ps.getDistrict().getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getDistrict().getGumResults(),ps.getDistrict().getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getDistrict().getCppResults(),ps.getDistrict().getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getDistrict().getPppResults(),ps.getDistrict().getPppResults())
            );
    ObservableList<PieChart.Data> regionalData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+ps.getDistrict().getRegion().getNppResults(),ps.getDistrict().getRegion().getNppResults()),
                    new PieChart.Data("NDC"+":"+ps.getDistrict().getRegion().getNdcResults(),ps.getDistrict().getRegion().getNdcResults()),
                    new PieChart.Data("GUM"+":"+ps.getDistrict().getRegion().getGumResults(),ps.getDistrict().getRegion().getGumResults()),
                    new PieChart.Data("CPP"+":"+ps.getDistrict().getRegion().getCppResults(),ps.getDistrict().getRegion().getCppResults()),
                    new PieChart.Data("PPP"+":"+ps.getDistrict().getRegion().getPppResults(),ps.getDistrict().getRegion().getPppResults())
            );
    ObservableList<PieChart.Data> nationalData =
            FXCollections.observableArrayList(
                    new PieChart.Data("NPP"+":"+National.getNppResults(),National.getNppResults()),
                    new PieChart.Data("NDC"+":"+National.getNdcResults(),National.getNdcResults()),
                    new PieChart.Data("GUM"+":"+National.getGumResults(),National.getGumResults()),
                    new PieChart.Data("CPP"+":"+National.getCppResults(),National.getCppResults()),
                    new PieChart.Data("PPP"+":"+National.getPppResults(),National.getPppResults())
            );


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pollingStation.setData(pollingStationData);
        district.setData(districtData);
        regional.setData(regionalData);
        national.setData(nationalData);
    }

}
