package prisonersdilemma;


public class AlwaysCooperate implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return true;
    }
}