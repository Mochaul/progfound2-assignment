import java.io.IOException;

import javax.swing.JFrame;

public class Game{
    private static void createAndShowGUI() throws IOException{
        Board board = new Board();
        board.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.getFrame().setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    createAndShowGUI();
                }catch (IOException e){
                    System.out.println("icons not found");
                }
            }
        });
    }
}