package Greed;

import SimStation.*;
import mvc.Utilities;

public class GreedSimulation extends GreedWorld {
    public static int GROW_BACK_RATE = 5;
    public static int COW_GREEDINESS = 10;
    public static int COW_MOVE_ENERGY = 5;
    public static int NUM_COWS = 50;
    public static int NUM_PATCHES = 100;

    @Override
    public void populate() {
        for (int i = 0; i < NUM_PATCHES; i++) {
            int x = Utilities.rng.nextInt(SIZE);
            int y = Utilities.rng.nextInt(SIZE);
            addPatch(new Patch(x, y));
        }

        for (int i = 0; i < NUM_COWS; i++) {
            Cow c = new Cow("Cow-" + i, COW_GREEDINESS, COW_MOVE_ENERGY);
            c.setXc(Utilities.rng.nextInt(SIZE));
            c.setYc(Utilities.rng.nextInt(SIZE));
            addAgent(c);
        }

        addAgent(new ObserverAgent());
    }

    @Override
    public String getStatus() {
        long alive = agents.stream()
                .filter(a -> a instanceof Cow)
                .filter(c -> ((Cow)c).isAlive())
                .count();
        return "";
        //return String.format("Clock: %d\nAlive: %d/%d\nGrass: %d",
        //        clock, alive, NUM_COWS, getPatches().size());
    }
}