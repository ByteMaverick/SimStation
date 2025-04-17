package prisonersdilemma;
/*
Edits:
Eda Koker: 4/15 created file
 */
public class TitForTat implements Strategy {
    @Override
    public boolean cooperate(Boolean lastOpponentMove) {
        if (lastOpponentMove == null)
            return true;
        return lastOpponentMove;
    }
}