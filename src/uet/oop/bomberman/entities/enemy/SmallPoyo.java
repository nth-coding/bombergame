package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class SmallPoyo extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0;

    
    public SmallPoyo(int x, int y, Image img) {
        super(x, y, img);
    }

    public SmallPoyo(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public SmallPoyo(boolean life) {
        super(life);
    }

    public SmallPoyo() {
        
    }
    private void kill() {
        for (Entity entity : entities) {
            if (list_kill[entity.getX() / 32][entity.getY() / 32 + 1] == 4) {
                entity.setLife(false);
            }
        }
    }

    private void killPoyo(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.smallPoyo_dead.getFxImage());
                swap_kill = 2;
            } 
            else if (swap_kill == 2) {
                entity.setImg(Sprite.smallPoyo_dead1.getFxImage());
                swap_kill = 3;
            } 
            else {
                entity.setLife(false);
                entities.remove(entity);
                swap_kill = 1;
            }
        }
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof SmallPoyo && !entity.life)
                killPoyo(entity);
        }

        if (this.y % 16 == 0 && this.x % 16 == 0 && this.life) {
            if (bomberman.getX() < this.x) {
                ComponentMovement.left(this);
            }
            if (bomberman.getX() > this.x) {
                ComponentMovement.right(this);
            }
            if (bomberman.getY() + 1 > this.y) {
                ComponentMovement.down(this);
            }
            if (bomberman.getY() + 1< this.y) {
                ComponentMovement.up(this);
            }
        }

//        System.out.println("Poyo: " + this.getX() + " " + this.getY());
    }
}