//Game.java by Ryan Madigan
/*This class will be used for playing the game calling other classes and methods.
* While also using some of its own methods*/

//import sun.audio.AudioData;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javax.swing.*;
import javafx.scene.media.Media;
public class Game {

    static int count = 0;
    static MediaPlayer mediaPlayer;
    static String audioFile= "bensound-summer.wav";
    //static String audioFile = "gunshot.wav"; was used for testing audio
    static MainMenuGUI mainMenu;


    public static void main(String[] args)
    {
        if(count==0) {
            JFXPanel fxPanel = new JFXPanel();
            count++;

            playMusic(audioFile);
            System.out.print("\nIn main of Game.java");
            mainMenu = new MainMenuGUI();
        }

       //if(count==1)




        if (MainMenuGUI.getOptionSelected() == true)
        {
           GameBoardGUI boardGUI = new GameBoardGUI();
          // boardGUI.setVisible(true);
           boardGUI.playGame();
           System.out.print("\nIn MainMenuGUI.getOptionSelected = true");

        }//end of if(mainMenu.getOptionSelected() == true)

    }//end of main



        public static void playMusic(String path) // I got the code for the playMusic() from John Brosnan
         {
            Media audioClip = new Media(new File(path).toURI().toString());

            mediaPlayer = new MediaPlayer(audioClip);

            mediaPlayer.setOnEndOfMedia(new Runnable() {
                public void run() {
                    //Platform.exit();
                }
            });

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


