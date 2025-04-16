package prisonersdilemma;

import SimStation.WorldView;
import mvc.Model;
import SimStation.Agent;
import java.awt.Graphics;
import java.awt.Color;

public class PrisonerDilemmaView extends WorldView {
    public PrisonerDilemmaView(Model model) {
        super(model);
        setBackground(Color.WHITE);
    }

    @Override
    protected void drawAgent(Agent a, Graphics gc) {
        if (a instanceof Prisoner) {
            Prisoner p = (Prisoner) a;
            Color color = Color.GRAY;
            if (p.getStrategy() instanceof AlwaysCooperate) {
                color = Color.GREEN;
            } else if (p.getStrategy() instanceof AlwaysCheat) {
                color = Color.RED;
            } else if (p.getStrategy() instanceof RandomCooperate) {
                color = Color.BLUE;
            } else if (p.getStrategy() instanceof TitForTat) {
                color = Color.ORANGE;
            }
            gc.setColor(color);
            int size = 10;
            int x = a.getXc();
            int y = a.getYc();
            gc.fillOval(x, y, size, size);
        }
    }
}