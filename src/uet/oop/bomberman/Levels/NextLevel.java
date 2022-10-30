package uet.oop.bomberman.Levels;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.model.MenuButton;
import uet.oop.bomberman.view.Bar;
import uet.oop.bomberman.view.PauseMenu;
import uet.oop.bomberman.view.ViewManager;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.object.Portal.*;
import static uet.oop.bomberman.view.ViewManager.gameStage;
import static uet.oop.bomberman.view.ViewManager.mainStage;

//Class NextLevel to choose level but for now only have 1 level.
public class NextLevel {
    public static boolean wait;
    public static long waiting_time;
    private static Scene TransScene;
    public static Group Transroot = new Group();
    public static Image Up;
    private static ImageView Overimg;
    private static final int MENU_START_X = 270;
    private static final int MENU_START_Y = 190;
    private static List<MenuButton> menuButtons = new ArrayList<>();
    private static MenuButton ExitButton = new MenuButton("EXIT");
    private static  MenuButton RestartButton = new MenuButton("RESTART");
    public static void fadeTrans(){
        img.setImage(Up);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(4000));
        fadeTransition.setFromValue(1);

        fadeTransition.setToValue(0);
        fadeTransition.setNode(img);
        fadeTransition.play();
    }
    private static void addMenuButton(MenuButton button) {

        menuButtons.add(button);
        root.getChildren().add(button);

    }
    private static void createdExitButton(){

        addMenuButton(ExitButton);
        ExitButton.setLayoutX(MENU_START_X);
        ExitButton.setLayoutY(MENU_START_Y + 2 * 120- 50);
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStage.close();

            }
        });
    }
    private  static void createdRestartButton(){

        addMenuButton(RestartButton);
        RestartButton.setLayoutX(MENU_START_X);
        RestartButton.setLayoutY(MENU_START_Y + 1 * 120- 50);
        RestartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Bomber.dem =1;


                root.getChildren().remove(Overimg);
                root.getChildren().remove(RestartButton);
                root.getChildren().remove(ExitButton);

                mainStage.show();

            }
        });
    }
    public static void waitToLevelUp(Stage TransStage) {

        try {
            if (wait) {

                long now = System.currentTimeMillis();
                if(now - waiting_time <=2000&& level!=3) {
                    Up = new Image(new FileInputStream("res\\Trans\\Trans.jpg"));

                }
                else if(now - waiting_time <=2000&& level==3) {
                    Up = new Image(new FileInputStream("res\\textures\\congratulation.png"));

                }
                else {
                    if(level ==1 )
                        Up = new Image(new FileInputStream("res\\Trans\\Level2.png"));
                    if(level ==2){
                        Up = new Image(new FileInputStream("res\\Trans\\Level3.png"));
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
                            running = false;
                            Bomber.dem =1;


                            Image OverImg;

                            try {
                                OverImg = new Image(new FileInputStream("res\\textures\\youwon.png"), 800, 480, false, true);
                                Overimg = new ImageView(OverImg);
                                Overimg.setLayoutX(0);
                                Overimg.setLayoutY(0);
                                root.getChildren().add(Overimg);
                                createdRestartButton();
                                createdExitButton();

                            }catch (Exception e){}
                    }
                    wait = false;
                }
            }
        } catch (Exception e) {
        }
    }
}
