package dk.sdu.mmmi.cbse.enemy;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;
public class EnemyPlugin implements IGamePluginService {
    private Entity enemy;
    @Override
    public void start(GameData gameData, World world) {
        enemy = createEnemyShip(gameData, world);
        world.addEntity(enemy);
    }
    private Entity createEnemyShip(GameData gameData, World world) {
        Random random = new Random();
        float deacceleration = 10;
        float acceleration = 200;
        float maxspeed = 200;
        float rotationSpeed = 5;
        float x = random.nextFloat() * gameData.getDisplayWidth();
        float y = random.nextFloat() * gameData.getDisplayHeight();
        float radians = (float)Math.PI / 2;
        Entity enemyShip = new Enemy();
        enemyShip.add(new MovingPart(deacceleration, acceleration, maxspeed, rotationSpeed));
        enemyShip.add(new PositionPart(x, y, radians));
        enemyShip.add(new LifePart(1, 69));
        return enemyShip;
    }
    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(enemy);
    }
    @Override
    public String toString() {
        return "Enemy parts: " + enemy.getParts().toString();
    }
}
