package com.oop1.map;

import com.oop1.view.DecalView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


// changed enum to class
public class Decal {
   // RED_CROSS, SKULL_AND_CROSSBONES, GOLD_STAR

    private BufferedImage[][] currentDecal;
    private String currentString;

    public static BufferedImage[][] SKULL_AND_CROSSBONES = load("../resources/SKULL_AND_CROSSBONES.png", 60, 60);
    public static BufferedImage[][] DUCK = load("duck.gif", 16, 16);
    public static BufferedImage[][] RED_CROSS = load("../resources/RED_CROSS.png", 60, 60);
    public static BufferedImage[][] GOLD_STAR = load("../resources/GOLD_STAR.png", 60, 60);

    public Decal(String newDecalName){
        currentString = newDecalName;
        switch(newDecalName){
            case "SKULL_AND_CROSSBONES":
                currentDecal = SKULL_AND_CROSSBONES;
                break;
            case "DUCK":
                currentDecal = DUCK;
                break;
            case "RED_CROSS":
                currentDecal = RED_CROSS;
                break;
            case "GOLD_STAR":
                currentDecal = GOLD_STAR;
                break;
            default:
                currentDecal = DUCK;
                currentString.concat(" (INVALID NAME)");
                break;
        }
    }

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

    public String toString(){
        return currentString;
    }

    public BufferedImage[][] getImage(){
        return currentDecal;
    }

}


