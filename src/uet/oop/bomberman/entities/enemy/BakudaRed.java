package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Blocked;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.AI.AStar;
import uet.oop.bomberman.entities.AI.Node;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;
import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

public class BakudaRed extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0;
    Random random = new Random();
    private int direction_status = 0;
    private int direction = random.nextInt(4);

    public BakudaRed(int x_unit, int y_unit, Image img) {
        super(x_unit, y_unit, img);
    }

    public BakudaRed(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public BakudaRed(boolean life) {
        super(life);
    }

    public BakudaRed() {

    }

    private void setDirection() {
        if (!Blocked.block_down(this) && this.direction_status == 0) {
            this.direction = 1;
            return;
        }
        if (!Blocked.block_up(this) && this.direction_status == 1) {
            this.direction = 0;
            return;
        }
        if (!Blocked.block_left(this) && this.direction_status == 2) {
            this.direction = 3;
            return;
        }
        if (!Blocked.block_right(this) && this.direction_status == 3) {
            this.direction = 2;
            return;
        }
    }
    private void killBakudaRed(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.bakudaRed_dead.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                entity.setImg(Sprite.smallPoyo_dead.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                entity.setImg(Sprite.smallPoyo_dead1.getFxImage());
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
            if (entity instanceof BakudaRed && list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {
                entity.setLife(false);
            }
        }
    }

    private void move() {
        if (this.life) {
            switch (direction) {
                case 0:
                    ComponentMovement.down(this);
                    direction_status = 0;
                    break;
                case 1:
                    ComponentMovement.up(this);
                    direction_status = 1;
                    break;
                case 2:
                    ComponentMovement.left(this);
                    direction_status = 2;
                    break;
                case 3:
                    ComponentMovement.right(this);
                    direction_status = 3;
                    break;
            }
            setDirection();
        }
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof BakudaRed && !entity.life)
                killBakudaRed(entity);
        }
        move();
    }
}
