//Player.java by Ryan Madigan
/*This class will be used for saving details of the player, name,wins
 * losses and draws */

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;

   public Player()
    {
        name = "Unknown";
        numberOfWins = 0;
        numberOfLosses = 0;
        numberOfDraws = 0;
    }

    public Player(String name, int numberOfWins, int numberOfLosses, int numberOfDraws)
    {
        this.name = name;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraws = numberOfDraws;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumberOfWins(int numberOfWins)
    {
        this.numberOfWins = numberOfWins;
    }

    public void setNumberOfLosses(int numberOfLosses)
    {
        this.numberOfLosses = numberOfLosses;
    }

    public void setNumberOfDraws(int numberOfDraws)
    {
        this.numberOfDraws = numberOfDraws;
    }

    public String getName()
    {
        return name;
    }

    public int getNumberOfWins()
    {
        return numberOfWins;
    }

    public int getNumberOfLosses()
    {
        return numberOfLosses;
    }

    public int getNumberOfDraws()
    {
        return numberOfDraws;
    }

    public String toString()
    {
        return  "\n\nName: " + getName() +
                "\nWins: " + getNumberOfWins() +
                "\nLosses: " + getNumberOfLosses() +
                "\nDraws: " + getNumberOfDraws();
    }
}
