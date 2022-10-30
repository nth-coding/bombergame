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
        speed =1;

        Entity enemy1 = new BakudaRed(4, 4, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy2 = new BakudaRed(4, 5, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy3 = new BakudaRed(4, 6, Sprite.bakudaRed_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);
        entities.add(enemy3);

        Entity enemy4 = new BakudaRed(5, 4, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy5 = new BakudaRed(5, 5, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy6 = new BakudaRed(5, 6, Sprite.bakudaRed_left1.getFxImage());
        entities.add(enemy4);
        entities.add(enemy5);
        entities.add(enemy6);

        Entity enemy7 = new BakudaRed(6, 4, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy8 = new BakudaRed(6, 5, Sprite.bakudaRed_left1.getFxImage());
        Entity enemy9 = new BakudaRed(6, 6, Sprite.bakudaRed_left1.getFxImage());
        entities.add(enemy7);
        entities.add(enemy8);
        entities.add(enemy9);

        // set default for enemy
        for (Entity Entity : entities) {
            Entity.setLife(true);
        }
    }
}
