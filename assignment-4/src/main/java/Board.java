import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Arrays;

public class Board extends JFrame{
    private final int SIZE = 6;
    private final int CARD_WIDTH = 100;
    private final String defaultIconPath = "./../../../icons/0.png";
    private Card[] cards = new Card[SIZE*SIZE];
    private Card selected1;
    private Card selected2;
    private Timer timer;
    private int turns;
    private JLabel turnsCounter;

    public Board(){
        turns = 0;
        selected1 = null;
        selected2 = null;

        // fill array then shuffle
        for(int i=0; i<SIZE*SIZE; i++){
            this.cards[i] = new Card((i/2)+1);
            this.cards[i].setIcon(new ImageIcon(defaultIconPath));
        }
        Collections.shuffle(Arrays.asList(cards));

        // fill game board
        JPanel gameBoard = new JPanel(new GridLayout(SIZE, SIZE));
        for(Card card : cards){
            gameBoard.add(card);
            card.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                    if(card.getCanClick()){
                        card.flip();
                        pickCard(card);
                    }
                }  
            });
        }
        gameBoard.setSize(CARD_WIDTH*SIZE, CARD_WIDTH*SIZE);
        gameBoard.setVisible(true);

        // add buttons to restart and exit
        JPanel menu = new JPanel(new FlowLayout());
        JButton playAgain = new JButton("Play Again");
        JButton exit = new JButton("Exit");
        turnsCounter = new JLabel("Number of turns: " + this.turns);
        playAgain.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                resetBoard();
            }  
        });
        exit.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                System.exit(0); // CHANGE LATER
            }  
        });
        menu.add(playAgain);
        menu.add(exit);
        menu.add(turnsCounter);

        // initialize timer
        timer = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCard();
            }
        });
        timer.setRepeats(false);

        // add components to JFrame
        this.add(gameBoard, BorderLayout.CENTER);
        this.add(menu, BorderLayout.SOUTH);
        this.setSize(800,800);
        this.setVisible(true);
    }

    private void pickCard(Card card){
        if (selected1 == null){
            selected1 = card;
            selected1.setCanClick(false);
        }
        else{
            selected2 = card;
            selected2.setCanClick(false);
        }

        if (selected1 != null && selected2 != null){
            turns++;
            turnsCounter.setText("Number of turns: " + this.turns);
            setAllCardsCanClick(false);
            timer.start();
            setAllCardsCanClick(true);
        }
    }

    private void checkCard(){
        if (selected1.getId() == selected2.getId()){
            selected1.setVisible(false);
            selected2.setVisible(false);
            selected1.setMatched(true);
            selected2.setMatched(true);
        }
        selected1.flip();
        selected2.flip();
        selected1 = null;
        selected2 = null;
        if(isWon()){
            JOptionPane.showMessageDialog(this, String.format("You won with %d turns!", turns));
            dispose();
        }
    }

    private void setAllCardsCanClick(boolean b){
        for(Card card : cards){
            card.setCanClick(b);
        }
    }

    private void resetBoard(){
        turns = 0;
        turnsCounter.setText("Number of turns: " + this.turns);
        for(Card card : cards){
            card.resetCard();
        }
    }

    private boolean isWon(){
        for (Card card : cards){
            if(card.getMatched() == false){
                return false;
            }
        }
        return true;
    }
}