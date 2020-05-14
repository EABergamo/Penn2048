import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;


class BoardTest {

    Board board = new Board();
    Board shiftedBoard = new Board();

    Block[][] noNeighbors = {{new Block(0),new Block(2),new Block(0),new Block(2)},
        {new Block(2),new Block(0),new Block(2),new Block(0)}, 
        {new Block(0),new Block(2),new Block(0),new Block(2)}, 
        {new Block(2),new Block(0),new Block(2),new Block(0)}};

    Block[][] losingBoard = {{new Block(4),new Block(2),new Block(4),new Block(2)},
        {new Block(2),new Block(4),new Block(2),new Block(4)},
        {new Block(4),new Block(2),new Block(4),new Block(2)},
        {new Block(2),new Block(4),new Block(2),new Block(4)}};

    Block[][] possibleBoard = {{new Block(2),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)}};

    Block[][] winBoard = {{new Block(2048),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)},
        {new Block(2),new Block(0),new Block(2),new Block(0)}};

    Block[][] simpleBoard = {{new Block(0),new Block(0),new Block(0),new Block(0)},
        {new Block(0),new Block(2),new Block(0),new Block(0)},
        {new Block(0),new Block(0),new Block(0),new Block(0)},
        {new Block(0),new Block(0),new Block(0),new Block(0)}};

    Block[][] fullBoard = {{new Block(2),new Block(2),new Block(2),new Block(2)},
        {new Block(2),new Block(2),new Block(2),new Block(2)},
        {new Block(2),new Block(2),new Block(2),new Block(2)},
        {new Block(2),new Block(2),new Block(2),new Block(2)}};

    @Test
    public void mergeIsPossibleTest() {
        board.setBoard(possibleBoard);
        assertTrue(board.mergePossible());
    }

    @Test
    public void mergeImpossibleTest() {
        board.setBoard(noNeighbors);
        assertFalse(board.mergePossible());
    }

    @Test
    public void shiftLeftTest() {
        Block[][] shiftedBoardArray = {{new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(2),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)}};

        board.setBoard(simpleBoard);
        board.leftShift();
        shiftedBoard.setBoard(shiftedBoardArray);

        assertEquals(shiftedBoard, board);
    }

    @Test
    public void shiftRightTest() {
        Block[][] shiftedBoardArray = {{new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(2)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)}};

        board.setBoard(simpleBoard);
        board.rightShift();
        shiftedBoard.setBoard(shiftedBoardArray);

        assertEquals(shiftedBoard, board);
    }

    @Test
    public void shiftUpTest() {
        Block[][] shiftedBoardArray = {{new Block(0),new Block(2),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)}};

        board.setBoard(simpleBoard);
        board.upShift();
        shiftedBoard.setBoard(shiftedBoardArray);

        assertEquals(shiftedBoard, board);
    }

    @Test
    public void shiftDownTest() {
        Block[][] shiftedBoardArray = {{new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(0),new Block(0),new Block(0)},
            {new Block(0),new Block(2),new Block(0),new Block(0)}};

        board.setBoard(simpleBoard);
        board.downShift();
        shiftedBoard.setBoard(shiftedBoardArray);

        assertEquals(shiftedBoard, board);
    }

    @Test
    public void fullBoardReturnsFalse() {
        board.setBoard(fullBoard);

        assertFalse(board.emptyPositionExists());
    }

    @Test
    public void availablePositionBoardReturnsTrue() {
        board.setBoard(simpleBoard);

        assertTrue(board.emptyPositionExists());
    }

    @Test
    public void insertBlockInsertsInEmptySpace() {
        board.setBoard(simpleBoard);
        board.insertNewBlock();

        assertNotEquals(simpleBoard, board);
    }

    @Test
    public void hasWonContains2048() {
        board.setBoard(winBoard);

        assertTrue(board.hasWon());
    }

    @Test
    public void hasWonDoesNotContain2048() {
        board.setBoard(simpleBoard);

        assertFalse(board.hasWon());
    }

    @Test
    public void getBoardReturnsCorrect() {
        board.setBoard(simpleBoard);
        Block[][] boardObtained = board.getBoard();

        Board generated = new Board();
        generated.setBoard(boardObtained);

        assertEquals(generated, board);
    }

    @Test
    public void isMovementValidReturnsFalse() {
        board.setBoard(losingBoard);

        assertFalse(board.isMovementValid("up"));
    }

    @Test
    public void isMovementValidReturnsTrue() {
        board.setBoard(possibleBoard);

        assertTrue(board.isMovementValid("up"));
    }

    @Test
    public void resetDefinesNewBoard() {
        Board original = new Board();  
        board.setBoard(losingBoard);
        board.setBoard(losingBoard);
        board.reset();

        assertNotEquals(board, original);
    }

}
