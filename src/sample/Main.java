package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    public static String name = "";

    public static int rounds = 0;

    public static int questionsPerRound = 0;

    public void init(){

        Controller.readProperties();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane root = new Pane();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setWidth(700);
        primaryStage.setHeight(500);

        Button settingsButton = new Button("Settings");
        settingsButton.setLayoutX(10);
        settingsButton.setLayoutY(300);
        settingsButton.setPrefHeight(70);
        settingsButton.setPrefWidth(150);
        root.getChildren().add(settingsButton);


        primaryStage.show();



        settingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Stage settingsWindow = new Stage();

                GridPane settingsRoot = new GridPane();
                Scene settingsScene = new Scene(settingsRoot);

                settingsWindow.setTitle("Settings");
                settingsWindow.setHeight(200);
                settingsWindow.setWidth(300);
                settingsWindow.initModality(Modality.APPLICATION_MODAL);

                Label nextToPlayerName = new Label("Player Name");
                Label nextToPlayerRounds = new Label("Rounds");
                Label nextToPlayerQuestPerRound = new Label("Questions Per Round");
                TextField playerName = new TextField(name);
                TextField playerRounds = new TextField(String.valueOf(rounds));
                TextField playerQuestionsPerRound = new TextField(
                        String.valueOf(questionsPerRound)
                );

                playerRounds.setLayoutY(40);
                playerQuestionsPerRound.setLayoutY(80);

                Button applySettingsButton = new Button("Apply");
                applySettingsButton.setLayoutY(100);
                applySettingsButton.setLayoutX(200);
                applySettingsButton.setDisable(true);

                settingsRoot.addRow(0, nextToPlayerName, playerName);
                settingsRoot.addRow(1, nextToPlayerRounds, playerRounds);
                settingsRoot.addRow(2,nextToPlayerQuestPerRound,playerQuestionsPerRound);
                settingsRoot.addRow(3, applySettingsButton);
                settingsWindow.setScene(settingsScene);
                settingsWindow.show();

                playerName.textProperty().addListener((observable, oldValue, newValue) -> {
                    applySettingsButton.setDisable(false);
                });
                playerRounds.textProperty().addListener((observable, oldValue, newValue) -> {

                    applySettingsButton.setDisable(false);

                });
                playerQuestionsPerRound.textProperty().addListener((observable, oldValue, newValue) -> {


                    applySettingsButton.setDisable(false);

                });

                applySettingsButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {


                            try {
                                int test = Integer.parseInt(playerQuestionsPerRound.getText());
                            } catch (NumberFormatException e) {

                                playerQuestionsPerRound.setText("3");
                                JOptionPane.showMessageDialog(null,
                                        "Rounds Have To Be A Number!");
                                return;
                            }
                            try {
                                int test = Integer.parseInt(playerRounds.getText());
                            }catch(NumberFormatException e){
                                playerRounds.setText("3");
                                JOptionPane.showMessageDialog(null,
                                        "Questions Per Round Have To Be A Number!");
                                return;
                            }

                            Controller.writeToProperties(playerName.getText(),
                                    playerRounds.getText(),playerQuestionsPerRound.getText());
                            settingsWindow.close();
                            Controller.readProperties();




                    }
                });
            }
        });
    }


    public static void main(String[] args) { launch(args);
    }
}
