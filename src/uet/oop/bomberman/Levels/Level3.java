package uet.oop.bomberman.Levels;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.BigPoyo;
import uet.oop.bomberman.entities.enemy.BakudaBlack;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.is_bomb;
import static uet.oop.bomberman.entities.Bomber.swap_kill;

public class Level3 {
    public Level3() {
        entities.clear();
        stillObjects.clear();
        swap_kill = 1;
        try {
            new MapCreation("Level3.txt");
        } catch (Exception e){}
        bomberman.setLife(true);
        bomberman.setX(32);
        bomberman.setY(32);
        BombItem.BombMax = false;
        Bar.llevel.setText("Level: 3");
        Bomb.bomb_number =20;
        Bar.time_number = 120;
        is_bomb = 0;


        Entity enemy1 = new BigPoyo(5, 5, Sprite.bigPoyo_left1.getFxImage());
        Entity enemy2 = new BigPoyo(11, 9, Sprite.bigPoyo_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);

        Entity enemy3 = new BakudaBlack(7, 5, Sprite.bakudaBlack_left1.getFxImage());
        entities.add(enemy3);

        for (Entity animal : entities) {
            animal.setLife(true);
        }
    }
}
