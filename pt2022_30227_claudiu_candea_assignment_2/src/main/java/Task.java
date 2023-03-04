public class Task {
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Task(int ID, int arrivalTime, int serviceTime){
        this.ID=ID;
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
    }

    public int getID(){
        return ID;
    }
    public int getArrivalTime(){
        return arrivalTime;
    }
    public int getServiceTime(){
        return serviceTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setServiceTime(int serviceTime){
        this.serviceTime=serviceTime;
    }

    public String toString(){
        String s = "("+this.ID + ", " + this.arrivalTime + ", "+this.serviceTime + ")";
        return s;
    }
}
