package uet.oop.bomberman.components;

import uet.oop.bomberman.entities.PvP.PvPBomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class PvPComponentAnimation {
    public static void down_step(Entity entity) {      //Show the animation of all mob that go down
        if (entity instanceof PvPBomber && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.player_down.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.player_down_1.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.player_down.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.player_down_2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void up_step(Entity entity) {        //Show the animation of all mob that go down
        if (entity instanceof PvPBomber && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.player_up.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.player_up_1.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.player_up.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.player_up_2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void left_step(Entity entity) {      //Show the animation of all mob that go left
        if (entity instanceof PvPBomber && entity.getX() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.player_left.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.player_left_1.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.player_left.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.player_left_2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void right_step(Entity entity) {      //Show the animation of all mob that go right
        if (entity instanceof PvPBomber && entity.getX() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.player_right.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.player_right_1.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.player_right.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.player_right_2.getFxImage());
                entity.setSwap(1);
            }
        }
    }
}
