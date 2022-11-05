package uet.oop.bomberman.entities.enemy;

import java.util.List;

import javafx.scene.image.Image;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.entities.AI.AStar;
import uet.oop.bomberman.entities.AI.Node;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;

import static uet.oop.bomberman.BombermanGame.*;

public class BakudaBlack extends Entity{
    private static int swap_kill = 1;
    private static int count_kill = 0;

    public BakudaBlack(int x_unit, int y_unit, Image img) {
        super(x_unit, y_unit, img);
    }

    public BakudaBlack(int is_move, int swap, String direction, int count, int count_to_run) {
        super(4, 1, "up", 0, 0);
    }

    public BakudaBlack(boolean life) {
        super(life);
    }

    public BakudaBlack() {

    }

    private void killBakudaBlack(Entity entity) {

        if (count_kill % 16 == 0) {
            if (swap_kill == 1) {
                entity.setImg(Sprite.bakudaBlack_dead.getFxImage());
                swap_kill = 2;
            } else if (swap_kill == 2) {
                entity.setImg(Sprite.smallPoyo_dead.getFxImage());
                swap_kill = 3;
            } else if (swap_kill == 3) {
                entity.setImg(Sprite.smallPoyo_dead1.getFxImage());
                swap_kill = 4;
            } else {
                entity.setLife(false);
                Bar.score_number= Bar.score_number + 10;
                Bar.score.setText("Score: "+ Bar.score_number);
                entities.remove(entity);
                swap_kill = 1;
            }
        }
    }

    private void moveBakudaBlack() {
        if (this.x % 32 == 0 && this.y % 32 == 0 && this.life) {
            Node initial_node = new Node(this.y / 32, this.x / 32);
            Node final_node = new Node(bomberman.getY() / 32 + 1, bomberman.getX() / 32);

            int rows = height;
            int cols = width;

            AStar a_star = new AStar(rows, cols, initial_node, final_node);

            int[][] blocks_in_array = new int[width * height][2];
            int count_block = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (id_objects[j][i] != 0) {
                        blocks_in_array[count_block][0] = i;
                        blocks_in_array[count_block][1] = j;
                        count_block++;
                    }
                }
            }
            a_star.setBlocks(blocks_in_array, count_block);
            List<Node> path = a_star.findPath();
            if (path.size() > 1) {
                int nextX = path.get(1).getCol();
                int nextY = path.get(1).getRow();

                if (this.y / 32 > nextY)
                    ComponentMovement.up(this);
                if (this.y / 32 < nextY)
                    ComponentMovement.down(this);
                if (this.x / 32 > nextX)
                    ComponentMovement.left(this);
                if (this.x / 32 < nextX)
                    ComponentMovement.right(this);
            }
        }
    }

    private void kill() {
        for (Entity entity : entities) {
            if (entity instanceof BakudaBlack && list_kill[entity.getX() / 32][entity.getY() / 32] == 4) {
                entity.setLife(false);
            }
        }
    }

    @Override
    public void update() {
        kill();
        count_kill++;
        moveBakudaBlack();
        for (int i = 0; i < entities.size(); ++i) {
            Entity entity = entities.get(i);
            if (entity instanceof BakudaBlack && !entity.life) {
                killBakudaBlack(entity);

            }

        }
    }
}
