package test.ex06_2;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// 메인쓰레드는 바쁨 - 키보드 이벤트를 처리하기 바쁘다.
public class BackgroundPlayerService implements Runnable {
    
    private Player player;      
    private BufferedImage image;

    // 플레이어의 상태를 알아야 하므로 
    public BackgroundPlayerService(Player player) {
        this.player = player;
        File file = new File("image/backgroundMapService.png");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // 새로운 쓰레드의 생명줄
        while(true) {
            // Color color = new Color(image.getRGB(player.getX(), player.getY()));
            Color colorLeft = new Color(image.getRGB(player.getX()-25, player.getY()));
            Color colorRight = new Color(image.getRGB(player.getX()+25, player.getY()));
            // System.out.println("보글이 위치의 빨간색상 : "+color.getRed());
            // System.out.println("보글이 위치의 초록색상 : "+color.getGreen());
            // System.out.println("보글이 위치의 파란색상 : "+color.getBlue());
            // System.out.println("보글이의 x값 : "+player.getX());


            if((colorLeft.getRed() == 255) && (colorLeft.getGreen() == 0) && (colorLeft.getBlue() == 0)) {
                // System.out.println("왼쪽 빨간색상 : "+colorLeft.getRed());
                // System.out.println("왼쪽 초록색상 : "+colorLeft.getGreen());
                // System.out.println("왼쪽 파란색상 : "+colorLeft.getBlue());
                System.out.println("왼쪽 벽에 충돌했습니다!!!");
            }

            else if((colorRight.getRed() == 255) && (colorRight.getGreen() == 0) && (colorRight.getBlue() == 0)) {
                // System.out.println("오른쪽 빨간색상 : "+colorRight.Red());
                // System.out.println("오른쪽 초록색상 : "+colorRight.getGreen());
                // System.out.println("오른쪽 파란색상 : "+colorRight.getBlue());
                // System.out.println("보글이의 x+25값: "+(player.getX()+25));
                System.out.println("오른쪽 벽에 충돌했습니다!!!");
            }

            
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
