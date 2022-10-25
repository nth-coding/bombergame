package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.PvPGame.list_kill;
import static uet.oop.bomberman.PvPGame.stillObjectsPvP;

public class PvPBrick extends Entity {

    public PvPBrick(int x, int y, Image img) {     // Create a contructor of the Brick class
        super(x, y, img);
    }

    private void checkHidden() {    //Check Brick's Visibility
        for (Entity entity : stillObjectsPvP) {
            if (entity instanceof PvPBrick) {
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
