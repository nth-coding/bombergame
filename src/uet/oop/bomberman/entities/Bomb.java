package uet.oop.bomberman.entities;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import uet.oop.bomberman.components.*;
//import Features.SoundManager;
//import static Control.Menu.bomb_number;
import uet.oop.bomberman.*;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.*;

public class Bomb extends Entity {

    public static int bomb_number = 20;
    private static long time_bomb;      // Exploding time bomb
    private static long time_tmp;       // Time between 2 bombings
    private static Entity bomb;
    private static int swap_active = 1;     // Change the operational state of the bomb
    private static int swap_explosion = 1;  // Change bomb's explosive state
    private static final List<Entity> list_bomb_middle_width = new ArrayList();
    private static final List<Entity> list_bomb_middle_height = new ArrayList();
    public static int power_bomb = 0;   // Bomb's destructive power
    private static int power_bomb_down = 0;     // Bomb's destructive power from top to bottom
    private static int power_bomb_up = 0;       // The bomb's destructive power is from the bottom up
    private static int power_bomb_left = 0;     // Bomb's destructive power is from right to left
    private static int power_bomb_right = 0;    // The explosive power of the bomb is from left to right
    private static Entity edge_down = null;     // The bottom edge of the block blocks the character from going through
    private static Entity edge_up = null;       // The up edge of the block blocks the character from going through
    private static Entity edge_left = null;     // The left edge of the block blocks the character from going through
    private static Entity edge_right = null;    // The right edge of the block blocks the character from going through
    private static boolean is_edge = false;     // Check if that edge exists
    private static boolean is_middle = false;   // Check if the bomb explodes in the center (plus sign, not T )
    public static int is_bomb = 0;      // Check to see if there's a bomb there: //0 no bomb  //1 had bomb  //2 explosion
    private static MediaPlayer mediaPlayerbomb;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void putBomb() {      // The function used for the bomber to place the bomb
        if (is_bomb == 0 && bomb_number > 0
                && id_objects[bomberman.getX() / 32][bomberman.getY() / 32 + 1] != 2
                && id_objects[bomberman.getX() / 32][bomberman.getY() / 32 + 1] != 3) {
            //new SoundManager("sound/put_bombs.wav", "putBomb");
            Media h = new Media(new File("res/sound/put_bombs.wav").toURI().toString());
            mediaPlayerbomb = new MediaPlayer(h);

            mediaPlayerbomb.play();
            bomb_number--;
            is_bomb = 1;
            time_bomb = System.currentTimeMillis();
            time_tmp = time_bomb;
            int x = bomberman.getX() / 32;
            int y = bomberman.getY() / 32;
            x = Math.round((float) x);
            y = Math.round((float) y);
            bomb = new Bomb(x, y + 1, Sprite.bomb.getFxImage());
            stillObjects.add(bomb);
            id_objects[bomberman.getX() / 32][bomberman.getY() / 32 + 1] = 4;
        }
    }

