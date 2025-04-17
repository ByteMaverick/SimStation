package SimStation;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import java.io.Serializable;

public  abstract  class Agent implements Runnable, Serializable {

    int xc ;
    int yc;
    boolean paused;
    boolean stopped;
    String agentName;
    transient Thread myThread;
    protected World world;

    public Agent(String name) {
        this.agentName = name;
        this.xc = 0;
        this.yc = 0;
        stopped = false;
        paused = false;
        myThread = null;
    }


    public synchronized void start(){
        if (myThread == null){
            myThread = new Thread(this);
            myThread.start();
        }
    }

    public synchronized void stop(){
        stopped = true;
        myThread.interrupt();
    }

    public synchronized void pause(){
        paused = true;
    }

    public synchronized void resume(){
        paused = false;
        notify();

    }

    @Override
    public void run() {
        onStart();

        try {
            while (!stopped) {
                synchronized (this) {
                    while (paused) {
                        wait();
                    }
                }

                update();
                Thread.sleep(20); // Smooth pacing
            }
        } catch (InterruptedException e) {
            onInterrupted();
        }

        onExit();
    }

    public void setXc(int xc) {
        if(xc >=0){
            this.xc = xc;
        }
    }

    public void setYc(int yc) {
        if(yc <=World.SIZE){
            this.yc = yc;
        }

    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }


    // Lifecycle hooks
    protected void onStart() {}
    protected void onInterrupted() {}
    protected void onExit() {}

    public abstract void update(); //  implemented by subclasses











}
