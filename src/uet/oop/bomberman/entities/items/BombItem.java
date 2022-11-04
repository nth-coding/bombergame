package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.*;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class BombItem extends Items {
    public static boolean BombMax = false;
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
                Bomb.bomb_number= Integer.MAX_VALUE;
                BombMax =true;
            }
    }
}
