package sample;

import action.Important;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class Controller {
    MediaPlayer mediaPlayer;
    public void hover(){
        String s1= Controller.class.getResource("/media/ding.mp3").toString();
        Media media=new Media(s1);
        mediaPlayer=new MediaPlayer(media);
        mediaPlayer.play();


    }
    public void changeScene(){
        try {
            Important important=new Important();
            important.important();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void lexit(){
          System.exit(0);
    }
}
