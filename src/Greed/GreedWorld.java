package Greed;

import SimStation.*;
import mvc.Utilities;
import java.util.*;

public class GreedWorld extends World {
    private Map<String, Patch> patchMap = new HashMap<>();

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
        // Update grass growth
        for (Patch p : getPatches()) {
            p.grow(GreedSimulation.GROW_BACK_RATE);
        }
    }

    @Override
    public void populate() {

    }
}