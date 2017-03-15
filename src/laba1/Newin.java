package laba1;

import javafx.stage.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * Created by bystr on 23/02/17.
 */
public class Newin {
    public static void newwindow(String string){

        final Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(5,5,5,5));
        Text text = new Text(string);
        GridPane.setConstraints(text,0,0);
        Button clik = new Button("OK");
        GridPane.setConstraints(clik,1,1);
        clik.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });


        pane.getChildren().addAll(text,clik);
        Scene scine = new Scene(pane,216,50);
        window.setTitle("Warning!");
        window.setScene(scine);
        window.showAndWait();
    }
}
