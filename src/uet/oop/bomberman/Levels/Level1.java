package uet.oop.bomberman.Levels;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.*;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.Ballom;
import uet.oop.bomberman.entities.enemy.Doll;
import uet.oop.bomberman.entities.enemy.Kondoria;
import uet.oop.bomberman.entities.enemy.Oneal;

import static uet.oop.bomberman.entities.Bomber.*;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

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
        Bomb.bomb_number =20;
        Bar.time_number = 120;
        Bar.llevel.setText("Level: 1");
        Entity enemy1 = new Ballom(4, 4, Sprite.balloom_left1.getFxImage());
        Entity enemy2 = new Ballom(9, 9, Sprite.balloom_left1.getFxImage());
        Entity enemy3 = new Ballom(22, 6, Sprite.balloom_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);
        entities.add(enemy3);

        Entity enemy4 = new Oneal(7, 6, Sprite.oneal_right1.getFxImage());
        Entity enemy5 = new Oneal(13, 8, Sprite.oneal_right1.getFxImage());
        entities.add(enemy4);
        entities.add(enemy5);

        // set default for enemy
        for (Entity Entity : entities) {
            Entity.setLife(true);
        }
    }
}
