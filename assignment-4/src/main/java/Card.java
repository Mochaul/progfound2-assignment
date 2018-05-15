import javax.swing.ImageIcon;
import javax.swing.JButton;

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
    
    public void flip(){
        if(!this.getFaceUp()){
            this.setFaceUp(true);
            this.setIcon(new ImageIcon(contentIconPath));
        }else{
            this.setFaceUp(false);
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