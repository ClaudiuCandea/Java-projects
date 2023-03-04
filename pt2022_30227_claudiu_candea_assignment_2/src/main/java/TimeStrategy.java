import java.util.ArrayList;

public class TimeStrategy implements Strategy{

    public synchronized int addTask(ArrayList<Server> servers, Task t) {
        int minServerInd=0;
        int minWatingTime;
        int returnValue=0;
        minWatingTime=servers.get(0).getWaitingPeriod();
        for(int i=1;i<servers.size();i++){
            if(servers.get(i).getWaitingPeriod()<minWatingTime){
                minServerInd=i;
            }
        }
        returnValue+=servers.get(minServerInd).getWaitingPeriod();
        servers.get(minServerInd).addTask(t);
        return returnValue;
    }

}
