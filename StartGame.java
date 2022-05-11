package snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        mainwindow mainw  = new mainwindow();

    }
}
class  mainwindow{
    mainwindow(){
        init();
    }
    public  void init(){
        JFrame frame = new JFrame();
        frame.setBounds(10,10,900,720);
        frame.add(new GamePanel());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}