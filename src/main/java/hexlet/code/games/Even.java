package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;


public class Even {
    public static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";

    public static void start() {
        Engine.start();
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(DESCRIPTION);
        while (Engine.getRound() < Engine.MAXROUNDS) {
            int question = setQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = playerInput.nextLine();
            String correctAnswer = answer.equals("yes") ? "no" : "yes";
            Engine.run(playerName, answer, checkAnswer(question, answer), correctAnswer);
        }
    }

    public static int setQuestion() {
        final int rangeForNumbers = 100;
        return (int) (Math.random() * rangeForNumbers);
    }

    private static boolean checkAnswer(int number, String userAnswer) {
        if (number % 2 == 0 && userAnswer.equals("yes")) {
            return true;
        } else {
            return number % 2 != 0 && userAnswer.equals("no");
        }
    }
}
