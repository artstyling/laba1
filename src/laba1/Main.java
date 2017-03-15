package laba1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Iterator;


/**
 * Created by bystr on 23/02/17.
 */
public class Main extends Application {


    TextField text4;
    TableView<Tabble> table;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("laba1");
        GridPane root = new GridPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setHgap(5);
        root.setVgap(5);

        HBox first = new HBox(10);
        final TextField qlineedit = new TextField();
        qlineedit.setPromptText("задание1");
        final ComboBox qcombobox = new ComboBox();
        final Button qpushbutton = new Button("задание1");
        qcombobox.getItems().iterator().hasNext();
        qpushbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean bol = true;
                if(qlineedit.getText().isEmpty()){
                    Newin.newwindow("введите текст");
                }else
                if (qcombobox.getItems().isEmpty()){
                    qcombobox.getItems().add(qlineedit.getText());
                }else {
                    ObservableList<String> items = qcombobox.getItems();
                    for (String ite : items) {
                        if (qlineedit.getText().equals(ite.toString())) {
                            Newin.newwindow("такое уже есть");
                            bol = false;
                            break;
                        }
                    }
                    if (bol == true){
                        qcombobox.getItems().add(qlineedit.getText());
                    }
                }
            }
        });

        first.getChildren().addAll(qlineedit,qpushbutton,qcombobox);
        GridPane.setConstraints(first,0,0);
        HBox second = new HBox(10);
        final TextField tixt = new TextField();
        tixt.setPromptText("задание2");
        final Button QPushButton1 = new Button("кнопка1");
        GridPane.setConstraints(QPushButton1,0,3);
        final Button QPushButton2 = new Button("кнопка2");
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
        text2.setPromptText("задание3");
        ToggleGroup butgroup = new ToggleGroup();
        final RadioButton rb1 = new RadioButton("first");
        final RadioButton rb2 = new RadioButton("second");
        final RadioButton rb3 = new RadioButton("the third");

        rb1.setToggleGroup(butgroup);
        rb2.setToggleGroup(butgroup);
        rb3.setToggleGroup(butgroup);


        bitons.getChildren().addAll(rb1,rb2,rb3);

        Button button = new Button("click");

        three.getChildren().addAll(text2,button,bitons);

        GridPane.setConstraints(three,0,3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (text2.getText().isEmpty()){
                    Newin.newwindow("введите текст");
                }else
                if (text2.getText().equals(rb1.getText())){
                    rb1.setSelected(true);
                }else
                if (text2.getText().equals(rb2.getText())){
                    rb2.setSelected(true);
                }else
                if (text2.getText().equals(rb3.getText())){
                    rb3.setSelected(true);
                }else
                    Newin.newwindow("такого нет");
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
        text3.setPromptText("задание4");



        Button button1 = new Button("click 2");


        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (text3.getText().isEmpty()){
                    Newin.newwindow("введите текст");
                }else {
                    boolean a = true;
                    for (int i = 0; i < 3; i++) {
                        if (text3.getText().equals(che[i].getText())) {
                            if (che[i].isSelected()) {
                                che[i].setSelected(false);
                                a = false;
                            } else {
                                che[i].setSelected(true);
                                a = false;
                            }


                        }
                    }
                    if (a == true) {
                        Newin.newwindow("такого нет");
                    }
                }
            }
        });



        GridPane.setConstraints(four,0,4);
        four.getChildren().addAll(text3,button1,kill);

        kill.getChildren().addAll(che);



        VBox five = new VBox(10);







        TableColumn<Tabble, String> pervoecoloms = new TableColumn<>("first");
        pervoecoloms.setMinWidth(100);
        pervoecoloms.setCellValueFactory(new PropertyValueFactory<Tabble, String>("pervoe"));


        TableColumn<Tabble, String> vtoroecoloms = new TableColumn<>("first");
        vtoroecoloms.setMinWidth(100);
        vtoroecoloms.setCellValueFactory(new PropertyValueFactory<Tabble, String>("vtoroe"));




        table = new TableView<>();
        table.setItems(gettablicka());
        table.getColumns().addAll(pervoecoloms,vtoroecoloms);




        five.getChildren().add(table);
        GridPane.setConstraints(five,0,5);






        HBox fifive = new HBox(10);
        text4 = new TextField();
        text4.setPromptText("введите сюда");
        fifive.getChildren().add(text4);

        Button knopka0 = new Button("first");
        Button knopka1 = new Button("second");
        Button knopka2 = new Button("the third");
        fifive.getChildren().add(knopka0);
        fifive.getChildren().add(knopka1);
        fifive.getChildren().add(knopka2);



        knopka0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    addbatton();
            }
        });



        knopka1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result1();
            }
        });


        knopka2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result2();
            }
        });






        five.getChildren().add(fifive);


        root.getChildren().addAll(first,second,three,four,five);
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.setWidth(660);
        stage.setHeight(660);
        stage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }



    public ObservableList<Tabble> gettablicka(){

        ObservableList<Tabble> tablickis = FXCollections.observableArrayList();

        return tablickis;
    }

public void addbatton(){
    Tabble tabble = new Tabble();
    if (text4.getText().isEmpty()){
        Newin.newwindow("введите текст");
    }
    else{
        tabble.setPervoe(text4.getText());
        table.getItems().add(tabble);
        text4.clear();
    }



}

public void result1(){
    if (table.getSelectionModel().getSelectedItem().getPervoe().isEmpty()){
        return;
    }else {


        table.getSelectionModel().getSelectedItem().setVtoroe(table.getSelectionModel().getSelectedItem().getPervoe());
        table.getSelectionModel().getSelectedItem().setPervoe("");
        table.getColumns().get(0).setVisible(false);
        table.getColumns().get(0).setVisible(true);


    }



}

public void result2(){

    if(table.getSelectionModel().getSelectedItem().getVtoroe().isEmpty()){
        return;
    }else{
        table.getSelectionModel().getSelectedItem().setPervoe(table.getSelectionModel().getSelectedItem().getVtoroe());
        table.getSelectionModel().getSelectedItem().setVtoroe("");
        table.getColumns().get(0).setVisible(false);
        table.getColumns().get(0).setVisible(true);


    }


}



}
