package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomber extends Entity {

    public static int swap_kill = 1;
    private static int count_kill = 0;
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
                System.exit(0);
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

    @Override
    public void update() {
        // testing commit
        checkBombs();
        checkEnemy();
        count_kill++;
        if (!this.life)
            killBomber(this);
    }
}
