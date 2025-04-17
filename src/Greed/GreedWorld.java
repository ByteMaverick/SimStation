package Greed;

import SimStation.*;
import mvc.Utilities;
import java.util.*;

public class GreedWorld extends World {
    private Map<String, Patch> patchMap = new HashMap<>();


    @Override
    public void populate() {

        for (int i = 0; i < GreedSimulation.NUM_PATCHES; i++) {
            int x = Utilities.rng.nextInt(SIZE);
            int y = Utilities.rng.nextInt(SIZE);
            addPatch(new Patch(x, y));
        }
        for (int i = 0; i < GreedSimulation.NUM_COWS; i++) {
            Cow c = new Cow("Cow-" + i, GreedSimulation.COW_GREEDINESS, GreedSimulation.COW_MOVE_ENERGY);
            c.setXc(Utilities.rng.nextInt(SIZE));
            c.setYc(Utilities.rng.nextInt(SIZE));
            addAgent(c);
        }


        addAgent(new ObserverAgent());
    }

    public void addPatch(Patch p) {
        patchMap.put(p.getX() + "," + p.getY(), p);
    }

    public Patch getPatchAt(int x, int y) {
        return patchMap.get(x + "," + y);
    }

    public Collection<Patch> getPatches() {
        return patchMap.values();
    }

    @Override
    public void updateStatistics() {
        super.updateStatistics();

        for (Patch p : getPatches()) {
            p.grow(GreedSimulation.GROW_BACK_RATE);
        }
    }
}