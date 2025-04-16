package prisonersdilemma;

import mvc.AppPanel;
import SimStation.WorldPanel;
import SimStation.WorldFactory;

public class PrisonerDilemmaSimulationRunner {
    public static void main(String[] args) {
        WorldFactory factory = new PrisonerDilemmaFactory();
        AppPanel panel = new WorldPanel(factory);
        panel.display();
    }
}