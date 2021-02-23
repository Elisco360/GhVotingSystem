package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class VotedController implements Initializable {
    @FXML private ImageView nppImg;
    @FXML private ImageView ndcImg;
    @FXML private ImageView gumImg;
    @FXML private ImageView cppImg;
    @FXML private ImageView pppImg;
    private final int position = DashboardController.trackVoter().votedFor();

    Image img = new Image(getClass().getResourceAsStream("/pics/fingerprint.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
                default:
                    break;
            }
        }
    }
}
