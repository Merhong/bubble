package test.ex05;

// import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    private int x;
	private int y;

    // 플레이어의 방향 상태(쓰레드에 활용)
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    // 플레이어 속도
    private final int SPEED = 5;        // x축
    private final int JUMPSPEED = 10;    // y축
    
    private final int HEIGHT = 50;
    
	private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();
    }

    // new가 붙는 객체들을 집어 넣어 초기화
    public void initObject() {
        playerR = new ImageIcon("image/playerR.png");
        playerL = new ImageIcon("image/playerL.png");
    }

    // new가 안붙는 값들을 집어 넣어 초기화
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

    // 오른쪽 이동 메소드, right()
    public void right() {
        System.out.println("Right 실행");
        right = true;
        
        new Thread(() -> {
            while(right) {
                setIcon(playerR);
                x = x + SPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(10); // 0.01초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 왼쪽 이동 메소드, left()
    public void left() {
        System.out.println("Left 실행");
        left = true;

        new Thread(() -> {
            while(left) {
                setIcon(playerL);
                x = x - SPEED;
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
    // 점프(위로 이동) 메소드, up()
    public void up() {
        System.out.println("Up 실행");
        up = true;
        // 좌,우 이동과는 다르게 점프는 잠시 올라갔다 내려와야함.(for문)
        new Thread(() -> {
           
            for(int i=0; i < HEIGHT; i++) {
                y = y - JUMPSPEED;
                setLocation(x, y);
                
                try {
                    Thread.sleep(10); // 0.1초 딜레이
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            up = false;

            // 점프하고 나서 다시 아래로 떨어지는 것 구현
            down();
        
        }).start();
    }

    // 내려가는 느낌은 y좌표 증가
    // 아래 이동 메소드, down()
    public void down() {
        System.out.println("Down 실행");
        down = true;

        new Thread(() -> {
            for(int i=0; i<HEIGHT; i++) {
                y = y + JUMPSPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(1); // 0.1초 딜레이
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false;
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