package uet.oop.bomberman.graphics;

import javafx.scene.image.*;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;

/**
 * Lưu trữ thông tin các pixel của 1 sprite (hình ảnh game)
 */
public class Sprite {

    public static final int DEFAULT_SIZE = 16;
    public static final int SCALED_SIZE = DEFAULT_SIZE * 2;
    private static final int TRANSPARENT_COLOR = 0xffff00ff;
    public final int SIZE;
    private int _x, _y;
    public int[] _pixels;
    protected int _realWidth;
    protected int _realHeight;
    private SpriteSheet _sheet;

    //
    // This object creates transparent color in the outline of the interface.
    public static Sprite transparent = new Sprite(DEFAULT_SIZE, 1, 1, SpriteSheet.tiles, 16, 16);
    //
    /*
     * |--------------------------------------------------------------------------
     * | Board sprites
     * |--------------------------------------------------------------------------
     */
    public static Sprite grass_shadow = new Sprite(DEFAULT_SIZE, 6, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite grass1 = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite grass2 = new Sprite(DEFAULT_SIZE, 7, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite brick1 = new Sprite(DEFAULT_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick2 = new Sprite(DEFAULT_SIZE, 6, 0, SpriteSheet.tiles, 16, 16);
//    public static Sprite wall1 = new Sprite(DEFAULT_SIZE, 5, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite wall2 = new Sprite(DEFAULT_SIZE, 8, 1, SpriteSheet.tiles, 16, 16);
//    public static Sprite portal = new Sprite(DEFAULT_SIZE, 4, 0, SpriteSheet.tiles, 14, 14);
    public static Sprite portal = new Sprite(DEFAULT_SIZE, 9, 12, SpriteSheet.tiles, 16, 16);
    /*
     * |--------------------------------------------------------------------------
     * | Bomber Sprites
     * |--------------------------------------------------------------------------
     */
    public static Sprite player_up = new Sprite(SCALED_SIZE, 0, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite player_up_1 = new Sprite(SCALED_SIZE, 1, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite player_up_2 = new Sprite(SCALED_SIZE, 2, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite player_down = new Sprite(SCALED_SIZE, 0, 2, SpriteSheet.tiles, 16, 16);
    public static Sprite player_down_1 = new Sprite(SCALED_SIZE, 1, 2, SpriteSheet.tiles, 16, 16);
    public static Sprite player_down_2 = new Sprite(SCALED_SIZE, 2, 2, SpriteSheet.tiles, 16, 16);
    public static Sprite player_left = new Sprite(SCALED_SIZE, 0, 3, SpriteSheet.tiles, 16, 16);
    public static Sprite player_left_1 = new Sprite(SCALED_SIZE, 1, 3, SpriteSheet.tiles, 16, 16);
    public static Sprite player_left_2 = new Sprite(SCALED_SIZE, 2, 3, SpriteSheet.tiles, 16, 16);
    public static Sprite player_right = new Sprite(SCALED_SIZE, 0, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite player_right_1 = new Sprite(SCALED_SIZE, 1, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite player_right_2 = new Sprite(SCALED_SIZE, 2, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead1 = new Sprite(SCALED_SIZE, 0, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead2 = new Sprite(SCALED_SIZE, 1, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead3 = new Sprite(SCALED_SIZE, 2, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead4 = new Sprite(SCALED_SIZE, 3, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead5 = new Sprite(SCALED_SIZE, 4, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite player_dead6 = new Sprite(SCALED_SIZE, 5, 4, SpriteSheet.tiles, 16, 16);
    /*
     * |--------------------------------------------------------------------------
     * | Character
     * |--------------------------------------------------------------------------
     */
    // BALLOM
    public static Sprite bigPoyo_up1 = new Sprite(SCALED_SIZE, 7, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite bigPoyo_up2 = new Sprite(SCALED_SIZE, 7, 0, SpriteSheet.tiles, 16, 16);

    public static Sprite bigPoyo_down1 = new Sprite(SCALED_SIZE, 3, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite bigPoyo_down2 = new Sprite(SCALED_SIZE, 4, 1, SpriteSheet.tiles, 16, 16);

    public static Sprite bigPoyo_left1 = new Sprite(SCALED_SIZE, 5, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite bigPoyo_left2 = new Sprite(SCALED_SIZE, 6, 1, SpriteSheet.tiles, 16, 16);

    public static Sprite bigPoyo_right1 = new Sprite(SCALED_SIZE, 6, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite bigPoyo_right2 = new Sprite(SCALED_SIZE, 7, 4, SpriteSheet.tiles, 16, 16);

    public static Sprite bigPoyo_dead = new Sprite(SCALED_SIZE, 4, 1, SpriteSheet.tiles, 16, 16);

    // smallPoyo
    public static Sprite smallPoyo_up1 = new Sprite(DEFAULT_SIZE, 6, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_up2 = new Sprite(DEFAULT_SIZE, 7, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_down1 = new Sprite(DEFAULT_SIZE, 8, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_down2 = new Sprite(DEFAULT_SIZE, 9, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_left1 = new Sprite(DEFAULT_SIZE, 12, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_left2 = new Sprite(DEFAULT_SIZE, 13, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_right1 = new Sprite(DEFAULT_SIZE, 10, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_right2 = new Sprite(DEFAULT_SIZE, 11, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_dead = new Sprite(DEFAULT_SIZE, 14, 5, SpriteSheet.tiles, 16, 16);
    public static Sprite smallPoyo_dead1 = new Sprite(DEFAULT_SIZE, 15, 5, SpriteSheet.tiles, 16, 16);

    // bakudaBlack
    public static Sprite bakudaBlack_up1 = new Sprite(DEFAULT_SIZE, 10, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_up2 = new Sprite(DEFAULT_SIZE, 11, 6, SpriteSheet.tiles, 16, 16);

    public static Sprite bakudaBlack_down1 = new Sprite(DEFAULT_SIZE, 8, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_down2 = new Sprite(DEFAULT_SIZE, 9, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_left1 = new Sprite(DEFAULT_SIZE, 6, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_left2 = new Sprite(DEFAULT_SIZE, 7, 6, SpriteSheet.tiles, 16, 16);

    public static Sprite bakudaBlack_right1 = new Sprite(DEFAULT_SIZE, 13, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_right2 = new Sprite(DEFAULT_SIZE, 14, 6, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaBlack_dead = new Sprite(DEFAULT_SIZE, 12, 6, SpriteSheet.tiles, 16, 16);

    // bakudaRed
    public static Sprite bakudaRed_up1 = new Sprite(DEFAULT_SIZE, 10, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_up2 = new Sprite(DEFAULT_SIZE, 11, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite bakudaRed_down1 = new Sprite(DEFAULT_SIZE, 8, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_down2 = new Sprite(DEFAULT_SIZE, 9, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_left1 = new Sprite(DEFAULT_SIZE, 6, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_left2 = new Sprite(DEFAULT_SIZE, 7, 7, SpriteSheet.tiles, 16, 16);

    public static Sprite bakudaRed_right1 = new Sprite(DEFAULT_SIZE, 13, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_right2 = new Sprite(DEFAULT_SIZE, 14, 7, SpriteSheet.tiles, 16, 16);
    public static Sprite bakudaRed_dead = new Sprite(DEFAULT_SIZE, 12, 7, SpriteSheet.tiles, 16, 16);

    // gurorin
    public static Sprite gurorin_left1 = new Sprite(DEFAULT_SIZE, 6, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite gurorin_left2 = new Sprite(DEFAULT_SIZE, 7, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite gurorin_left3 = new Sprite(DEFAULT_SIZE, 8, 4, SpriteSheet.tiles, 16, 16);

    public static Sprite gurorin_right1 = new Sprite(DEFAULT_SIZE, 9, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite gurorin_right2 = new Sprite(DEFAULT_SIZE, 10, 4, SpriteSheet.tiles, 16, 16);
    public static Sprite gurorin_right3 = new Sprite(DEFAULT_SIZE, 11, 4, SpriteSheet.tiles, 16, 16);

    public static Sprite gurorin_dead = new Sprite(DEFAULT_SIZE, 12, 4, SpriteSheet.tiles, 16, 16);

    /*
     * |--------------------------------------------------------------------------
     * | Bomb Sprites
     * |--------------------------------------------------------------------------
     */
    public static Sprite bomb = new Sprite(DEFAULT_SIZE, 9, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_1 = new Sprite(DEFAULT_SIZE, 10, 1, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_2 = new Sprite(DEFAULT_SIZE, 11, 1, SpriteSheet.tiles, 16, 16);

    /*
     * |--------------------------------------------------------------------------
     * | FlameSegment Sprites
     * |--------------------------------------------------------------------------
     */
    public static Sprite bomb_exploded = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded1 = new Sprite(DEFAULT_SIZE, 6, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite bomb_exploded2 = new Sprite(DEFAULT_SIZE, 6, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical = new Sprite(DEFAULT_SIZE, 4, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical1 = new Sprite(DEFAULT_SIZE, 4, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical2 = new Sprite(DEFAULT_SIZE, 4, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal1 = new Sprite(DEFAULT_SIZE, 5, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal2 = new Sprite(DEFAULT_SIZE, 5, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_left_last = new Sprite(DEFAULT_SIZE, 2, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last1 = new Sprite(DEFAULT_SIZE, 2, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_left_last2 = new Sprite(DEFAULT_SIZE, 2, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_horizontal_right_last = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last1 = new Sprite(DEFAULT_SIZE, 3, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_horizontal_right_last2 = new Sprite(DEFAULT_SIZE, 3, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_top_last = new Sprite(DEFAULT_SIZE, 0, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last1 = new Sprite(DEFAULT_SIZE, 0, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_top_last2 = new Sprite(DEFAULT_SIZE, 0, 12, SpriteSheet.tiles, 16, 16);

    public static Sprite explosion_vertical_down_last = new Sprite(DEFAULT_SIZE, 1, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_down_last1 = new Sprite(DEFAULT_SIZE, 1, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite explosion_vertical_down_last2 = new Sprite(DEFAULT_SIZE, 1, 12, SpriteSheet.tiles, 16, 16);

    /*
     * |--------------------------------------------------------------------------
     * | Brick FlameSegment
     * |--------------------------------------------------------------------------
     */
    public static Sprite brick_exploded = new Sprite(DEFAULT_SIZE, 10, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded1 = new Sprite(DEFAULT_SIZE, 11, 0, SpriteSheet.tiles, 16, 16);
    public static Sprite brick_exploded2 = new Sprite(DEFAULT_SIZE, 13, 0, SpriteSheet.tiles, 16, 16);

    /*
     * |--------------------------------------------------------------------------
     * | Powerups
     * |--------------------------------------------------------------------------
     */
    public static Sprite powerup_bombs = new Sprite(DEFAULT_SIZE, 8, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_flames = new Sprite(DEFAULT_SIZE, 9, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_speed = new Sprite(DEFAULT_SIZE, 9, 11, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_wallpass = new Sprite(DEFAULT_SIZE, 3, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_detonator = new Sprite(DEFAULT_SIZE, 4, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_bombpass = new Sprite(DEFAULT_SIZE, 5, 10, SpriteSheet.tiles, 16, 16);
    public static Sprite powerup_flamepass = new Sprite(DEFAULT_SIZE, 6, 10, SpriteSheet.tiles, 16, 16);

    public Sprite(int size, int x, int y, SpriteSheet sheet, int rw, int rh) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        _x = x * SIZE;
        _y = y * SIZE;
        _sheet = sheet;
        _realWidth = rw;
        _realHeight = rh;
        load();
    }

    public Sprite(int size, int color) {
        SIZE = size;
        _pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    private void setColor(int color) {
        for (int i = 0; i < _pixels.length; i++) {
            _pixels[i] = color;
        }
    }

    private void load() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                _pixels[x + y * SIZE] = _sheet._pixels[(x + _x) + (y + _y) * _sheet.SIZE];
            }
        }
    }

    public static Sprite movingSprite(Sprite normal, Sprite x1, Sprite x2, int animate, int time) {
        int calc = animate % time;
        int diff = time / 3;

        if (calc < diff) {
            return normal;
        }

        if (calc < diff * 2) {
            return x1;
        }

        return x2;
    }

    public static Sprite movingSprite(Sprite x1, Sprite x2, int animate, int time) {
        int diff = time / 2;
        return (animate % time > diff) ? x1 : x2;
    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return _pixels[i];
    }

    public Image getFxImage() {
        WritableImage wr = new WritableImage(SIZE, SIZE);
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (_pixels[x + y * SIZE] == TRANSPARENT_COLOR) {
                    pw.setArgb(x, y, 0);
                } else {
                    pw.setArgb(x, y, _pixels[x + y * SIZE]);
                }
            }
        }
        Image input = new ImageView(wr).getImage();
        return resample(input, SCALED_SIZE / DEFAULT_SIZE);
    }

    private Image resample(Image input, int scaleFactor) {
        final int W = (int) input.getWidth();
        final int H = (int) input.getHeight();
        final int S = scaleFactor;

        WritableImage output = new WritableImage(
                W * S,
                H * S);

        PixelReader reader = input.getPixelReader();
        PixelWriter writer = output.getPixelWriter();

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                final int argb = reader.getArgb(x, y);
                for (int dy = 0; dy < S; dy++) {
                    for (int dx = 0; dx < S; dx++) {
                        writer.setArgb(x * S + dx, y * S + dy, argb);
                    }
                }
            }
        }

        return output;
    }
}
