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

/**
 * This class is responsible for providing functionality of the voter interface
 */
public class VoteController implements Initializable {
    @FXML private RadioButton npp;    //Represents selection choice for NPP
    @FXML private RadioButton ndc;    //Represents selection choice for NDC
    @FXML private RadioButton gum;    //Represents selection choice for GUM
    @FXML private RadioButton cpp;    //Represents selection choice for CPP
    @FXML private RadioButton ppp;    //Represents selection choice for PPP
    @FXML private RadioButton apc;    //Represents selection choice for APC
    @FXML private Button submit;      //Represents button for choice approval
    @FXML private ImageView nppImg;   //Represents a vote for NPP
    @FXML private ImageView ndcImg;   //Represents a vote for NDC
    @FXML private ImageView gumImg;   //Represents a vote for GUM
    @FXML private ImageView cppImg;   //Represents a vote for CPP
    @FXML private ImageView pppImg;   //Represents a vote for PPP
    @FXML private ImageView apcImg;   //Represents a vote for APC
    Image img = new Image(getClass().getResourceAsStream("/pics/fingerprint.png"));  //Thumb print image
    private final File votedList = new File("voted.txt");   //List of voters who have voted

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            votedList.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called to provided the functionality that shows that a voter has voted, thus, updating results and adding the
     * voter to the voted list. It also handles the user interface response when a user casts their vote
     * @param e represents an action performed by the user (Clicking)
     */
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
            apc.setVisible(false);
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
            apc.setVisible(false);
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
            apc.setVisible(false);
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
            apc.setVisible(false);
            submit.setVisible(false);
            cppImg.setImage(img);
        }
        else if(ppp.isSelected()){
            DashboardController.trackVoter().castVote(5);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            apc.setVisible(false);
            submit.setVisible(false);
            pppImg.setImage(img);
        }
        else if(apc.isSelected()){
            DashboardController.trackVoter().castVote(6);
            recordVoter();
            updateVotes(DashboardController.trackVoter().getPollingStation().getResults());
            npp.setVisible(false);
            ndc.setVisible(false);
            gum.setVisible(false);
            cpp.setVisible(false);
            ppp.setVisible(false);
            apc.setVisible(false);
            submit.setVisible(false);
            apcImg.setImage(img);
        }
    }

    /**
     * This method writes into the voted list the id and candidate who was voted for by a voter
     */
    public void recordVoter(){
        try {
            FileWriter writer = new FileWriter(votedList, true);
            Voter currentVoter = DashboardController.trackVoter();
            writer.write(currentVoter.getVOTER_ID()+","+currentVoter.getCandidate()+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called to read the results sheet and add one vote for the candidate who has been voted
     * @param file represents the particular results sheet to be updated
     */
    public void updateVotes(File file){
        try{
            FileWriter writer = new FileWriter(file, false);
            Voter currentVoter = DashboardController.trackVoter();
            int[] votes = currentVoter.getPollingStation().readResults(currentVoter.getPollingStation().getResults());
            String[] values = new String[6];
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
                case 6:
                    votes[5] = votes[5]+1;
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
