package nl.han.ica.ICAman;

import java.util.ArrayList;
import java.io.*;

public class IWriteReadTextFile {
    public static void writeFile(String player, int score){
        ArrayList<String> players = new ArrayList<String>();
        ArrayList<Integer> scores = new ArrayList<Integer>();

        players.add(player);
        scores.add(score);


        try {
            FileWriter fw = new FileWriter("test.txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("HIGHSCORES: ");
            for(int writeLine = 0; writeLine < players.size(); writeLine++) {
                pw.println(players.get(writeLine) + ": " + scores.get(writeLine));
            }


            pw.close();
            System.out.println("File write successful");
        } catch (IOException e) {
            System.out.println("ERROR!");
        }
    }
}
