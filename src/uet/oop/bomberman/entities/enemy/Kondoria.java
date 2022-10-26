package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Blocked;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

public class Kondoria extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0; // Count the number of Kondorias destroyed

    public Kondoria(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Kondoria() {

    }

    private void killKondoria(Entity entity) { // Bomber destroys Balloon
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.kondoria_dead.getFxImage());
                swap_kill = 2;
            }
            else if (swap_kill == 2) {
                entity.setImg(Sprite.player_dead3.getFxImage());
                swap_kill = 3;
            }
            else {
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

    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof Kondoria && !entity.life)
                killKondoria(entity);
        }

        if (this.y % 32 == 0 && this.x % 32 == 0 && this.life) {
            Random random = new Random();
            int direction = random.nextInt(4);
            switch (direction) {
                case 0:
                    ComponentMovement.down(this);
                    break;
                case 1:
                    ComponentMovement.up(this);
                    break;
                case 2:
                    ComponentMovement.left(this);
                    break;
                case 3:
                    ComponentMovement.right(this);
                    break;
            }
        }
    }
}
