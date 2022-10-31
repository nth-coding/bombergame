package uet.oop.bomberman.Levels;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.*;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.*;

import static uet.oop.bomberman.entities.Bomber.*;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.entities;


public class Level1 {
    public Level1() {
        stillObjects.clear();
        entities.clear();

        swap_kill = 1;
        try {
            new MapCreation("Level1.txt");
        }catch (Exception e){}
        bomberman.setX(32);
        bomberman.setY(32);
        bomberman.setLife(true);
        is_bomb = 0;

        Entity enemy1 = new BakudaRed(4, 4, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy2 = new BakudaRed(9, 9, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy3 = new BakudaRed(22, 6, Sprite.bakudaRed_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);
        entities.add(enemy3);

        Entity enemy4 = new BigPoyo(7, 6, Sprite.bigPoyo_left1.getFxImage());
        Entity enemy5 = new BigPoyo(13, 8, Sprite.bigPoyo_left1.getFxImage());
        entities.add(enemy4);
        entities.add(enemy5);


        // set default for enemy
        for (Entity Entity : entities) {
            Entity.setLife(true);
        }
    }
}
