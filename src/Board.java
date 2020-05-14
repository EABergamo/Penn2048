import java.awt.*;

public class Board {

    private Block[][] board;

    public Board() {
        this.board = new Block[4][4];
        fillBoard();
    }

    /**
     * Fills the board in all positions with new blocks.
     */
    public void fillBoard() {
        int blocksAdded = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (Math.random() < 0.2) {
                    board[row][col] = new Block(2);
                    blocksAdded++;
                } else {
                    board[row][col] = new Block(0);                    
                }
            }
        }
        if (blocksAdded < 2) {
            fillBoard();
        }
    }

    /**
     * Checks if there are any possible merges
     * @return boolean indicating if there are possible merges.
     */
    public boolean mergePossible() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (col + 1 < 4) { // compares element to the right
                    if (board[row][col].equals(board[row][col + 1])) {
                        return true;
                    }
                }
                if (col - 1 >= 0) { // compares element to the left
                    if (board[row][col].equals(board[row][col - 1])) {
                        return true;
                    }
                }
                if (row - 1 >= 0) { // compares element to down
                    if (board[row][col].equals(board[row - 1][col])) {
                        return true;
                    }
                } 
                if (row + 1 < 4) { // compares element up
                    if (board[row][col].equals(board[row + 1][col])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void leftShift() {
        for (int row = 0; row < 4; row++) {
            int movedBlockPosition = 0;
            for (int col = 0; col < 4; col++) {
                if (board[row][col].getValue() != 0) {
                    int analyzed = col - 1;
                    while (analyzed >= 0) {
                        if (board[row][analyzed].getValue() == 0) {
                            board[row][col].merge(board[row][analyzed]);
                            col = col - 1; // remains in the same position in keep updating it
                        } else if (board[row][analyzed].equals(board[row][col])
                                && movedBlockPosition <= analyzed) {
                            board[row][col].merge(board[row][analyzed]);
                            movedBlockPosition = analyzed + 1;
                        } else if (!board[row][analyzed].equals(board[row][col])) {
                            break;
                        }
                        analyzed = analyzed - 1; // goes back to compare
                    }
                }

            }
        }
    }

    public void rightShift() {
        for (int row = 0; row < 4; row++) {
            int movedBlockPosition = 0;
            for (int col = 3; col >= 0; col--) {
                if (board[row][col].getValue() != 0) {
                    int analyzed = col + 1;
                    while (analyzed <= 3) {
                        if (board[row][analyzed].getValue() == 0) {
                            board[row][col].merge(board[row][analyzed]);
                            col = col + 1; // remains in the same position in keep updating it
                        } else if (board[row][analyzed].equals(board[row][col])
                                && movedBlockPosition <= analyzed) {
                            board[row][col].merge(board[row][analyzed]);
                            movedBlockPosition = analyzed + 1;
                        } else if (!board[row][analyzed].equals(board[row][col])) {
                            break;
                        }
                        analyzed = analyzed + 1; // goes back to compare
                    }
                }

            }
        }
    }

    public void upShift() {
        for (int col = 0; col < 4; col++) {
            int movedBlockPosition = 0;
            for (int row = 0; row < 4; row++) {
                if (board[row][col].getValue() != 0) {
                    int analyzed = row - 1;
                    while (analyzed >= 0) {
                        if (board[analyzed][col].getValue() == 0) {
                            board[row][col].merge(board[analyzed][col]);
                            row = row - 1; // remains in the same position in keep updating it
                        } else if (board[analyzed][col].equals(board[row][col]) 
                                && movedBlockPosition <= analyzed) {
                            board[row][col].merge(board[analyzed][col]);
                            movedBlockPosition = analyzed + 1;
                        } else if (!board[analyzed][col].equals(board[row][col])) {
                            break;
                        }
                        analyzed = analyzed - 1; // goes back to compare
                    }
                }

            }
        }
    }

    public void downShift() {
        for (int col = 0; col < 4; col++) {
            int movedBlockPosition = 0;
            for (int row = 3; row >= 0; row--) {
                if (board[row][col].getValue() != 0) {
                    int analyzed = row + 1;
                    while (analyzed <= 3) {
                        if (board[analyzed][col].getValue() == 0) {
                            board[row][col].merge(board[analyzed][col]);
                            row = row + 1; // remains in the same position in keep updating it
                        } else if (board[analyzed][col].equals(board[row][col]) 
                                && movedBlockPosition <= analyzed) {
                            board[row][col].merge(board[analyzed][col]);
                            movedBlockPosition = analyzed + 1;
                        } else if (!board[analyzed][col].equals(board[row][col])) {
                            break;
                        }
                        analyzed = analyzed + 1; // goes back to compare
                    }
                }

            }
        }
    }



    /**
     * Checks if there are any free positions in the board.
     * @return boolean indicating if there are available positions in the board.
     */
    public boolean emptyPositionExists() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col].getValue() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Inserts block position in the board.
     */
    public void insertNewBlock() {
        int value;
        if (Math.random() < 0.8) {
            value = 2;
        } else {
            value = 4;
        }
        Block newBlock = new Block(value);

        int row = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);

        while (board[row][col].getValue() != 0 && emptyPositionExists()) {
            row = (int) (Math.random() * 4);
            col = (int) (Math.random() * 4);
        }

        board[row][col] = newBlock;
    }



    /**
     * Check if the user has won the game (obtained the 2048 block)
     * @return boolean indicating if the user has won the game
     */
    public boolean hasWon() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col].getValue() == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return copy of the 2D array.
     */
    public Block[][] getBoard() {
        Block[][] copy = new Block[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                copy[row][col] = new Block(board[row][col].getValue());
            }
        }
        return copy;
    }
    public void draw(Graphics g) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col].draw(g, 150 * row, 150 * col + 100);
            }
        }
    }

    /**
     * Debug method, prints current state of the board in the console.
     */
    public void drawInConsole() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(board[row][col].getValue());
                if (col == 3) {
                    System.out.println();
                }
            }
        }
    }

    /**
     * Reset the game to a new state; removes all blocks and randomly adds new ones.
     */
    public void reset() {
        fillBoard();
    }

    /**
     * Wrapper for move functions.
     * @param direction defines what shift should be done.
     */
    public void move(String direction) {
        switch (direction) {
            case "down":
                downShift();
                break;
            case "up":
                upShift();
                break;
            case "right":
                rightShift();
                break;
            case "left":
                leftShift();
                break;
            default:
                break;
        }
    }

    /**
     * Setter function for the 2D array.
     * @param newBoard
     */
    public void setBoard(Block[][] newBoard) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = newBoard[row][col];
            }
        }
    }

    /**
     * Checks if a movement is valid according to the rules of the game
     * @param direction what direction should be checked
     * @return whether the movement is valid or not 
     */
    public boolean isMovementValid(String direction) {
        Board check = new Board();
        check.setBoard(this.getBoard());
        switch (direction) {
            case "down":
                check.downShift();
                return !check.equals(this);
            case "up":
                check.upShift();
                return !check.equals(this);
            case "right":
                check.rightShift();
                return !check.equals(this);
            case "left":
                check.leftShift();
                return !check.equals(this);
            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Board) {
            Board otherBoard = (Board) o;
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    if (!otherBoard.getBoard()[row][col].equals(board[row][col])) {
                        return false;
                    }
                }

            }
            return true;
        } 
        return false;
    }
}

