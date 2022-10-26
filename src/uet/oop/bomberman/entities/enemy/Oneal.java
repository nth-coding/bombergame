package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.Component;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0;

    
    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public Oneal(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public Oneal(boolean life) {
        super(life);
    }

    public Oneal() {
        
    }

    private void killOneal(Entity entity) {
        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.oneal_dead.getFxImage());
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

    @Override
    public void update() {
        count_kill++;
        for (Entity entity : entities) {
            if (entity instanceof Oneal && !entity.life)
                killOneal(entity);
        }

        if (this.y % 32 == 0 && this.x % 32 == 0) {
            if (bomberman.getX() < this.x) {
                Component.left(this);
            }
            if (bomberman.getX() > this.x) {
                Component.right(this);
            }
            if (bomberman.getY() > this.y) {
                Component.down(this);
            }
            if (bomberman.getY() < this.y) {
                Component.up(this);
            }
        }
    }
}
