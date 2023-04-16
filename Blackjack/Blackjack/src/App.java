import java.util.Random;
import java.util.*;

public class App {
    static String[] CARDS = { "A of hearts", "2 of hearts", "3 of hearts", "4 of hearts",
            "5 of hearts", "6 of hearts", "7 of hearts", "8 of hearts", "9 of hearts", "10 of hearts", "J of hearts",
            "Q of hearts",
            "K of hearts", "A of clubs", "2 of clubs", "3 of clubs", "4 of clubs", "5 of clubs", "6 of clubs",
            "7 of clubs", "8 of clubs", "9 of clubs", "10 of clubs", "J of clubs", "Q of clubs", "K of clubs",
            "A of spades",
            "2 of spades", "3 of spades", "4 of spades", "5 of spades", "6 of spades", "7 of spades", "8 of spades",
            "9 of spades", "10 of spades",
            "J of spades", "Q of spades", "K of spades", "A of diamonds", "2 of diamonds", "3 of diamonds",
            "4 of diamonds",
            "5 of diamonds", "6 of diamonds", "7 of diamonds", "8 of diamonds", "9 of diamonds", "10 of diamonds",
            "J of diamonds",
            "Q of diamonds",
            "K of diamonds" };
    static int[] VALUES = { 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,
            0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
    static String currentCard;
    static int currentValue;
    static int total1 = 0;
    static int total2 = 0;
    static int played = 0;
    static int won = 0;
    static Scanner reader = new Scanner(System.in);
    static String[] drawn = new String[52];

    public static String randomCard() throws InvalidSuiteExcepetion {
        Random rand = new Random();
        int x = rand.nextInt(52);
        currentCard = CARDS[x];
        currentValue = VALUES[x];
        return currentCard;
    }

    public static boolean checkAce() {
        if (currentValue == 0) {
            return true;
        }
        return false;
    }

    public static String printTotal() {
        if (total1 == total2) {
            return "The current total is " + total1;
        } else {
            return "The current total is either " + total1 + " or " + total2;
        }
    }

    public static boolean alreadyDrawn() {
        for (String card : drawn) {
            if (currentCard == card) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlackjack() {
        if (total1 == 21) {
            System.out.println("Blackjack!");
            won += 1;
            return true;
        } else if (total2 == 21) {
            System.out.println("Blackjack!");
            won += 1;
            return true;
        } else if (total1 > 21 & total2 > 21) {
            System.out.println("Busted!");
            return true;
        }
        return false;
    }

    public static void drawCard() throws InvalidSuiteExcepetion {
        randomCard();
        String card = currentCard;
        if (checkAce()) {
            total1 += 1;
            total2 += 11;
        } else {
            total1 += currentValue;
            total2 += currentValue;
        }
        if (alreadyDrawn()) {
            drawCard();
        } else {
            for (int index = 0; index < drawn.length; index++) {
                if (drawn[index] == null) {
                    drawn[index] = card;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InvalidSuiteExcepetion {

        boolean keepPlaying = true;
        String faceDown, faceUp;
        boolean roundOver = false;
        String ratio = "You have won " + won + " out of " + played + " games.";
        while (keepPlaying) {
            played += 1;
            // Draws random card
            randomCard();
            faceDown = currentCard;
            if (checkAce()) {
                total1 += 1;
                total2 += 11;
            } else {
                total1 += currentValue;
                total2 += currentValue;
            }
            randomCard();
            faceUp = currentCard;
            if (checkAce()) {
                total1 += 1;
                total2 += 11;
            } else {
                total1 += currentValue;
                total2 += currentValue;
            }
            System.out.print("Facedown card: ");
            System.out.println(faceDown);
            System.out.print("Faceup card: ");
            System.out.println(faceUp);
            System.out.println(printTotal());
            while (!roundOver) {
                // If total greater or equal to 21 game ends
                roundOver = isBlackjack();
                System.out.println("hit(h) or stick(s)");
                roundOver = reader.hasNext("s");
                if (!roundOver) {
                    drawCard();
                    printTotal();
                }
            }
            System.out.println(printTotal());
            // resets incase user wants to play again
            total1 = 0;
            total2 = 0;
            System.out.println("Would you like another game? y or n");
            boolean again = reader.hasNext("n");
            if (again) {
                keepPlaying = false;
            }
            roundOver = false;
        }
        System.out.println(ratio);
    }

}
