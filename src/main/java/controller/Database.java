package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import model.Player;
import model.cards.Card;
import model.cards.CardTypes;
import model.cards.magiccard.MagicCard;
import model.cards.magiccard.MagicCardStatuses;
import model.cards.monstercard.MonsterCardAttributes;
import model.cards.monstercard.MonsterCard;

import java.io.*;
import java.util.ArrayList;

public class Database {
    public static void prepareGame() {
        new File("src/database/players").mkdirs();
        addCardsToGame();
        readPlayersDataFromDatabase();
    }

    private static void addCardsToGame() {
        try {
            FileReader monsterCardFileReader = new FileReader("src/database/cards/Monster Upgraded.csv");
            CSVReader monsterCardCSVReader = new CSVReaderBuilder(monsterCardFileReader).withSkipLines(1).build();

            String[] monsterCardData;
            while ((monsterCardData = monsterCardCSVReader.readNext()) != null) {
                createNewMonsterCard(monsterCardData);
            }


            FileReader magicCardFileReader = new FileReader("src/database/cards/SpellTrap.csv");
            CSVReader magicCardCSVReader = new CSVReaderBuilder(magicCardFileReader).withSkipLines(1).build();

            String[] magicCardData;
            while ((magicCardData = magicCardCSVReader.readNext()) != null) {
                createNewMagicCard(magicCardData);
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(0);
        }
    }

    private static void createNewMonsterCard(String[] data) {
        String name = data[0];
        short level = Short.parseShort(data[1]);
        MonsterCardAttributes monsterCardAttributes = MonsterCardAttributes.valueOf(data[2]);
        String monsterType = data[3];
        CardTypes cardType = CardTypes.valueOf(data[4].toUpperCase());
        int attackPoints = Integer.parseInt(data[5]);
        int defensePoints = Integer.parseInt(data[6]);
        String description = data[7];
        int price = Integer.parseInt(data[8]);

        new MonsterCard(name, level, monsterCardAttributes, monsterType, cardType, attackPoints, defensePoints, description, price);
    }

    private static void createNewMagicCard(String[] data) {
        String name = data[0];
        CardTypes cardType = CardTypes.valueOf(data[1].toUpperCase());
        String icon = data[2];
        String description = data[3];
        MagicCardStatuses status = MagicCardStatuses.valueOf(data[4].toUpperCase());
        int price = Integer.parseInt(data[5]);

        new MagicCard(name, cardType, icon, description, status,price);
    }

    public static void readPlayersDataFromDatabase() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File("src/database/players");
        FilenameFilter filenameFilter = (direction, name) -> name.endsWith(".json");
        String[] filesName = file.list(filenameFilter);

        for (String fileName : filesName) {
            try {
                FileReader fileReader = new FileReader("src/database/players/" + fileName);
                Player player = gson.fromJson(fileReader, Player.class);
                fileReader.close();
                Player.addPlayerToAllPlayers(player);
                addCardsToPlayer(player);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void addCardsToPlayer(Player player) {
        ArrayList<Card> boughtCards = player.getBoughtCards();
        for (int i = 0; i < boughtCards.size(); i++) {
            Card fakeCard = boughtCards.get(0);
            Card originalCard = Card.getCardByName(fakeCard.getName());
            boughtCards.remove(fakeCard);
            player.addCardToBoughtCards(originalCard);
        }
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
