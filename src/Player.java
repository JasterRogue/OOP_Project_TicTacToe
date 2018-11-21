//Player.java by Ryan Madigan
/*This class will be used for creating the player components, games played,wins
 * losses and draws */

import java.io.Serializable;

public class Player implements Serializable {

    private int gamesPlayed;
    private int numberOfWins;
    private int numberOfLosses;
    private int numberOfDraws;

   public Player()
    {
        gamesPlayed = 0;
        numberOfWins = 0;
        numberOfLosses = 0;
        numberOfDraws = 0;
    }

    public Player(int gamesPlayed, int numberOfWins, int numberOfLosses, int numberOfDraws)
    {
        this.gamesPlayed = gamesPlayed;
        this.numberOfWins = numberOfWins;
        this.numberOfLosses = numberOfLosses;
        this.numberOfDraws = numberOfDraws;
    }

    public void setGamesPlayed(int gamesPlayed)
    {
        this.gamesPlayed = gamesPlayed;
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

    public int getGamesPlayed()
    {
        return gamesPlayed;
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
        return  "\n\nGames Played: " + getGamesPlayed() +
                "\nWins: " + getNumberOfWins() +
                "\nLosses: " + getNumberOfLosses() +
                "\nDraws: " + getNumberOfDraws();
    }
}
