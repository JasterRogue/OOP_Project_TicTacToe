//Game.java by Ryan Madigan
/*This class will be used for playing the game calling other classes and mathods.
* While also using some of its own methods*/

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.*;

public class Game {

    static String printText;


    public static void main(String[] args)
    {
        String url="bensound-summer.wav";
        MainMenuGUI mainMenu = new MainMenuGUI();
        Boolean tileTaken[] = new Boolean[]{false, false, false, false, false, false, false, false, false};
        boolean isGameFinished = false;
        GameBoardGUI boardGUI = new GameBoardGUI();
        playMusic(url);



        if (mainMenu.getOptionSelected() == true) {

            //GameBoardGUI boardGUI = new GameBoardGUI();
            System.out.print(mainMenu.getTypeOfGame());

            if (mainMenu.getTypeOfGame().equals("two"))
            {

                while (!isGameFinished) {
                    playerOneTurn();

                    playerTwoTurn();

                }

            }


            if (mainMenu.getTypeOfGame().equals("one"))
            {

                while (!isGameFinished) {

                    playerOneTurn();

                    cpuTurn();

                }

            }

        }

    }


    public static void playerOneTurn ()
    {
        printText = "X";

        JOptionPane.showMessageDialog(null, "Player One Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void playerTwoTurn ()
    {
        printText = "O";

        JOptionPane.showMessageDialog(null, "Player Two Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cpuTurn ()
    {
        printText = "O";
        JOptionPane.showMessageDialog(null, "CPU Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);

//        for(int i =0; i < tileTaken.length;i++)
//        {
//            if(tileTaken[i] == false)
//            {
//                break;
//            }


            //add code to set tile



    }

    public static void playMusic(String url)
    {
        InputStream music;
        try
        {
            //Plays music once
            music = new FileInputStream(new File(url));
            AudioStream audios = new AudioStream(music);
            AudioPlayer.player.start(audios);

            //Loops the music(doesn't work)
            /*AudioData data = new AudioStream(new FileInputStream(filepath)).getData();
            ContinuousAudioDataStream sound = new ContinuousAudioDataStream(data);
            AudioPlayer.player.start(sound);*/

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    }


