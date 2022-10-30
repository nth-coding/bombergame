package uet.oop.bomberman.Levels;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.Ballom;
import uet.oop.bomberman.entities.enemy.Kondoria;
import uet.oop.bomberman.entities.enemy.Oneal;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import java.io.FileNotFoundException;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.entities.Bomb.*;
import static uet.oop.bomberman.entities.Bomb.is_bomb;
import static uet.oop.bomberman.entities.Bomber.*;
import static uet.oop.bomberman.entities.Bomber.speed;
import static uet.oop.bomberman.entities.Bomber.swap_kill;


public class Level2 {
    public Level2() {
        entities.clear();
        stillObjects.clear();
        swap_kill = 1;
        try {
            new MapCreation("Level2.txt");
        } catch (Exception e){}
        bomberman.setLife(true);
        bomberman.setX(32);
        bomberman.setY(32);

        is_bomb = 0;
        speed =1;
        Bar.llevel.setText("Level: 2");
        Bomb.bomb_number =20;
        Bar.time_number = 120;
        Entity enemy1 = new Ballom(5, 5, Sprite.balloom_left1.getFxImage());
        Entity enemy2 = new Ballom(11, 9, Sprite.balloom_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);

        Entity enemy3 = new Kondoria(1, 3, Sprite.kondoria_right1.getFxImage());
        Entity enemy4 = new Kondoria(1, 7, Sprite.kondoria_right1.getFxImage());
        Entity enemy5 = new Kondoria(1, 11, Sprite.kondoria_right1.getFxImage());
        entities.add(enemy3);
        entities.add(enemy4);
        entities.add(enemy5);

        Entity enemy6 = new Oneal(7, 5, Sprite.oneal_right1.getFxImage());
        Entity enemy7 = new Oneal(19, 7, Sprite.oneal_right1.getFxImage());
        entities.add(enemy6);
        entities.add(enemy7);

        for (Entity animal : entities) {
            animal.setLife(true);
        }
    }
}
