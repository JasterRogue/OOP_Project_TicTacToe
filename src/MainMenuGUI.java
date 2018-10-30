//MainMenuGUI.java by Ryan Madigan
/*This class creates the GUI for the main menu.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame {

    JFrame mainMenu = new JFrame();
    JButton twoPlayerButton = new JButton();
    JButton onePlayerButton = new JButton();
    JLabel welcomeMessage = new JLabel();
    ImageIcon ticTacToeIcon = new ImageIcon("tictactoeicon.PNG");

    private String typeOfGame;

    //Creating the menu gui
    public MainMenuGUI()
    {
        //Menu JFrame setup
        mainMenu.setLayout(null);
        mainMenu.setSize(500,500);
        mainMenu.setLocation(350,50);
        mainMenu.setIconImage(ticTacToeIcon.getImage());
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainMenu.setTitle("Tic Tac Toe");
        mainMenu.getContentPane().setBackground(Color.LIGHT_GRAY);

       /* welcomeMessage.setText("Welcome to Tic Tac Toe. Please select an option");
        welcomeMessage.setLocation(350,100);
        mainMenu.add(welcomeMessage);*/

        //two player button setup
        twoPlayerButton.setText("Two Player");
        twoPlayerButton.setSize(100,70);
        twoPlayerButton.setLocation(180,90);
        mainMenu.add(twoPlayerButton);

        //one player button setup
        onePlayerButton.setText("One Player");
        onePlayerButton.setSize(100,70);
        onePlayerButton.setLocation(180,280);
        mainMenu.add(onePlayerButton);

        ButtonEventHandler buttonHandler = new ButtonEventHandler();

        twoPlayerButton.addActionListener(buttonHandler);
        onePlayerButton.addActionListener(buttonHandler);
        typeOfGame = "";

        mainMenu.setVisible(true);

    }

    private class ButtonEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == twoPlayerButton)
            {
                //This line is just for testing if the button works
                //JOptionPane.showMessageDialog(null,"Pressed two player button");

                //Sets the varaible based on what option is selected
                typeOfGame = "two";
                setTypeOfGame(typeOfGame);
                System.exit(0);
            }

            if(e.getSource() == onePlayerButton)
            {
                //This line is just for testing if the button works
                //JOptionPane.showMessageDialog(null,"Pressed one player button");

                //Sets the varaible based on what option is selected
                typeOfGame = "one";
                setTypeOfGame(typeOfGame);
                System.exit(0);
            }
        }

    }

   /* public MainMenuGUI(String typeOfGame)
    {
        this.typeOfGame = typeOfGame;

    }*/

    public void setTypeOfGame(String typeOfGame)
    {
        this.typeOfGame = typeOfGame;
    }

    public String getTypeOfGame()
    {
        return typeOfGame;
    }

}

