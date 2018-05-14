import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JFrame{
    private final int SIZE = 6;
    private final int CARD_WIDTH = 150;
    private Card[] cards = new Card[SIZE*SIZE];
    private final String defaultIconPath = "./../../../icons/0.png";
    private Card selected1;
    private Card selected2;
    private Timer timer;
    private int turns;

    public Board(){
        turns = 0;
        selected1 = null;
        selected2 = null;

        for(int i=0; i<SIZE*SIZE; i++){
            this.cards[i] = new Card((i/2)+1, String.valueOf((i/2)+1));
            this.cards[i].setIcon(new ImageIcon(defaultIconPath));
        }

        for(Card card : cards){
            card.setIcon(new ImageIcon(defaultIconPath));
            this.add(card);
            card.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                    if(card.getCanClick()){
                        card.flip();
                        pickCard(card);
                    }
                }  
            });
        }
        this.setLayout(new GridLayout(SIZE, SIZE));
        this.setSize(CARD_WIDTH*SIZE, CARD_WIDTH*SIZE);
        
        timer = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCard();
            }
        });
        timer.setRepeats(false);
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
            for(Card card_ : cards){
                card_.setCanClick(false);
            }
            timer.start();
        }
    }

    private void checkCard(){
        turns++;
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
        for(Card card_ : cards){
            card_.setCanClick(true);
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