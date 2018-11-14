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
     JButton tile7 = new JButton();
     JButton tile8 = new JButton();
     
     //JB advise - you have an awful lot of repeated code here in terms of the JButtons
     //See if you can improve the efficiency of it by creating an array of size 9 to create and hold 
     //the 9 JButton objects using a for loop and also manipulate them in several ways like setting their 
     //size (which is common to all, setting their font and adding the action listener to them as well as
     //adding each one to the pane - it will streamline your code a lot 



     JLabel playerTurn;
     int turns = 0; //added by JB - use this to count the number of tiles that have been selected to date
                    //this can be used to determine whos turn it is

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
        playerTurn = new JLabel("Player One Turn");

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

        pane.add(tile0);
        pane.add(tile1);
        pane.add(tile2);
        pane.add(tile3);
        pane.add(tile4);
        pane.add(tile5);
        pane.add(tile6);
        pane.add(tile7);
        pane.add(tile8);

        pane.add(playerTurn);

        ticTacToeBoard.setVisible(true);
        
        //playGame(); //JB - it is the call to playGame() that is ultimately causing the game to crash after board GUI is called
        
        
    } // end of GameBoardGUI constructor

    /**Deals with button clicks during the game */
    //JB - I made no changes to the code below at all. At the moment when I click on each tile
    //it renders an 'O' and should I click on the same tile twice I get a message dialog
    //indicating the tile has already been taken
    
   private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int tileNum;
            String printText;
            
            //JB advise - if you had the 9 JButtons all in an array then you could write the code below in a much
            //more efficient manner, as it is all common for each tile in the game e.g. if the array was declared
            //as follows
            //
            //  Tile[] tiles = new Tile[9];
            //
            //then you could loop over the tiles in the array using a for loop and test as follows each time
            //
            //if(e.getSource()==tiles[i] && tileTaken[tileNum] == false)
            //{
            //	    tileTaken[i] = true; //this will be a parallel array for the tiles array
            //      tiles[i].setText(printText);
            //}
            //else
            //   .......


            if(turns%2==0) //it player 1's turn
            {
                printText = "O";
                playerTurn.setText("Player Two Turn");
               // cpuTurn();
            }
            else {
                printText = "X";
               // cpuTurn();
                playerTurn.setText("Player One Turn");
            }

            if(e.getSource()==tile0)
            {
                tileNum = 0;

                if(tileTaken[tileNum] == false)
                {
                    turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile0.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile1.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile2.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile3.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile4.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile5.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile6.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile7.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken
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
                	turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    tile8.setText(printText);
                    checkForWinner(); //added by JB to check for winner after each turn is taken

                }

                else
                {
                    JOptionPane.showMessageDialog(null,"Tile is taken","Tile Status",JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } // end of actionPerformed
    }//end of EventHandler class

    /**When this method is called it plays the game , turns will continue until isGameFinished evaluates to true */
    //JB Advise - you'll never call this method, the while loop within it was causing the crash we saw earlier in class
    //as it was eating up the entire CPU time and so the GUI could never get a chance to render
    //The player turns are taken care of through a simple counter variable here and the checkForWinner() can be called
    //on its own after each turn is taken
    
    /*public  void playGame()
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
    }//end of play game*/

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

        //JB - created else-if here for efficiency and deal with "no winner" scenario
        
        //Horizontal wins for X 
        if(tile0.getText().equals("X") && tile1.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true; //JB - don't need this boolean really
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
        }

        else if(tile3.getText().equals("X") && tile4.getText().equals("X") && tile5.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile6.getText().equals("X") && tile7.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //vertical wins for x
        else if(tile0.getText().equals("X") && tile3.getText().equals("X") && tile6.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile1.getText().equals("X") && tile4.getText().equals("X") && tile7.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile2.getText().equals("X") && tile5.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //diagonal wins for x
        else if(tile0.getText().equals("X") && tile4.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile6.getText().equals("X") && tile4.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }


        //Horizontal wins for O
        else if(tile0.getText().equals("O") && tile1.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile3.getText().equals("O") && tile4.getText().equals("O") && tile5.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile6.getText().equals("O") && tile7.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //vertical wins for O
        else if(tile0.getText().equals("O") && tile3.getText().equals("O") && tile6.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile1.getText().equals("O") && tile4.getText().equals("O") && tile7.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile2.getText().equals("O") && tile5.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        //diagonal wins for O
        else if(tile0.getText().equals("O") && tile4.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tile6.getText().equals("O") && tile4.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

        }

        else if(tileTaken[0]==true && tileTaken[1]==true && tileTaken[2]==true
        && tileTaken[3]==true && tileTaken[4]==true && tileTaken[5]==true
        && tileTaken[6]==true && tileTaken[7]==true && tileTaken[8]==true)
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Neither Player Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
        }

    }//end of checkForWinner

}
