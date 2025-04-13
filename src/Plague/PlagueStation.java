package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import SimStation.*;
import mvc.*;

public class PlagueStation extends World {
    public static int VIRULENCE = 1000; // % chance of infection
    public static int RESISTANCE = 0; // % chance of resisting infection
    public static int population_Size = 500;

    @Override
    public void populate() {
        for (int i = 0; i < population_Size; i++) {
            Host h = new Host("Host-" + i);

            // Infect just one agent to start the spread
            if (i == 0) {
                h.setInfected(true);
            }

            // Set random location
            h.setXc(Utilities.rng.nextInt(World.SIZE));
            h.setYc(Utilities.rng.nextInt(World.SIZE));

            addAgent(h);
        }

        // Add the observer to track simulation stats
        addAgent(new ObserverAgent());
    }

    // Optional: override status to show infection info
    @Override
    public String getStatus() {
        long infectedCount = agents.stream()
                .filter(a -> a instanceof Host && ((Host) a).isInfected())
                .count();

        return super.getStatus() + " | Infected: " + infectedCount;
    }




}

