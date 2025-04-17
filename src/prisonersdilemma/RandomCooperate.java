package prisonersdilemma;
/*
Edits:
Gonul Koker: 4/15 created file
 */
import mvc.Utilities;

public class RandomCooperate implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return Utilities.rng.nextBoolean();
    }
}