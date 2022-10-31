package uet.oop.bomberman.entities.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.PvP.Player1Bomb;
import uet.oop.bomberman.entities.PvP.Player2Bomb;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.PvPGame.*;

public class PvPFlameItem extends Items {

    public PvPFlameItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public PvPFlameItem(boolean received) {
        super(received);
    }

    public PvPFlameItem() {
    }

    // Extends the range of flame if a player gets the item
    @Override
    public void update() {
        for (Entity entity : stillObjectsPvP)
            if (entity instanceof PvPFlameItem && !this.received)
                if (list_kill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_flames.getFxImage());

        if (!this.received) {
            if (player1.getX() == this.x && player1.getY() + 32 == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;
                Player1Bomb.power_bomb += 2;
            } else if (player2.getX() == this.x && player2.getY() + 32 == this.y) {
                this.setImg(Sprite.grass2.getFxImage());
                this.received = true;
                Player2Bomb.power_bomb += 2;
            }

        }


    }
}
