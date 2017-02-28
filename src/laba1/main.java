package laba1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;


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

        HBox first = new HBox(10);
        final TextField QLineEdit = new TextField();
        QLineEdit.setPromptText("QLineEdit");
        final ChoiceBox QComboBox = new ChoiceBox();
        final Button QPushButton = new Button("QPushButton");
        QComboBox.getItems().add("first");
        QComboBox.getItems().add("second");
        int i = 0;
        while (){
           i++;
        }

        System.out.println(i);

        first.getChildren().addAll(QLineEdit,QPushButton,QComboBox);
        GridPane.setConstraints(first,0,0);
        HBox second = new HBox(10);
        final TextField tixt = new TextField();
        tixt.setPromptText("QLineEdit");
        final Button QPushButton1 = new Button("QPushButton1");
        GridPane.setConstraints(QPushButton1,0,3);
        final Button QPushButton2 = new Button("QPushButton2");
        GridPane.setConstraints(QPushButton2,1,3);
        QPushButton1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                QPushButton2.setText(tixt.getText());
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
        second.getChildren().addAll(QPushButton1,tixt,QPushButton2);
        GridPane.setConstraints(second,0,2);
        HBox bitons = new HBox(10);
         HBox three = new HBox(10);
        final TextField text2 = new TextField();
        text2.setPromptText("QLineEdit");
        final RadioButton[] rb = new RadioButton[]{
                new RadioButton("first"),
                new RadioButton("second"),
                new RadioButton("the third"),



        };




            bitons.getChildren().addAll(rb);

        Button button = new Button("click");

        three.getChildren().addAll(text2,button,bitons);

        GridPane.setConstraints(three,0,3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean a = true;
                for (int i = 0;i<3;i++){
                    if (text2.getText().equals(rb[i].getText())){
                        for (int j = 0;j<3;j++)
                            rb[j].setSelected(false);

                        rb[i].setSelected(true);
                        a = false;
                    }

                }
                if (a == true){
                    newin.newwindow("такого нет");
                }
            }
        });

        HBox four = new HBox(10);
        final CheckBox[] che = new CheckBox[]{


                new CheckBox("first"),
                new CheckBox("second"),
                new CheckBox("the third")



        };

        VBox kill = new VBox(10);

        final TextField text3 = new TextField();
        text3.setPromptText("напиши сюда");



        Button button1 = new Button("click 2");


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean a = true;
                for (int i = 0;i<3;i++){
                    if (text3.getText().equals(che[i].getText())){
                        che[i].setSelected(true);
                        a = false;
                    }
                }
                if (a == true){
                    newin.newwindow("такого нет");
                }
            }
        });



        GridPane.setConstraints(four,0,4);
        four.getChildren().addAll(text3,button1,kill);


        kill.getChildren().addAll(che);






        root.getChildren().addAll(first,second,three,four);
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
