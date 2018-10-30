//Game.java by Ryan Madigan
/*This class will be used for playing the game calling other classes and mathods.
* While also using some of its own methods*/

public class Game {
    public static void main(String[] args)
    {
        MainMenuGUI mainMenu = new MainMenuGUI();
        Boolean tileTaken [] = new Boolean[]{false,false,false,false,false,false,false,false,false};
        boolean isGameFinished=false;
        //GameBoardGUI boardGUI = new GameBoardGUI();



        if(mainMenu.getTypeOfGame().equals("two"))
        {
            GameBoardGUI boardGUI = new GameBoardGUI();

            while(!isGameFinished)
            {
                playerOneTurn();

                playerTwoTurn();

            }

        }

        if(mainMenu.getTypeOfGame().equals("one"))
       {
          GameBoardGUI boardGUI = new GameBoardGUI();

          while(!isGameFinished)
          {

              playerOneTurn();

              cpuTurn();

          }

        }

    }

    public static void playerOneTurn()
    {

    }

    public static void playerTwoTurn()
    {

    }

    public static void cpuTurn()
    {
        
    }
}
