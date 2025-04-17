package Greed;

public class Patch {
    private final int x, y;
    private int energy;
    private final int maxEnergy = 100;

    public Patch(int x, int y) {
        this.x = x;
        this.y = y;
        this.energy = maxEnergy;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getEnergy() { return energy; }

    public int consume(int amount) {
        int consumed = Math.min(amount, energy);
        energy -= consumed;
        return consumed;
    }

    public void grow(int amount) {
        energy = Math.min(energy + amount, maxEnergy);
    }
}