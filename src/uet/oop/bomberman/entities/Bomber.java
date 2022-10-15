package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Bomber extends Entity {

    public static int swap_kill = 1;

    public Bomber() {

    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    // public static void move(javafx.scene.input.KeyEvent e) {
    //     KeyCode key = e.getCode();

    //     if (key == KeyCode.A || key == KeyCode.LEFT) {
    //         setVelX(-5);
    //     } else if (key == KeyCode.D ||key == KeyCode.RIGHT) {
    //         setVelX(5);
    //     } else if (key == KeyCode.W ||key == KeyCode.UP) {
    //         setVelY(-5);
    //     } else if (key == KeyCode.S ||key == KeyCode.DOWN) {
    //         setVelY(5);
    //     }

    //     // chekc ne hieu oi
    // }

    // public static void stop(javafx.scene.input.KeyEvent e) {
    //     KeyCode key = e.getCode();

    //     if (key == KeyCode.A || key == KeyCode.LEFT) {
    //         setVelX(0);
    //     } else if (key == KeyCode.D ||key == KeyCode.RIGHT) {
    //         setVelX(0);
    //     } else if (key == KeyCode.W ||key == KeyCode.UP) {
    //         setVelY(0);
    //     } else if (key == KeyCode.S ||key == KeyCode.DOWN) {
    //         setVelY(0);
    //     }
    // }
    @Override
    public void update() {
        // testing commit
    }
}
