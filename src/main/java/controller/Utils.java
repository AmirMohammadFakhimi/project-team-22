package controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Matcher getMatcher(String regex, String command) {
        return Pattern.compile(regex).matcher(command);
    }
}
