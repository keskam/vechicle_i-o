package lt.sda.model;

public class Cars extends Vehicle {

    private final int topSpeed;
    private final String transmission; //(Manual/Automatic)
    private final String shape; //(Coupe/Sedan/Wagon)

    public Cars(String brand, String model, int price, int topSpeed, String transmission, String shape) {
        super(brand, model, price);
        this.topSpeed = topSpeed;
        this.transmission = transmission;
        this.shape = shape;
    }
}
