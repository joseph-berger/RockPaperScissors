import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame implements ActionListener {
    private JButton rockButton, paperButton, scissorsButton, quitButton;
    private JLabel playerWinsLabel, computerWinsLabel, tiesLabel;
    private JTextArea resultsTextArea;
    private RockPaperScissorsRunner gameRunner;

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setLayout(new BorderLayout());
        gameRunner = new RockPaperScissorsRunner(this);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose"));
        rockButton = new JButton(new ImageIcon("rock.png"));
        rockButton.setText("Rock");
        paperButton = new JButton(new ImageIcon("paper.png"));
        paperButton.setText("Paper");
        scissorsButton = new JButton(new ImageIcon("scissors.png"));
        scissorsButton.setText("Scissors");
        quitButton = new JButton("Quit");

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        quitButton.addActionListener(this);

        buttonPanel.add(createButtonPanel(rockButton));
        buttonPanel.add(createButtonPanel(paperButton));
        buttonPanel.add(createButtonPanel(scissorsButton));
        buttonPanel.add(quitButton);

        // Stats panel
        JPanel statsPanel = new JPanel(new GridLayout(3, 2));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Stats"));
        playerWinsLabel = new JLabel("Player Wins:");
        computerWinsLabel = new JLabel("Computer Wins:");
        tiesLabel = new JLabel("Ties:");
        statsPanel.add(playerWinsLabel);
        statsPanel.add(new JTextField("0"));
        statsPanel.add(computerWinsLabel);
        statsPanel.add(new JTextField("0"));
        statsPanel.add(tiesLabel);
        statsPanel.add(new JTextField("0"));

        // Results panel
        resultsTextArea = new JTextArea(10, 30);
        resultsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);

        // Adding components to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.EAST);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitButton) {
            System.exit(0);
        } else {
            String playerChoice = e.getActionCommand();
            gameRunner.playRound(playerChoice);
        }
    }

    public void updateStats(int playerWins, int computerWins, int ties) {
        playerWinsLabel.setText("Player Wins: " + playerWins);
        computerWinsLabel.setText("Computer Wins: " + computerWins);
        tiesLabel.setText("Ties: " + ties);
    }

    public void updateResults(String result) {
        resultsTextArea.append(result + "\n");
    }

    private JPanel createButtonPanel(JButton button) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
        panel.add(new JLabel(button.getText()), BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissorsFrame::new);
    }
}
