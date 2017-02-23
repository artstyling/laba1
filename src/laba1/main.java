package laba1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by bystr on 23/02/17.
 */
public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("laba1");
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(5);
        root.setVgap(5);


        final TextField QLineEdit = new TextField();
        GridPane.setConstraints(QLineEdit,0,0);
        QLineEdit.setPromptText("QLineEdit");
        final TextField QComboBox = new TextField();
        GridPane.setConstraints(QComboBox,2,0);
        QComboBox.setPromptText("QComboBox");
        final Button QPushButton = new Button("QPushButton");
        GridPane.setConstraints(QPushButton,1,0);
        QPushButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (QLineEdit.getText().equals(QComboBox.getText())){
                    newin.newwindow("невозможно сделать");
                }
                else QComboBox.setText(QLineEdit.getText());
            }
        });

        final Button QPushButton1 = new Button("QPushButton1");
        GridPane.setConstraints(QPushButton1,0,3);
        final Button QPushButton2 = new Button("QPushButton2");
        GridPane.setConstraints(QPushButton2,1,3);
        QPushButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                QPushButton2.setText(QLineEdit.getText());
            }
        });

        QPushButton2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String h = QPushButton2.getText();
                QPushButton2.setText(QPushButton1.getText());
                QPushButton1.setText(h);
            }
        });



















        root.getChildren().addAll(QLineEdit,QComboBox,QPushButton,QPushButton1,QPushButton2);
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
