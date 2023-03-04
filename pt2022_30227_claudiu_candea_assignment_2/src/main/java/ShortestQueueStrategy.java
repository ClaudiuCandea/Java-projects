import java.util.ArrayList;

public class ShortestQueueStrategy implements Strategy{
    @Override
    public synchronized int addTask(ArrayList<Server> servers, Task t) {
        int shortestQueue=0;
        int shortestQueueSize=servers.get(0).getTasks().size();
        int returnValue=0;
        for(int i=1;i<servers.size();i++){
            if(servers.get(i).getTasks().size()<shortestQueueSize){
                shortestQueue=i;
            }
        }
        returnValue+=servers.get(shortestQueue).getWaitingPeriod();
        servers.get(shortestQueue).addTask(t);
        return returnValue;
    }
}
