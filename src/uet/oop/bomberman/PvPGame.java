package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import uet.oop.bomberman.Levels.Level1;
import uet.oop.bomberman.Levels.Level_PvP;
import uet.oop.bomberman.components.ComponentMovement;
import uet.oop.bomberman.components.PvPComponentMovement;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.PvP.Player1Bomb;
import uet.oop.bomberman.entities.PvP.Player2Bomb;
import uet.oop.bomberman.entities.PvP.PvPBomber;
import uet.oop.bomberman.entities.enemy.BigPoyo;
import uet.oop.bomberman.entities.enemy.Pink;
import uet.oop.bomberman.entities.enemy.SmallPoyo;
import uet.oop.bomberman.entities.items.BombItem;
import uet.oop.bomberman.graphics.PvPMapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.Bar;
import uet.oop.bomberman.view.PauseMenu;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.BombermanGame.entities;
import static uet.oop.bomberman.entities.Bomb.is_bomb;
import static uet.oop.bomberman.entities.PvP.Player1Bomb.*;
import static uet.oop.bomberman.entities.PvP.Player2Bomb.*;
import static uet.oop.bomberman.entities.Bomber.swap_kill;

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
    public static boolean running;
    public static boolean through_the_wall = false;
    public static final List<Entity> entities = new ArrayList<>();
    public static final List<Entity> stillObjects = new ArrayList<>();

    private Scene playScene;
    public static PvPBomber player1;
    public static PvPBomber player2;
    private GraphicsContext gc;
    private Canvas pvpCanvas;
    private final PauseMenu pause = new PauseMenu();
    public static final List<Entity> stillObjectsPvP = new ArrayList<>();

    public Scene getMainScene() {
        return playScene;
    }

    public void createGame(Stage stage) {
        // Tao Canvas
        pvpCanvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = pvpCanvas.getGraphicsContext2D();


        // Tao root container

        BombermanGame.root.getChildren().add(pvpCanvas);

        // Tao playScene
        playScene = new Scene(BombermanGame.root);

        stage.setScene(playScene);
        stage.setTitle("Bomberman By B.H.H");
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.getIcons().add(new Image("textures\\icon.png"));
        stage.show();

        // Tao bomber
        player1 = new PvPBomber(1, 1, Sprite.player_right.getFxImage());
        player2 = new PvPBomber(WIDTH - 2, HEIGHT - 3, Sprite.player_left.getFxImage());

        // setLife
        player1.setLife(false);
        player2.setLife(false);

        // Tao map
        createMap();

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
        new Level_PvP();
        running = true;
    }

    // moves the player1.
    private void updatePlayerInput() {
        // KeyPressed
        playScene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();

            // player1
            if (key == KeyCode.A) {
                // player1.setVelX(-5);
                PvPComponentMovement.left(player1);
            } else if (key == KeyCode.D) {
                // player1.setVelX(5);
                PvPComponentMovement.right(player1);
            } else if (key == KeyCode.W) {
                // player1.setVelY(-5);
                PvPComponentMovement.up(player1);
            } else if (key == KeyCode.S) {
                // player1.setVelY(5);
                PvPComponentMovement.down(player1);
            } else if (key == KeyCode.SPACE) {
                Player1Bomb.putBomb();

            // player2
            } else if (key == KeyCode.LEFT) {
                PvPComponentMovement.left(player2);
            } else if (key == KeyCode.RIGHT) {
                // player1.setVelX(5);
                PvPComponentMovement.right(player2);
            } else if (key == KeyCode.UP) {
                // player1.setVelY(-5);
                PvPComponentMovement.up(player2);
            } else if (key == KeyCode.DOWN) {
                // player1.setVelY(5);
                PvPComponentMovement.down(player2);
            } else if (key == KeyCode.ENTER) {
                Player2Bomb.putBomb();
            }
            else if (key == KeyCode.ESCAPE) {
                running = false;

                pause.showPause();
            }
        });
    }

    public void update() {
        // keybindings update
        updatePlayerInput();

        // enemy update
        for (int i = 0; i < entities.size(); ++i) {
            entities.get(i).update();
        }

        // player1 update
        player1.update();
        player1.setCountToRun(player1.getCountToRun() + 1);
        if (player1.getCountToRun() == 4) {
            PvPComponentMovement.checkRun(player1);
            player1.setCountToRun(0);
        }

        // player2 update
        player2.update();
        player2.setCountToRun(player2.getCountToRun() + 1);
        if (player2.getCountToRun() == 4) {
            PvPComponentMovement.checkRun(player2);
            player2.setCountToRun(0);
        }

        // objects update
        for (int i = 0; i < stillObjectsPvP.size(); ++i) {
            stillObjectsPvP.get(i).update();
        }

        for (Entity a : entities) {
            a.setCountToRun(a.getCountToRun() + 1);
            if (a.getCountToRun() == 8) {
                PvPComponentMovement.checkRun(a);
                a.setCountToRun(0);
            }
        }
    }

    public void render() {
        gc.clearRect(0, 0, pvpCanvas.getWidth(), pvpCanvas.getHeight());
        stillObjectsPvP.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        player1.render(gc);
        player2.render(gc);
    }
}
