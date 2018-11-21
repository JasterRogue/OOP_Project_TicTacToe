//GameBoardGUI.java by Ryan Madigan
/*This class is used to create the game board and all of its necessary
* components. It also deals with the running of the game and
* checks when the game is finished*/

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GameBoardGUI implements CheckingWinners{

    File file;
    ArrayList<Player> playerDetails;

    JFrame ticTacToeBoard;
    ImageIcon ticTacToeIcon;

    MediaPlayer mediaPlayer;
    String buttonPushFile="TinyButtonPush.mp3";
    JFXPanel fxPanel = new JFXPanel();

    String winner; // This will store who is the winner

    //Each board tile is an individual button
     JButton tile0 = new JButton();
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

    Boolean tileTaken [] = new Boolean[]{false,false,false,false,false,false,false,false,false};
    Font buttonFont = new Font("Arial", Font.PLAIN,80); // This is really just for setting the text size

     boolean isGameFinished;

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

        playerDetails = new ArrayList<>();
        file = new File("playerStats.dat");

        ticTacToeBoard.setVisible(false);
        
        //playGame(); //JB - it is the call to playGame() that is ultimately causing the game to crash after board GUI is called
        
        
    } // end of GameBoardGUI constructor

    /**Deals with button clicks during the game and also whos turn it is.
     * There is a variable called turns and depending on it's value it will set the
     * variable printText to X or O.*/
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

            }
            else {
                printText = "X";
                playerTurn.setText("Player One Turn");
            }


            if(e.getSource()==tile0)
            {
                tileNum = 0;

                if(tileTaken[tileNum] == false)
                {
                    turns++; //added by JB to keep track of number of turns
                    tileTaken[tileNum] = true;
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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
                    buttonPushSound();
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

    /**This method goes through all the possible winning
     * combinations for each player. There is also a condition
     * if the game is a draw*/
    public  void checkForWinner()
    {

        //JB - created else-if here for efficiency and deal with "no winner" scenario
        
        //Horizontal wins for X 
        if(tile0.getText().equals("X") && tile1.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        else if(tile3.getText().equals("X") && tile4.getText().equals("X") && tile5.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        else if(tile6.getText().equals("X") && tile7.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        //vertical wins for x
        else if(tile0.getText().equals("X") && tile3.getText().equals("X") && tile6.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        else if(tile1.getText().equals("X") && tile4.getText().equals("X") && tile7.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        else if(tile2.getText().equals("X") && tile5.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        //diagonal wins for x
        else if(tile0.getText().equals("X") && tile4.getText().equals("X") && tile8.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";
        }

        else if(tile6.getText().equals("X") && tile4.getText().equals("X") && tile2.getText().equals("X"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player Two Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }


        //Horizontal wins for O
        else if(tile0.getText().equals("O") && tile1.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tile3.getText().equals("O") && tile4.getText().equals("O") && tile5.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tile6.getText().equals("O") && tile7.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);

            winner = "playerOne";
        }

        //vertical wins for O
        else if(tile0.getText().equals("O") && tile3.getText().equals("O") && tile6.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tile1.getText().equals("O") && tile4.getText().equals("O") && tile7.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tile2.getText().equals("O") && tile5.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        //diagonal wins for O
        else if(tile0.getText().equals("O") && tile4.getText().equals("O") && tile8.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tile6.getText().equals("O") && tile4.getText().equals("O") && tile2.getText().equals("O"))
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Player One Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        else if(tileTaken[0]==true && tileTaken[1]==true && tileTaken[2]==true
        && tileTaken[3]==true && tileTaken[4]==true && tileTaken[5]==true
        && tileTaken[6]==true && tileTaken[7]==true && tileTaken[8]==true)
        {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null,"Neither Player Wins","End of Game",JOptionPane.INFORMATION_MESSAGE);
            winner = "na";
        }

        if(isGameFinished)
        {
            ArrayList<Player> allPlayers = openStats();

            Player p = allPlayers.get(0);

            p.setGamesPlayed(p.getGamesPlayed()+1);


            if(winner.equals("playerOne"))
            {
                p.setNumberOfWins((p.getNumberOfWins() +1));

            }

            else if(winner.equals("playerTwo"))
            {
                p.setNumberOfLosses((p.getNumberOfLosses() +1));
            }

            else
            {
                p.setNumberOfDraws((p.getNumberOfDraws() +1));
            }

            ticTacToeBoard.setVisible(false);
            //ticTacToeBoard.dispose();
            MainMenuGUI mainMenuGUI = new MainMenuGUI();

            saveStats(allPlayers);
        }//end of if(gameFinished)

    }//end of checkForWinner

    /**This method saves the players stats to a file */
    public void saveStats(ArrayList<Player> playerDetails)
    {

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(playerDetails);
           // JOptionPane.showMessageDialog(null, "Player details saved successfully");
            oos.close();
        }

        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error. Could not find file.");

        }

        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error. IOException occurred");

        }

    }//end of saveStats()

    /**This opens the stats that are currently saved in the file */
    public ArrayList<Player> openStats()
    {
        ArrayList<Player> playerDetails = new ArrayList<Player>();

        try{

            File file = new File("playerStats.dat");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            playerDetails = (ArrayList<Player>) ois.readObject();
            ois.close();

        }

        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error. Stats are corrupt and can't be opened");
        }

        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error. Class not found");

        }


        return playerDetails;
    }//end of openStats

    public void buttonPushSound()
    {
        Media audioClip = new Media(new File(buttonPushFile).toURI().toString());

        mediaPlayer = new MediaPlayer(audioClip);

        try
        {
            mediaPlayer.play();
        }

        catch (Exception e)
        {
            System.out.print("Sound effect cannot play");
        }

    }

}
