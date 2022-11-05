package uet.oop.bomberman.Levels;

import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.*;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.PvPMapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import static uet.oop.bomberman.PvPGame.*;
//import static uet.oop.bomberman.PvPGame.entities;
import static uet.oop.bomberman.PvPGame.player1;
import static uet.oop.bomberman.PvPGame.player2;
import static uet.oop.bomberman.entities.Bomb.is_bomb;
import static uet.oop.bomberman.entities.Bomber.swap_kill;

public class Level_PvP {
    public Level_PvP() {
        stillObjectsPvP.clear();
        entities.clear();

//        level = 1;
        swap_kill = 1;
        try {
            new PvPMapCreation("PvPMap.txt");
        }catch (Exception e){}
        player1.setLife(true);
        player2.setLife(true);
        is_bomb = 0;
//        BombItem.BombMax = false;
//        Bomb.bomb_number =20;
//        Bar.time_number = 120;
//        Bar.llevel.setText("Level: 1");

//        Entity enemy1 = new PvPSmallPoyo(4, 4, Sprite.smallPoyo_left1.getFxImage());
//        Entity enemy2 = new PvPSmallPoyo(9, 9, Sprite.smallPoyo_left1.getFxImage());
//        Entity enemy3 = new PvPSmallPoyo(22, 6, Sprite.smallPoyo_left1.getFxImage());
//        entities.add(enemy1);
//        entities.add(enemy2);
//        entities.add(enemy3);
//
//        Entity enemy4 = new PvPBigPoyo(7, 6, Sprite.bigPoyo_left1.getFxImage());
//        Entity enemy5 = new PvPBigPoyo(13, 8, Sprite.bigPoyo_left1.getFxImage());
//        entities.add(enemy4);
//        entities.add(enemy5);

//        entities.clear();
//         set default for enemy
        for (Entity Entity : entities) {
            Entity.setLife(true);
        }
    }
}
