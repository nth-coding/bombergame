package uet.oop.bomberman.view;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

import static uet.oop.bomberman.BombermanGame.level;

public class Bar {

    public static Text llevel, bbomb, ttime;
    public static int  time_number = 120;   // the number of bomb is 20 and the time limit is 120 seconds

  public static void createMenu(Group root){
      llevel = new Text("Level: "+1);
      llevel.setFont(Font.font("Arial", FontWeight.BOLD, 17));
      llevel.setFill(Color.BLACK);
      llevel.setX(10);
      llevel.setY(500);
      bbomb = new Text("Bombs: 20");
      bbomb.setFont(Font.font("Arial", FontWeight.BOLD, 17));
      bbomb.setFill(Color.BLACK);
      bbomb.setX(320);
      bbomb.setY(500);
      ttime = new Text("Times: 120");
      ttime.setFont(Font.font("Arial", FontWeight.BOLD, 17));
      ttime.setFill(Color.BLACK);
      ttime.setX(650);
      ttime.setY(500);
      Pane pane = new Pane();
      pane.getChildren().addAll(llevel, bbomb, ttime);

      root.getChildren().add(pane);
  }

}
