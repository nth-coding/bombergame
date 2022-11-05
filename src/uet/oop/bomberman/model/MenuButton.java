package uet.oop.bomberman.model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MenuButton extends Button {
    private final String FONT_PATH= "res/font/ChunkFive-Regular.otf";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: linear-gradient(to bottom right, derive(lightskyblue, 50%), derive(lightcyan, -40%));";
    private final String BUTTON_FREE_STYLE = "-fx-background-color: linear-gradient(to bottom right, derive(lightskyblue, 30%), derive(lightcyan, -40%));";
    private final Text text= new Text();
    public MenuButton(String s) {

        setText(s);

        setButtonFont();
        setPrefWidth(250);
        setPrefHeight(55);
        setStyle(BUTTON_FREE_STYLE);
        initializeButton();
    }

    protected void setButtonFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH),26));
            setStyle("-fx-text-inner-color: red;");
        } catch (FileNotFoundException e){
            setFont(Font.font("Verdana",23));
        }
    }
    protected void setButtonPressedStyle(){
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(40);
        setLayoutY(getLayoutY()+6);
    }
    protected  void setButtonReleasedStyle(){
        setStyle(BUTTON_FREE_STYLE);
        setPrefHeight(46);
        setLayoutY(getLayoutY()-6);
    }
    public void initializeButton(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonPressedStyle();
                }
            }
        });
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton().equals(MouseButton.PRIMARY)){
                    setButtonReleasedStyle();
                }
            }
        });
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());

            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });
    }

}