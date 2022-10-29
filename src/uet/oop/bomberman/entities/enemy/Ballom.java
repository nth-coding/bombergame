package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Blocked;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
public class Ballom extends Entity {

    private static int swap_kill = 1;
    private static int count_kill = 0;
    private int direction = 0;
    private int direction_status = 0;

    public Ballom(int x, int y, Image img) {
        super(x, y, img);
    }

    public Ballom(int is_move, int swap, String directionection, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Ballom(boolean life) {
        super(life);
    }

    public Ballom() {
    }

    private boolean checkDirection() {
        // true: need to switch direction
        // false: no need

        if (!Blocked.block_down(this) && this.direction_status == 0) {
            return true;
        }
        if (!Blocked.block_up(this) && this.direction_status == 1) {
            return true;
        }
        if (!Blocked.block_left(this) && this.direction_status == 2) {
            return true;
        }
        if (!Blocked.block_right(this) && this.direction_status == 3) {
            return true;
        }
        return false;
    }

    private void killBallom(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.balloom_dead.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                entity.setImg(Sprite.player_dead4.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                entity.setImg(Sprite.player_dead5.getFxImage());
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

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof Ballom && !entity.life)
                killBallom(entity);
        }

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

            if (checkDirection()) {
                Random random = new Random();
                direction = random.nextInt(4);
//                System.out.println("Ok");
            }
        }
    }
}
