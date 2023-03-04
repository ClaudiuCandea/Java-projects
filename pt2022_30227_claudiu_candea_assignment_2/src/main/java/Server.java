import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private boolean closed;
    private static int noProcessedTasks=0;
    private static double totalServiceTime=0;

    public Server(int capacity){
        this.waitingPeriod=new AtomicInteger(0);
        tasks= new ArrayBlockingQueue<Task>(capacity);
        closed=false;
    }

    public synchronized void addTask(Task newTask){
        try {
            this.tasks.put(newTask);
            waitingPeriod.addAndGet(newTask.getServiceTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void close(){
        this.closed=true;
    }

    public void run() {
        while(!closed) {
            Task currentTask = null;
            try {
                currentTask = tasks.peek();
                if (currentTask != null) {
                    totalServiceTime+= currentTask.getServiceTime();
                    noProcessedTasks++;
                    Thread.sleep(100 * (currentTask.getServiceTime()));
                    this.waitingPeriod.addAndGet(-(currentTask.getServiceTime()));
                    tasks.poll();
                    //totalWaitingTime+= this.getWaitingPeriod()+currentTask.getServiceTime();
                }
            }
            catch (Exception e) {
                System.out.println("Interrupted");
            }
        }
    }

    public int getNoProcessedTasks(){
        return noProcessedTasks;
    }

    public double getTotalServiceTime(){
        return totalServiceTime;
    }

    public synchronized int getWaitingPeriod(){
        return this.waitingPeriod.intValue();
    }


    public BlockingQueue<Task> getTasks() {
        return tasks;
    }



    public String toString(){
        String s = "";
        if(this.tasks.isEmpty()){
            s+="closed";
            return s;
        }
        s+=this.tasks.toString();
        return s;
    }



}
