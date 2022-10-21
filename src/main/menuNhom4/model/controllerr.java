package model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class controllerr  {

    ImageView myImageView;
    Button myButton;
    Image myImage = new Image(getClass().getResourceAsStream("PlayButton.jpg"));
    public void displayImage(){
        myImageView.setImage(myImage);
    }


}
