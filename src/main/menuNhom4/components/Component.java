package components;

import entities.Ballom;
import entities.Bomber;
import entities.Entity;
import graphics.Sprite;

public class Component {
    public static void checkRun(Entity entity) { // Check if all your mob move or not
        if ((entity instanceof Bomber|| entity instanceof Ballom)&& entity.getCount() > 0) {
            setDirection(entity.getDirection(), entity);
            entity.setCount(entity.getCount() -1);
        }
    }

    private static void position(Entity entity) {
        entity.setX(entity.getX() + entity.getVelX());
        entity.setY(entity.getY() + entity.getVelY());
    }

    private static void setDirection(String direction, Entity entity) { // Show the direction of all mob
        switch (direction) {
            case "down":
                down_step(entity);
                entity.setY(entity.getY() +8);
                // entity.setY(entity.getY() + entity.getVelY());
                break;
            case "up":
                up_step(entity);
                entity.setY(entity.getY() - 8);
                // entity.setY(entity.getY() + entity.getVelY());
                break;
            case "left":
                left_step(entity);
                entity.setX(entity.getX() - 8);
                // entity.setX(entity.getX() + entity.getVelX());
                break;
            case "right":
                right_step(entity);
                entity.setX(entity.getX() + 8);
                // entity.setX(entity.getX() + entity.getVelX());
                break;
        }
    }

    public static void down(Entity entity) { // Control all mob to go down
        if (entity.getY() % 32 == 0 ) {
            if ((entity instanceof Bomber|| entity instanceof Ballom) && Blocked.block_down(entity) ) {
                entity.setDirection("down");
                entity.setCount(4);
                checkRun(entity);
            }
        }
    }

    public static void up(Entity entity) { // Control all mob to go up
        if (entity.getY() % 32 == 0) {
            if ((entity instanceof Bomber|| entity instanceof Ballom) && Blocked.block_up(entity) ) {
                entity.setDirection("up");
                entity.setCount(4);
                checkRun(entity);
            }
        }
    }

    public static void left(Entity entity) { // Control all mob to go left
        if (entity.getX() % 32 == 0 ) {
            if ((entity instanceof Bomber|| entity instanceof Ballom) && Blocked.block_left(entity) ) {
                entity.setDirection("left");
                entity.setCount(4);
                checkRun(entity);
            }
        }
    }

    public static void right(Entity entity) { // Control all mob to go right
        if (entity.getX() % 32 == 0 ) {
            if ((entity instanceof Bomber|| entity instanceof Ballom)&& Blocked.block_right(entity)  ) {
                entity.setDirection("right");
                entity.setCount(4);
                checkRun(entity);
            }
        }
    }

    private static void down_step(Entity entity) { // Show the animation of all mob that go down
        if ((entity instanceof Bomber)  ) {
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
        if(entity instanceof Ballom && entity.getY() % 8 == 0){
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_left3.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    private static void up_step(Entity entity) { // Show the animation of all mob that go down
        if ((entity instanceof Bomber) && entity.getY() % 8 == 0) {
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
        if(entity instanceof Ballom && entity.getY()% 8 ==0){
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_right3.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    private static void left_step(Entity entity) { // Show the animation of all mob that go left
        if ((entity instanceof Bomber) ) {
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
        if(entity instanceof Ballom && entity.getX()%8 ==0){
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_left3.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void right_step(Entity entity) { // Show the animation of all mob that go right
        if ((entity instanceof Bomber) ) {
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
        if(entity instanceof Ballom && entity.getX() % 8 ==0){
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_right3.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(1);
            }
        }
    }
}
