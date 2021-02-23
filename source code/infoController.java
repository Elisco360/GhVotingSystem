package sample;

import javafx.fxml.Initializable;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class infoController implements Initializable {

    //Desktop desktop = Desktop.getDesktop();
    String ec = "https://www.ec.gov.gh/";
    String eli = "https://www.linkedin.com/in/elijah-kwaku-adutwum-boateng-074733194/";
    String hassan = "https://www.linkedin.com/in/alhassan-hassan-7b2a02194/";
    String nana = "https://www.linkedin.com/in/nana-kofi-boakye-1b8623186/";
    String taiwo = "https://www.linkedin.com/in/taiwo-ogunkeye-aaa013196/";
    String philip = "https://www.linkedin.com/in/philip-amarteyfio-089133196/";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void handleECClick() {
    }
    public void handleEliClick() {
        //desktop.browse(new URI(eli));
    }
    public void handleHassanClick() {
        //desktop.browse(new URI(hassan));
    }
    public void handleNanaClick() throws URISyntaxException, IOException {
//        desktop.browse(new URI(nana));
    }
    public void handleTaiwoClick() throws URISyntaxException, IOException {
//        desktop.browse(new URI(taiwo));
    }
    public void handlePhilipClick() throws URISyntaxException, IOException {
        //desktop.browse(new URI(philip));
    }
}