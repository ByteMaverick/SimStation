package prisonersdilemma;

import mvc.Utilities;

public class RandomCooperate implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return Utilities.rng.nextBoolean();
    }
}