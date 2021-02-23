package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String filename){
        try {
            URL fileUrl = Main.class.getResource(filename);
            view = new FXMLLoader().load(fileUrl);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }




}