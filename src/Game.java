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
    static boolean playerOneTurnTaken=false;
    static boolean playerTwoTurnTaken=false;

    public static void main(String[] args)
    {
        count++;
        MainMenuGUI mainMenu;
        String url="bensound-summer.wav";
        if(count==1)
             mainMenu = new MainMenuGUI();
       // Boolean tileTaken[] = new Boolean[]{false, false, false, false, false, false, false, false, false};
        boolean isGameFinished = false;
        //GameBoardGUI boardGUI = new GameBoardGUI();
        playMusic(url);


        if (MainMenuGUI.getOptionSelected() == true)
        {

           GameBoardGUI boardGUI = new GameBoardGUI();
        //   System.out.print("\nType of game" + MainMenuGUI.getTypeOfGame());
           //System.out.print("\nWe got past the first if statement but it's not over");

            if (MainMenuGUI.getTypeOfGame().equals("two"))
            {
             //   System.out.print("\nWe did it! We actually did it");

                while (!isGameFinished)
                {
                    playerOneTurn();

                    playerTwoTurn();

                }

            }


            if (MainMenuGUI.getTypeOfGame().equals("one"))
            {
             //   System.out.print("\nWe did it! We actually did it");

                while (!isGameFinished)
                {

                    playerOneTurn();

                    cpuTurn();

                }

            }

        }//end of if(mainMenu.getOptionSelected() == true)

    }//end of main


    public static void playerOneTurn ()
    {
        printText = "X";

        JOptionPane.showMessageDialog(null, "Player One Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);

    }//end of playerOneTurn

    public static void playerTwoTurn ()
    {
        printText = "O";

        JOptionPane.showMessageDialog(null, "Player Two Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);
    }//end of playerTwoTurn

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



    }//end of cpuTurn

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
                JOptionPane.showMessageDialog(null,"Error. Music cannot play");
            }

         }//end of playMusic method


    }//end of game


