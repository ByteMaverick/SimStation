package prisonersdilemma;

/*
Edits:
Gonul Koker: 4/15 created file
 */
public class AlwaysCheat implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return false;
    }
}