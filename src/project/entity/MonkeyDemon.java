package project.entity;


import project.test2.GamePanel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MonkeyDemon extends Entity {
    public MonkeyDemon(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 1;
        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(new File("src/res/monster/left1.png"));
            up2 = ImageIO.read(new File("src/res/monster/left2.png"));
            down1 = ImageIO.read(new File("src/res/monster/down1.png"));
            down2 = ImageIO.read(new File("src/res/monster/down2.png"));
            left1 = ImageIO.read(new File("src/res/monster/left1.png"));
            left2 = ImageIO.read(new File("src/res/monster/left2.png"));
            right1 = ImageIO.read(new File("src/res/monster/right1.png"));
            right2 = ImageIO.read(new File("src/res/monster/right2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ArrayList<String> dir = new ArrayList<>();
    int idx = 0;


    @Override
    public void setAction() {
        if (dir.size() == 0) {
            gp.pathFinder.getPath((worldX + solidArea.x) / 48, (worldY + solidArea.y) / 48, 2, 1);
            for (int i = gp.pathFinder.path.size() - 2; i >= 0; i--) {
                dir.add(gp.pathFinder.path.get(i));
            }
        }
        if (idx < dir.size()) {
            if (actionLockCounter == 0) {
                direction = dir.get(idx++);
            }
            if (++actionLockCounter == 48) {
                actionLockCounter = 0;
            }
        } else {
            actionLockCounter++;
            if (actionLockCounter == 200) {
                Random random = new Random();
                int i = random.nextInt(200);
                if (i <= 50) {
                    direction = "up";
                } else if (i <= 100) {
                    direction = "down";
                } else if (i <= 150) {
                    direction = "left";
                } else {
                    direction = "right";
                }
                actionLockCounter = 0;
            }
        }
    }
}
