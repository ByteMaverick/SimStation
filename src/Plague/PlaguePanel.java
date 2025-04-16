package Plague;

/*
Edits:
Mohammed Ansari: 4/11 created file, copied from assignment description
 */

import SimStation.WorldFactory;
import SimStation.WorldPanel;
import mvc.AppPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlaguePanel extends WorldPanel  implements ChangeListener {

    private JPanel sliderPanel;
    private static JSlider initialInfectedSlider;
    private static JSlider infectionProbabiltySlider;
    private static JSlider InitialPopulationSlider;
    private static JSlider fatalitySlider;

    public PlaguePanel(WorldFactory factory) {
        super(factory);

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(0, 1, 10, 10)); // spacing between rows
        sliderPanel.setOpaque(false);
        sliderPanel.setBorder(BorderFactory.createTitledBorder("Plague Parameters"));


        // Create all sliders using helper
        initialInfectedSlider = createSlider( 0, 100, 10,10);
        infectionProbabiltySlider = createSlider( 0, 100, 50,10);
        InitialPopulationSlider = createSlider( 0, 200, 45,20);
        fatalitySlider = createSlider( 0, 500, 200,50);

        // Add them to actionlisener
        initialInfectedSlider.addChangeListener(this);
        infectionProbabiltySlider.addChangeListener(this);
        InitialPopulationSlider.addChangeListener(this);
        fatalitySlider.addChangeListener(this);


        // Fatal Button





        // Add them to panel
        sliderPanel.add(makeLabeledSlider("Initial (%) Infectioned", initialInfectedSlider));
        sliderPanel.add(makeLabeledSlider("Infection Probability", infectionProbabiltySlider));
        sliderPanel.add(makeLabeledSlider("Initial Population Size", InitialPopulationSlider));
        sliderPanel.add(makeLabeledSlider("Fatality/Recovery Time", fatalitySlider));


        // Add the whole slider panel to control panel
        controlPanel.add(sliderPanel, BorderLayout.CENTER);

    }



    private JSlider createSlider(int min, int max, int initial, int tickSpacing) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, initial);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(tickSpacing);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 12));
        return slider;
    }

    private JPanel makeLabeledSlider(String labelText, JSlider slider) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("MV Boli", Font.BOLD, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.NORTH);
        panel.add(slider, BorderLayout.CENTER);
        return panel;
    }

    public static void main(String[] args) {
        WorldFactory factory = new PlagueFactory();
        AppPanel panel = new PlaguePanel(factory);
        panel.display();
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == initialInfectedSlider) {
           PlagueStation.setInitialInfected(initialInfectedSlider.getValue());
           // System.out.println("initialInfectedSlider: " +initialInfectedSlider.getValue());
        }
        if (e.getSource() == infectionProbabiltySlider) {
            PlagueStation.setVirulence(infectionProbabiltySlider.getValue());
           // System.out.println("infectionProbabiltySlider: " +infectionProbabiltySlider.getValue());
        }
        if (e.getSource() == InitialPopulationSlider) {
            PlagueStation.setPopulationSize(InitialPopulationSlider.getValue());
          //  System.out.println("InitialPopulationSlider: " +InitialPopulationSlider.getValue());

        }
        if (e.getSource() == fatalitySlider) {
          PlagueStation.setInfectionLength(fatalitySlider.getValue());
          //  System.out.println("fatalitySlider: " +fatalitySlider.getValue());
        }




        model.changed();
    }


}
