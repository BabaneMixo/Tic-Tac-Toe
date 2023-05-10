package za.co.chauke.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    public TicTacToe() throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 225, 0));
        textField.setFont(new Font("Ink Free", Font.ITALIC, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        textField.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        title_panel.add(textField);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }


    public void firstTurn() throws InterruptedException {
        Thread.sleep(2000);
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }

    }

    public void check() {
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")

        ) {

            xWins(0, 1, 2);

        }

        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") && (buttons[5].getText() == "X")

        ) {

            xWins(3, 4, 5);

        }

        if (
                (buttons[6].getText() == "X") && (buttons[7].getText() == "X") &&
                        (buttons[8].getText() == "X")

        ) {

            xWins(6, 7, 8);

        }

        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")

        ) {

            xWins(0, 3, 6);

        }

        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")

        ) {

            xWins(1, 4, 7);

        }

        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")

        ) {

            xWins(2, 5, 8);

        }

        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")

        ) {

            xWins(0, 4, 8);

        }

        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")

        ) {

            xWins(2, 4, 6);

        }

        //check O win conditions

        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")

        ) {

            oWins(0, 1, 2);

        }

        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")

        ) {

            oWins(3, 4, 5);

        }

        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")

        ) {

            oWins(6, 7, 8);

        }

        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")

        ) {

            oWins(0, 3, 6);

        }

        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")

        ) {

            oWins(1, 4, 7);

        }

        if ((buttons[2].getText() == "O") &&
                        (buttons[5].getText() == "O") &&
                        (buttons[8].getText() == "O")

        ) {
            oWins(2, 5, 8);

        }

        if ((buttons[0].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[8].getText() == "O")

        ) {oWins(0, 4, 8);

        }

        if ((buttons[2].getText() == "O") &&
                        (buttons[4].getText() == "O") &&
                        (buttons[6].getText() == "O")

        ) {

            oWins(2, 4, 6);

        }

    }

    /**
     * This method changes the display of the frame when player X wins the game
     * @param a this if the first button
     * @param b this if the second button
     * @param c this is the third button*/
    public void xWins(int a,int b,int c) {
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins");

    }
    /**
     * This method changes the display of the frame when player X wins the game
     * @param a this if the first button
     * @param b this if the second button
     * @param c this is the third button*/
    public void oWins(int a,int b, int c){
        buttons[a].setBackground(Color.BLUE);
        buttons[b].setBackground(Color.BLUE);
        buttons[c].setBackground(Color.BLUE);

        for(int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins");

    }

    @Override

    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {
            if(e.getSource()==buttons[i]) {
                if(player1_turn) {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(106, 255,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textField.setText("O turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="") {
                        buttons[i].setForeground(new Color(149, 53, 197));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textField.setText("X turn");
                        check();

                    }

                }

            }
        }
    }
}
