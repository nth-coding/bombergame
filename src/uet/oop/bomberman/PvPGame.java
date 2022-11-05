package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uet.oop.bomberman.Levels.Level1;
import uet.oop.bomberman.components.PvPComponentMovement;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.PvP.Player1Bomb;
import uet.oop.bomberman.entities.PvP.Player2Bomb;
import uet.oop.bomberman.entities.PvP.PvPBomber;
import uet.oop.bomberman.graphics.PvPMapCreation;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.view.PauseMenu;
import uet.oop.bomberman.view.ViewManager;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.entities.Bomber.*;
import static uet.oop.bomberman.entities.PvP.Player1Bomb.*;
import static uet.oop.bomberman.entities.PvP.Player2Bomb.*;

public class PvPGame {
    public static final int WIDTH = 25;
    public static final int HEIGHT = 16;
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

    private Scene playScene;
    public static PvPBomber player1;
    public static PvPBomber player2;
    private GraphicsContext gc;
    private Canvas pvpCanvas;
    private final PauseMenu pause = new PauseMenu();
    private static Text mode;
    public static final List<Entity> stillObjectsPvP = new ArrayList<>();

    public Scene getMainScene() {
        return playScene;
    }
    public static Group pvpRoot = new Group();
    public void createGame(Stage stage) {
        if(pvpDem!=0 ) {
            // hoan thien not de replay pvp
        }
        else{

        // Tao Canvas
        pvpCanvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = pvpCanvas.getGraphicsContext2D();
        pvpRoot.getChildren().add(pvpCanvas);
        // tao chu pvp mode
            mode = new Text("PVP MODE");
            mode.setFont(Font.font("Arial", FontWeight.BOLD, 17));
            mode.setFill(Color.BLACK);
            mode.setX(350);
            mode.setY(500);
            pvpRoot.getChildren().add(mode);
        // Tao root container


        // Tao playScene
        playScene = new Scene(pvpRoot);

        stage.setScene(playScene);
        stage.setTitle("Bomberman By B.H.H");
        stage.setFullScreen(false);
        stage.setResizable(false);
        stage.getIcons().add(new Image("textures\\icon.png"));
        stage.show();

        // Tao bomber
        player1 = new PvPBomber(1, 0, Sprite.player_right.getFxImage());
        player2 = new PvPBomber(WIDTH - 2, HEIGHT - 4, Sprite.player_left.getFxImage());

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
    }

    public void createMap() {
        stillObjectsPvP.clear();

        PvPBomber.swap_kill_pvp = 1;

        new PvPMapCreation("res/levels/PvPMap.txt");
        is_bomb_player1 = 0;
        is_bomb_player2 = 0;

//        player1.speed = 1;
//        player2.speed = 2;
//        player1.power_bomb = 0;
//        player2.power_bomb = 0;

        player1.setLife(true);
        player2.setLife(true);
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
    }

    public void render() {
        gc.clearRect(0, 0, pvpCanvas.getWidth(), pvpCanvas.getHeight());
        stillObjectsPvP.forEach(g -> g.render(gc));
        player1.render(gc);
        player2.render(gc);
    }
}
