package prisonersdilemma;

public class TitForTat implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        if (lastOpponentMove == null)
            return true;
        return lastOpponentMove;
    }
}