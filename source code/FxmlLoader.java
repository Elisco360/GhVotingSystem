package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * This class is responsible for the functionality of switching between screens
 */
public class FxmlLoader {
    private Pane view;  //Represents a screen

    /**
     * Called to load a screen unto the user interface
     * @param filename represents the name of file containing the graphic elements
     * @return the loaded screen
     */
    public Pane getPage(String filename){
        try {
            URL fileUrl = Main.class.getResource(filename);
            view = FXMLLoader.load(fileUrl);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }
}
