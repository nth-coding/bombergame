package uet.oop.bomberman.components;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.PvP.PvPBomber;
import uet.oop.bomberman.entities.enemy.*;

import static uet.oop.bomberman.BombermanGame.*;

public class PvPComponentMovement {
    public static void checkRun(Entity entity) { // Check if all your mob move or not
        if (entity instanceof PvPBomber && entity.getCount() > 0) {
            setDirection(entity.getDirection(), entity, 8 * entity.getSpeed());
            entity.setCount(entity.getCount() - 1);
        }
        if ((entity instanceof PvPBigPoyo || entity instanceof PvPSmallPoyo)
                && entity.getCount() > 0) {
            setDirection(entity.getDirection(), entity, 4);
            entity.setCount(entity.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Entity entity, int speed) { // Show the direction of all mob
        switch (direction) {
            case "down":
                PvPComponentAnimation.down_step(entity);
                entity.setY(entity.getY() + speed);
                // entity.setY(entity.getY() + entity.getVelY());
                break;
            case "up":
                PvPComponentAnimation.up_step(entity);
                entity.setY(entity.getY() - speed);
                // entity.setY(entity.getY() + entity.getVelY());
                break;
            case "left":
                PvPComponentAnimation.left_step(entity);
                entity.setX(entity.getX() - speed);
                // entity.setX(entity.getX() + entity.getVelX());
                break;
            case "right":
                PvPComponentAnimation.right_step(entity);
                entity.setX(entity.getX() + speed);
                // entity.setX(entity.getX() + entity.getVelX());
                break;
        }
    }

    public static void down(Entity entity) { // Control all mob to go down
        if (entity.getY() % 32 == 0 && entity.getX() % 32 == 0) {
            if (entity instanceof PvPBomber && PvPBlocked.block_down(entity)) {
                entity.setDirection("down");
                entity.setCount(4);
                checkRun(entity);
            }
            if ((entity instanceof PvPBigPoyo)
                    && PvPBlocked.block_down(entity)) {
                entity.setDirection("down");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
            if (entity instanceof PvPSmallPoyo && entity.getY() / 32 < height - 2) {
                entity.setDirection("down");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }

    public static void up(Entity entity) { // Control all mob to go up
        if (entity.getY() % 32 == 0 && entity.getX() % 32 == 0) {
            if (entity instanceof PvPBomber && PvPBlocked.block_up(entity)) {
                entity.setDirection("up");
                entity.setCount(4);
                checkRun(entity);
            }
            if ((entity instanceof PvPBigPoyo)
                    && PvPBlocked.block_up(entity)) {
                entity.setDirection("up");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
            if (entity instanceof PvPSmallPoyo && entity.getY() / 32 > 1) {
                entity.setDirection("up");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }

    public static void left(Entity entity) { // Control all mob to go left
        if (entity.getX() % 32 == 0 && entity.getY() % 32 == 0) {
            if (entity instanceof PvPBomber && PvPBlocked.block_left(entity)) {
                entity.setDirection("left");
                entity.setCount(4);
                checkRun(entity);
            }
        }
        if ((entity instanceof PvPBigPoyo)
                && PvPBlocked.block_left(entity)) {
            entity.setDirection("left");
            if (!running) entity.setCount(0);
            else entity.setCount(8);
            checkRun(entity);
        }
        if (entity instanceof PvPSmallPoyo && entity.getX() / 32 > 2) {
            entity.setDirection("left");
            if (!running) entity.setCount(0);
            else entity.setCount(8);
            checkRun(entity);
        }
    }

    public static void right(Entity entity) { // Control all mob to go right
        if (entity.getX() % 32 == 0 && entity.getY() % 32 == 0) {
            if (entity instanceof PvPBomber && PvPBlocked.block_right(entity)) {
                entity.setDirection("right");
                entity.setCount(4);
                checkRun(entity);
            }
            if ((entity instanceof PvPBigPoyo)
                    && PvPBlocked.block_right(entity)) {
                entity.setDirection("right");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
            if (entity instanceof PvPSmallPoyo && entity.getX() / 32 < width - 2) {
                entity.setDirection("right");
                if (!running) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }
}