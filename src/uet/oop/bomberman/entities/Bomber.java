package uet.oop.bomberman.entities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.Levels.Level1;
import uet.oop.bomberman.Levels.Level2;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.model.MenuButton;
import uet.oop.bomberman.view.ViewManager;

import javax.swing.text.View;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.view.ViewManager.*;
import uet.oop.bomberman.entities.enemy.BigPoyo;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.model.MenuButton;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.view.ViewManager.mainStage;

public class Bomber  extends Entity {

    public static int swap_kill = 1;
    private static int count_kill = 0;
    public static int bomb_number = 20;
    public static int power_bomb = 0;
    public static int dem =0;
    public static int speed = 1;
    private static final int MENU_START_X = 270;
    private static final int MENU_START_Y = 190;
    public static Stage newStage;

    private static List<MenuButton> menuButtons = new ArrayList<>();
    private  MenuButton ExitButton = new MenuButton("EXIT");
    private  MenuButton RestartButton = new MenuButton("RESTART");
    private ImageView Overimg;
    private static MediaPlayer mediaPlayerbomb;
    public Bomber() {

    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    private void killBomber(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.player_dead1.getFxImage());
                swap_kill = 2;
            }
            else if (swap_kill == 2) {
                entity.setImg(Sprite.player_dead2.getFxImage());
                swap_kill = 3;
            }
            else if (swap_kill == 3) {
                entity.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 4;
            }
            else if (swap_kill == 4) {
                entity.setImg(Sprite.player_dead4.getFxImage());
                swap_kill = 5;
            }
            else if (swap_kill == 5) {
                entity.setImg(Sprite.player_dead5.getFxImage());
                swap_kill = 6;
            }
            else if (swap_kill == 6) {
                entity.setImg(Sprite.player_dead6.getFxImage());
                swap_kill = 7;
            }
            else {
                running = false;
                dem =1;
                entity.setImg(Sprite.player_right.getFxImage());

                Image OverImg;

                try {
                    OverImg = new Image(new FileInputStream("res\\textures\\gameover.jpg"), 800, 480, false, true);
                    Overimg = new ImageView(OverImg);
                    Overimg.setLayoutX(0);
                    Overimg.setLayoutY(0);
                    root.getChildren().add(Overimg);
                    createdRestartButton();
                    createdExitButton();
                }catch (Exception e){}
            }
        }
    }

    private void checkBombs() {
        if (list_kill[this.getX() / 32][this.getY() / 32 + 1] == 4)
            this.setLife(false);
    }

    private void checkEnemy() {
        int ax = this.getX();
        int ay = this.getY() + 16;
        for (Entity entity : entities) {
            int bx = entity.getX();
            int by = entity.getY();
            if (entity instanceof BigPoyo) {
                bx = entity.getX();
                by = entity.getY();
            }
            if (ax == bx && by - 16 < ay && by + 16 > ay
                    || ay == by && bx - 16 < ax && bx + 16 > ax)
            {
                this.life = false;
                System.out.println("Killed by Ballom bug at " + bx + " " + by + " when you were at " + ax + " " + ay);
                break;
            }
        }
    }
    private void addMenuButton(MenuButton button) {

        menuButtons.add(button);
        root.getChildren().add(button);

    }
    private void createdExitButton(){

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
    private void createdRestartButton(){

        addMenuButton(RestartButton);
        RestartButton.setLayoutX(MENU_START_X);
        RestartButton.setLayoutY(MENU_START_Y + 1 * 120- 50);
        RestartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dem =1;


                root.getChildren().remove(Overimg);
                root.getChildren().remove(RestartButton);
                root.getChildren().remove(ExitButton);

                mainStage.show();

            }
        });
    }
    @Override
    public void update() {
        // testing commit
        checkBombs();
        checkEnemy();
        count_kill++;
        if (!this.life) {
            killBomber(this);

        }
    }
}