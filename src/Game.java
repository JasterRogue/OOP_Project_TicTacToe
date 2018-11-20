//Game.java by Ryan Madigan
/*This class will be used for starting everything and also plays the music*/


import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javax.swing.*;
import javafx.scene.media.Media;

public class Game {

    static MediaPlayer mediaPlayer;
    static String audioFile= "bensound-summer.wav";

    public static void main(String[] args)
    {
            JFXPanel fxPanel = new JFXPanel();
            
            playMusic(audioFile);

            MainMenuGUI mainMenu = new MainMenuGUI();

            mainMenu.boardGUI.openStats();

    }



   public static void playMusic(String path) // I got the code for the playMusic() from John Brosnan
         {
            Media audioClip = new Media(new File(path).toURI().toString());

            mediaPlayer = new MediaPlayer(audioClip);

            try
            {
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
                mediaPlayer.play();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error. Music cannot play");
            }

         }//end of playMusic method

    }//end of game


