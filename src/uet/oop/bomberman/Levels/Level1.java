package uet.oop.bomberman.Levels;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame.*;

import static uet.oop.bomberman.entities.items.SpeedItem.*;
import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Bomb.*;
import uet.oop.bomberman.components.*;
import uet.oop.bomberman.components.Component;
import static uet.oop.bomberman.entities.Bomber.*;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;

import static javafx.application.Application.getUserAgentStylesheet;
import static uet.oop.bomberman.BombermanGame.*;


public class Level1 {
    public Level1() {
        stillObjects.clear();
        entities.clear();
        swap_kill = 1;
        power_bomb = 0;
        new MapCreation("res/levels/Level1.txt");
        is_bomb = 0;
        speed = 1;
    }
}
