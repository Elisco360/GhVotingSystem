package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class VotedController implements Initializable {
    @FXML private ImageView nppImg;    //Represents a vote for NPP
    @FXML private ImageView ndcImg;    //Represents a vote for NDC
    @FXML private ImageView gumImg;    //Represents a vote for GUM
    @FXML private ImageView cppImg;    //Represents a vote for CPP
    @FXML private ImageView pppImg;    //Represents a vote for PPP
    @FXML private ImageView apcImg;    //Represents a vote for APC

    //Represents the party position who the voter has voted for
    private final int position = DashboardController.trackVoter().votedFor();

    Image img = new Image(getClass().getResourceAsStream("/pics/fingerprint.png")); //Thumb print image

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Checks the party voted for and sets its image to a the thumb print
        if(DashboardController.trackVoter().hasVoted()){
            switch (position){
                case 1:
                    nppImg.setImage(img);
                    break;
                case 2:
                    ndcImg.setImage(img);
                    break;
                case 3:
                    gumImg.setImage(img);
                    break;
                case 4:
                    cppImg.setImage(img);
                    break;
                case 5:
                    pppImg.setImage(img);
                    break;
                case 6:
                    apcImg.setImage(img);
                    break;
                default:
                    break;
            }
        }
    }
}
