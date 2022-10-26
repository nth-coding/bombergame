package uet.oop.bomberman.components;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.Ballom;
import uet.oop.bomberman.entities.enemy.Doll;
import uet.oop.bomberman.entities.enemy.Kondoria;
import uet.oop.bomberman.entities.enemy.Oneal;
import uet.oop.bomberman.graphics.Sprite;

public class ComponentAnimation {
    public static void down_step(Entity entity) {      //Show the animation of all mob that go down
        if (entity instanceof Bomber && entity.getY() % 8 == 0) {
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
        if (entity instanceof Ballom && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Oneal && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.oneal_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.oneal_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.oneal_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.oneal_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Doll && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.doll_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.doll_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.doll_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.doll_left2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void up_step(Entity entity) {        //Show the animation of all mob that go down
        if (entity instanceof Bomber && entity.getY() % 8 == 0) {
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
        if (entity instanceof Ballom && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Oneal && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.oneal_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.oneal_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.oneal_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.oneal_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Doll && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.doll_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.doll_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.doll_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.doll_right2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void left_step(Entity entity) {      //Show the animation of all mob that go left
        if (entity instanceof Bomber && entity.getX() % 8 == 0) {
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
        if (entity instanceof Ballom && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Oneal && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.oneal_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.oneal_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.oneal_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.oneal_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Doll && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.doll_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.doll_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.doll_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.doll_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Kondoria && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.kondoria_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.kondoria_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.kondoria_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.kondoria_left2.getFxImage());
                entity.setSwap(1);
            }
        }
    }

    public static void right_step(Entity entity) {      //Show the animation of all mob that go right
        if (entity instanceof Bomber && entity.getX() % 8 == 0) {
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

        if (entity instanceof Ballom && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.balloom_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.balloom_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.balloom_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Oneal && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.oneal_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.oneal_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.oneal_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.oneal_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Doll && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.doll_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.doll_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.doll_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.doll_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Kondoria && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.kondoria_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.kondoria_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.kondoria_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.kondoria_right2.getFxImage());
                entity.setSwap(1);
            }
        }
    }
}
