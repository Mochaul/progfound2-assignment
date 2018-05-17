import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

/**
 * Card is a class that extends {@link JButton}.
 * Card represents an individual card icon in the memory match pair game.
 * 
 * @author Nicolaus
 */
public class Card{
    private final int id;
    private final ImageIcon faceUpIcon;
    private final ImageIcon faceDownIcon;
    private JButton button;
    private boolean faceUp;
    private boolean matched;
    private boolean canClick;

    /**
     * Creates an instance of {@code Card}.
     * 
     * @param id    id to be assigned to the card
     */
    public Card(int id) throws IOException{
        this.button = new JButton("");
        this.id = id;
        this.faceUpIcon = new ImageIcon(ImageIO.read(new File("./../../../icons/" + id + ".png")));
        this.faceDownIcon = new ImageIcon(ImageIO.read(new File("./../../../icons/0.png")));
        this.faceUp = false;
        this.matched = false;
        this.canClick = true;
        this.button.setIcon(faceDownIcon);
        this.getButton().setFocusPainted(false);
    }

    public JButton getButton(){
        return this.button;
    }
    public int getId(){
        return this.id;
    }
    public boolean isFaceUp(){
        return this.faceUp;
    }
    public void setFace(boolean b){
        this.faceUp = b;
    }
    public boolean getMatched(){
        return this.matched;
    }
    public void setMatched(boolean matched){
        this.matched = matched;
    }
    public boolean getCanClick(){
        return this.canClick;
    }
    public void setCanClick(boolean canClick){
        this.canClick = canClick;
    }
    
    public void flip(){
        // flips card between showing default icon (backside of card) and content icon (front side of card)
        if(!this.isFaceUp()){
            this.setFace(true);
            this.getButton().setIcon(faceUpIcon);
        }else{
            this.setFace(false);
            this.getButton().setIcon(faceDownIcon);
        }
    }

    public void resetCard(){
        this.setFace(false);
        this.setMatched(false);
        this.getButton().setIcon(faceDownIcon);
        this.getButton().setVisible(true);
    }
}