package controller.mainmenu;

import controller.Utils;
import model.Player;
import view.DuelMenuView;
import view.ImportExportMenuView;
import view.ShopMenuView;

import java.util.regex.Matcher;

public class MainMenuController {
    private Player loggedInPlayer;

    public MainMenuController(Player loggedInPlayer) {
        setLoggedInPlayer(loggedInPlayer);
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public MainMenuMessages findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return MainMenuMessages.EXIT_MAIN_MENU;
        else if (command.equals("menu show-current")) return MainMenuMessages.SHOW_MENU;
        else if (command.equals("user logout")) return MainMenuMessages.USER_LOGGED_OUT;
        else if (command.startsWith("duel")) return enterDuelMenu(command);

        return MainMenuMessages.INVALID_COMMAND;
    }

    private MainMenuMessages enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher(MainMenuRegexes.ENTER_A_MENU.getRegex(), command);
        if (!matcher.find()) return MainMenuMessages.INVALID_COMMAND;

        String menu = matcher.group(1);
        if (menu.equalsIgnoreCase("Login")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Main")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Duel")) {
            return MainMenuMessages.INVALID_NAVIGATION;
        } else if (menu.equalsIgnoreCase("Deck")) {
//            DeckMenuView deckMenuView = new DeckMenuView(loggedInPlayer);
//            deckMenuView.deckMenuView();
        } else if (menu.equalsIgnoreCase("Scoreboard")) {
//            ScoreboardMenuView scoreboardMenuView = new ScoreboardMenuView(loggedInPlayer);
//            scoreboardMenuView.scoreboardMenuView();
        } else if (menu.equalsIgnoreCase("Profile")) {
//            ProfileMenuView profileMenuView = new ProfileMenuView(loggedInPlayer);
//            profileMenuView.profileMenuView();
        } else if (menu.equalsIgnoreCase("Shop")) {
            ShopMenuView shopMenuView = new ShopMenuView(loggedInPlayer);
            shopMenuView.shopMenuView();
        } else if (menu.equalsIgnoreCase("ImportExport")) {
            ImportExportMenuView importExportMenuView = new ImportExportMenuView();
            importExportMenuView.ImportExportMenuView();
        }

        return MainMenuMessages.EMPTY;
    }

    private MainMenuMessages enterDuelMenu(String command) {
//        TODO: clean and optimise this code according to AI
        Matcher matcher;
        String opponentPlayerCommand, rounds;
        if (( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_FIRST_PATTERN.getRegex(), command) ).find() ||
                ( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_THIRD_PATTERN.getRegex(), command) ).find() ||
                ( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_FOURTH_PATTERN.getRegex(), command) ).find()) {
            opponentPlayerCommand = matcher.group(1);
            rounds = matcher.group(2);
        } else if (( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_SECOND_PATTERN.getRegex(), command) ).find() ||
                ( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_FIFTH_PATTERN.getRegex(), command) ).find() ||
                ( matcher = Utils.getMatcher(MainMenuRegexes.ENTER_DUEL_MENU_SIXTH_PATTERN.getRegex(), command) ).find()) {
            rounds = matcher.group(1);
            opponentPlayerCommand = matcher.group(2);
        } else {
            return MainMenuMessages.INVALID_COMMAND;
        }

        if (opponentPlayerCommand.startsWith("second-player")) {
            String opponentPlayerUsername = opponentPlayerCommand.substring(14);
            Player opponentPlayer = Player.getPlayerByUsername(opponentPlayerUsername);
            if (opponentPlayer == null) {
                return MainMenuMessages.UNAVAILABLE_USERNAME;
            }

            if (opponentPlayer.equals(loggedInPlayer)) return MainMenuMessages.SAME_USERNAME;

            if (loggedInPlayer.getActivatedDeck() == null) {
                MainMenuMessages.setUnavailableActiveDeck(loggedInPlayer.getUsername());
                return MainMenuMessages.UNAVAILABLE_ACTIVE_DECK;
            } else if (opponentPlayer.getActivatedDeck() == null) {
                MainMenuMessages.setUnavailableActiveDeck(opponentPlayerUsername);
                return MainMenuMessages.UNAVAILABLE_ACTIVE_DECK;
            }

//            TODO: handle MainMenuMessages.INVALID_DECK message
//            TODO: MainMenuMessages.setInvalidDeck(opponentPlayerUsername or loggedInPlayer.getUsername());
//            TODO: return MainMenuMessages.INVALID_DECK;

            if (!rounds.equals("1") && !rounds.equals("3")) {
                return MainMenuMessages.INVALID_ROUNDS_NUMBER;
            }

            DuelMenuView duelMenuView = new DuelMenuView(loggedInPlayer, opponentPlayer);
            duelMenuView.duelMenuView();
        } else {
//            TODO: handle entering to enter duel menu by AI

            if (!rounds.equals("1") && !rounds.equals("3")) {
                return MainMenuMessages.INVALID_ROUNDS_NUMBER;
            }
        }

        return MainMenuMessages.EMPTY;
    }
}
