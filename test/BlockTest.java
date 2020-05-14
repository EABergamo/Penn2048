import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class BlockTest {

    @Test
    public void blockConstructor() {
        int expectedValue = 4;
        Block block = new Block(4);

        assertEquals(expectedValue, block.getValue());
    }

    @Test
    public void blockSetValue() {
        int expectedValue = 4;
        Block block = new Block(2);
        block.setValue(4);

        assertEquals(expectedValue, block.getValue());
    }

    @Test
    public void blockIsFilledContainsNumber() {
        Block block = new Block(2);
        assertTrue(block.isFilled());        
    }

    @Test
    public void blockIsFilledDoesNotContainNumber() {
        Block block = new Block(0);
        assertFalse(block.isFilled());        
    }

    @Test
    public void blockMergeWithZero() {
        Block block = new Block(2);
        Block block2 = new Block(0);

        block.merge(block2);

        assertEquals(0, block.getValue());
        assertEquals(2, block2.getValue());
    }
    
    @Test
    public void blockMergeEquals() {
        Block block = new Block(2);
        Block block2 = new Block(2);

        block.merge(block2);

        assertEquals(0, block.getValue());
        assertEquals(4, block2.getValue());
    }
    
    @Test
    public void blockEquals() {
        Block block = new Block(2);
        Block block2 = new Block(2);

        assertTrue(block.equals(block2));
    }
    
    @Test
    public void blockNotEquals() {
        Block block = new Block(2);
        Block block2 = new Block(4);

        assertFalse(block.equals(block2));
    }
    
    @Test
    public void blockOtherObject() {
        Block block = new Block(2);

        assertFalse(block.equals("False"));
    }
    
    
    
    
    
    







}
