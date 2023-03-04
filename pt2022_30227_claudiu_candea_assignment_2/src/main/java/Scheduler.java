import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Server> servers;
    private int maxNoServers;
    private int maxTaskPerServer;
    private ArrayList<Thread> threads;
    private Strategy strategy;

    public Scheduler(int nrServers, int nrTasks){
        maxNoServers=nrServers;
        maxTaskPerServer=nrTasks;
        servers = new ArrayList<Server>();
        threads = new ArrayList<Thread>();
        for(int i=0;i<nrServers;i++){
            Server server = new Server(nrTasks);
            servers.add(server);
            Thread thread = new Thread(server);
            threads.add(thread);
            thread.start();
        }
    }

    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            strategy = new ShortestQueueStrategy();
        }
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new TimeStrategy();
        }
    }


    public int dispatchTask(Task t){
       return strategy.addTask(servers,t);
    }

    public int getMaxNoServers() {
        return maxNoServers;
    }

    public void setMaxNoServers(int nrServers){
        this.maxNoServers=nrServers;
    }

    public int getMaxTaskPerServer() {
        return maxTaskPerServer;
    }

    public void setMaxTaskPerServer(int maxTaskPerServer) {
        this.maxTaskPerServer = maxTaskPerServer;
    }

    public ArrayList<Server> getServers(){
        return this.servers;
    }
    public ArrayList<Thread> getThreads(){
        return this.threads;
    }
}
