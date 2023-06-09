public class Storage extends Resource {
    private int storageSize;
    private int minimumDiscount =250; //$250 is 500GBS



    public Storage(String name, double price, int storageSize) {
        super(name, price);
        setStorageSize(storageSize);
    }


    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public double calculateFees() {
        return getPrice()-savings();
    }

    public double savings() { //anything over 500gbs is 20% off. 500 gbs is $250.
        if(getStorageSize()*CloudResourceAllocation.storagePrice>minimumDiscount){
            double savingPrice = getPrice()-250;
            savingPrice*=0.2;
            
            return savingPrice;
        }else{
        return 0;
        }
    }

    public String toString() {
        return super.toString()+"    "+storageSize+"GBS";
    }
}
