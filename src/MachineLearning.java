public class MachineLearning extends Resource{
    private int mlDuration; //options would be build, train, deploy, other

    public int getMlDuration() {
        return mlDuration;
    }

    public void setMlDuration(int mlDuration) {
        this.mlDuration = mlDuration;
    }
    
    public double calculateFees() {
        return 0;
    }

    public double savings() {
        return 0;
    }

    public MachineLearning(String name, double price, int mlDuration) {
            super(name, price);
            setMlDuration(mlDuration);
    }

}
