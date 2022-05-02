package dk.sdu.mmmi.cbse.common.data;

import dk.sdu.mmmi.cbse.common.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameData {
    private final GameKeys keys = new GameKeys();
    private float delta;
    private int displayWidth;
    private int displayHeight;
    private List<Event> events = new CopyOnWriteArrayList<>();

    public void addEvent(Event e) {
        events.add(e);
    }

    public void removeEvent(Event e) {
        events.remove(e);
    }

    public List<Event> getEvents() {
        return events;
    }

    public GameKeys getKeys() {
        return keys;
    }

    public float getDelta() {
        return delta;
    }

    public void setDelta(float delta) {
        this.delta = delta;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public <E extends Event> List<Event> getEvents(Class<E> type, String sourceID) {
        ArrayList r = new ArrayList();
        for (Event event : events) {
            if (event.getClass().equals(type) && event.getSource().getID().equals(sourceID)) {
                r.add(event);
            }
        }
        return r;
    }
}
