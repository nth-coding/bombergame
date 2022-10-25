package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.components.PvPComponent;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.MapCreation;
import uet.oop.bomberman.graphics.PvPMapCreation;
import uet.oop.bomberman.graphics.Sprite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.entities.Player1Bomb.*;
import static uet.oop.bomberman.entities.Player2Bomb.*;
import static uet.oop.bomberman.entities.Bomber.swap_kill;
import static uet.oop.bomberman.entities.items.SpeedItem.speed;

public class PvPGame {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 15;
    //
    public static int width = 0;
    //
    public static int height = 0;
    //
    public static int[][] id_objects;
    //
    public static int[][] list_kill;
    //
    public static String[][] string_list_kill;
    //
    public static String[][] string_id_objects;
    //
    public static int level;

    private Scene playScene;
    public static Bomber player1;
    public static Bomber player2;
    private GraphicsContext gc;
    private Canvas pvpCanvas;
    public static final List<Entity> stillObjectsPvP = new ArrayList<>();

    public Scene getMainScene() {
        return playScene;
    }

    public void createGame(Stage stage) {
        // Tao Canvas
        pvpCanvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = pvpCanvas.getGraphicsContext2D();


        // Tao root container
        Group root = new Group();
        root.getChildren().add(pvpCanvas);

        // Tao playScene
        playScene = new Scene(root);

        stage.setScene(playScene);
        stage.setTitle("Bomberman");
        stage.show();

        // Tao map
        createMap();

        // Tao bomber
        player1 = new Bomber(1, 1, Sprite.player_right.getFxImage());
        player2 = new Bomber(WIDTH - 2, HEIGHT - 2, Sprite.player_left.getFxImage());

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
    }

    public void createMap() {
        stillObjectsPvP.clear();

        swap_kill = 1;
        player1.power_bomb = 0;
        player2.power_bomb = 0;
        new PvPMapCreation("res/levels/PvPMap.txt");
        is_bomb_player1 = 0;
        is_bomb_player2 = 0;
//        player1.speed = 1;
//        player2.speed = 2;
    }

    // moves the player1.
    private void updatePlayerInput() {
        // KeyPressed
        playScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();

            // player1
            if (key == KeyCode.A) {
                // player1.setVelX(-5);
                PvPComponent.left(player1);
            } else if (key == KeyCode.D) {
                // player1.setVelX(5);
                PvPComponent.right(player1);
            } else if (key == KeyCode.W) {
                // player1.setVelY(-5);
                PvPComponent.up(player1);
            } else if (key == KeyCode.S) {
                // player1.setVelY(5);
                PvPComponent.down(player1);
            } else if (key == KeyCode.SPACE) {
                Player1Bomb.putBomb();

            // player2
            } else if (key == KeyCode.LEFT) {
                PvPComponent.left(player2);
            } else if (key == KeyCode.RIGHT) {
                // player1.setVelX(5);
                PvPComponent.right(player2);
            } else if (key == KeyCode.UP) {
                // player1.setVelY(-5);
                PvPComponent.up(player2);
            } else if (key == KeyCode.DOWN) {
                // player1.setVelY(5);
                PvPComponent.down(player2);
            } else if (key == KeyCode.ENTER) {
                Player2Bomb.putBomb();
            }
        });
    }

    public void update() {
        // keybindings update
        updatePlayerInput();

        // objects update
        stillObjectsPvP.forEach(Entity::update);

        // player1 update
        player1.update();
        player1.setCountToRun(player1.getCountToRun() + 1);
        if (player1.getCountToRun() == 4) {
            PvPComponent.checkRun(player1);
            player1.setCountToRun(0);
        }

        // player2 update
        player2.update();
        player2.setCountToRun(player2.getCountToRun() + 1);
        if (player2.getCountToRun() == 4) {
            PvPComponent.checkRun(player2);
            player2.setCountToRun(0);
        }
    }

    public void render() {
        gc.clearRect(0, 0, pvpCanvas.getWidth(), pvpCanvas.getHeight());
        stillObjectsPvP.forEach(g -> g.render(gc));
        player1.render(gc);
        player2.render(gc);
    }
}
