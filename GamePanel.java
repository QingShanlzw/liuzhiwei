package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener , ActionListener {
    int length;
    int[] snakeX =new int[600];
    int[] snakeY =new int[600];
    String fx ;
    int foodx;
    int foody;
    Random random=new Random();
    boolean isstrart=false;
    Timer timer =new Timer(100,this);
    public GamePanel(){
        init();
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }
    public void init(){
        length =3;
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        fx="R";
        foodx=25+25*random.nextInt(34);
        foody=75+25*random.nextInt(24);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //绘制静态面板
        this.setBackground(Color.black);
        Data.header.paintIcon(this,g,25,11);
        g.fillRect(25,75,850,600);
        if(fx.equals("R")) {
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("L"))
        {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("U"))
        {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if(fx.equals("D"))
        {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i=0;i<length;i++){

            Data.body .paintIcon(this,g,snakeX[i],snakeY[i]);

        }
        Data.food.paintIcon(this,g,foodx,foody);
        if(isstrart==false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("开始游戏",300,400);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Keycode = e.getKeyCode();
        if (Keycode == KeyEvent.VK_SPACE) {
            isstrart = !isstrart;
            repaint();
        }
        if (Keycode == KeyEvent.VK_UP) {

            fx = "U";

        } else if (Keycode == KeyEvent.VK_DOWN) {
            fx = "D";

        } else if (Keycode == KeyEvent.VK_RIGHT) {
            fx = "R";

        } else if (Keycode == KeyEvent.VK_LEFT) {
            fx = "L";

        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(isstrart){
            if(snakeX[0]==foodx&&snakeY[0]==foody){
                length++;
                foodx=25+25*random.nextInt(34);
                foody=75+25*random.nextInt(24);
            }
            for(int i =length-1;i>0;i--){
                snakeX[i]= snakeX[i-1];
                snakeY[i]= snakeY[i-1];
            }
            if(fx.equals("R")){snakeX[0]=snakeX[0]+25;
                if(snakeX[0]>850){
                    snakeX[0]=25;}}
            else if(fx.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25){
                    snakeX[0]=850;}
            }
            else if(fx.equals("U")){
                snakeY[0]=snakeY[0]-25;
                if(snakeY[0]<75){
                    snakeY[0]=650;}
            }
            else if(fx.equals("D")){
                snakeY[0]=snakeY[0]+25;
                if(snakeY[0]>650){
                    snakeY[0]=75;}
            }

            repaint();
        }timer.start();


    }
}
