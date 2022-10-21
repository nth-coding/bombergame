package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.FileInputStream;

public class Instruction extends SubScene {


    private boolean isHidden;

    public Instruction() throws Exception {
        super(new AnchorPane(), 500, 300);
        prefWidth(500);
        prefHeight(300);
        Image backgroundImage = new Image(new FileInputStream("src\\main\\resources\\instruction.jpg"),500,300,false,true);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(background));
        isHidden = true;
        setLayoutX(1000);
        setLayoutY(200);
    }
    public void moveScene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(this);
        if(isHidden) {
            transition.setToX(-550);
            isHidden = false;
        }else{
            transition.setToX(0);
            isHidden = true;
        }

        transition.play();
    }
}
