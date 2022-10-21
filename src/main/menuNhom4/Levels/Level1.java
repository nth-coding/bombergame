package Levels;

import graphics.MapCreation;

import java.io.FileNotFoundException;

import static view.BombermanGame.entities;
import static view.BombermanGame.stillObjects;
public class Level1 {
    public Level1() {
        stillObjects.clear();
        entities.clear();
        try {
            MapCreation a = new MapCreation("Hieu");
        } catch (FileNotFoundException e){}
        //Image transparent = new Image("images/transparent.png");
    }
}
