package prisonersdilemma;

public class AlwaysCheat implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        return false;
    }
}