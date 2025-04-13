package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file, copied form assigment description
 */
import SimStation.WorldFactory;
import SimStation.WorldPanel;
import mvc.AppFactory;
import mvc.AppPanel;
import stoplight.StoplightFactory;
import stoplight.StoplightPanel;

import javax.swing.*;
import java.awt.*;
// Currently Working on it
public class PlaguePanel extends WorldPanel {
    public PlaguePanel(WorldFactory factory) {
        super(factory);




        JLabel initialInfectedLabel = new JLabel("Initial % Infected:");

        JSlider initialInfectedSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 10);
        initialInfectedSlider.setMajorTickSpacing(10);
        initialInfectedSlider.setMinorTickSpacing(2);
        initialInfectedSlider.setPaintTicks(true);
        initialInfectedSlider.setPaintLabels(true);

        JPanel initialInfectedPanel = new JPanel();

        initialInfectedPanel.setOpaque(false);
        initialInfectedPanel.add(initialInfectedLabel);
        initialInfectedPanel.add(initialInfectedSlider);

        controlPanel.add(initialInfectedPanel);

        // ===== Infection Probability Slider =====
        JLabel infectionProbabilityLabel = new JLabel("Infection Probability:");

        JSlider infectionProbabilitySlider = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 10);
        infectionProbabilitySlider.setMajorTickSpacing(10);
        infectionProbabilitySlider.setMinorTickSpacing(2);
        infectionProbabilitySlider.setPaintTicks(true);
        infectionProbabilitySlider.setPaintLabels(true);

        JPanel infectionProbabilityPanel = new JPanel();

        infectionProbabilityPanel.setOpaque(false);
        infectionProbabilityPanel.add(infectionProbabilityLabel);
        infectionProbabilityPanel.add(infectionProbabilitySlider);

        controlPanel.add(infectionProbabilityPanel);
    }


    public static void main(String[] args) {
        WorldFactory factory = new PlagueFactory();
        AppPanel panel = new PlaguePanel(factory);
        panel.display();
    }
}
