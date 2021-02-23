package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VoteController implements Initializable {
    @FXML private RadioButton npp;
    @FXML private RadioButton ndc;
    @FXML private RadioButton gum;
    @FXML private RadioButton cpp;
    @FXML private RadioButton ppp;
    @FXML private Button submit;
    @FXML private ImageView nppImg;
    @FXML private ImageView ndcImg;
    @FXML private ImageView gumImg;
    @FXML private ImageView cppImg;
    @FXML private ImageView pppImg;
    Image img = new Image(getClass().getResourceAsStream("/pics/fingerprint.png"));
    private final File votedList = new File("voted.txt");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void trackVote(ActionEvent e) {
        if(npp.isSelected()){
            DashboardController.trackVoter().castVote(1);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            submit.setVisible(false);
            nppImg.setImage(img);
        }
        else if(ndc.isSelected()){
            DashboardController.trackVoter().castVote(2);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            submit.setVisible(false);
            ndcImg.setImage(img);
        }
        else if(gum.isSelected()){
            DashboardController.trackVoter().castVote(3);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            submit.setVisible(false);
            gumImg.setImage(img);
        }
        else if(cpp.isSelected()){
            DashboardController.trackVoter().castVote(4);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            submit.setVisible(false);
            cppImg.setImage(img);
        }else if(ppp.isSelected()){
            DashboardController.trackVoter().castVote(5);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            submit.setVisible(false);
            pppImg.setImage(img);
        }
    }



    public void recordVoter(){
        try {
            FileWriter writer = new FileWriter(votedList, true);
            for (Voter v: DashboardController.trackVoter().getPollingStation().voted) {
                writer.write(v.getVOTER_ID()+","+DashboardController.trackVoter().getCandidate()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateVotes(File file){
        try{
            FileWriter writer = new FileWriter(file, false);
            int[] votes = DashboardController.trackVoter().getPollingStation().pinkSheet;
            String[] values = new String[5];
            switch (DashboardController.trackVoter().votedFor()){
                case 1:
                    votes[0] = votes[0]+1;
                    break;
                case 2:
                    votes[1] = votes[1]+1;
                    break;
                case 3:
                    votes[2] = votes[2]+1;
                    break;
                case 4:
                    votes[3] = votes[3]+1;
                    break;
                case 5:
                    votes[4] = votes[4]+1;
                    break;
                default:
                    break;
            }
            for (int i = 0; i < votes.length; i++){ values[i] = String.valueOf(votes[i]); }
            writer.write(String.join(",", values));
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
