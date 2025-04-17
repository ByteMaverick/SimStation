package prisonersdilemma;
/*
Edits:
Gonul Koker: 4/15 created file
 */
public class AlwaysCooperate implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return true;
    }
}