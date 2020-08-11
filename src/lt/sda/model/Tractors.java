package lt.sda.model;

public class Tractors extends Vehicle {
    private final int maxPulledWeight;

    public Tractors(String brand, String model, int price, int maxPulledWeight) {
        super(brand, model, price);
        this.maxPulledWeight = maxPulledWeight;
    }
}
