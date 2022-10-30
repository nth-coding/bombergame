package uet.oop.bomberman.components;

import uet.oop.bomberman.entities.enemy.Ballom;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.Doll;
import uet.oop.bomberman.entities.enemy.Kondoria;
import uet.oop.bomberman.entities.enemy.Oneal;


import static uet.oop.bomberman.BombermanGame.running;
import static uet.oop.bomberman.entities.items.SpeedItem.speed;


public class ComponentMovement {
    public static void checkRun(Entity entity) {    //Check if all your mob move or not
        if (entity instanceof Bomber && entity.getCount() > 0) {
            setDirection(entity.getDirection(), entity, 8* speed);
            entity.setCount(entity.getCount() - 1);
        }
        if ((entity instanceof Ballom || entity instanceof Oneal
                || entity instanceof Doll || entity instanceof Kondoria)
                && entity.getCount() > 0) {
            setDirection(entity.getDirection(), entity, 4);
            entity.setCount(entity.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Entity entity, int speed) {     //Show the direction of all mob
        switch (direction) {
            case "down":
                ComponentAnimation.down_step(entity);
                entity.setY(entity.getY() + speed);
                break;
            case "up":
                ComponentAnimation.up_step(entity);
                entity.setY(entity.getY() - speed);
                break;
            case "left":
                ComponentAnimation.left_step(entity);
                entity.setX(entity.getX() - speed);
                break;
            case "right":
                ComponentAnimation.right_step(entity);
                entity.setX(entity.getX() + speed);
                break;
        }
    }

    public static void down(Entity entity) {        //Control all mob to go down

        if (entity.getY() % 32 == 0 && entity.getX() % 32 == 0) {
            if (entity instanceof Bomber && Blocked.block_down(entity)) {
                entity.setDirection("down");
                if(running ==false) entity.setCount(0);
                else entity.setCount(4/speed);
                checkRun(entity);
            }
            if ((entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll)
                    && Blocked.block_down(entity)) {
                entity.setDirection("down");
                if(running ==false) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }
    public static void up(Entity entity) {      //Control all mob to go up

        if (entity.getY() % 32 == 0 && entity.getX() % 32 == 0) {
            if (entity instanceof Bomber && Blocked.block_up(entity)) {
                entity.setDirection("up");
                if(running ==false) entity.setCount(0);
                else entity.setCount(4/speed);
                checkRun(entity);
            }
            if ((entity instanceof Ballom || entity instanceof Oneal || entity instanceof Doll)
                    && Blocked.block_up(entity)) {
                entity.setDirection("up");
                if(running ==false) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }
    public static void left(Entity entity) {        //Control all mob to go left

        if (entity.getX() % 32 == 0 && entity.getY() % 32 == 0) {
            if (entity instanceof Bomber && Blocked.block_left(entity)) {
                entity.setDirection("left");
                if(running ==false) entity.setCount(0);
                else entity.setCount(4/speed);
                checkRun(entity);
            }
            if ((entity instanceof Ballom || entity instanceof Oneal
                    || entity instanceof Doll || entity instanceof Kondoria)
                    && Blocked.block_left(entity)) {
                entity.setDirection("left");
                if(running ==false) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }
    public static void right(Entity entity) {       //Control all mob to go right

        if (entity.getX() % 32 == 0 && entity.getY() % 32 == 0) {
            if (entity instanceof Bomber && Blocked.block_right(entity)) {
                entity.setDirection("right");
                if(running ==false) entity.setCount(0);
                else entity.setCount(4/speed);
                checkRun(entity);
            }
            if ((entity instanceof Ballom || entity instanceof Oneal
                    || entity instanceof Doll || entity instanceof Kondoria)
                    && Blocked.block_right(entity)) {
                entity.setDirection("right");
                if(running ==false) entity.setCount(0);
                else entity.setCount(8);
                checkRun(entity);
            }
        }
    }
}
