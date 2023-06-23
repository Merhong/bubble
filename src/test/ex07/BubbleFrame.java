package test.ex07;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
// import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {
    private JLabel backgroundMap;           // 맵의 배경
    private Player player;                  // 플레이어

    public BubbleFrame() {
        InitObject();       // 오브젝트 호출
        InitSetting();      // 세팅값 호출
        initListener();     // 리스너 호출

        setVisible(true); // 화면에 보이게 설정
    }

    /* 객체 인스턴스 초기화 메소드, new 되는것들*/
    private void InitObject() {
        backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));   // 맵 인스턴스 생성
        setContentPane(backgroundMap);       // 맵을 패널에 붙인다.
        player = new Player();               // 플레이어 인스턴스 생성
        add(player);                         // 플레이어를 패널에 붙인다.



    }

    /* 세팅값 초기화 메소드 */
    private void InitSetting() {
        setSize(1000, 640);         // 프로그램의 크기
        setLayout(null);                 // 프로그램 레이아웃 : null
        setLocationRelativeTo(null);           // JFrame 가운데 배치
        setDefaultCloseOperation(EXIT_ON_CLOSE); // x누르면 메모리에서도 제거
    }

    /* 리스너 초기화 메소드 */
    private void initListener() {
        // 키보드 리스너
        addKeyListener(new KeyAdapter() {

            // 키보드 클릭 이벤트 핸들러
            @Override
            public void keyPressed(KeyEvent e) {
                // 방향키 오른쪽 눌렀을때
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if(!player.isRight()) { // 초기값은 false, !(NOT)을 붙이니 true로 변경되면서 실행된다.
                        player.right();
                        
                    }
                }

                // 방향키 왼쪽 눌렀을때
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(!player.isLeft()) { // 초기값은 false, !(NOT)을 붙이니 true로 변경되면서 실행된다.
                        player.left();
                        
                    }
                }
                
                // 방향키 위쪽 눌렀을때
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    if(!player.isUp() && !player.isDown()) { // 위,아래 이동 상태가아닐때 작동
                        // 초기값은 false, !(NOT)을 붙이니 true로 변경되면서 실행된다.
                        player.up();
                    }
                }                
            }

            // 키를 뗐을때 이벤트 핸들러
            // 왼쪽, 오른쪽은 떼고나서 움직이면 안되므로 false로 바꿔준다.
            // 위,아래는 누를때만 작동하면 되므로 필요없다.
            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new BubbleFrame();

    }
}
