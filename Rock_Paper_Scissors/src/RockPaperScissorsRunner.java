import java.util.Random;

public class RockPaperScissorsRunner {
    private RockPaperScissorsFrame frame;
    private int playerWins = 0, computerWins = 0, ties = 0;

    public RockPaperScissorsRunner(RockPaperScissorsFrame frame) {
        this.frame = frame;
    }

    public void playRound(String playerChoice) {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int computerChoiceIndex = random.nextInt(choices.length);
        String computerChoice = choices[computerChoiceIndex];

        String result = determineWinner(playerChoice, computerChoice);

        frame.updateResults(result);
        frame.updateStats(playerWins, computerWins, ties);
    }

    private String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            ties++;
            return "It's a tie! Both chose " + playerChoice;
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            playerWins++;
            return playerChoice + " beats " + computerChoice + ". Player wins!";
        } else {
            computerWins++;
            return computerChoice + " beats " + playerChoice + ". Computer wins!";
        }
    }
}
