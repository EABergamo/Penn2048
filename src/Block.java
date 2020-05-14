import java.awt.*;

public class Block {
    private int value;
    public Block(int value) {
        this.value = value;
        new ImageLoader();
    }

    /**
     * Setter for the value field
     * @param value new value of the block
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Getter for the current value of the field
     * @return current value of the field
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns state of the board (filled or not)
     * @return boolean indicating state
     */
    public boolean isFilled() {
        return value != 0;
    }

    /**
     * Merges two blocks; if block a calls this method, it becomes zero and argument has 
     * its value increased
     * @param block that will be merged
     */
    public void merge(Block block) {
        block.setValue(block.getValue() + this.value);
        this.value = 0;
    }

    public void draw(Graphics g, int yPos, int xPos) {
        if (value == 2) {
            g.drawImage(ImageLoader.img2, xPos, yPos, 100, 120, null);
        }
        if (value == 4) {
            g.drawImage(ImageLoader.img4, xPos, yPos, 100, 120, null);
        }
        if (value == 8) {
            g.drawImage(ImageLoader.img8, xPos, yPos, 100, 120, null);
        }
        if (value == 16) {
            g.drawImage(ImageLoader.img16, xPos, yPos, 100, 120, null);
        }
        if (value == 32) {
            g.drawImage(ImageLoader.img32, xPos, yPos, 100, 120, null);
        }
        if (value == 64) {
            g.drawImage(ImageLoader.img64, xPos, yPos, 100, 120, null);
        }
        if (value == 128) {
            g.drawImage(ImageLoader.img128, xPos, yPos, 100, 120, null);
        }
        if (value == 256) {
            g.drawImage(ImageLoader.img256, xPos, yPos, 100, 120, null);
        }
        if (value == 512) {
            g.drawImage(ImageLoader.img512, xPos, yPos, 100, 120, null);
        }
        if (value == 1024) {
            g.drawImage(ImageLoader.img1024, xPos, yPos, 100, 120, null);
        }
        if (value == 2048) {
            g.drawImage(ImageLoader.img2048, xPos, yPos, 100, 120, null);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Block) {
            Block block = (Block) o;
            return this.value == block.getValue();
        }
        return false;
    }



}

