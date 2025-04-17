package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import SimStation.*;
import mvc.Command;
import mvc.Model;
import mvc.View;

class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PlagueStation();
    }

    @Override
    public View makeView(Model m) {
        return new PlagueView(m);
    }

    @Override
    public String getTitle() {
        return "Plague Simulation";
    }



    @Override
    public String about() {
        return "SimStation, created by team 6: Mohammed Ansari, Mallika Natarajan, Gonul Koker";
    }


    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if(type.equalsIgnoreCase("Not Fatal")){return  new notFatalCommand(model);}

        // Fall back SimStation makeEditCommand()
        return super.makeEditCommand(model, type, source);
    }

}

class notFatalCommand extends  Command{

    public notFatalCommand(Model model){
        super(model);
    }
    @Override
    public void execute() throws Exception {
        ((PlagueStation)model).setFatal(false);
        System.out.println("Test");
    }
}






