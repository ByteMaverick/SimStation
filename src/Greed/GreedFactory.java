package Greed;

import mvc.Model;
import mvc.View;
import SimStation.WorldFactory;

public class GreedFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new GreedSimulation();
    }

    @Override
    public View makeView(Model m) {
        return new GreedView(m);
    }

    @Override
    public String getTitle() {
        return "Greed Simulation";
    }

    @Override
    public String[] getHelp() {
        return new String[] {
                "Cows (black dots) eat grass (green squares)",
                "Adjust sliders to change simulation parameters"
        };
    }

    @Override
    public String about() {
        return "Greed Simulation";
    }
}