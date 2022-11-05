package uet.oop.bomberman.components;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.enemy.*;
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
        if (entity instanceof BigPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bigPoyo_down1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bigPoyo_down2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bigPoyo_down1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bigPoyo_down2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof SmallPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.smallPoyo_down1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.smallPoyo_down2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.smallPoyo_down1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.smallPoyo_down2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaBlack && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaBlack_down1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaBlack_down2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaBlack_down1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaBlack_down2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaRed && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaRed_down1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaRed_down2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaRed_down1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaRed_down2.getFxImage());
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
        if (entity instanceof BigPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bigPoyo_up1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bigPoyo_up2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bigPoyo_up1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bigPoyo_up2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof SmallPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.smallPoyo_up1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.smallPoyo_up2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.smallPoyo_up1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.smallPoyo_up2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaBlack && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaBlack_up1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaBlack_up2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaBlack_up1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaBlack_up2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaRed && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaRed_up1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaRed_up2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaRed_up1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaRed_up2.getFxImage());
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
        if (entity instanceof BigPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bigPoyo_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bigPoyo_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bigPoyo_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bigPoyo_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof SmallPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.smallPoyo_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.smallPoyo_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.smallPoyo_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.smallPoyo_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaRed && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaRed_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaRed_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaRed_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaRed_left2.getFxImage());
                entity.setSwap(1);
            }
        }

        if (entity instanceof BakudaBlack && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaBlack_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaBlack_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaBlack_left1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaBlack_left2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Gurorin && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.gurorin_left1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.gurorin_left2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.gurorin_left3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.gurorin_left2.getFxImage());
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

        if (entity instanceof BigPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bigPoyo_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bigPoyo_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bigPoyo_right1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bigPoyo_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof SmallPoyo && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.smallPoyo_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.smallPoyo_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.smallPoyo_right1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.smallPoyo_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaRed && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaRed_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaRed_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaRed_right1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaRed_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof BakudaBlack && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.bakudaBlack_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.bakudaBlack_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.bakudaBlack_right1.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.bakudaBlack_right2.getFxImage());
                entity.setSwap(1);
            }
        }
        if (entity instanceof Gurorin && entity.getY() % 8 == 0) {
            if (entity.getSwap() == 1) {
                entity.setImg(Sprite.gurorin_right1.getFxImage());
                entity.setSwap(2);
            } else if (entity.getSwap() == 2) {
                entity.setImg(Sprite.gurorin_right2.getFxImage());
                entity.setSwap(3);
            } else if (entity.getSwap() == 3) {
                entity.setImg(Sprite.gurorin_right3.getFxImage());
                entity.setSwap(4);
            } else {
                entity.setImg(Sprite.gurorin_right2.getFxImage());
                entity.setSwap(1);
            }
        }
    }
}
