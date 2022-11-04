package uet.oop.bomberman.entities.object;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Brick extends Entity {

    public Brick(int x, int y, Image img) {     // Create a contructor of the Brick class
        super(x, y, img);
    }

    private void checkHidden() {    //Check Brick's Visibility
        for (Entity entity : stillObjects) {
            if (entity instanceof Brick) {
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {    // At the element of the 2-dimensional listKill array with the value 4, Brick and Grass will appear
                    if (BombermanGame.level == 1) {
                        entity.setImg(Sprite.grass1.getFxImage());
                    } else if (BombermanGame.level == 2){
                        entity.setImg(Sprite.grass2.getFxImage());
                    } else {
                        entity.setImg(Sprite.grass3.getFxImage());
                    }

//                    if (id_objects[entity.getX() / 32][entity.getY() / 32 + 1] == 9) {
//                        for (Entity _entity : stillObjects) {
//                        }
//                        Entity e = new Brick(entity.getX() / 32, entity.getY() / 32 + 1, Sprite.grass1.getFxImage());
//                        stillObjects.add(e);
//                    }
                }
            }
        }
    }

    @Override
    public void update() {
        checkHidden();
    }
}
