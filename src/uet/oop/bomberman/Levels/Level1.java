package uet.oop.bomberman.Levels;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame.*;

import static uet.oop.bomberman.entities.Entity.*;
import static uet.oop.bomberman.BombermanGame.*;
import uet.oop.bomberman.components.*;
import uet.oop.bomberman.components.Component;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.Sprite;

import static javafx.application.Application.getUserAgentStylesheet;
import static uet.oop.bomberman.BombermanGame.*;


public class Level1 {
    public Level1() {
        stillObjects.clear();
        entities.clear();
        new MapCreation("res/levels/Level1.txt");
        //Image transparent = new Image("images/transparent.png");
    }
}
