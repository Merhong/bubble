package test.ex06_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
    //플레이어 좌표
    private int x;
    private int y;

    // 플레이어 움직임 상태
    private boolean left;
    private boolean right;    
    private boolean up;    
    private boolean down;

    // 플레이어 속도, final = static 상수
    private final int SPEED = 10;
    private final int JUMPSPEED = 10;
    private final int HEIGHT = 10;


    // 플레이어 이미지(왼쪽 오른쪽 모습)
    private ImageIcon playerL, playerR;

    // 생성자, 플레이어가 만들어지면 생성되는 것들 넣어둠.
    public Player() {
        initObject();
        initSetting();
    }

    // 객체 초기화 메소드
    private void initObject() {
        playerR = new ImageIcon("image/playerR.png");   // 오른쪽 모습 아이콘
        playerL = new ImageIcon("image/playerL.png");   // 왼쪽 모습 아이콘
    }

    // 세팅값 초기화 메소드
    private void initSetting() {
        x = 55;     // 처음 실행될때 플레이어 x좌표
        y = 535;    // 처음 실행될때 플레이어 y좌표

        // 멈춘 상태로 생성되니 다 false
        left = false;
        right = false;
        up = false;
        down = false;

        setIcon(playerR);              // 처음은 오른쪽을 보고 생성
        setSize(50, 50);  // 플레이어 캐릭터 크기
        setLocation(x, y);             // 초기 캐릭터 생성 좌표
    }

    /* 움직임 메소드  */
    // right(), 오른쪽 이동. x좌표 증가
    public void right() {
        System.out.println("right() 실행");
        right = true;                  // 움직임 상태를 true로 바꿔줌
        
        // 쓰레드 사용 Thread.start()
        new Thread(() -> {
            while(right) {          // right가 true일때 계속 반복
                setIcon(playerR);   // 아이콘이 오른쪽 모습 보이게 설정
                x = x + SPEED;      // Speed 만큼 X좌표 증가
                setLocation(x, y);  // 변경된 좌표 화면에 다시 찍어줌

                try {               // 예외처리구문
                    Thread.sleep(10);   // 딜레이 시켜줌
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }    

    // left(), 왼쪽 이동, x좌표 감소
    public void left() {
        System.out.println("left() 실행");
        left = true;                  // 움직임 상태를 true로 바꿔줌
        
        // 쓰레드 사용 Thread.start()
        new Thread(() -> {
            while(left) {           // left가 true일때 계속 반복
                setIcon(playerL);   // 아이콘이 왼쪽 모습 보이게 설정
                x = x - SPEED;      // Speed 만큼 X좌표 감소
                setLocation(x, y);  // 변경된 좌표 화면에 다시 찍어줌

                try {               // 예외처리구문
                    Thread.sleep(10);   // 딜레이 시켜줌
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // (0,0)이 왼쪽 상단, 올라가는 느낌은 y좌표를 감소시켜야함.
    // up(), 점프 메소드, y좌표 감소
    public void up() {
        System.out.println("up() 실행");
        up = true;                  // 움직임 상태를 true로 바꿔줌
        
        // 쓰레드 사용 Thread.start()
        new Thread(() -> {               // 점프는 잠시 떴다가 가라앉으므로
            for(int i=0; i<HEIGHT; i++) {// Height만큼 반복
                y = y - JUMPSPEED;       // JumpSpeed 만큼 y좌표 감소
                setLocation(x, y);       // 변경된 좌표 화면에 다시 찍어줌

                try { // 예외처리구문
                    Thread.sleep(10);   // 딜레이 시켜줌
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            up = false; // 점프가 끝나면 up을 하는게 아니니 false로 변경

            down();     // 점프하고 나서 다시 아래로 떨어지는 것 구현
            
        }).start();
    }

    // 내려가는 느낌 = y 증가
    // down(), 아래 이동 메소드, y좌표 증가
    public void down() {
        System.out.println("down() 실행");
        down = true;                    // 움직임 상태를 true로 바꿔줌
        
        // 쓰레드 사용 Thread.start()
        new Thread(() -> {               
            for(int i=0; i<HEIGHT; i++) { // Height만큼 반복
                y = y + JUMPSPEED;        // JumpSpeed 만큼 y좌표 증가
                setLocation(x, y);        // 변경된 좌표 화면에 다시 찍어줌

                try { // 예외처리구문
                    Thread.sleep(10);   // 딜레이 시켜줌
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            down = false; // 점프가 끝나면 up을 하는게 아니니 false로 변경
        }).start();
    }
    


    // Getter & Setter
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

    public int getSPEED() {
        return SPEED;
    }

    public int getJUMPSPEED() {
        return JUMPSPEED;
    }

    public ImageIcon getPlayerL() {
        return playerL;
    }

    public void setPlayerL(ImageIcon playerL) {
        this.playerL = playerL;
    }

    public ImageIcon getPlayerR() {
        return playerR;
    }

    public void setPlayerR(ImageIcon playerR) {
        this.playerR = playerR;
    }
}
