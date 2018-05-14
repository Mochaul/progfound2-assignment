import javax.swing.JButton;

public class Card extends JButton{
    private final int id;
    private boolean matched;
    private String content;
    private boolean canClick;

    public Card(int id, String s){
        super("");
        this.id = id;
        this.matched = false;
        this.content = s;
        this.canClick = true;
    }

    public int getId(){
        return this.id;
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
        if(this.getText().equals("")){
            this.setText(content);
        }else{
            this.setText("");
        }
    }
}