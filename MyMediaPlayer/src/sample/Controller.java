package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Queue;

import static javafx.application.Platform.runLater;

public class Controller implements Initializable {
    Media media;
    MediaPlayer mediaPlayer;
    public Slider slid_level;
    public Label lab_level;
    public Button btn_file;
    public String[] pathFiles;
    public int index = 0;



    public void playOnClick(){
        mediaPlayer.play();
    }

    public void pauseOnClick(){
        mediaPlayer.pause();
    }

    public void stopOnClick(){
        mediaPlayer.stop();
    }

    public void nextOnClick() {
        if(pathFiles == null){
            return;
        }
        if(pathFiles.length > index + 1){
            ++index;
        }else {
            index = 0;
        }
        newMusic(pathFiles[index]);
    }

    public void backOnClick() {
        if(pathFiles == null){
            return;
        }
        if(0 < index ){
            --index;
        }else{
            index = pathFiles.length - 1;
        }
        newMusic(pathFiles[index]);
    }

    public void levelOnChange(){
        slid_level.valueProperty().addListener((ov, old_val, new_val) -> {
            lab_level.setText("Уровень: "+(int)new_val.doubleValue()+"%");
            mediaPlayer.setVolume(new_val.doubleValue()/100);
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        slid_level.setMax(100);
        slid_level.setMin(0);
        slid_level.setValue(100);
        media = new Media(Controller.class.getResource("/sound/enemy.mp3").toString());
        mediaPlayer = new MediaPlayer(media);

        btn_file.setOnAction((e) -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.wav", "*.mp3"));
            File file = fc.showOpenDialog(null);
            if(file == null) {
                return;
            }
            String path = file.getAbsolutePath();
            path = path.replace("\\", "/");
            File myFolder = new File(path.substring(0, path.lastIndexOf('/')));
            File[] files = myFolder.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.toString().endsWith(".mp3") || pathname.toString().endsWith(".wav");
                }
            });
            pathFiles = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                pathFiles[i] = files[i].toString().replace("\\", "/");
            }
            newMusic(path);
        });
    }

    public void newMusic(String path){
        media = new Media(new File(path).toURI().toString());
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }
}

