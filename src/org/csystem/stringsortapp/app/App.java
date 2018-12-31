package org.csystem.stringsortapp.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    private ArrayList<String> songList = new ArrayList<>();
    public static void main(String[] args)
    {
        new App().run();
    }

    public void run()
    {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

    private void getSongs()
    {

        try {
            File file = new File("SongList.txt");

            if (!file.exists())
                throw new FileNotFoundException("File not found");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) { // \n dahil okur.
                //tam bu noktada -> Pink Moon/Nick, bunun parse edilip Pink Moon olan listeye eklemek lazım
                addSong(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void addSong(String line)
    {
        String[] tokens = line.split("/");
        songList.add(tokens[0]); //Pink Moon\n
    }

}
