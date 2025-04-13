package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import SimStation.*;
import mvc.Utilities;

public class Host extends MobileAgent {

    private boolean infected = false;

    public Host(String name) {
        super(name);
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean status) {
        infected = status;
    }

    @Override
    public void update() {
        // Move around randomly
        Heading randomHeading = Heading.random();
        turn(randomHeading);
        move(1);

        // Try to infect a neighbor if currently infected
        if (infected) {
            Agent neighbor = world.getNeighbor(this, 10); // search radius = 10

            if (neighbor != null && neighbor instanceof Host) {
                Host other = (Host) neighbor;

                if (!other.infected) {
                    int chance = Utilities.rng.nextInt(100);
                    if (chance < PlagueStation.VIRULENCE - PlagueStation.RESISTANCE) {
                        other.setInfected(true);
                    }
                }
            }
        }

        // Optional sleep to slow down simulation speed (not needed if Agent already sleeps)
    }
}
