package TicTacToeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

public class TicTacToe extends JFrame implements ActionListener {
    Container c = new Container();
    JLabel l;
    JButton[] buttons;
    boolean player1Turn;
    JPanel lPanel;
    JPanel bPanel;
    int chance = 9;
    int choice;


    TicTacToe() {
        setTitle("Tic Tac Toe Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 1000);
        setVisible(true);

        addContainer();
        addComponents();
        componentsWithContainer();
        playerChoose();
        winnerCheck();


    }

    void addContainer() {
        c = getContentPane();
        c.setBounds(0, 0, 1000, 1000);
        c.setBackground(new Color(50, 50, 50));

    }

    void addComponents() {

        l = new JLabel();
        l.setHorizontalAlignment(JTextField.CENTER);
        l.setForeground(Color.WHITE);
        l.setBackground(Color.BLACK);
        l.setOpaque(true);
        l.setFont(new Font("Georgia Bold", Font.ITALIC, 80));


        lPanel = new JPanel();
        lPanel.setLayout(new BorderLayout());
        lPanel.setBounds(0, 0, 1000, 400);

        bPanel = new JPanel();
        bPanel.setLayout(new GridLayout(3, 3));
        bPanel.setBackground(new Color(150, 150, 150));

        buttons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Georgia Bold", Font.ITALIC, 120));
            buttons[i].setFocusable(false);
            bPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }


    }

    void playerChoose() {

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        l.setText("Tic Tac Toe");
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        l.setText("Loading.....");
        l.setText("FUCK your bitch.....");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Random random = new Random();

        int value = random.nextInt(10);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(true);
        }

        if (value % 2 == 0) {
            player1Turn = true;
            l.setText("X - Turns");
        } else {
            player1Turn = false;
            l.setText("O - Turns");
        }

    }


    void componentsWithContainer() {
        c.add(lPanel, BorderLayout.NORTH);
        c.add(bPanel);
        lPanel.add(l);

    }

    void winnerCheck() {
        if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            player1Wins(0, 1, 2);
        } else if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            player1Wins(3, 4, 5);
        } else if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            player1Wins(6, 7, 8);
        } else if (buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            player1Wins(0, 3, 6);
        } else if (buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            player1Wins(1, 4, 7);
        } else if (buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            player1Wins(2, 5, 8);
        } else if (buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            player1Wins(0, 4, 8);
        } else if (buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            player1Wins(2, 4, 6);
        } else if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            player2Wins(0, 1, 2);
        } else if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            player2Wins(3, 4, 5);
        } else if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            player2Wins(6, 7, 8);
        } else if (buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            player2Wins(0, 3, 6);
        } else if (buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            player2Wins(1, 4, 7);
        } else if (buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
            player2Wins(2, 5, 8);
        } else if (buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            player2Wins(0, 4, 8);
        } else if (buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            player2Wins(2, 4, 6);
        } else if (chance == 0) {
            l.setText("Tied");
            updateResult("Match Tied");

        }
    }

    void player1Wins(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        l.setText("Game Done\n X is Winner!!!!");
        updateResult("X wins");

    }

    void player2Wins(int a, int b, int c) {
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        l.setText("Game Done \n O is Winner!!!!");
        updateResult("O wins");

    }


    void updateResult(String s) {
        chance = 9;
        Object option[] = {"Restart", "Exit"};


        choice = JOptionPane.showInternalOptionDialog(c, "Game Over\n  " + s, "Game results", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

        if (choice == JOptionPane.YES_OPTION) {
            dispose();
            new TicTacToe();

        } else
            System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("X");
                        buttons[i].setForeground(Color.BLUE);
                        player1Turn = false;
                        l.setText("O - Turns");
                        chance--;
                        winnerCheck();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setText("O");
                        buttons[i].setForeground(Color.RED);
                        player1Turn = true;
                        l.setText("X - Turns");
                        chance--;
                        winnerCheck();
                    }
                }
            }
        }
    }
}
