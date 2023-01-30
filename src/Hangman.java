import java.util.Scanner;

public class Hangman {
    private int mistake;
    private String mysteryWord;
    private Character[] lettersOfMysteryWord;
    public static final int COUNT_OF_PERMISSIBLE_ERRORS = 5;

    public Hangman() {
        this.mistake = 0;
        this.mysteryWord = Dictionary.getRandomWord();
        this.lettersOfMysteryWord = new Character[mysteryWord.length()];
        startGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver()) {
            printRowOfDashes();
            System.out.println("\n");
            Character character = scanner.next().charAt(0);
            if (isYourLetterHere(character)) {
                setLetterToArrayList(character);
            } else {
                System.out.println("Wrong letter");
                mistake++;
                printGallows();
                System.out.println("\n");

            }
        }
    }

    public boolean gameOver() {
        if (isLose()) {
            System.out.println("LOSER");
            System.out.println("Word was: " + mysteryWord);
            System.out.println("\n");
            return true;
        } else if (isWin()) {
            printRowOfDashes();
            System.out.println("\n");
            System.out.println("WINNER");
            return true;
        }
        return false;
    }

    public void printRowOfDashes() {
        for (int i = 0; i < lettersOfMysteryWord.length; i++) {
            if (lettersOfMysteryWord[i] == null) {
                System.out.print(" _ ");
            } else {
                System.out.print(lettersOfMysteryWord[i] + " ");
            }
        }
    }

    public boolean isYourLetterHere(Character letter) {
        return mysteryWord.contains(letter.toString());
    }

    public void setLetterToArrayList(Character letter) {
        for (int i = 0; i < mysteryWord.length(); i++) {
            if (mysteryWord.charAt(i) == letter) {
                lettersOfMysteryWord[i] = letter;
            }
        }
    }

    public boolean isWin() {
        for (Character character : lettersOfMysteryWord) {
            if (character == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isLose() {
        return mistake == COUNT_OF_PERMISSIBLE_ERRORS;
    }

    public void printGallows() {
        if (mistake == 1) {
            printFrame();
        } else if (mistake == 2) {
            printFrame();
            System.out.println("|/     |");
        } else if (mistake == 3) {
            printFrame();
            System.out.println("|/     |");
            System.out.println("|      0");
        } else if (mistake == 4) {
            printFrame();
            System.out.println("|/     |");
            System.out.println("|      0");
            System.out.println("|     /|\\");
        } else if (mistake == 5) {
            printFrame();
            System.out.println("|/     |");
            System.out.println("|      0");
            System.out.println("|     /|\\");
            System.out.println("|     / \\");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("\n");
        }
    }

    public void printFrame() {
        for (int i = 0; i < 3; i++) {
            System.out.print(" _ ");
        }
        System.out.println("");
    }
}
