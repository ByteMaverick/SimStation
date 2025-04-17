package Greed;

import SimStation.*;
import mvc.Model;
import java.awt.*;

public class GreedView extends WorldView {
    public GreedView(Model model) {
        super(model);
        setBackground(Color.WHITE);
    }

    @Override
    protected void drawAgent(Agent a, Graphics gc) {
        int size = 8;
        int x = a.getXc();
        int y = a.getYc();

        if (a instanceof Cow) {
            gc.setColor(((Cow)a).isAlive() ? Color.BLACK : Color.LIGHT_GRAY);
            gc.fillOval(x, y, size, size);
        }
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        GreedWorld world = (GreedWorld)model;
        for (Patch p : world.getPatches()) {
            int green = (int)(255 * (p.getEnergy() / 100.0));
            gc.setColor(new Color(0, green, 0));
            gc.fillRect(p.getX(), p.getY(), 10, 10);
        }

        //draw theagents on top
        for (Agent a : world.getAgents()) {
            drawAgent(a, gc);
        }
    }
}