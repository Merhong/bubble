package test.ex08;

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
         // 색상 확인을 통해서 동작
         Color leftColor = new Color(image.getRGB(player.getX() - 5, player.getY() + 25));
         Color rightColor = new Color(image.getRGB(player.getX() + 65, player.getY() + 25));
         
         // 바닥 계산용 컬러 (왼쪽 아래 & 오른쪽 아래 양쪽을 계산한다.)
         int bottomColor = image.getRGB(player.getX() + 10, player.getY() + 50 + 5) // -1
                    + image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5); // -1
            System.out.println(image.getRGB(player.getX() + 10, player.getY() + 50 + 5));

        // bottomColor 가 -2이면 바닥에 충돌함
        if (bottomColor != -2) {
            player.setDown(false);
        } 
        // if 바닥이 흰색이면 떨어짐
        else if (bottomColor == -1) {
             player.down();
        }
        // if 바닥이 없고 점프하지 않으며 떨어지지 않는 중일때 작동
        else if(!player.isBottomCrash() && !player.isUp() && !player.isDown()) {
            player.down();
        }

         
        //  System.out.println("leftColor : "+leftColor);
        //  System.out.println("rightColor : "+rightColor);

        /* 벽 충돌 */
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
