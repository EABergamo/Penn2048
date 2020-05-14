import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Game implements Runnable {
    public void run() {   

        final JFrame frame = new JFrame("2048");
        frame.setLocation(300, 300);
        frame.setLayout(new BorderLayout());

        final JLabel status = new JLabel("Moves: 0");
        
        GameLogic gameLogic = new GameLogic(status);
        frame.add(gameLogic, BorderLayout.CENTER);


        final JPanel controlPanel = new JPanel();
        frame.add(controlPanel, BorderLayout.NORTH);

        JButton instructions = new JButton("Instructions");
        frame.add(instructions, BorderLayout.SOUTH);
        
        JLabel messageLabel = new JLabel("<html><center>Welcome to 2048."
                + "<br>In order to move the tiles, please use<br> the keyboard arrows!");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, messageLabel, "Instructions", 
                        JOptionPane.PLAIN_MESSAGE);
                gameLogic.requestFocusInWindow();
            }
        });
        

        final JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameLogic.reset();
                gameLogic.repaint();

            }
        });
        
        controlPanel.add(reset);
        controlPanel.add(status);


        final JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameLogic.undo();
                gameLogic.repaint();
            }
        });
        controlPanel.add(undo);


        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        gameLogic.reset();            
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}





