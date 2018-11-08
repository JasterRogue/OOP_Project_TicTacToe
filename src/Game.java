//Game.java by Ryan Madigan
/*This class will be used for playing the game calling other classes and methods.
* While also using some of its own methods*/

//import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;

public class Game {

    static String printText;
    static int count = 0;

    public static void main(String[] args)
    {
        count++;
        MainMenuGUI mainMenu;
        String file="bensound-summer.wav";
        System.out.print("\nIn main of Game.java");
       if(count==1)
             mainMenu = new MainMenuGUI();
        playMusic(file);


        if (MainMenuGUI.getOptionSelected() == true)
        {
           GameBoardGUI boardGUI = new GameBoardGUI();
           System.out.print("\nIn MainMenuGUI.getOptionSelected = true");

        }//end of if(mainMenu.getOptionSelected() == true)

    }//end of main



        public static void playMusic(String file)
         {
            InputStream music;
            try
            {
                //Plays music once
                music = new FileInputStream(new File(file));
                AudioStream audios = new AudioStream(music);
                AudioPlayer.player.start(audios);

                //Loops the music(doesn't work)
                /*AudioData data = new AudioStream(new FileInputStream(filepath)).getData();
                ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
                AudioPlayer.player.start(sound);*/

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Error. Music cannot play");
            }

         }//end of playMusic method


    }//end of game


