package controller.importexportmenu;

import controller.Utils;

import java.util.regex.Matcher;

public class ImportExportMenuController {
    public ImportExportMenuMessages findCommand(String command) {

        if (command.startsWith("menu enter")) return enterAMenu(command);
        else if (command.equals("menu exit")) return ImportExportMenuMessages.EXIT_IMPORT_EXPORT_MENU;
        else if (command.equals("menu show-current")) return ImportExportMenuMessages.SHOW_MENU;
        else if (command.equals("import card")) return importCard(command);
        else if (command.equals("export card")) return exportCard(command);

        return ImportExportMenuMessages.INVALID_COMMAND;
    }

    private ImportExportMenuMessages enterAMenu(String command) {
        Matcher matcher = Utils.getMatcher(ImportExportMenuRegexes.ENTER_A_MENU.getRegex(), command);
        if (!matcher.find()) return ImportExportMenuMessages.INVALID_COMMAND;

        return ImportExportMenuMessages.INVALID_NAVIGATION;
    }

    private ImportExportMenuMessages importCard(String command) {
        Matcher matcher = Utils.getMatcher(ImportExportMenuRegexes.IMPORT_CARD.getRegex(), command);
        if (!matcher.find()) return ImportExportMenuMessages.INVALID_COMMAND;
//        TODO: complete this function.
        return ImportExportMenuMessages.EMPTY;
    }

    private ImportExportMenuMessages exportCard(String command) {
        Matcher matcher = Utils.getMatcher(ImportExportMenuRegexes.EXPORT_CARD.getRegex(), command);
        if (!matcher.find()) return ImportExportMenuMessages.INVALID_COMMAND;
//        TODO: complete this function.
        return ImportExportMenuMessages.EMPTY;
    }
}
