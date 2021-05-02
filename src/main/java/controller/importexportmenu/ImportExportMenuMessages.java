package controller.importexportmenu;

public enum ImportExportMenuMessages {
    INVALID_NAVIGATION("menu navigation is not possible\n"),
    EXIT_IMPORT_EXPORT_MENU(""),
    SHOW_MENU("Import/Export Menu\n"),
    INVALID_COMMAND("invalid command\n"),
    EMPTY("");

    private final String message;

    ImportExportMenuMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
