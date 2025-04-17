package prisonersdilemma;
/*
Edits:
Gonul Koker: 4/15 created file
 */
import mvc.Model;
import mvc.View;
import SimStation.WorldFactory;

public class PrisonerDilemmaFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PrisonerDilemmaSimulation();
    }

    @Override
    public View makeView(Model m) {
        return new PrisonerDilemmaView(m);
    }

    @Override
    public String getTitle() {
        return "Prisoners' Dilemma Tournament";
    }

    @Override
    public String about() {
        return "SimStation Prisoners Dilemma Tournament";
    }
}