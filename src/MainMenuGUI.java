//MainMenuGUI.java by Ryan Madigan
/*This class creates the GUI for the main menu.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI {//extends JFrame {

    JFrame mainMenu = new JFrame();
    JButton twoPlayerButton = new JButton();
    JButton onePlayerButton = new JButton();
    JButton statsButton = new JButton();
    JButton quitButton = new JButton();
    ImageIcon ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

    private static String typeOfGame;
    private static boolean optionSelected=false;

    //Creating the menu gui
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
        twoPlayerButton.setText("Two Player");
        twoPlayerButton.setSize(100,70);
        twoPlayerButton.setLocation(180,40);
        mainMenu.add(twoPlayerButton);

        //one player button setup
        onePlayerButton.setText("One Player");
        onePlayerButton.setSize(100,70);
        onePlayerButton.setLocation(180,150);
        mainMenu.add(onePlayerButton);

        statsButton.setText("Stats");
        statsButton.setSize(100,70);
        statsButton.setLocation(180,260);
        mainMenu.add(statsButton);

        quitButton.setText("Quit");
        quitButton.setSize(100,70);
        quitButton.setLocation(180,360);
        mainMenu.add(quitButton);

        ButtonEventHandler buttonHandler = new ButtonEventHandler();

        twoPlayerButton.addActionListener(buttonHandler);
        onePlayerButton.addActionListener(buttonHandler);
        statsButton.addActionListener(buttonHandler);
        quitButton.addActionListener(buttonHandler);


        mainMenu.setVisible(true);

    }//end of MainMenuGUI constructor

    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == twoPlayerButton)
            {
                //Sets the varaible based on what option is selected
               // typeOfGame = "two";
                optionSelected = true;
                setTypeOfGame("two");
               // mainMenu.setVisible(false);
                mainMenu.dispose();
                String args[] = {"",""};
                Game.main(args);
                //Game.x(this);
            }

            if(e.getSource() == onePlayerButton)
            {
                //Sets the varaible based on what option is selected
                //typeOfGame = "one";
                setTypeOfGame("one");
                System.out.print("Type of game is: " + getTypeOfGame());
                optionSelected = true;
                mainMenu.setVisible(false);
                String args[] = {"",""};
                Game.main(args);
            }

            if(e.getSource()== statsButton)
            {
                JOptionPane.showMessageDialog(null,"Wins: " + "\nTies" + "\nLosses","Stats",JOptionPane.INFORMATION_MESSAGE);
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

    public static boolean getOptionSelected()
    {
        return optionSelected;
    }

}

