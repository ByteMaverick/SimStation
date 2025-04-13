package SimStation;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import mvc.Model;
import mvc.View;

import java.awt.*;

public class WorldView extends View {
    public WorldView(Model model) {
        super(model);
        setBackground(Color.blue);
    }


    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        // Cast the model to World to access agents
        World world = (World) model;

        // Loop over each agent and draw them
        for (Agent a : world.getAgents()) {
            drawAgent(a, gc);
        }
        System.out.println("Agent count: " + world.getAgents().size());

    }

    // Default drawing method (can be overridden in future)
    protected void drawAgent(Agent a, Graphics gc) {
        int size = 10;
        int x = a.getXc();
        int y = a.getYc();

        gc.setColor(Color.RED);
        gc.fillOval(x, y, size, size);
        System.out.println("Drawing agent at: " + a.getXc() + ", " + a.getYc());

    }
}
