package Plague;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import SimStation.WorldFactory;
import mvc.Model;
import mvc.View;

public class PlagueFactory extends WorldFactory {
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
        return "PlagueStation";
    }

    @Override
    public String about() {
        return "";
    }

}


