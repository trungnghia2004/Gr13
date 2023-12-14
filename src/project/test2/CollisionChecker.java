package project.test2;


import project.entity.Entity;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityTopRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityBottomRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityLeftCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityLeftCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileManager.map[entityTopRow][entityRightCol];
                tileNum2 = gp.tileManager.map[entityBottomRow][entityRightCol];
                if (gp.tileManager.tiles[tileNum1].collision ||
                        gp.tileManager.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }
}
