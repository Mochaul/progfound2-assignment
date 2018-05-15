import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class Card extends JButton{
    private final int id;
    private final String defaultIconPath = "./../../../icons/0.png";
    private final String contentIconPath;
    private boolean faceUp;
    private boolean matched;
    private boolean canClick;

    public Card(int id){
        super("");
        this.id = id;
        this.contentIconPath = "./../../../icons/" + id + ".png";
        this.faceUp = false;
        this.matched = false;
        this.canClick = true;
        this.setFocusPainted(false);
    }

    public int getId(){
        return this.id;
    }
    public boolean getFaceUp(){
        return this.faceUp;
    }
    public void setFaceUp(boolean b){
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
    public void setIconFound(boolean b){
        this.iconFound = b;
    }
    
    public void flip(){
        if(!this.getFaceUp()){
            this.setFaceUp(true);
            try{
                this.setIcon(new ImageIcon(ImageIO.read(new File(contentIconPath))));
            }catch(IOException e){
                this.setIcon(null);
            }
        }else{
            this.setFaceUp(false);
            this.setText("");
            this.setIcon(new ImageIcon(defaultIconPath));
        }
    }

    public void resetCard(){
        this.setFaceUp(false);
        this.setMatched(false);
        this.setIcon(new ImageIcon(defaultIconPath));
        this.setVisible(true);
    }
}