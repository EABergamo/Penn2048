import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameLogic extends JPanel {
    Board board;
    LinkedList<Block[][]> movementHistory;
    JLabel moves;
    int moveCount;

    public GameLogic(JLabel moves) {
        this.moves = moves;
        board = new Board();
        movementHistory = new LinkedList<Block[][]>();
        setFocusable(true);
        moveCount = 0;

        // Listener: acts according to which key is pressed.
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (board.isMovementValid("left")) {
                        movementHistory.addLast(board.getBoard());
                        board.leftShift();
                        board.insertNewBlock();
                        moveCount++;
                        moves.setText("Moves:" + Integer.toString(moveCount));
                    }

                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (board.isMovementValid("right")) {
                        movementHistory.addLast(board.getBoard());
                        board.rightShift();
                        board.insertNewBlock();
                        moveCount++;
                        moves.setText("Moves:" + Integer.toString(moveCount));
                    }
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (board.isMovementValid("down")) {
                        movementHistory.addLast(board.getBoard());
                        board.downShift();
                        board.insertNewBlock();
                        moveCount++;
                        moves.setText("Moves:" + Integer.toString(moveCount));
                    }
                    repaint();
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (board.isMovementValid("up")) {
                        movementHistory.addLast(board.getBoard());
                        board.upShift();
                        board.insertNewBlock();
                        moveCount++;
                        moves.setText("Moves:" + Integer.toString(moveCount));
                    }
                }
                if (isOver()) {
                    moves.setForeground(Color.RED);
                    moves.setText("Game over!");
                }



                if (board.hasWon()) {
                    moves.setForeground(Color.BLUE);
                    moves.setText("Victory!");
                }
                repaint();

            }
        });
    };

    /**
     * Checks if the losing conditions have been met
     * @return whether the game is over or not
     */
    public boolean isOver() {
        return !board.mergePossible() && !board.emptyPositionExists();
    }

    /**
     * Resets the game, clears the movement history.
     */
    public void reset() {
        board.reset();
        moves.setForeground(Color.BLACK);
        movementHistory.clear();
        moveCount = 0;
        moves.setText("Moves:" + Integer.toString(moveCount));
        requestFocusInWindow();
        repaint();
    }


    /**
     * Undoes latest move by the player
     */
    public void undo() {
        if (movementHistory.size() != 0) {
            board.setBoard(movementHistory.removeLast());
            repaint();
            if (moveCount > 0) {
                moveCount--;
            }
            moves.setForeground(Color.BLACK);
            moves.setText("Moves:" + Integer.toString(moveCount));
        }
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(750, 580);
    }

}
