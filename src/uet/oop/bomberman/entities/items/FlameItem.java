package uet.oop.bomberman.entities.items;

import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.graphics.*;
import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;

public class FlameItem extends Items {

    public FlameItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public FlameItem(boolean received) {
        super(received);
    }

    public FlameItem() {
    }

    // Extends the range of flame if a player gets the item
    @Override
    public void update() {
        for (Entity entity : stillObjects)
            if (entity instanceof FlameItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_flames.getFxImage());

        if (!this.received) {
            if (bomberman.getX() == this.x && bomberman.getY() + 32 == this.y) {
                if (BombermanGame.level == 1) {
                    this.setImg(Sprite.grass1.getFxImage());
                } else if (BombermanGame.level == 2){
                    this.setImg(Sprite.grass2.getFxImage());
                } else
                {
                    this.setImg(Sprite.grass3.getFxImage());
                }
                this.received = true;
                Bomb.power_bomb += 2;
            }
        }
    }
}
