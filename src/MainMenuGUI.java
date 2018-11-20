//MainMenuGUI.java by Ryan Madigan
/*This class creates the GUI for the main menu.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuGUI {

    JFrame mainMenu = new JFrame();
    JButton twoPlayerButton = new JButton();
   // JButton onePlayerButton = new JButton();
    JButton statsButton = new JButton();
    JButton quitButton = new JButton();
    ImageIcon ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

    private static String typeOfGame;
    private static boolean optionSelected=false;

    JTextArea playerStats = new JTextArea();


    Player player = new Player();
    GameBoardGUI boardGUI;

    /**Creates the main menu gui setting it up with jbuttons */

    public MainMenuGUI()
    {
        //Menu JFrame setup
        mainMenu.setLayout(null);
        mainMenu.setSize(500,500);
        mainMenu.setLocation(550,50);
        mainMenu.setIconImage(ticTacToeIcon.getImage());
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainMenu.setTitle("Tic Tac Toe");
        mainMenu.getContentPane().setBackground(Color.LIGHT_GRAY);

        //two player button setup
        twoPlayerButton.setText("Play");
        twoPlayerButton.setSize(100,70);
        twoPlayerButton.setLocation(180,40);
        mainMenu.add(twoPlayerButton);

        //one player button setup
       /* onePlayerButton.setText("One Player");
        onePlayerButton.setSize(100,70);
        onePlayerButton.setLocation(180,150);
        mainMenu.add(onePlayerButton);*/

        //stats button setup
        statsButton.setText("Stats");
        statsButton.setSize(100,70);
        statsButton.setLocation(180,180);
        mainMenu.add(statsButton);

        //quit button setup
        quitButton.setText("Quit");
        quitButton.setSize(100,70);
        quitButton.setLocation(180,320);
        mainMenu.add(quitButton);

        //ButtonEventHandler buttonHandler = new ButtonEventHandler();

        twoPlayerButton.addActionListener(new ButtonEventHandler());
      //  onePlayerButton.addActionListener(buttonHandler);
        statsButton.addActionListener(new ButtonEventHandler());
        quitButton.addActionListener(new ButtonEventHandler());


        boardGUI = new GameBoardGUI();

        mainMenu.setVisible(true);

    }//end of MainMenuGUI constructor

    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == twoPlayerButton)
            {
                //Sets the varaible based on what option is selected
                boardGUI.ticTacToeBoard.setVisible(true);
                mainMenu.dispose();
               // mainMenu.setVisible(false);
                
            }

            if(e.getSource()== statsButton)
            {
                ArrayList<Player> playerDetails =  boardGUI.openStats();

                JTextArea playerStats = new JTextArea();
                playerStats.setText("Player Stats");

                if(playerDetails.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"No stats to display");
                }
                else
                    {

                    for (int i = 0; i < playerDetails.size(); i++)
                    {
                        playerStats.append(playerDetails.get(i).toString());
                    }

                    JOptionPane.showMessageDialog(null,playerStats);
                }

            }

            if(e.getSource()== quitButton)
            {
                JOptionPane.showMessageDialog(null,"Thanks for playing","Close Application",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } // end of actionPerformed

    }//End of ButtonEventHandler class


    public void setTypeOfGame(String typeOfGame)
    {
        this.typeOfGame = typeOfGame;
    }

    public static String getTypeOfGame()
    {
        return typeOfGame;
    }


}

