//GameBoardGUI.java by Ryan Madigan
/*This class is used to create the game board and all of its neccessary
* components*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoardGUI extends JFrame{

    JFrame ticTacToeBoard = new JFrame();
    ImageIcon ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

    //Each board tile is an individual button
    static JButton tile0 = new JButton();
    static JButton tile1 = new JButton();
    static JButton tile2 = new JButton();
    static JButton tile3 = new JButton();
    static JButton tile4 = new JButton();
    static JButton tile5 = new JButton();
    static JButton tile6 = new JButton();
    static JButton tile7 = new JButton();
    static JButton tile8 = new JButton();

    static JLabel playerTurn = new JLabel("Player turn");

    static Boolean tileTaken [] = new Boolean[]{false,false,false,false,false,false,false,false,false};
    Font buttonFont = new Font("Arial", Font.PLAIN,80); // This is really just for setting the text size
    static String printText;

    /**Creates the Game board . Creates 9 buttons and sets there size, location and font*/
    public GameBoardGUI()
    {
        ticTacToeBoard.setTitle("Tic Tac Toe");
        ticTacToeBoard.setSize(608,650);
        ticTacToeBoard.setLocation(350,50);
        ticTacToeBoard.setIconImage(ticTacToeIcon.getImage());
        ticTacToeBoard.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ticTacToeBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
        ticTacToeBoard.setResizable(false);
        ticTacToeBoard.setLayout(null);

        //sets the postion and size of each tile so they don't overlap each other
        tile0.setSize(200,200);
        tile0.setLocation(0,0);

        tile1.setSize(200,200);
        tile1.setLocation(200,0);

        tile2.setSize(200,200);
        tile2.setLocation(400,0);

        tile3.setSize(200,200);
        tile3.setLocation(0,200);

        tile4.setSize(200,200);
        tile4.setLocation(200,200);

        tile5.setSize(200,200);
        tile5.setLocation(400,200);

        tile6.setSize(200,200);
        tile6.setLocation(0,400);

        tile7.setSize(200,200);
        tile7.setLocation(200,400);

        tile8.setSize(200,200);
        tile8.setLocation(400,400);

        playerTurn.setLocation(270,560);
        playerTurn.setSize(100,100);

        ticTacToeBoard.add(tile0);
        ticTacToeBoard.add(tile1);
        ticTacToeBoard.add(tile2);
        ticTacToeBoard.add(tile3);
        ticTacToeBoard.add(tile4);
        ticTacToeBoard.add(tile5);
        ticTacToeBoard.add(tile6);
        ticTacToeBoard.add(tile7);
        ticTacToeBoard.add(tile8);

        ticTacToeBoard.add(playerTurn);

        tile0.setFont(buttonFont);
        tile1.setFont(buttonFont);
        tile2.setFont(buttonFont);
        tile3.setFont(buttonFont);
        tile4.setFont(buttonFont);
        tile5.setFont(buttonFont);
        tile6.setFont(buttonFont);
        tile7.setFont(buttonFont);
        tile8.setFont(buttonFont);

        EventHandler handler = new EventHandler();

        tile0.addActionListener(handler);
        tile1.addActionListener(handler);
        tile2.addActionListener(handler);
        tile3.addActionListener(handler);
        tile4.addActionListener(handler);
        tile5.addActionListener(handler);
        tile6.addActionListener(handler);
        tile7.addActionListener(handler);
        tile8.addActionListener(handler);

        ticTacToeBoard.setVisible(true);
    } // end of GameBoardGUI constructor

    /**Deals with button clicks during the game */
   private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int tileNum;
           // String printText= Game.printText;
            String printText = "O";

            if(e.getSource()==tile0)
            {
                tileNum = 0;
              //  System.out.print("\nTile Number: " + tileNum );
               // System.out.print("\nTile Status: " + tileTaken[tileNum]);

                if(tileTaken[tileNum] == false)
                {

                    tileTaken[tileNum] = true;
                    tile0.setText(printText);

                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile1)
            {
                tileNum = 1;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile1.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile2)
            {
                tileNum = 2;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile2.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile3)
            {
                tileNum = 3;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile3.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile4)
            {
                tileNum = 4;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile4.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile5)
            {
                tileNum = 5;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile5.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile6)
            {
                tileNum = 6;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile6.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile7)
            {
                tileNum = 7;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile7.setText(printText);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()==tile8)
            {
                tileNum = 8;

                if(tileTaken[tileNum] == false)
                {
                    tileTaken[tileNum] = true;
                    tile8.setText(printText);

                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } // end of actionPerformed
    }//end of EventHandler class

    /**When this method is called it plays the game , turns will continue until isGameFinished evaulates to false */
    public static void playGame()
    {
        boolean isGameFinished=false;

        if (MainMenuGUI.getTypeOfGame().equals("two"))
        {
            System.out.print("\nIm here");
            while (!isGameFinished)
            {
                playerOneTurn();

                checkForWinner();

                playerTwoTurn();

                checkForWinner();

            }

        }


        if (MainMenuGUI.getTypeOfGame().equals("one"))
        {
            while (!isGameFinished)
            {
                playerOneTurn();

                checkForWinner();

                cpuTurn();

                checkForWinner();

            }

        }
    }//end of play game

    /**Sets the printText varaible to x so if a button is clicked it applies the right mark */
    public static void playerOneTurn ()
    {
        printText = "X";
        playerTurn.setText("Player One Turn");

        //JOptionPane.showMessageDialog(null, "Player One Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);

    }//end of playerOneTurn

    /**Sets the printText varaible to o so if a button is clicked it applies the right mark */
    public static void playerTwoTurn ()
    {
        printText = "O";
        playerTurn.setText("Player Two Turn");

        //JOptionPane.showMessageDialog(null, "Player Two Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);
    }//end of playerTwoTurn

    /**The cpu loops through the tile array checking for the first available tile and selects it */
    public static void cpuTurn ()
    {
        printText = "O";
        int i;
        JOptionPane.showMessageDialog(null, "CPU Turn", "Turn", JOptionPane.INFORMATION_MESSAGE);
        for( i =0; i < tileTaken.length;i++) {
            if (tileTaken[i] == false) {
                break;
            }
        }

           if(i == 0)
           {
               tile0.setText(printText);
           }

           if(i == 1)
           {
               tile1.setText(printText);
           }

           if(i == 2)
           {
               tile2.setText(printText);
           }

           if(i == 3)
           {
               tile3.setText(printText);
           }

           if(i == 4)
           {
               tile4.setText(printText);
           }

           if(i == 5)
           {
               tile5.setText(printText);
           }

           if(i == 6)
           {
               tile6.setText(printText);
           }

           if(i == 7)
           {
               tile7.setText(printText);
           }

           if(i == 8)
           {
               tile8.setText(printText);
           }


    }//end of cpuTurn

    public static void checkForWinner()
    {

    }

    public static void main(String[] args)
    {
        System.out.print("In main of GameBoardGUI");
        playGame();
    }


}
