package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class acts the entry point of the system by allowing a user to login
 */
public class LoginController implements Initializable {
    @FXML private BorderPane mainPane; //Main stage that hosts screens
    @FXML private TextField voterId;   //Graphic element for voter's Id
    @FXML private PasswordField password; //Graphic element for password
    private String credentials; //credentials of the voter
    static long voterID; //Logged in voter's Id

    /**
     * Called to when the home button is clicked to display the home screen
     * @param e represents an action the user performs to call this method (clicking)
     */
    @FXML
    public void handleDashboardClick(ActionEvent e){
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("dashboard.fxml");
            mainPane.setCenter(view);
        }else {
            //Prompts the user to login
            alert();
        }
    }

    /**
     * Called to when the vote button is clicked to display the vote or voted screen(depending on the voter's status)
     * @param e represents an action the user performs to call this method (clicking)
     */
    @FXML
    public void handleVoteClick(ActionEvent e){
        //Opens the vote screen to allow the logged in voter to vote
        if (isLoggedIn(credentials) && DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("Voted.fxml");
            mainPane.setCenter(view);
        }
        //Opens the voted screen where user is not allowed to vote again
        else if (isLoggedIn(credentials) && !DashboardController.trackVoter().hasVoted()){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("Vote.fxml");
            mainPane.setCenter(view);
        }else {
            //Prompts the user to login
            alert();
        }
    }

    /**
     * Called to when the results button is clicked to display the resultSelection screen
     * @param e represents an action the user performs to call this method (clicking)
     */
    @FXML
    public void handleResultsClick(ActionEvent e){
        //checks if user has logged in and is eligible to vote
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("resultSelection.fxml");
            mainPane.setCenter(view);
        }else {
            //prompts the user to login
            alert();
        }
    }

    /**
     * Called to when the info button is clicked to display the info screen
     * @param e represents an action the user performs to call this method (clicking)
     */
    @FXML
    public void handleInfoClick(ActionEvent e){
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("info.fxml");
            mainPane.setCenter(view);
        }else {
            alert();
        }
    }

    /**
     * Called to verify and grant user access to the full functionalities of the system
     * @param e represents an action the user performs to call this method (clicking)
     */
    @FXML
    public void handleLoginClick(ActionEvent e){
        credentials = voterId.getText()+password.getText(); //getting the credentials from the user interface
        LoginController.voterID = Integer.parseInt(voterId.getText()); //keeps the Id of the voter trying to login

        //If correct credentials are entered, the default screen is loaded
        if (isLoggedIn(credentials)){
            FxmlLoader ldr = new FxmlLoader();
            Pane view = ldr.getPage("dashboard.fxml");
            mainPane.setCenter(view);
        }else {
            //User is prompted and given another opportunity to try again
            alertLoginFailed();
            voterId.clear();
            password.clear();
        }
    }

    /**
     * Prompts the user to login before certain functionalities can be accessed
     */
    private void alert(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Not logged In");
        a.setHeaderText("Login");
        a.setContentText("Kindly login before you access this portal." +
                         "\nEnter your details and click the 'LOGIN' button.");
        a.showAndWait();
    }

    /**
     * Prompts the user about entry of wrong credentials
     */
    private void alertLoginFailed(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Incorrect Credentials");
        a.setHeaderText("Login failed");
        a.setContentText("Incorrect Id or password\nRetry.");
        a.showAndWait();
    }

    /**
     * Called to verify credentials entered by the user
     * @param credential represents the combination of voter's Id and password
     * @return true if credentials are correct and false if otherwise
     */
    private boolean isLoggedIn(String credential){
        return Admin.voterCredentials.contains(credential);
    }

    /**
     * Called to initialize a controller after its root element has been completely processed.
     * @param url represents the location used to resolve relative paths for the root object, or null if the location is not known.
     * @param resourceBundle represents the resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}

