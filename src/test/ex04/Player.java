package test.ex04;

// import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    private int x;
	private int y;

    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;
    

	
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

        left = false;
        right = false;
        up = false;
        down = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void right() {
        System.out.println("Right 실행");
        right = true;
        
        new Thread(() -> {
            while(right) {
                setIcon(playerR);
                x = x + 4;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void left() {
        System.out.println("Left 실행");
        left = true;

        new Thread(() -> {
            while(left) {
                setIcon(playerL);
                x = x - 4;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 절대값 0,0이 왼쪽 상단임 올라가는 느낌을 주려면 y좌표 감소!!
    public void up() {
        System.out.println("Up 실행");
        up = true;

        new Thread(() -> {
            while(up) {
                y = y - 4;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 내려가는 느낌은 y좌표 증가
    public void down() {
        System.out.println("Down 실행");
        down = true;

        new Thread(() -> {
            while(down) {
                y = y + 4;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }








    ///////////////////// Getter & Setter 
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public ImageIcon getPlayerR() {
        return playerR;
    }

    public void setPlayerR(ImageIcon playerR) {
        this.playerR = playerR;
    }

    public ImageIcon getPlayerL() {
        return playerL;
    }

    public void setPlayerL(ImageIcon playerL) {
        this.playerL = playerL;
    }
}