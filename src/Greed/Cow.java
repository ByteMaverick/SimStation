package Greed;

import SimStation.*;
import mvc.Utilities;

public class Cow extends MobileAgent {
    private int energy;
    private final int greediness;
    private final int moveEnergy;

    public Cow(String name, int greediness, int moveEnergy) {
        super(name);
        this.greediness = greediness;
        this.moveEnergy = moveEnergy;
        this.energy = 50; // Start with half energy
    }

    public boolean isAlive() { return energy > 0; }

    @Override
    public void update() {
        if (!isAlive()) return;

        Patch patch = ((GreedWorld)world).getPatchAt(this.getXc(), this.getYc());

        if (patch != null) {
            int gained = patch.consume(greediness);
            energy += gained;

            if (gained < greediness && energy >= moveEnergy) {
                moveRandomly();
            }
        } else {
            moveRandomly();
        }

        energy--;
    }

    private void moveRandomly() {
        if (energy >= moveEnergy) {
            heading = Heading.random();
            move(1);
            energy -= moveEnergy;
        }
    }
}