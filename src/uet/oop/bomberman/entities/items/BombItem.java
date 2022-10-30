package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.*;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class BombItem extends Items {
    public BombItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public BombItem() {
    }
    public BombItem(boolean received) {
        super(received);
    }
    @Override
    public void update() {
        for (Entity entity : stillObjects)
            if (entity instanceof BombItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_bombs.getFxImage());

        if (!this.received)
            if (bomberman.getX() == this.x && bomberman.getY() == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;

            }
    }
}
