package snake;

import javax.swing.*;
import java.net.URL;

public class Data {
    public static URL headerURL=Data.class.getResource("statics/header.jpg");
    public static ImageIcon  header=new ImageIcon(headerURL);
    public static URL upURL=Data.class.getResource("statics/up.jpg");
    public static URL downURL=Data.class.getResource("statics/down.jpg");
    public static URL rightURL=Data.class.getResource("statics/right.jpg");
    public static URL leftURL=Data.class.getResource("statics/left.jpg");
    public static ImageIcon  up=new ImageIcon(upURL);
    public static ImageIcon  down=new ImageIcon(downURL);
    public static ImageIcon  right=new ImageIcon(rightURL);
    public static ImageIcon  left=new ImageIcon(leftURL);
    public static URL bodyURL=Data.class.getResource("statics/body.jpg");
    public static ImageIcon  body=new ImageIcon(bodyURL);
    public static URL foodURL=Data.class.getResource("statics/food.jpg");
    public static ImageIcon  food=new ImageIcon(foodURL);
}
