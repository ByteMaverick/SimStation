package prisonersdilemma;

/*
Edits:
Eda Koker: 4/15 created file
 */
public class AlwaysCheat implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return false;
    }
}