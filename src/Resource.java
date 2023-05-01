public abstract class Resource {
    private String name; //name is resource type
    private double price;
    public static int numResources=0;    

    public Resource(String name, double price) {
        setName(name);
        setPrice(price);
        numResources++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getNumResources() {
        return numResources;
    }

    //will use getPrice in subclass to calculate initial price. Calculate fees will subtract savings.
    abstract public double savings();
    abstract public double calculateFees(); //final price



    public String toString() {
        return name+"    $"+calculateFees()+"    $"+savings()+"    $"+price;
    }

}