package test.ex03;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
	private Player player;

    public BubbleFrame() {
        initObject();       // 오브젝트 호출
        initSetting();      // 세팅값 호출
        initListener();     // 리스너 호출

        setVisible(true);
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
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                // 방향키 오른쪽 눌렀을때
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.right();
                }
                
                // 방향키 왼쪽 눌렀을때
                else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.left();
                }

                // 방향키 위쪽 눌렀을때
                else if(e.getKeyCode() == KeyEvent.VK_UP) {
                    player.up();
                }

                else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    player.down();
                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();    
    }

}
