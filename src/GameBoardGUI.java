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
    JButton tile0 = new JButton();
    JButton tile1 = new JButton();
    JButton tile2 = new JButton();
    JButton tile3 = new JButton();
    JButton tile4 = new JButton();
    JButton tile5 = new JButton();
    JButton tile6 = new JButton();
    JButton tile7 = new JButton();
    JButton tile8 = new JButton();

    public GameBoardGUI()
    {
        ticTacToeBoard.setTitle("Tic Tac Toe");
        ticTacToeBoard.setSize(617,640);
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

        ticTacToeBoard.add(tile0);
        ticTacToeBoard.add(tile1);
        ticTacToeBoard.add(tile2);
        ticTacToeBoard.add(tile3);
        ticTacToeBoard.add(tile4);
        ticTacToeBoard.add(tile5);
        ticTacToeBoard.add(tile6);
        ticTacToeBoard.add(tile7);
        ticTacToeBoard.add(tile8);

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
    }

    private class EventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }
    }
}
