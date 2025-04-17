package Greed;

import SimStation.WorldFactory;
import SimStation.WorldPanel;
import mvc.AppPanel;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GreedPanel extends WorldPanel {
    public GreedPanel(WorldFactory factory) {
        super(factory);

        addControl("Grow Rate", GreedSimulation.GROW_BACK_RATE, 1, 20,
                e -> GreedSimulation.GROW_BACK_RATE = ((JSlider)e.getSource()).getValue());

        addControl("Greediness", GreedSimulation.COW_GREEDINESS, 1, 20,
                e -> GreedSimulation.COW_GREEDINESS = ((JSlider)e.getSource()).getValue());

        addControl("Move Cost", GreedSimulation.COW_MOVE_ENERGY, 1, 10,
                e -> GreedSimulation.COW_MOVE_ENERGY = ((JSlider)e.getSource()).getValue());
    }

    private void addControl(String label, int initial, int min, int max, ChangeListener listener) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.add(new JLabel(label + ":"));

        JSlider slider = new JSlider(min, max, initial);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.addChangeListener(listener);
        panel.add(slider);

        controlPanel.add(panel);
    }

    public static void main(String[] args) {
        WorldFactory factory = new GreedFactory();
        AppPanel panel = new GreedPanel(factory);
        panel.display();
    }
}