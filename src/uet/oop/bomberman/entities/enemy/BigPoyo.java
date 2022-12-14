package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Blocked;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;
public class BigPoyo extends Entity {

    private static int swap_kill = 1;
    private static int count_kill = 0;
    private int direction = 0;
    private int direction_status = 0;

    public BigPoyo(int x, int y, Image img) {
        super(x, y, img);
    }

    public BigPoyo(int is_move, int swap, String directionection, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public BigPoyo(boolean life) {
        super(life);
    }

    public BigPoyo() {
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
        return !Blocked.block_right(this) && this.direction_status == 3;
    }

    private void killPoyo(Entity entity) {

        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.bigPoyo_dead.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                entity.setImg(Sprite.player_dead5.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                entity.setImg(Sprite.player_dead6.getFxImage());
                swap_kill = 4;
            } else {
                entity.setLife(false);
                Bar.score_number= Bar.score_number + 10;
                Bar.score.setText("Score: "+ Bar.score_number);
                entities.remove(entity);
                swap_kill = 1;
            }
        }
    }

    private void kill() {
        for (Entity entity : entities) {
            if (entity instanceof BigPoyo && list_kill[entity.getX() / 32][entity.getY() / 32 + 1] == 4) {
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

            if (checkDirection()) {
                Random random = new Random();
                direction = random.nextInt(4);
//                System.out.println("Ok");
            }
        }
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof BigPoyo && !entity.life) {
                killPoyo(entity);

            }

        }
        move();
    } 
}
