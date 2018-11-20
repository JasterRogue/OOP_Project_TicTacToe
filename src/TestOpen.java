import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TestOpen {

    public static void main(String[] args) {



        try{
            File file = new File("playerStats.dat");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Player> playerDetails = (ArrayList<Player>) ois.readObject();
            ois.close();
        }

        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Stats are corrupt and can't be opened");
        }

        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Error. Class not found");

        }


    }//end of openStats




}
