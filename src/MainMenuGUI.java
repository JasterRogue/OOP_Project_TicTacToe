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
    JButton statsButton = new JButton();
    JButton quitButton = new JButton();
    ImageIcon ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

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

        ButtonEventHandler buttonHandler = new ButtonEventHandler();

        twoPlayerButton.addActionListener(buttonHandler);
        statsButton.addActionListener(buttonHandler);
        quitButton.addActionListener(buttonHandler);


        boardGUI = new GameBoardGUI();

        mainMenu.setVisible(true);

    }//end of MainMenuGUI constructor

    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == twoPlayerButton)
            {
                boardGUI.ticTacToeBoard.setVisible(true);
                mainMenu.dispose();
               // mainMenu.setVisible(false);
            }

            if(e.getSource()== statsButton)
            {
                ArrayList<Player> playerDetails =  boardGUI.openStats();

                JTextArea playerStats = new JTextArea();
                playerStats.setText("All Player Stats");

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

                    JOptionPane.showMessageDialog(null,playerStats,"Stats",JOptionPane.INFORMATION_MESSAGE);
                }

            }

            if(e.getSource()== quitButton)
            {
                JOptionPane.showMessageDialog(null,"Thanks for playing","Close Application",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } // end of actionPerformed

    }//End of ButtonEventHandler class

}//end of MainMenuGUI class

