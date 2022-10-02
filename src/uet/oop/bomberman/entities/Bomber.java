package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class Bomber extends Entity {
    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void move(javafx.scene.input.KeyEvent e) {
        KeyCode key = e.getCode();

        if (key == KeyCode.A || key == KeyCode.LEFT) {
            setVelX(-5);
        } else if (key == KeyCode.D ||key == KeyCode.RIGHT) {
            setVelX(5);
        } else if (key == KeyCode.W ||key == KeyCode.UP) {
            setVelY(-5);
        } else if (key == KeyCode.S ||key == KeyCode.DOWN) {
            setVelY(5);
        }
    }

    public static void stop(javafx.scene.input.KeyEvent e) {
        KeyCode key = e.getCode();

        if (key == KeyCode.A || key == KeyCode.LEFT) {
            setVelX(0);
        } else if (key == KeyCode.D ||key == KeyCode.RIGHT) {
            setVelX(0);
        } else if (key == KeyCode.W ||key == KeyCode.UP) {
            setVelY(0);
        } else if (key == KeyCode.S ||key == KeyCode.DOWN) {
            setVelY(0);
        }
    }
    @Override
    public void update() {
        // testing commit
    }
}
