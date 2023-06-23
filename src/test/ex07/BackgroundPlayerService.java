package test.ex07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
    private BufferedImage image;
    private Player player;

    // 생성자
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
        // 실의 길이
        while (true) {
         // 색상 확인
         Color leftColor = new Color(image.getRGB(player.getX() - 5, player.getY() + 25));
         Color rightColor = new Color(image.getRGB(player.getX() + 65, player.getY() + 25));
        //  System.out.println("leftColor : "+leftColor);
        //  System.out.println("rightColor : "+rightColor);

         if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
            System.out.println("왼쪽 벽에 충돌함");
            player.setLeftwallCrash(true);
            player.setLeft(false);
         }
         else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
            System.out.println("오른쪽 벽에 충돌함");
            player.setRightwallCrash(true);
            player.setRight(false);
         }
         else { // 벽에 충돌하지 않을때, 상태를 false로 초기화
                player.setLeftwallCrash(false);
                player.setRightwallCrash(false);
         }

         try {
            Thread.sleep(10);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
    }

    
}
