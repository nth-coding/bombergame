package uet.oop.bomberman.Levels;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.*;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.*;

import static uet.oop.bomberman.entities.Bomber.*;

import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import static uet.oop.bomberman.BombermanGame.entities;


public class Level1 {
    public Level1() {
        stillObjects.clear();
        entities.clear();

//        level = 1;
        swap_kill = 1;
        try {
            new MapCreation("Level1.txt");
        }catch (Exception e){}
        bomberman.setX(32);
        bomberman.setY(32);
        bomberman.setLife(true);
        is_bomb = 0;
        BombItem.BombMax = false;
        Bomb.bomb_number =20;
        Bar.time_number = 120;
        Bar.llevel.setText("Level: 1");

        Entity enemy1 = new SmallPoyo(4, 4, Sprite.smallPoyo_left1.getFxImage());
        Entity enemy2 = new SmallPoyo(9, 9, Sprite.smallPoyo_left1.getFxImage());
        Entity enemy3 = new SmallPoyo(22, 6, Sprite.smallPoyo_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);
        entities.add(enemy3);

        Entity enemy4 = new BigPoyo(7, 6, Sprite.bigPoyo_left1.getFxImage());
        Entity enemy5 = new BigPoyo(13, 8, Sprite.bigPoyo_left1.getFxImage());
        entities.add(enemy4);
        entities.add(enemy5);

        Entity enemy6 = new Pink(6, 10, Sprite.pink_left1.getFxImage());
        entities.add(enemy6);

//        entities.clear();
        // set default for enemy
        for (Entity Entity : entities) {
            Entity.setLife(true);
        }
    }
}
