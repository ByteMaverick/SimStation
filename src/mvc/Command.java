package mvc;

/*Edits:

Mohammed Ansari: 4/10 created file, using code from minefield assignment
 */
public abstract class Command {
    protected Model model;

    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute() throws Exception;
}