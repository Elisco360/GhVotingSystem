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


public class DashboardController implements Initializable {
    @FXML private Text name;
    @FXML private ImageView png;
    @FXML private Circle status;
    Image img = new Image(getClass().getResourceAsStream("/pics/Man.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(trackVoter().getName());
        if (trackVoter().getGender().equals("Male")){ png.setImage(img); }
        if (trackVoter().hasVoted()){
            status.setFill(Paint.valueOf("red"));
            status.setStroke(Paint.valueOf("red"));
        }
    }

    public static Voter trackVoter(){
        for(Voter v: Admin.votersRegister){
            if (v.getVOTER_ID() == LoginController.voterID){ return v; }
        }
        return Admin.votersRegister.get(0);
    }
}
