package uet.oop.bomberman.entities.items;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.*;
import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class WallPassItem extends Items {
    public WallPassItem() {
    }

    public WallPassItem(int x, int y, Image img) {
        super(x, y, img);
    }
    public WallPassItem(boolean received) {
        super(received);
    }

    @Override
    public void update() {
        for (Entity entity : stillObjects)
            if (entity instanceof WallPassItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_wallpass.getFxImage());

        if (!this.received) {
            if (bomberman.getX() == this.x && bomberman.getY() + 32 == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;
                through_the_wall = true;
            }
        }
    }
}
