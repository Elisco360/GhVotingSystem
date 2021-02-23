package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private BorderPane mainPane;
    @FXML private TextField voterId;
    @FXML private TextField password;
    private String credentials;
    static long voterID;

    @FXML
    public void handleDashboardClick(ActionEvent e){
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("dashboard.fxml");
            mainPane.setCenter(view);
        }else {
            alert();
        }
    }

    @FXML
    public void handleVoteClick(ActionEvent e){
        if (isLoggedIn(credentials) && DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("voted.fxml");
            mainPane.setCenter(view);
        }
        else if (isLoggedIn(credentials) && !DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("vote.fxml");
            mainPane.setCenter(view);
        }else {
            alert();
        }
    }

    @FXML
    public void handleResultsClick(ActionEvent e){
        if (isLoggedIn(credentials) && DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("resultSelection.fxml");
            mainPane.setCenter(view);
        }
        else if (isLoggedIn(credentials) && !DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("resultSelection.fxml");
            mainPane.setCenter(view);
        }else {
            alert();
        }
    }

    @FXML
    public void handleInfoClick(ActionEvent e){
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.
                    getPage("info.fxml");
            mainPane.setCenter(view);
        }else {
            alert();
        }
    }

    @FXML
    public void handleLoginClick(ActionEvent e){
        credentials = voterId.getText()+password.getText();
        LoginController.voterID = Integer.parseInt(voterId.getText());
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("dashboard.fxml");
            mainPane.setCenter(view);
        }else {
            alertLoginFailed();
            voterId.clear();
            password.clear();
        }
    }

    private void alert(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Not logged In");
        a.setHeaderText("Login");
        a.setContentText("Kindly login before you access this portal.\nEnter your details and click the 'LOGIN' button.");
        a.showAndWait();
    }

    private void alertLoginFailed(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Incorrect Credentials");
        a.setHeaderText("Login failed");
        a.setContentText("Incorrect Id or password. Retry.");
        a.showAndWait();
    }

    private boolean isLoggedIn(String credential){
        return Admin.voterCredentials.contains(credential);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}

