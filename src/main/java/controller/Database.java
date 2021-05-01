package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Database {
    public static void readFromDatabase() {
        new File("src/database/players").mkdirs();

    }

    public static void updatePlayerInformationInDatabase(Player player) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter fileWriter = new FileWriter("src/database/players/" + player.getUsername() + ".json");
            fileWriter.write(gson.toJson(player));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