    public static void activeBomb() {   // Show the animation from the time the bomb is placed to the time it explodes
        if (swap_active == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swap_active = 2;
        } else if (swap_active == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 3;
        } else if (swap_active == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swap_active = 4;
        } else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swap_active = 1;
        }

    }

    public static void createEdge() {   // Create an egde to prevent the character's movement as well as the explosion range of the bomb
        int i;
        if (Blocked.block_down_bomb(bomb, 0)) {
            edge_down = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + 1, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for (i = 1; i <= power_bomb && Blocked.block_down_bomb(bomb, i); ++i) {
                    if (id_objects[bomb.getX() / 32][bomb.getY() / 32 + 1 + power_bomb_down] == 3) {
                        break;
                    }
                    edge_down.setY(bomb.getY() + 32 + i * 32);
                    ++power_bomb_down;
                }
            }
            stillObjects.add(edge_down);

        }

        if (Blocked.block_up_bomb(bomb, 0)) {
            edge_up = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - 1, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for (i = 1; i <= power_bomb && Blocked.block_up_bomb(bomb, i); ++i) {
                    if (id_objects[bomb.getX() / 32][bomb.getY() / 32 - 1 - power_bomb_up] == 3) {
                        break;
                    }
                    edge_up.setY(bomb.getY() - 32 - i * 32);
                    ++power_bomb_up;
                }
            }

            stillObjects.add(edge_up);
        }

        if (Blocked.block_left_bomb(bomb, 0)) {
            edge_left = new Bomb(bomb.getX() / 32 - 1, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for (i = 1; i <= power_bomb && Blocked.block_left_bomb(bomb, i); ++i) {
                    if (id_objects[bomb.getX() / 32 - 1 - power_bomb_left][bomb.getY() / 32] == 3) {
                        break;
                    }
                    edge_left.setX(bomb.getX() - 32 - i * 32);
                    ++power_bomb_left;
                }
            }

            stillObjects.add(edge_left);
        }

        if (Blocked.block_right_bomb(bomb, 0)) {
            edge_right = new Bomb(bomb.getX() / 32 + 1, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            if (power_bomb > 0) {
                for (i = 1; i <= power_bomb && Blocked.block_right_bomb(bomb, i); ++i) {
                    if (id_objects[bomb.getX() / 32 + 1 + power_bomb_right][bomb.getY() / 32] == 3) {
                        break;
                    }
                    edge_right.setX(bomb.getX() + 32 + i * 32);
                    ++power_bomb_right;
                }
            }

            stillObjects.add(edge_right);
        }

    }

    public static void createMiddle() {     // Adjust the bomb to explode at the center position
        Entity middle;
        int i;
        for (i = 1; i <= power_bomb_down; i++) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + i, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_height.add(middle);
        }

        for (i = 1; i <= power_bomb_up; i++) {
            middle = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - i, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_height.add(middle);
        }

        for (i = 1; i <= power_bomb_left; i++) {
            middle = new Bomb(bomb.getX() / 32 - i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_width.add(middle);
        }

        for (i = 1; i <= power_bomb_right; i++) {
            middle = new Bomb(bomb.getX() / 32 + i, bomb.getY() / 32, Sprite.bomb_exploded.getFxImage());
            list_bomb_middle_width.add(middle);
        }

        stillObjects.addAll(list_bomb_middle_width);
        stillObjects.addAll(list_bomb_middle_height);
    }

    public static void explosionCenter() {      // Determine the explosion center of the bomb
        if (swap_explosion == 1) {
            bomb.setImg(Sprite.bomb_exploded.getFxImage());
            list_kill[bomb.getX() / 32][bomb.getY() / 32] = 4;
            if (Blocked.block_down_bomb(bomb, power_bomb_down)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 + 1 + power_bomb_down] != 3) {
                    edge_down.setImg(Sprite.explosion_vertical_down_last.getFxImage());
                } else {
                    edge_down.setImg(Sprite.brick_exploded.getFxImage());
                }
                list_kill[edge_down.getX() / 32][edge_down.getY() / 32] = 4;
            }

            if (Blocked.block_up_bomb(bomb, power_bomb_up)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 - 1 - power_bomb_up] != 3) {
                    edge_up.setImg(Sprite.explosion_vertical_top_last.getFxImage());
                } else {
                    edge_up.setImg(Sprite.brick_exploded.getFxImage());
                }
                list_kill[edge_up.getX() / 32][edge_up.getY() / 32] = 4;
            }

            if (Blocked.block_left_bomb(bomb, power_bomb_left)) {
                if (id_objects[bomb.getX() / 32 - 1 - power_bomb_left][bomb.getY() / 32] != 3) {
                    edge_left.setImg(Sprite.explosion_horizontal_left_last.getFxImage());
                } else {
                    edge_left.setImg(Sprite.brick_exploded.getFxImage());
                }
                list_kill[edge_left.getX() / 32][edge_left.getY() / 32] = 4;
            }

            if (Blocked.block_right_bomb(bomb, power_bomb_right)) {
                if (id_objects[bomb.getX() / 32 + 1 + power_bomb_right][bomb.getY() / 32] != 3) {
                    edge_right.setImg(Sprite.explosion_horizontal_right_last.getFxImage());
                } else {
                    edge_right.setImg(Sprite.brick_exploded.getFxImage());
                }
                list_kill[edge_right.getX() / 32][edge_right.getY() / 32] = 4;
            }

            if (list_bomb_middle_height.size() > 0) {
                for (Entity e : list_bomb_middle_height) {
                    e.setImg(Sprite.explosion_vertical.getFxImage());
                    list_kill[e.getX() / 32][e.getY() / 32] = 4;
                }
            }

            if (list_bomb_middle_width.size() > 0) {
                for (Entity e : list_bomb_middle_width) {
                    e.setImg(Sprite.explosion_horizontal.getFxImage());
                    list_kill[e.getX() / 32][e.getY() / 32] = 4;
                }
            }

            swap_explosion = 2;
        } else if (swap_explosion == 2) {
            bomb.setImg(Sprite.bomb_exploded1.getFxImage());
            if (Blocked.block_down_bomb(bomb, power_bomb_down)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 + 1 + power_bomb_down] != 3) {
                    edge_down.setImg(Sprite.explosion_vertical_down_last1.getFxImage());
                } else {
                    edge_down.setImg(Sprite.brick_exploded1.getFxImage());
                }
            }

            if (Blocked.block_up_bomb(bomb, power_bomb_up)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 - 1 - power_bomb_up] != 3) {
                    edge_up.setImg(Sprite.explosion_vertical_top_last1.getFxImage());
                } else {
                    edge_up.setImg(Sprite.brick_exploded1.getFxImage());
                }
            }

            if (Blocked.block_left_bomb(bomb, power_bomb_left)) {
                if (id_objects[bomb.getX() / 32 - 1 - power_bomb_left][bomb.getY() / 32] != 3) {
                    edge_left.setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
                } else {
                    edge_left.setImg(Sprite.brick_exploded1.getFxImage());
                }
            }

            if (Blocked.block_right_bomb(bomb, power_bomb_right)) {
                if (id_objects[bomb.getX() / 32 + 1 + power_bomb_right][bomb.getY() / 32] != 3) {
                    edge_right.setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
                } else {
                    edge_right.setImg(Sprite.brick_exploded1.getFxImage());
                }
            }

            if (is_middle) {
                for (Entity e : list_bomb_middle_height) {
                    e.setImg(Sprite.explosion_vertical1.getFxImage());
                }
                for (Entity e : list_bomb_middle_width) {
                    e.setImg(Sprite.explosion_horizontal1.getFxImage());
                }
            }

            swap_explosion = 3;
        } else if (swap_explosion == 3) {
            bomb.setImg(Sprite.bomb_exploded2.getFxImage());
            if (Blocked.block_down_bomb(bomb, power_bomb_down)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 + 1 + power_bomb_down] != 3) {
                    edge_down.setImg(Sprite.explosion_vertical_down_last2.getFxImage());
                } else {
                    edge_down.setImg(Sprite.brick_exploded2.getFxImage());
                }
            }

            if (Blocked.block_up_bomb(bomb, power_bomb_up)) {
                if (id_objects[bomb.getX() / 32][bomb.getY() / 32 - 1 - power_bomb_up] != 3) {
                    edge_up.setImg(Sprite.explosion_vertical_top_last2.getFxImage());
                } else {
                    edge_up.setImg(Sprite.brick_exploded2.getFxImage());
                }
            }

            if (Blocked.block_left_bomb(bomb, power_bomb_left)) {
                if (id_objects[bomb.getX() / 32 - 1 - power_bomb_left][bomb.getY() / 32] != 3) {
                    edge_left.setImg(Sprite.explosion_horizontal_left_last2.getFxImage());
                } else {
                    edge_left.setImg(Sprite.brick_exploded2.getFxImage());
                }
            }

            if (Blocked.block_right_bomb(bomb, power_bomb_right)) {
                if (id_objects[bomb.getX() / 32 + 1 + power_bomb_right][bomb.getY() / 32] != 3) {
                    edge_right.setImg(Sprite.explosion_horizontal_right_last2.getFxImage());
                } else {
                    edge_right.setImg(Sprite.brick_exploded2.getFxImage());
                }
            }

            if (is_middle) {
                for (Entity e : list_bomb_middle_height) {
                    e.setImg(Sprite.explosion_vertical2.getFxImage());
                }
                for (Entity e : list_bomb_middle_width) {
                    e.setImg(Sprite.explosion_horizontal2.getFxImage());
                }
            }

            swap_explosion = 1;
        }

    }

    private static void checkActive() {     // Check what stages the bomb has gone through before detonating
        if (is_bomb == 1) {
            if (System.currentTimeMillis() - time_bomb < 2000L) {
                if (System.currentTimeMillis() - time_tmp > 100L) {
                    activeBomb();
                    time_tmp += 100L;
                }
            } else {
                is_bomb = 2;
                time_bomb = System.currentTimeMillis();
                time_tmp = time_bomb;
            }
        }
    }

    private static void checkExplosion() {      // Check the bomb's detonation time after the bomb is activated
        if (is_bomb == 2) {
            if (System.currentTimeMillis() - time_bomb < 330L) {
                if (System.currentTimeMillis() - time_tmp > 30L) {
                    if (!is_edge) {
                        createEdge();
                        is_edge = true;
                    }

                    if (power_bomb > 0 && !is_middle) {
                        createMiddle();
                        is_middle = true;
                    }

                    //new SoundManager("sound/bomb_explosion.wav", "explosion");
                    Media h = new Media(new File("res/sound/bomb_explosion.wav").toURI().toString());
                    mediaPlayerbomb = new MediaPlayer(h);
                    mediaPlayerbomb.play();
                    explosionCenter();
                    time_tmp += 100L;
                }
            } else {
                is_bomb = 0;
                id_objects[bomb.getX() / 32][bomb.getY() / 32] = 0;
                list_kill[bomb.getX() / 32][bomb.getY() / 32] = 0;
                bomb.setImg(Sprite.transparent.getFxImage());
                if (Blocked.block_down_bomb(bomb, power_bomb_down)) {
                    edge_down.setImg(Sprite.transparent.getFxImage());
                    id_objects[edge_down.getX() / 32][edge_down.getY() / 32] = 0;
                    list_kill[edge_down.getX() / 32][edge_down.getY() / 32] = 0;
                }

                if (Blocked.block_up_bomb(bomb, power_bomb_up)) {
                    edge_up.setImg(Sprite.transparent.getFxImage());
                    id_objects[edge_up.getX() / 32][edge_up.getY() / 32] = 0;
                    list_kill[edge_up.getX() / 32][edge_up.getY() / 32] = 0;
                }

                if (Blocked.block_left_bomb(bomb, power_bomb_left)) {
                    edge_left.setImg(Sprite.transparent.getFxImage());
                    id_objects[edge_left.getX() / 32][edge_left.getY() / 32] = 0;
                    list_kill[edge_left.getX() / 32][edge_left.getY() / 32] = 0;
                }

                if (Blocked.block_right_bomb(bomb, power_bomb_right)) {
                    edge_right.setImg(Sprite.transparent.getFxImage());
                    id_objects[edge_right.getX() / 32][edge_right.getY() / 32] = 0;
                    list_kill[edge_right.getX() / 32][edge_right.getY() / 32] = 0;
                }

                if (is_middle) {
                    for (Entity e : list_bomb_middle_width) {
                        list_kill[e.getX() / 32][e.getY() / 32] = 0;
                        id_objects[e.getX() / 32][e.getY() / 32] = 0;
                    }
                    for (Entity e : list_bomb_middle_height) {
                        list_kill[e.getX() / 32][e.getY() / 32] = 0;
                        id_objects[e.getX() / 32][e.getY() / 32] = 0;
                    }
                }

                stillObjects.removeAll(list_bomb_middle_height);
                stillObjects.removeAll(list_bomb_middle_width);
                list_bomb_middle_height.clear();
                list_bomb_middle_width.clear();
                is_edge = false;
                is_middle = false;
                power_bomb_down = 0;
                power_bomb_up = 0;
                power_bomb_left = 0;
                power_bomb_right = 0;
            }
        }

    }

    @Override
    public void update() {
        checkActive();
        checkExplosion();
    }
}