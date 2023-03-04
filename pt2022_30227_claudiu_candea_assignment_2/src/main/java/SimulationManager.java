import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SimulationManager implements Runnable, ActionListener {

    private int timeLimit=0;
    private int maxProcessingTime=0;
    private int minProcessingTime=0;
    private int maxArrivalTime=0;
    private int minArrivalTime=0;
    private int numberOfServers=0;
    private int numberOfClients=0;
    private int peakHour=0;
    private int peakHourSize=0;
    private Scheduler scheduler;
    private SimulationFrame frame;
    private ArrayList<Task> tasks;
    private SelectionPolicy policy = SelectionPolicy.SHORTEST_TIME;

    public SimulationManager(){
        frame = new SimulationFrame();
        frame.startButton.addActionListener(this);
    }


    public void generateNRandomTasks(){
        for(int i=0;i<this.numberOfClients;i++){
            int newArrivalTime = (int)((Math.random()*(maxArrivalTime-minArrivalTime))+minArrivalTime);
            int newServiceTIme = (int)((Math.random()*(maxProcessingTime-minProcessingTime))+minProcessingTime);
            Task newTask= new Task(i+1,newArrivalTime,newServiceTIme);
            this.tasks.add(newTask);
        }
    }

    public void writeInFile(String s) throws IOException {
        FileWriter writer = new FileWriter("QueueSimulation.txt",true);
        writer.write(("New Simulation\n"));
        writer.write(s);
        writer.close();
    }

    public void run() {
        try {
            int currentTime = 1;
            double totalWaiting=0;
            int addedTasks=0;
            ArrayList<Task> tasksToRemove = new ArrayList<Task>();
            while (currentTime <= timeLimit) {
                int totalQueuesSize=0;
                for (Task t : tasks) {
                    if (t.getArrivalTime() == currentTime) {
                        addedTasks++;
                        totalWaiting+=scheduler.dispatchTask(t)+t.getServiceTime();
                        tasksToRemove.add(t);
                    }
                }
                //System.out.println("Total waitng "+totalWaiting+" at time " +currentTime);
                for (Task task : tasksToRemove) {
                    tasks.remove(task);
                }
                String s = "Time " + currentTime+"\n";
                for(int i=0; i<this.numberOfServers;i++){
                    totalQueuesSize+=scheduler.getServers().get(i).getTasks().size();
                }
                if(totalQueuesSize>peakHourSize){
                    peakHourSize=totalQueuesSize;
                    peakHour=currentTime;
                }
                s+=this.toString();
                this.frame.textArea.setText(frame.textArea.getText()+s);
                currentTime++;
                Thread.sleep(100);
            }
            String average = "Average waiting time is " + totalWaiting/addedTasks+ "\n";
            average += "Peak hours is " + peakHour + "\n";
            average += "Average service time is " + scheduler.getServers().get(0).getTotalServiceTime()/scheduler.getServers().get(0).getNoProcessedTasks()+"\n";
            frame.textArea.setText(frame.textArea.getText()+average);
            writeInFile(frame.textArea.getText());
            for(int i=0;i<scheduler.getServers().size();i++){
                //scheduler.getServers().get(i).close();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void init(){
        this.maxArrivalTime=Integer.parseInt(frame.textField1.getText());
        this.minArrivalTime=Integer.parseInt(frame.textField2.getText());
        this.maxProcessingTime=Integer.parseInt(frame.textField3.getText());
        this.minProcessingTime=Integer.parseInt(frame.textField4.getText());
        this.timeLimit=Integer.parseInt(frame.textField5.getText());
        this.numberOfServers=Integer.parseInt(frame.textField6.getText());
        this.numberOfClients=Integer.parseInt(frame.textField7.getText());
        scheduler = new Scheduler(numberOfServers,numberOfClients);
        scheduler.changeStrategy(policy);
        tasks=new ArrayList<Task>(numberOfClients);
        generateNRandomTasks();
    }

    public void actionPerformed(ActionEvent e) {
        init();
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args){
        SimulationManager manager = new SimulationManager();
    }

    public String toString(){
        String s="Waiting clients"+ tasks.toString()+"\n";
        for(int i=0; i<this.numberOfServers;i++){
            s+="Queue "+i+": " + this.scheduler.getServers().get(i).toString()+"\n";
        }
        s+="\n";
        return s;
    }
}


