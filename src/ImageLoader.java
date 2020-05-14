

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    public static final String IMG_FILE0 = "files/0.jpg";
    public static final String IMG_FILE2 = "files/2.jpg";
    public static final String IMG_FILE4 = "files/4.jpg";
    public static final String IMG_FILE8 = "files/8.jpg";
    public static final String IMG_FILE16 = "files/16.jpg";
    public static final String IMG_FILE32 = "files/32.jpg";
    public static final String IMG_FILE64 = "files/64.jpg";
    public static final String IMG_FILE128 = "files/128.jpg";
    public static final String IMG_FILE256 = "files/256.jpg";
    public static final String IMG_FILE512 = "files/512.jpg";
    public static final String IMG_FILE1024 = "files/1024.jpg";
    public static final String IMG_FILE2048 = "files/2048.jpg";

    static BufferedImage img2;
    static BufferedImage img4;
    static BufferedImage img8;
    static BufferedImage img16;
    static BufferedImage img32;
    static BufferedImage img64;
    static BufferedImage img128;
    static BufferedImage img256;
    static BufferedImage img512;
    static BufferedImage img1024;
    static BufferedImage img2048;

    public ImageLoader() {
        try {
            if (img2 == null) {
                img2 = ImageIO.read(new File(IMG_FILE2));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }

        try {
            if (img4 == null) {
                img4 = ImageIO.read(new File(IMG_FILE4));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img8 == null) {
                img8 = ImageIO.read(new File(IMG_FILE8));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img16 == null) {
                img16 = ImageIO.read(new File(IMG_FILE16));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img32 == null) {
                img32 = ImageIO.read(new File(IMG_FILE32));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img64 == null) {
                img64 = ImageIO.read(new File(IMG_FILE64));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img128 == null) {
                img128 = ImageIO.read(new File(IMG_FILE128));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img256 == null) {
                img256 = ImageIO.read(new File(IMG_FILE256));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img512 == null) {
                img512 = ImageIO.read(new File(IMG_FILE512));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img256 == null) {
                img256 = ImageIO.read(new File(IMG_FILE256));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img1024 == null) {
                img1024 = ImageIO.read(new File(IMG_FILE1024));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        }
        try {
            if (img2048 == null) {
                img2048 = ImageIO.read(new File(IMG_FILE2048));
            }
        } catch (IOException e) {
            System.out.println("Internal Error:" + e.getMessage());
        } 

    }

}
