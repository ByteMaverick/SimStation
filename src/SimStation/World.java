package SimStation;
/*
Edits:
Mohammed Ansari: 4/11 created file
 */
import mvc.*;

import java.util.*;

public abstract  class World extends Model {
    protected static final int SIZE = 500;
    int clock = 0;
    int alive = 0;
    protected ArrayList <Agent> agents = new ArrayList<>();

    public  void addAgent(Agent a){
        a.world = this;
        agents.add(a);
    }
    public  void startAgents(){
        populate();
        for (Agent agent: agents){
            agent.start();
        }
    }
    public  void stopAgents(){

        for (Agent agent: agents){
            agent.stop();
        }
    }

    public  void pauseAgents(){

        for (Agent agent: agents){
            agent.pause();
        }
    }
    public  void resumeAgents(){

        for (Agent agent: agents){
            agent.resume();
        }
    }

    public  String getStatus(){
        String status = "Clock: " + clock + "\n" + "Agents:" + agents.size();
        return  status;
    }

    public void updateStatistics(){
        alive = agents.size();
        clock++;
        changed();
    }

    public Agent getNeighbor(Agent caller, int radius) {
        int n = agents.size();
        if (n <= 1) return null;

        int start = Utilities.rng.nextInt(n);  // random starting index

        for (int i = 0; i < n; i++) {
            int index = (start + i) % n;
            Agent other = agents.get(index);

            if (other == caller) continue;

            int dx = other.xc - caller.xc;
            int dy = other.yc - caller.yc;
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance <= radius) {
                return other;
            }
        }

        return null; // No suitable neighbor found
    }


    public abstract void populate();


    public ArrayList<Agent> getAgents() {
        return  agents;
    }

    public Iterator<Agent> iterator() {
        return agents.iterator();
    }
}
