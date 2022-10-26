package uet.oop.bomberman.Levels;

import static uet.oop.bomberman.BombermanGame.*;

//Class NextLevel to choose level but for now only have 1 level.
public class NextLevel {
    public static boolean wait;
    public static long waiting_time;
    public static void  waitToLevelUp() {
        long now = System.currentTimeMillis();
        if (now - waiting_time > 3000) {
            new Level1();
            running = true;
            wait = false;
        }
    }
}
