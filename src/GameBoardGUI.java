//GameBoardGUI.java by Ryan Madigan
/*This class is used to create the game board and all of its neccessary
* components*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoardGUI{

    JFrame ticTacToeBoard;
    ImageIcon ticTacToeIcon;

    //Each board tile is an individual button
     JButton tile0   = new JButton();
     JButton tile1 = new JButton();
     JButton tile2 = new JButton();
     JButton tile3 = new JButton();
     JButton tile4 = new JButton();
     JButton tile5 = new JButton();
     JButton tile6 = new JButton();
     JButton tile7;
     JButton tile8;



   /* tile2 = new JButton();
    tile3 = new JButton();
    tile4 = new JButton();
    tile5 = new JButton();
    tile6 = new JButton();*/


     JLabel playerTurn;

    static Boolean tileTaken [] = new Boolean[]{false,false,false,false,false,false,false,false,false};
    Font buttonFont = new Font("Arial", Font.PLAIN,80); // This is really just for setting the text size

    static String printText;
    static boolean isGameFinished;

    /**Creates the Game board . Creates 9 buttons and sets there size, location and font*/
    public GameBoardGUI()
    {
        ticTacToeBoard = new JFrame();
        ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

        ticTacToeBoard.setTitle("Tic Tac Toe");
        ticTacToeBoard.setSize(608,650);
        ticTacToeBoard.setLocation(350,50);
        ticTacToeBoard.setIconImage(ticTacToeIcon.getImage());
        ticTacToeBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // ticTacToeBoard.getContentPane().setBackground(Color.LIGHT_GRAY);
        ticTacToeBoard.setResizable(false);
        ticTacToeBoard.setLayout(null);

        Container pane = ticTacToeBoard.getContentPane();
        pane.setBackground(Color.LIGHT_GRAY);

        //sets the postion and size of each tile so they don't overlap each other
        playerTurn = new JLabel("Player turn");

        /* tile0 = new JButton();
         tile1 = new JButton();
         tile2 = new JButton();
         tile3 = new JButton();
         tile4 = new JButton();
         tile5 = new JButton();
         tile6 = new JButton();*/
       //  tile7 = new JButton();
       //  tile8 = new JButton();

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

       // tile6.setSize(200,200);
       // tile6.setLocation(0,400);

     //   tile7.setSize(200,200);
     //   tile7.setLocation(200,400);

      //  tile8.setSize(200,200);
      //  tile8.setLocation(400,400);

      //  playerTurn.setLocation(270,560);
       // playerTurn.setSize(100,100);

        tile0.setFont(buttonFont);
        tile1.setFont(buttonFont);
        tile2.setFont(buttonFont);
        tile3.setFont(buttonFont);
        tile4.setFont(buttonFont);
        tile5.setFont(buttonFont);
      //  tile6.setFont(buttonFont);
      //  tile7.setFont(buttonFont);
      //  tile8.setFont(buttonFont);

        EventHandler handler = new EventHandler();

        tile0.addActionListener(handler);
        tile1.addActionListener(handler);
        tile2.addActionListener(handler);
        tile3.addActionListener(handler);
        tile4.addActionListener(handler);
        tile5.addActionListener(handler);
      // tile6.addActionListener(handler);
      //  tile7.addActionListener(handler);
      //  tile8.addActionListener(handler);

        ticTacToeBoard.add(tile0);
        ticTacToeBoard.add(tile1);
        ticTacToeBoard.add(tile2);
        pane.add(tile3);
        pane.add(tile4);
        pane.add(tile5);
      // pane.add(tile6);
       // pane.add(tile7);
       // pane.add(tile8);


       // pane.add(playerTurn);

        ticTacToeBoard.setVisible(true);
    } // end of GameBoardGUI constructor

    /**Deals with button clicks during the game */
   private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int tileNum;
            String printText = "O";

            if(e.getSource()==tile0)
            {
                tileNum = 0;

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

    /**When this method is called it plays the game , turns will continue until isGameFinished evaluates to true */
    public  void playGame()
    {
        boolean isGameFinished=false;

        if (MainMenuGUI.getTypeOfGame().equals("two"))
        {
            System.out.print("\nIn playGame method");

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

    /**Sets the printText variable to x so if a button is clicked it applies the right mark */
    public  void playerOneTurn ()
    {
        printText = "X";
        playerTurn.setText("Player One Turn");

    }//end of playerOneTurn

    /**Sets the printText variable to o so if a button is clicked it applies the right mark */
    public  void playerTwoTurn ()
    {
        printText = "O";
        playerTurn.setText("Player Two Turn");
    }//end of playerTwoTurn

    /**The cpu loops through the tile array checking for the first available tile and selects it */
    public  void cpuTurn ()
    {
        printText = "O";
        int i;

        for( i =0; i < tileTaken.length;i++)
        {
            if (tileTaken[i] == false) {
                break;
            }
        }

           if(i == 0)
           {
               tile0.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 1)
           {
               tile1.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 2)
           {
               tile2.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 3)
           {
               tile3.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 4)
           {
               tile4.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 5)
           {
               tile5.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 6)
           {
               tile6.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 7)
           {
               tile7.setText(printText);
               tileTaken[i] = true;
           }

           if(i == 8)
           {
               tile8.setText(printText);
               tileTaken[i] = true;
           }


    }//end of cpuTurn

    public  void checkForWinner()
    {

        //Horizontal wins for X
        if(tile0.getText().equals("X") && tile1.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
        }

        if(tile3.getText().equals("X") && tile4.getText().equals("X") && tile5.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        if(tile6.getText().equals("X") && tile7.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //vertical wins for x
        if(tile0.getText().equals("X") && tile3.getText().equals("X") && tile6.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        if(tile1.getText().equals("X") && tile4.getText().equals("X") && tile7.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        if(tile2.getText().equals("X") && tile5.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //diagonal wins for x
        if(tile0.getText().equals("X") && tile4.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        if(tile6.getText().equals("X") && tile4.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }


        //Horizontal wins for O
        if(tile0.getText().equals("O") && tile1.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tile3.getText().equals("O") && tile4.getText().equals("O") && tile5.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tile6.getText().equals("O") && tile7.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;

        }

        //vertical wins for O
        if(tile0.getText().equals("O") && tile3.getText().equals("O") && tile6.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tile1.getText().equals("O") && tile4.getText().equals("O") && tile7.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tile2.getText().equals("O") && tile5.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;

        }

        //diagonal wins for O
        if(tile0.getText().equals("O") && tile4.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tile6.getText().equals("O") && tile4.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;

        }

        if(tileTaken[0]==true && tileTaken[1]==true && tileTaken[2]==true
        && tileTaken[3]==true && tileTaken[4]==true && tileTaken[5]==true
        && tileTaken[6]==true && tileTaken[7]==true && tileTaken[8]==true)
        {
            isGameFinished = true;
        }

    }//end of checkForWinner

}
