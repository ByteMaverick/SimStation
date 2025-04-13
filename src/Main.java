package SimStation;

import java.io.Serializable;

public class Agendt implements Runnable, Serializable {

    int xc ;
    int yc;
    boolean paused = false;
    boolean stopped = false;
    String agentName;
    Thread myThread = null;



    public void start(){
        if (myThread == null){
            myThread = new Thread(this);
            myThread.start();
        }
    }

    public void stop(){
        stopped = true;
        myThread.interrupt();
    }

    public void pause(){
        paused = true;
    }

    public void resume(){
        paused = false;

    }

    @Override
    public void run() {
        try {
            while (!stopped) {
                if (paused) {
                    Thread.sleep(20);  // Wait while paused
                    continue;
                }

                update();  // Subclass behavior

                Thread.sleep(20);  // Smooth execution
            }
        } catch (InterruptedException e) {
            onInterrupted();  // Optional hook
        }

        onExit();  // Optional hook for cleanup
    }

}
