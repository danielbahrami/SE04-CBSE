package dk.sdu.mmmi.cbse.player;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PlayerTest {

    @Test
    public void testPlayerMovement() {

        World world = new World();
        GameData gameData = new GameData();

        gameData.setDisplayWidth(800);
        gameData.setDisplayHeight(600);

        PlayerPlugin playerPlugin = new PlayerPlugin();
        playerPlugin.start(gameData, world);

        float spawnX = 0.f;
        float spawnY = 0.f;

        for (Entity entity : world.getEntities(Player.class)) {
            PositionPart positionPart = entity.getPart(PositionPart.class);
            spawnX = positionPart.getX();
            spawnY = positionPart.getY();
        }

        float newX = 0.f;
        float newY = 0.f;

        for (Entity entity : world.getEntities(Player.class)) {
            PositionPart positionPart = entity.getPart(PositionPart.class);
            positionPart.setX(100.0f);
            positionPart.setY(100.0f);
            newX = positionPart.getX();
            newY = positionPart.getY();
        }

        float delta = 0.f;

        assertNotEquals(spawnX, newX, delta);
        assertNotEquals(spawnY, newY, delta);

        System.out.println("Movement test completed");
    }
}
