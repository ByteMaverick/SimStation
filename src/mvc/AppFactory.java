package mvc;
/*
Edits:
Mohammed Ansari: 4/10 created file, using code from minefield assignment
 */

public interface AppFactory {
    public Model makeModel();

    public  View makeView(Model m);

    public String getTitle();

    public String[] getHelp() ;

    public String about();

    public String[] getEditCommands();

    public Command makeEditCommand(Model model, String type,Object source);
}
