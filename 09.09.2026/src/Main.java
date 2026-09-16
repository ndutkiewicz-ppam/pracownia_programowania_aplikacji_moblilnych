import java.util.Random;
import java.util.Scanner;

class DiceGame {
    private Random random = new Random();

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            int diceNumber = getDiceNumber(scanner);
            rollDice(diceNumber);

            System.out.println("grasz jeszcze raz? [t/n]");

            String answer = scanner.next();

            if (answer.equalsIgnoreCase("n")) {
                playing = false;
            }
        }
        scanner.close();
    }
    private int getDiceNumber(Scanner scanner) {
        int number = 0;

        while (number < 3 || number > 10) {
            System.out.println("ile kostek chcesz rzucić? [3-10]");

            number = scanner.nextInt();
        }
        return number;
    }
    private void rollDice(int diceNumber) {
        System.out.println();

        for (int i = 1; i <= diceNumber; i++) {
            int result = random.nextInt(6) + 1;

            System.out.println("kostka " + i + ": " + result);
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {

        DiceGame game = new DiceGame();
        game.startGame();
    }
}