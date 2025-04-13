package SimStation;

public class MobileAgent extends Agent {

    Heading heading;

    public MobileAgent(String name) {
        super(name);
        this.heading = Heading.random();
    }

    public void move(int steps) {
        switch (heading) {
            case NORTH:
                yc -= steps;
                break;
            case SOUTH:
                yc += steps;
                break;
            case EAST:
                xc += steps;
                break;
            case WEST:
                xc -= steps;
                break;
        }

        // Wraparound logic
        xc = (xc + World.SIZE) % World.SIZE;
        yc = (yc + World.SIZE) % World.SIZE;

        World.changed(); // Notify the view
    }

    public void turn(Heading dir){
        this.heading = dir;
    }


    @Override
    public void update() {

    }


}
