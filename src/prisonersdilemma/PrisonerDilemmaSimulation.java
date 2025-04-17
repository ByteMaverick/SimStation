package prisonersdilemma;
/*
Edits:
Gonul Koker: 4/15 created file
 */
import SimStation.World;
import mvc.Utilities;
import SimStation.ObserverAgent;

public class PrisonerDilemmaSimulation extends World {
    @Override
    public void populate() {
        int agentsPerStrategy = 10;
        for (int i = 0; i < agentsPerStrategy; i++) {
            addAgent(new Prisoner("Prisoner-AC-" + i, new AlwaysCooperate()));
            addAgent(new Prisoner("Prisoner-CH-" + i, new AlwaysCheat()));
            addAgent(new Prisoner("Prisoner-RC-" + i, new RandomCooperate()));
            addAgent(new Prisoner("Prisoner-TFT-" + i, new TitForTat()));
        }
        addAgent(new ObserverAgent());
    }

    @Override
    public String getStatus() {
        int totalFitness = 0;
        int count = 0;
        for (Object agent : agents) {
            if (agent instanceof Prisoner) {
                totalFitness += ((Prisoner) agent).getFitness();
                count++;
            }
        }
        double averageFitness = count == 0 ? 0 : ((double) totalFitness / count);
        return super.getStatus() + "\nAverage Fitness: " + averageFitness;
    }
}