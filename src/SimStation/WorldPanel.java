package SimStation;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import mvc.*;


import javax.swing.*;
import java.awt.*;
import java.util.*;

public class WorldPanel extends AppPanel {


    //private Timer timer;
    public JPanel threadPanel = new JPanel();

    public WorldPanel(WorldFactory factory) {

        super(factory);
        controlPanel.setBackground(Color.pink);

        threadPanel.setLayout(new GridLayout(1, 5));
        threadPanel.setOpaque(false);


        JPanel p = new JPanel();
        p.setOpaque(false);
        JButton button = new JButton("Start");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Pause");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Resume");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stop");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stats");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        controlPanel.setLayout(new BorderLayout());

        p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);


        //controlPanel.add(threadPanel, BorderLayout.NORTH);
        controlPanel.add(p,  BorderLayout.NORTH);
        //makeControlPanel();
        this.setPreferredSize(this.getPreferredSize());
        //frame.setSize(frame.getPreferredSize());
    }



    public void setModel(Model m) {
        super.setModel(m);
        World w = (World)m;
        Iterator<Agent> it = w.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
    }

    //protected View getView(Model model) { return new SimulationView(model); }

    public void update() {
        // repaint();
    }


}

