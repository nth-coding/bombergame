package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.BombermanGame.*;

public class Bomber extends Entity {

    public static int swap_kill = 1;
    //
    public boolean life = true;
    //
    private static int count_kill = 0;

    public Bomber() {

    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    public static void move(javafx.scene.input.KeyEvent e) {
        KeyCode key = e.getCode();

        if (key == KeyCode.A || key == KeyCode.LEFT) {
            setVelX(-5);
        } else if (key == KeyCode.D || key == KeyCode.RIGHT) {
            setVelX(5);
        } else if (key == KeyCode.W || key == KeyCode.UP) {
            setVelY(-5);
        } else if (key == KeyCode.S || key == KeyCode.DOWN) {
            setVelY(5);
        }

        // chekc ne hieu oi
    }

    public static void stop(javafx.scene.input.KeyEvent e) {
        KeyCode key = e.getCode();

        if (key == KeyCode.A || key == KeyCode.LEFT) {
            setVelX(0);
        } else if (key == KeyCode.D || key == KeyCode.RIGHT) {
            setVelX(0);
        } else if (key == KeyCode.W || key == KeyCode.UP) {
            setVelY(0);
        } else if (key == KeyCode.S || key == KeyCode.DOWN) {
            setVelY(0);
        }
    }

    //
    private void killBomber(Entity bomber) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                bomber.setImg(Sprite.player_dead1.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                bomber.setImg(Sprite.player_dead2.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                bomber.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 4;
            } else {
                bomber.setImg(Sprite.transparent.getFxImage());
                BombermanGame.running = false;
                //Image gameOver = new Image("images/gameOver.png");
                /*author_view.setImage(gameOver);*/
            }
        }
    }

    private void checkBombs() {
        if (BombermanGame.list_kill[BombermanGame.bomberman.getX() / 32][BombermanGame.bomberman.getY() / 32] == 4) {
            BombermanGame.bomberman.setLife(false);
            System.out.println("Bomb");
        }
    }

    @Override
    public void update() {
        // testing commit
        checkBombs();
        count_kill++;
        if (!BombermanGame.bomberman.isLife()) {
            killBomber(BombermanGame.bomberman);
        }
    }
}
