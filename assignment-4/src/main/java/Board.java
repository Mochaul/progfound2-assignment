import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Arrays;

/**
 * Board is a class that extends {@link JFrame}, 
 * Board represents the main container for the memory match pair game
 * 
 * @author Nicolaus
 */
public class Board{
    private final int SIZE = 6;
    private final int CARD_WIDTH = 100;
    private final int CARD_HEIGHT = 100;
    private JFrame frame;
    private Card[] cards = new Card[SIZE*SIZE];
    private Card selected1;
    private Card selected2;
    private Timer timer;
    private int turns;
    private JLabel turnsCounter;

    /**
     * Initializes the game board with 18 pairs of icon cards 
     * shuffled and displayed in 6 by 6 grid
     */
    public Board() throws IOException{
        frame = new JFrame();
        turns = 0;
        selected1 = null;
        selected2 = null;

        // fill array then shuffle
        for(int i=0; i<SIZE*SIZE; i++){
            this.cards[i] = new Card((i/2)+1);
        }
        Collections.shuffle(Arrays.asList(cards));

        // fill game board
        JPanel gameBoard = new JPanel(new GridLayout(SIZE, SIZE));
        for(Card card : cards){
            gameBoard.add(card.getButton());
            card.getButton().addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                    if(card.getCanClick()){
                        pickCard(card);
                    }
                }  
            });
        }
        gameBoard.setSize(CARD_WIDTH*SIZE, CARD_HEIGHT*SIZE);
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
                exitGame();
            }  
        });
        menu.add(playAgain);
        menu.add(exit);
        menu.add(turnsCounter);

        // initialize timer
        timer = new Timer(750, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCard();
            }
        });
        timer.setRepeats(false);

        // add components to JFrame
        this.frame.add(gameBoard, BorderLayout.CENTER);
        this.frame.add(menu, BorderLayout.SOUTH);
        this.frame.setSize(CARD_WIDTH*SIZE, CARD_HEIGHT*SIZE + 50);
        this.frame.setVisible(true);
    }
    
    public JFrame getFrame(){
        return this.frame;
    }

    private void pickCard(Card card){
        // picks the card in argument, when two is selected, start timer then do checking
        card.flip();
        if (selected1 == null){
            selected1 = card;
            selected1.setCanClick(false); // disables picked button
        }
        else{
            selected2 = card;
            selected2.setCanClick(false); // disables picked button
        }
        if (selected1 != null && selected2 != null){
            updateTurnLabel();
            this.setAllCardsCanClick(false); // disables all button while waiting for timer
            timer.start();
        }
    }

    /**
     * increments turns by 1 and updates label
     */
    private void updateTurnLabel(){
        turns++;
        turnsCounter.setText("Number of turns: " + this.turns);
    }

    private void checkCard(){
        this.setAllCardsCanClick(false);
        // checks if two selected cards has the same id
        if (selected1.getId() == selected2.getId()){
            selected1.getButton().setVisible(false);
            selected2.getButton().setVisible(false);
            selected1.setMatched(true);
            selected2.setMatched(true);
        }
        selected1.flip();
        selected2.flip();
        selected1 = null;
        selected2 = null;
        this.setAllCardsCanClick(true); // reenable all buttons
        if(isWon()){
            JOptionPane.showMessageDialog(this.frame, String.format("You won with %d turns!", turns));
            exitGame();
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
        selected1 = null;
        selected2 = null;
        for(Card card : cards){
            card.resetCard();
        }
        Collections.shuffle(Arrays.asList(cards));
    }

    private boolean isWon(){
        for (Card card : cards){
            if(card.getMatched() == false){
                return false;
            }
        }
        return true;
    }

    private void exitGame(){
        this.getFrame().dispatchEvent(new WindowEvent(this.getFrame(), WindowEvent.WINDOW_CLOSING));
    }
}