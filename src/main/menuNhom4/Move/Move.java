package Move;

import components.Blocked;
import entities.Animal;
import entities.Ballom;
import entities.Bomber;
import graphics.Sprite;



public class Move {
    private static int speed = 8;
    public static void checkRun(Animal animal) {    //Check if all your mob move or not
        if (animal instanceof Bomber && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 8 * speed);
            animal.setCount(animal.getCount() - 1);
        }
        if (animal instanceof Ballom && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 4);
            animal.setCount(animal.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Animal animal, int isMove) {     //Show the direction of all mob
        switch (direction) {
            case "down":
                down_step(animal);
                animal.setY(animal.getY() + isMove);
                break;
            case "up":
                up_step(animal);
                animal.setY(animal.getY() - isMove);
                break;
            case "left":
                left_step(animal);
                animal.setX(animal.getX() - isMove);
                break;
            case "right":
                right_step(animal);
                animal.setX(animal.getX() + isMove);
                break;
        }
    }
    private static void left_step(Animal animal) {      //Show the animation of all mob that go left

        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
            }
        }



    }
    public static void down(Animal animal) {        //Control all mob to go down
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if (animal instanceof Ballom
                    && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void down_step(Animal animal) {      //Show the animation of all mob that go down

        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
            }
        }

    }
    public static void up(Animal animal) {      //Control all mob to go up
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if (animal instanceof Ballom && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }
    private static void up_step(Animal animal) {        //Show the animation of all mob that go down

        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
            }
        }


    }
    public static void left(Animal animal) {        //Control all mob to go left
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if (animal instanceof Ballom

                    && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }
    public static void right(Animal animal) {       //Control all mob to go right
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if (animal instanceof Ballom
                    && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    public static void right_step(Animal animal) {      //Show the animation of all mob that go right


        if (animal instanceof Ballom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
            }
        }


    }
}
