package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Bomber extends Entity {

    public static int swap_kill = 1;
    public static int bomb_number = 20;
    public static int power_bomb = 0;
    public static int speed = 1;

    public Bomber() {

    }

    public Bomber(int x, int y, Image img) {
        super(x, y, img);
    }

    public Bomber(int is_move, int swap, String direction, int count, int count_to_run) {
        super(8, 1, "down", 0, 0);
    }

    @Override
    public void update() {
        // testing commit
    }
}
