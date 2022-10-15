package uet.oop.bomberman.Levels;

import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Portal.is_portal;

//Class NextLevel to choose level but for now only have 1 level.
public class NextLevel {
    public static void waitToLevelUp() {
        new Level1();
    }
}
