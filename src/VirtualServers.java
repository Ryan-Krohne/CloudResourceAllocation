public class VirtualServers extends Resource {
    private int numOfServers;

    public int getNumOfServers() {
        return numOfServers;
    }

    public void setNumOfServers(int numOfServers) {
        this.numOfServers = numOfServers;
    }

    public VirtualServers(String name, double price, int numOfServers) {
        super(name, price);
        this.numOfServers = numOfServers;
    }

    public double calculateFees() {
        return 0;
    }

    public double savings() {
        return 0;
    }   
}