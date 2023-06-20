package test.ex04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// main 쓰레드를 GUI 프로그램에서는 ui 쓰레드라고 부른다.
public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
	private Player player;

    public BubbleFrame() {
        initObject();       // 오브젝트 호출
        initSetting();      // 세팅값 호출
        initListener();     // 리스너 호출

        setVisible(true); // while
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initObject() {
       backgroundMap = new JLabel(new ImageIcon("image/backgroundMap.png"));
       setContentPane(backgroundMap);

       player = new Player();   
       add(player);
    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null);            // absolute 레이아웃(자유롭게 배치)
        setLocationRelativeTo(null);      // JFrame을 가운데에 배치한다.
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            // 키보드 눌렀을때 이벤트
            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyCode());

                // 방향키 오른쪽 눌렀을때
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if(!player.isRight()) { // 초기값이 false -> !이 붙어서
                        player.right();     // true가 되면서 실행됨.
                    }
                }
                
                // 방향키 왼쪽 눌렀을때
                else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if(!player.isLeft()) { // 초기값이 false -> !이 붙어서
                        player.left();     // true가 되면서 실행됨.
                    }
                }

                // 방향키 위쪽 눌렀을때
                else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    if(!player.isUp()) { // 초기값이 false -> !이 붙어서
                        player.up();     // true가 되면서 실행됨.
                    }
                }

                // 방향키 아래쪽 눌렀을때
                else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if(!player.isDown()) { // 초기값이 false -> !이 붙어서
                        player.down();     // true가 되면서 실행됨.
                    }
                }
            }
            // 키를 뗐을때 이벤트
            @Override
            public void keyReleased(KeyEvent e) {
                // 방향키 오른쪽을 뗐을때
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                }
                
                // 방향키 왼쪽을 뗐을때
                else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                }

                // 방향키 위쪽을 뗐을때
                else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    player.setUp(false);
                }

                // 방향키 아래쪽을 뗐을때
                else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.setDown(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();    
    }

}
