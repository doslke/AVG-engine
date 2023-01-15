package action;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import sample.Controller;
import sample.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Important {
    @FXML
    Label text;
    @FXML
    ImageView background=new ImageView();
    @FXML
    ImageView human=new ImageView();
    @FXML
    Button t_one;
    @FXML
    Button t_two;
    @FXML
    ImageView choosebg;
    int index=0;
    int num=0;
    boolean init=false;
    int temp;

    String article;int[] bgindex;String[] bgfile;int[] charindex;String[] charfile;int choose;


    //切换scene
    public void important() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainpage.fxml"));
        Scene scene=new Scene(root,1280,720);
        Main.primaryStage.setScene(scene);

    }
    //预加载
    public void load(){
        if(!init){
            background.setImage(new Image("file:"+returnPath("img","two.png")));
            human.setImage(new Image("file:"+returnPath("img","human.png")));
            init=true;
        }
    }
    //改变背景、立绘、与文字
    public void change() {
        //link();
    }
    //读取剧本
    public ArrayList<String> returnArticle(String filename){
        ArrayList<String> arr= new ArrayList<>();
        String str=null;
        BufferedReader bufferedReader=null;
        try{
            bufferedReader=new BufferedReader(new FileReader(returnPath("article",filename)));
            while((str=bufferedReader.readLine())!=null){

                arr.add(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    //对话动画的方法
    public void printString(String str) throws InterruptedException {
       num=0;
       Timeline timeline = new Timeline();
       timeline.setCycleCount(2*str.length()-1);
       timeline.setAutoReverse(true);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                text.setText(text.getText()+str.charAt(num));
                num++;
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

    }

    //切换立绘与背景
    public void imagePrint(int bgindexes[],String bgurls[],int[] humanindexes,String humanurls[]){
        for(int i=0;i<bgindexes.length;i++){
            if (bgindexes[i]==index) {
                background.setImage(new Image(bgurls[i]));
            }
        }
        for(int i=0;i<humanindexes.length;i++){
            if(humanindexes[i]==index){
                human.setImage(new Image(humanurls[i]));
            }
        }
    }
    //返回绝对路径
    public String returnPath(String path,String filename){
        return System.getProperty("user.dir")+ File.separator+"src"+File.separator+path+File.separator+filename;
    }

    public void link(String article,int[] bgindex,String[] bgfile,int[] charindex,String[] charfile,int choose) {

        ArrayList<String> arr=returnArticle(article);
        if(index>=arr.size()){

        }
        text.setText(" ");
        imagePrint(bgindex,bgfile,charindex,charfile);

        try{
            printString(arr.get(index));
        }catch (IndexOutOfBoundsException e){
            Main.primaryStage.setScene(Main.scene);
        }catch (InterruptedException e){
            text.setText(arr.get(index));
        }

        index++;
    }

    public void choose(int choose,String t_onet,String t_twot,String bgurl) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("choose-"+Integer.toString(choose)+".fxml"));
        Main.primaryStage.setScene(new Scene(root,1280,720));
        choosebg.setImage(new Image(bgurl));
        t_one.setText(t_onet);
        t_two.setText(t_twot);
    }

    /*public void one(){
        jump();
    }
    public void two(){
        jump();
    }*/
}


