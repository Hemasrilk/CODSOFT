import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number game!");

        // Initialize the score
        int totalScore = 0;

        while (true) {
            int score = playOneRound(scanner, random);
            totalScore += score;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing! Your total score is " + totalScore + ".");
    }

    private static int playOneRound(Scanner scanner, Random random) {
        // Set the range for the random number
        int lowerLimit = 1;
        int upperLimit = 100;
        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        // Set the number of attempts allowed
        int maxAttempts = 5;
        int attemptsLeft = maxAttempts;

        // Initialize the score for this round
        int score = 0;

        while (true) {
            // Prompt the user to enter their guess
            System.out.print("Guess the number between " + lowerLimit + " and " + upperLimit + ": ");
            int userGuess = scanner.nextInt();

            // Compare the user's guess with the generated number
            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + "!");
                score = maxAttempts - attemptsLeft + 1;
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            // Decrease the attempts left
            attemptsLeft--;

            // Check if the user has run out of attempts
            if (attemptsLeft == 0) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
                break;
            }

            System.out.println("Attempts left: " + attemptsLeft);
        }

        // Display the score for this round
        System.out.println("Your score for this round: " + score);

        return score;
    }
}
