package uet.oop.bomberman.Levels;

import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.Portal.is_portal;

//Class NextLevel to choose level but for now only have 1 level.
public class NextLevel {
    public static boolean wait;
    public static long waiting_time;
    public static void waitToLevelUp() {
        long now = System.currentTimeMillis();
        if (now - waiting_time > 3000) {
            new Level1();
            wait = false;
        }
    }
}
