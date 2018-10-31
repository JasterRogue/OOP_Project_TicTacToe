//Game.java by Ryan Madigan
/*This class will be used for playing the game calling other classes and mathods.
* While also using some of its own methods*/

import javax.swing.*;

public class Game {

    static String printText;

    public static void main(String[] args)
    {
        MainMenuGUI mainMenu = new MainMenuGUI();
        Boolean tileTaken [] = new Boolean[]{false,false,false,false,false,false,false,false,false};
        boolean isGameFinished=false;
         // This variable will be set to x or o depending on whose turn it is
       // GameBoardGUI boardGUI = new GameBoardGUI();



        if(mainMenu.getTypeOfGame().equals("two"))
        {
            GameBoardGUI boardGUI = new GameBoardGUI();

            while(!isGameFinished)
            {
                playerOneTurn(printText);

                playerTwoTurn(printText);

            }

        }

        if(mainMenu.getTypeOfGame().equals("one"))
       {
          GameBoardGUI boardGUI = new GameBoardGUI();

          while(!isGameFinished)
          {

              playerOneTurn(printText);

              cpuTurn(printText);

          }

        }

    }

    public static void playerOneTurn(String printText)
    {
        printText = "X";

        JOptionPane.showMessageDialog(null,"Player One Turn","Turn",JOptionPane.INFORMATION_MESSAGE);

    }

    public static void playerTwoTurn(String printText)
    {
        printText = "O";

        JOptionPane.showMessageDialog(null,"Player Two Turn","Turn",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cpuTurn(String printText)
    {
        printText = "O";

        JOptionPane.showMessageDialog(null,"CPU Turn","Turn",JOptionPane.INFORMATION_MESSAGE);
    }

}
