package uet.oop.bomberman.Levels;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.BakudaBlack;
import uet.oop.bomberman.entities.enemy.BigPoyo;
import uet.oop.bomberman.entities.enemy.Gurorin;
import uet.oop.bomberman.entities.enemy.SmallPoyo;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.BombermanGame.stillObjects;
import static uet.oop.bomberman.BombermanGame.level;
import static uet.oop.bomberman.entities.Bomb.is_bomb;
import static uet.oop.bomberman.entities.Bomber.swap_kill;
import static uet.oop.bomberman.entities.items.SpeedItem.speed;


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
        Bomb.power_bomb =0;
        BombItem.BombMax = false;
        Bar.llevel.setText("Level: 2");
        Bomb.bomb_number = 20;
        Bar.time_number = 120;
//        level = 2;

        Entity enemy1 = new BigPoyo(5, 5, Sprite.bigPoyo_left1.getFxImage());
        Entity enemy2 = new BigPoyo(11, 9, Sprite.bigPoyo_left1.getFxImage());
        entities.add(enemy1);
        entities.add(enemy2);

        Entity enemy3 = new Gurorin(1, 3, Sprite.gurorin_right1.getFxImage());
        Entity enemy4 = new Gurorin(1, 7, Sprite.gurorin_right1.getFxImage());
        Entity enemy5 = new BakudaBlack(1, 11, Sprite.bakudaBlack_right1.getFxImage());
        entities.add(enemy3);
        entities.add(enemy4);
        entities.add(enemy5);

        Entity enemy6 = new SmallPoyo(7, 5, Sprite.smallPoyo_right1.getFxImage());
        Entity enemy7 = new SmallPoyo(19, 7, Sprite.smallPoyo_right1.getFxImage());
        entities.add(enemy6);
        entities.add(enemy7);

//        entities.clear();

        for (Entity animal : entities) {
            animal.setLife(true);
        }
    }
}
