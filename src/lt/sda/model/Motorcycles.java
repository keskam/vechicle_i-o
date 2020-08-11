package lt.sda.model;

public class Motorcycles extends Vehicle {

    private final int topSpeed;
    private final String shape; //(Coupe/Sedan/Wagon)

    public Motorcycles(String brand, String model, int price, int topSpeed, String shape) {
        super(brand, model, price);
        this.topSpeed = topSpeed;
        this.shape = shape;
    }
}
