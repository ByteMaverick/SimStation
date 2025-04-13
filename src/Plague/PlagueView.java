package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import SimStation.Agent;
import SimStation.WorldView;
import mvc.Model;

import java.awt.*;

public class PlagueView extends WorldView {
    public PlagueView(Model model) {
        super(model);
        setBackground(Color.DARK_GRAY);
    }

    @Override
    protected void drawAgent(Agent a, Graphics gc) {
        int size = 10;
        int x = a.getXc();
        int y = a.getYc();

        if (a instanceof Host) {
            Host h = (Host) a;
            if (h.isInfected()) {
                gc.setColor(Color.RED);
            } else {
                gc.setColor(Color.GREEN);
            }
        } else {
            gc.setColor(Color.BLACK);
        }

        gc.fillOval(x, y, size, size);
    }



}
