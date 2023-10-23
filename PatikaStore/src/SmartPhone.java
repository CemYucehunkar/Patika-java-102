public class SmartPhone extends Product{
    private String colour;
    private double batteryPower;
    private int camera;

    public SmartPhone(int id, String name, double uniquePrice, int stockAmount, int discountRate,
                      int ram, String storage, double screenSize, String brandName, String colour, double batteryPower, int camera) {
        super(id, name, uniquePrice, stockAmount, discountRate, ram, storage, screenSize, brandName);
        this.colour=colour;
        this.batteryPower=batteryPower;
        this.camera=camera;
    }

    public String getColour() {
        return colour;
    }

    public double getBatteryPower() {
        return batteryPower;
    }

    public int getCamera() {
        return camera;
    }
}