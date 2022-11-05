package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.PvPGame.*;

public class PvPSpeedItem extends Items {
    public PvPSpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public PvPSpeedItem() {
    }

    public PvPSpeedItem(boolean received) {
        super(received);
    }

    // Enhance the speed of player if a player gets the item
    @Override
    public void update() {
        for (Entity entity : stillObjectsPvP)
            if (entity instanceof PvPSpeedItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_speed.getFxImage());

        if (!this.received)
            if (player1.getX() == this.x && player1.getY() + 32 == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;
                player1.setSpeed(2);
            } else if (player2.getX() == this.x && player2.getY() + 32 == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;
                player2.setSpeed(2);
            }
    }
}
