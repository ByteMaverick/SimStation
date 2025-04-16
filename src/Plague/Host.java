package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
Updated: 4/16 - added infection spread, movement, and fatality/recovery logic
*/
import SimStation.*;
import mvc.Utilities;

public class Host extends MobileAgent {

    private boolean infected = false;
    private int timeInfected = -1;

    public Host(String name) {
        super(name);
    }

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean status) {
        infected = status;
    }

    public void setTimeInfected(int time) {
        timeInfected = time;
    }

    public void infect() {
        if (!infected) {
            int chance = Utilities.rng.nextInt(100);
            if (chance < PlagueStation.VIRULENCE) {
                infected = true;
                timeInfected = world.getClock();
            }
        }
    }

    @Override
    public void update() {
        //  Try to infect a neighbor
        if (infected) {
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor instanceof Host) {
                ((Host) neighbor).infect();
            }

            // Check infection duration
            int duration = world.getClock() - timeInfected;
            if (duration >= PlagueStation.INFECTION_LENGTH) {
                if (PlagueStation.fatal) {
                    stop(); // Host dies
                    return;
                } else {
                    infected = false;
                    timeInfected = -1;
                }
            }
        }


        turn(Heading.random());
        move(1);
    }
}
