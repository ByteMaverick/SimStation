package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
Updated: 4/16 - improved status display, fixed comments, method naming consistency
*/
import SimStation.*;
import mvc.*;

public class PlagueStation extends World {

    public static int VIRULENCE = 50; // % chance of infection
    public static int population_Size = 40;
    public static int initialInfected = 10;
    public static int INFECTION_LENGTH = 200;
    public static boolean fatal = true;

    // Setter for initial infected agents as percentage
    public static void setInitialInfected(int percent) {
        PlagueStation.initialInfected = (int)((percent / 100.0) * population_Size);
    }

    public static void setPopulationSize(int value) {
        PlagueStation.population_Size = value;
    }

    public static void setVirulence(int virulence) {
        PlagueStation.VIRULENCE = virulence;
    }

    public static void setInfectionLength(int value) {
        PlagueStation.INFECTION_LENGTH = value;
    }

    public static void setFatal(boolean isFatal) {
        PlagueStation.fatal = isFatal;
    }

    @Override
    public void populate() {
        for (int i = 0; i < population_Size; i++) {
            Host h = new Host("Host-" + i);

            // Infect initial subset of agents
            if (i < initialInfected) {
                h.setInfected(true);
                h.setTimeInfected(getClock());
            }

            h.setXc(Utilities.rng.nextInt(World.SIZE));
            h.setYc(Utilities.rng.nextInt(World.SIZE));

            addAgent(h);
        }

        addAgent(new ObserverAgent());
    }

    @Override
    public String getStatus() {
        long infectedCount = agents.stream().filter(a -> a instanceof Host && ((Host) a).isInfected()).count();

        double infectedPercent = ((double) infectedCount / population_Size) * 100.0;
        double roundedPercent = Math.round(infectedPercent);

        String status = "Clock: " + clock +
                "\nAgents: " + agents.size() +
                "\nInfected (%): " + roundedPercent;
        return status;
    }

}
