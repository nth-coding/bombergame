package uet.oop.bomberman.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import uet.oop.bomberman.model.MenuButton;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.view.ViewManager.*;
public class PauseMenu {
    private final int MENU_START_X = 150;
    private final int MENU_START_Y = 70;

    private final int WIDTH = 300;
    private final int HEIGHT = 400;
    private Image PauseImg;
    private ImageView Pauseimg;
    private static final List<MenuButton> menuButtons = new ArrayList<>();

    private final MenuButton resumeButton = new MenuButton("RESUME");
    private final MenuButton SoundButton = new MenuButton("SOUND");
    private final MenuButton ExitButton = new MenuButton("EXIT");

    public PauseMenu() {

    }

    private void addMenuButton(MenuButton button) {

        menuButtons.add(button);
        root.getChildren().add(button);

    }

    protected void createbuttons() {
        createdResumeButton();
        createdsoundButton();
        createdExitButton();

    }

    public void createdResumeButton() {

        addMenuButton(resumeButton);
        resumeButton.setLayoutX(MENU_START_X);
        resumeButton.setLayoutY(MENU_START_Y + 80);
        resumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                running = true;
                root.getChildren().remove(resumeButton);
                root.getChildren().remove(SoundButton);
                root.getChildren().remove(Pauseimg);
                root.getChildren().remove(ExitButton);
            }
        });
    }

    private void createdsoundButton() {

        addMenuButton(SoundButton);
        SoundButton.setLayoutX(MENU_START_X);
        SoundButton.setLayoutY(MENU_START_Y + 2 * 80);
        SoundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mediaPlayer.pause();

                count++;
                if (count % 2 == 0) mediaPlayer.play();
            }
        });
    }

    private void createdExitButton() {

        addMenuButton(ExitButton);
        ExitButton.setLayoutX(MENU_START_X);
        ExitButton.setLayoutY(MENU_START_Y + 3 * 80);
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStage.close();
            }
        });
    }

    public void showPause() {
        try {

            PauseImg = new Image(new FileInputStream("res\\textures\\Pause.jpg"), 550, 330, false, true);
            Pauseimg = new ImageView(PauseImg);

            Pauseimg.setLayoutX(110);
            Pauseimg.setLayoutY(80);
            root.getChildren().add(Pauseimg);
            createbuttons();
        } catch (Exception e) {
        }

    }
}
