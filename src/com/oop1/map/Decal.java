package com.oop1.map;

import com.oop1.view.DecalView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


// changed enum to class
public class Decal {
   // RED_CROSS, SKULL_AND_CROSSBONES, GOLD_STAR

    //public static BufferedImage[][] SKULL_AND_CROSSBONES = load("skull.png", 16, 16);
    public static BufferedImage[][] DUCK = load("duck.gif", 16, 16);

    public static BufferedImage[][] load(String s, int w, int h) {
        BufferedImage[][] ret;
        try {
            BufferedImage decalImg = ImageIO.read(Decal.class.getResourceAsStream(s));
            int width = decalImg.getWidth() / w;
            int height = decalImg.getHeight() / h;
            ret = new BufferedImage[height][width];
            for(int i = 0; i < height; i++) {
                for(int j = 0; j < width; j++) {
                    ret[i][j] = decalImg.getSubimage(j * w, i * h, w, h);
                }
            }
            return ret;
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Problem loading decal.");
            System.exit(0);
        }
        return null;
    }

}


