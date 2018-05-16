import javax.swing.JFrame;

public class Game{
    private static void createAndShowGUI(){
        Board board = new Board();
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}