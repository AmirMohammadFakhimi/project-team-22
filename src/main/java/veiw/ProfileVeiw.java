package veiw;

import controller.ProfileController;

import java.util.Scanner;

public class ProfileVeiw {
    protected String input;
    Scanner scanner = new Scanner(System.in);

    public ProfileVeiw() {
        new ProfileController(input);
    }
}
