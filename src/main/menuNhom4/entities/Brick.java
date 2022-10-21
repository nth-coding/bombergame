package entities;

import graphics.Sprite;
import javafx.scene.image.Image;

import static view.BombermanGame.*;
public class Brick  extends  Entity{
    public Brick(int x, int y, Image img) {     // Create a contructor of the Brick class
        super(x, y, img);
    }

    private void checkHidden() {    //Check Brick's Visibility
        for (Entity entity : stillObjects) {
            if (entity instanceof Brick) {
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {    // At the element of the 2-dimensional listKill array with the value 4, Brick and Grass will appear
                    entity.setImg(Sprite.grass.getFxImage());
                }
            }
        }
    }

    @Override
    public void update() {
        checkHidden();
    }
}
