package uet.oop.bomberman.entities.enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.PvPComponentMovement;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import java.util.Random;

import static uet.oop.bomberman.PvPGame.entities;
import static uet.oop.bomberman.PvPGame.list_kill;

public class PvPSmallPoyo extends Entity {
    private static int swap_kill = 1;
    private static int count_kill = 0;
    public PvPSmallPoyo(int x, int y, Image img) {
        super(x, y, img);
    }

    public PvPSmallPoyo(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public PvPSmallPoyo(boolean life) {
        super(life);
    }

    public PvPSmallPoyo() {
        
    }
    private void kill() {
        for (Entity entity : entities) {
            if (entity instanceof PvPSmallPoyo && list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {
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
//                Bar.score_number= Bar.score_number + 10;
//                Bar.score.setText("Score: "+ Bar.score_number);
                entities.remove(entity);
                swap_kill = 1;
            }
        }
    }
    private void move() {
        if (this.y % 32 == 0 && this.x % 32 == 0 && this.life) {
            Random random = new Random();
            int direction = random.nextInt(4);
            switch (direction) {
                case 0:
                    PvPComponentMovement.down(this);
                    break;
                case 1:
                    PvPComponentMovement.up(this);
                    break;
                case 2:
                    PvPComponentMovement.left(this);
                    break;
                case 3:
                    PvPComponentMovement.right(this);
                    break;
            }
        }
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof PvPSmallPoyo && !entity.life) {
                killPoyo(entity);
            }
        }
        move();
//        System.out.println("Poyo: " + this.getX() + " " + this.getY());
    }
}
