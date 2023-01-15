package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage=new Stage();
    public static Scene scene=null;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        scene=new Scene(root, 1280, 720);
        primaryStage.setTitle("Wei引擎演示Demo");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        get();
    }


    public static void main(String[] args) {
        launch(args);

    }
    //播放背景音乐
    static MediaPlayer mediaPlayer;
    public void get() {
        String s1 = Main.class.getResource("/media/yandie.mp3").toString();
        Media media = new Media(s1);
        mediaPlayer= new MediaPlayer(media);
        //mediaPlayer.setAutoPlay(true);
        mediaPlayer.play();
    }
}




