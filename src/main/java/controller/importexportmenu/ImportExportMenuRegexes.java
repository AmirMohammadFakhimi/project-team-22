package controller.importexportmenu;

public enum ImportExportMenuRegexes {
    ENTER_A_MENU("^menu enter (?i)(Login|Main|Duel|Deck|Scoreboard|Profile|Shop|ImportExport) Menu$"),
    IMPORT_CARD("^import card ([^\n]+)$"),
    EXPORT_CARD("^export card ([^\n]+)$");

    private final String regex;

    ImportExportMenuRegexes(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
