package test.ex03_2;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    private int x;
	private int y;
	
	private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
    }

    public void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void right() {
        setIcon(playerR);
        while(true) {
        x = x + 2;
        setLocation(x, y);
        }
        

    }

    public void left() {
        setIcon(playerL);
        x = x - 2;
        setLocation(x, y);
    }

    // 절대값 0,0이 왼쪽 상단임 올라가는 느낌을 주려면 y좌표 감소!!
    public void up() {
        y = y - 2;
        setLocation(x, y);
    }

    // 내려가는 느낌은 y좌표 증가
    public void down() {
        y = y + 2;
        setLocation(x, y);
    }

}
