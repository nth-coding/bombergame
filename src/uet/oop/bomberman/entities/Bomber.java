package uet.oop.bomberman.entities;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private static final int MENU_START_Y = 300;

    private static List<MenuButton> menuButtons = new ArrayList<>();
    private  MenuButton ExitButton = new MenuButton("EXIT");
    private  MenuButton RestartButton = new MenuButton("RESTART");
    private ImageView Overimg;

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
            else {
                entity.setImg(Sprite.transparent.getFxImage());
                running = false;
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
            if (ax == bx && by - 32 <= ay && by + 32 >= ay
                    || ay == by && bx - 32 <= ax && bx + 32 >= ax)
            {
                this.life = false;
                break;
            }
        }
    }
    private void addMenuButton(MenuButton button) {
        button.setLayoutX(MENU_START_X);
        button.setLayoutY(MENU_START_Y + menuButtons.size() * 120- 50);
        menuButtons.add(button);
        root.getChildren().add(button);

    }
    private void createdExitButton(){

        addMenuButton(ExitButton);
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();

            }
        });
    }
    private void createdRestartButton(){

        addMenuButton(RestartButton);
        RestartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();





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