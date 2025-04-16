package randomWalk;
/*
Edits:
Mohammed Ansari: 4/11 copied file from Assigment description webpage,
 */

import mvc.*;
import SimStation.*;

class Drunk extends MobileAgent {

    public Drunk() {
        super("Drunk");
    }
    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }

}


class RandomWalkFactory extends WorldFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}

    @Override
    public String about() {
        return "";
    }
}

public class RandomWalkSimulation extends World {

    @Override
    public void populate() {
        for(int i = 0; i < 50; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new RandomWalkFactory());
        System.out.println("Agents added: " + ((World)((WorldPanel)panel).getModel()).getAgents().size());

        panel.display();
    }

}
