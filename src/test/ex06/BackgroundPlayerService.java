package test.ex06;

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
         Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
         Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
         System.out.println("leftColor : "+leftColor);
         System.out.println("rightColor : "+rightColor);

         if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
            System.out.println("왼쪽 벽에 충돌함");
         } else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
            System.out.println("오른쪽 벽에 충돌함");
         }

         try {
            // System.out.println("나 이제 쉴꼐");
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
    }

    
}
