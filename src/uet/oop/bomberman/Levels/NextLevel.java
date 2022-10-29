package uet.oop.bomberman.Levels;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.object.Portal.*;
//Class NextLevel to choose level but for now only have 1 level.
public class NextLevel {
    public static boolean wait;
    public static long waiting_time;
    private static Scene TransScene;
    public static Group Transroot = new Group();
    public static Image Up;
    public static void fadeTrans(){
        img.setImage(Up);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(4000));
        fadeTransition.setFromValue(1);

        fadeTransition.setToValue(0);
        fadeTransition.setNode(img);
        fadeTransition.play();
    }
    public static void waitToLevelUp(Stage TransStage) {

        try {
            if (wait) {

                long now = System.currentTimeMillis();
                if(now - waiting_time <=2000) {
                    Up = new Image(new FileInputStream("res\\Trans\\Trans.jpg"));

                }
                else {
                    if(level ==1 )
                        Up = new Image(new FileInputStream("res\\Trans\\Level2.png"));
                    if(level ==2){
                        Up = new Image(new FileInputStream("res\\Trans\\Level3.png"));
                    }
                    if(level ==3){
                        Up = new Image(new FileInputStream("res\\Trans\\Level1.png"));
                    }
                }

                fadeTrans();



                if (now - waiting_time > 4000) {

                    switch (level) {
                        case 1:
                            is_portal = false;
                            new Level2();
                            running = true;
                            break;
                        case 2:
                            new Level3();
                            running = true;
                            break;
                        case 3:
                            new Level1();
                            running = true;
                    }
                    wait = false;
                }
            }
        } catch (Exception e) {
        }
    }
}
