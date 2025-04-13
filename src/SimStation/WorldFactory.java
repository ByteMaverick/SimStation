package SimStation;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

import javax.swing.*;

public abstract  class WorldFactory implements AppFactory {


    @Override
    public View makeView(Model m) {
        return new WorldView(m);
    }

    public String about() {
        return "";
    }


    @Override
    public String[] getHelp() {
        return new String[] {
                "Start: Begin the simulation",
                "Pause: Pause the agents",
                "Resume: Resume the paused agents",
                "Stop: Stop the simulation",
                "Stats: Show current stats"
        };
    }


    @Override
    public String[] getEditCommands() {
        return new String[]{"Start","Pause","Resume","Stop","Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if(type.equalsIgnoreCase("Start")){return  new StartCommand(model);}
        if(type.equalsIgnoreCase("Stop")){return  new StopCommand(model);}
        if(type.equalsIgnoreCase("Resume")){return  new ResumeCommand(model);}
        if(type.equalsIgnoreCase("Pause")){return  new PauseCommand(model);}
        if(type.equalsIgnoreCase("Stats")){return  new StatsCommand(model);}
        return null;
    }
}



class StartCommand extends  Command{

    public StartCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        ((World)model).startAgents();
    }
}

class StopCommand extends  Command{

    public StopCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        ((World)model).stopAgents();
    }
}

class ResumeCommand extends  Command{

    public ResumeCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        ((World)model).resumeAgents();
    }
}


class PauseCommand extends  Command{

    public PauseCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        ((World)model).pauseAgents();
    }
}


// Create a pop-up
class StatsCommand extends  Command{

    public StatsCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        String status = ((World) model).getStatus();
        JOptionPane.showMessageDialog(null, status, "Simulation Stats", JOptionPane.INFORMATION_MESSAGE);
    }
}

