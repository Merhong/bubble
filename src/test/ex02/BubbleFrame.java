package test.ex02;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
	private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        
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

    public static void main(String[] args) {
        new BubbleFrame();    
    }

}
