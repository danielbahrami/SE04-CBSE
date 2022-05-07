package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class SplitterPart implements EntityPart {
    boolean shouldSplit = false;

    @Override
    public void process(GameData gameData, Entity entity) {
    }

    public boolean ShouldSplit() {
        return shouldSplit;
    }

    public void setShouldSplit(boolean shouldSplit) {
        this.shouldSplit = shouldSplit;
    }
}
