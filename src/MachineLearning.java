public class MachineLearning extends Resource{
    private int mlDuration;

    public int getMlDuration() {
        return mlDuration;
    }

    public void setMlDuration(int mlDuration) {
        this.mlDuration = mlDuration;
    }
    
    public double calculateFees() {
        return getPrice();
    }

    public double savings() { //no discounts available atm
        return 0;
    }

    public MachineLearning(String name, double price, int mlDuration) {
            super(name, price);
            setMlDuration(mlDuration);
    }

    public String toString() {
        return super.toString()+"    "+getMlDuration()+" months";
    }
}
