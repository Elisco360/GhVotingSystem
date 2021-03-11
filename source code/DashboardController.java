package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class is responsible for the functionality of the home user interface or screen
 */
public class DashboardController implements Initializable {
    @FXML private Text name;       //Represents the name of the voter on the interface
    @FXML private ImageView png;   //Represents an avatar of the voter's gender to add aesthetics to the interface
    @FXML private Circle status;   //Represents a colour indication of whether or not a user is eligible to vote
    Image img = new Image(getClass().getResourceAsStream("/pics/Man.png"));  //The image avatar

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(trackVoter().getName()); //sets the name on the screen to the logged in voter's name
        if (trackVoter().getGender().equals("Male")){ png.setImage(img); } //sets avatar according to their gender
        if (trackVoter().hasVoted()){              //sets the voting eligibility of the logged in voter(green default)
            status.setFill(Paint.valueOf("red"));        //red if the voter has already voted
            status.setStroke(Paint.valueOf("red"));
        }
    }

    /**
     * Called to keep track of a voter that logs into the system
     * @return an instance of Voter, the logged in voter
     */
    public static Voter trackVoter(){
        for(Voter v: Admin.votersRegister){
            if (v.getVOTER_ID() == LoginController.voterID){ return v; }
        }
        return Admin.votersRegister.get(0);
    }
}
