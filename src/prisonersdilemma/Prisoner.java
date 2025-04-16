package prisonersdilemma;

import mvc.Utilities;
import SimStation.MobileAgent;
import SimStation.Agent;
import SimStation.Heading;

public class Prisoner extends MobileAgent {
    private int fitness;
    private Strategy strategy;
    private Boolean lastOpponentMove;

    public Prisoner(String name, Strategy strategy) {
        super(name);
        this.strategy = strategy;
        this.fitness = 0;
        this.lastOpponentMove = null;
    }

    public int getFitness() {
        return fitness;
    }

    public void addFitness(int points) {
        fitness += points;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public Boolean getLastOpponentMove() {
        return lastOpponentMove;
    }

    public void setLastOpponentMove(Boolean move) {
        lastOpponentMove = move;
    }

    @Override
    public void update() {
        Agent partnerAgent = world.getNeighbor(this, 10);
        if (partnerAgent != null && partnerAgent instanceof Prisoner) {
            Prisoner partner = (Prisoner) partnerAgent;
            boolean myDecision = strategy.cooperate(lastOpponentMove);
            boolean partnerDecision = partner.getStrategy().cooperate(partner.getLastOpponentMove());
            this.setLastOpponentMove(partnerDecision);
            partner.setLastOpponentMove(myDecision);
            if (myDecision && partnerDecision) {
                this.addFitness(3);
                partner.addFitness(3);
            } else if (myDecision && !partnerDecision) {
                this.addFitness(0);
                partner.addFitness(5);
            } else if (!myDecision && partnerDecision) {
                this.addFitness(5);
                partner.addFitness(0);
            } else {
                this.addFitness(1);
                partner.addFitness(1);
            }
        }
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}