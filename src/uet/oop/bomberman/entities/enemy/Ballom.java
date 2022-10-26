package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Component;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.list_kill;

import java.util.Random;

public class Ballom extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0; // Count the number of Balloms destroyed

    public Ballom(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Ballom() {

    }

    private void killBallom(Entity entity) { // Bomber destroys Balloon
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.mob_dead1.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                entity.setImg(Sprite.mob_dead2.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                entity.setImg(Sprite.mob_dead3.getFxImage());
                swap_kill = 4;
            } else {
                entity.setLife(false);
                entities.remove(entity);
                swap_kill = 1;
            }
        }
    }

    private void kill() {
        for (Entity entity : entities) {
            if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {
                entity.setLife(false);
            }
        }
    }

    public Ballom(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (Entity entity : entities) {
            if (entity instanceof Ballom && !entity.life)
                killBallom(entity);
        }

        if (this.y % 32 == 0 && this.x % 32 == 0) {
            Random random = new Random();
            int direction = random.nextInt(4);
            switch (direction) {
                case 0:
                    Component.down(this);
                    break;
                case 1:
                    Component.up(this);
                    break;
                case 2:
                    Component.left(this);
                    break;
                case 3:
                    Component.right(this);
                    break;
            }
        }
    }
}