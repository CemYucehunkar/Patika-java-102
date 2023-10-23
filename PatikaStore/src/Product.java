public abstract class Product {
    private int id;
    private String name;
    private double uniqPrice;
    private int stockAmount;
    private double discountRate;
    private int ram;
    private String storage;
    private double screenSize;
    private String brandName;

    public  Product(int id, String name, double uniqPrice, int stockAmount, double discountRate, int ram, String storage, double screenSize, String brandName) {
        this.id = id;
        this.name = name;
        this.uniqPrice = uniqPrice;
        this.stockAmount = stockAmount;
        this.discountRate = discountRate;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.brandName = brandName;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getUniqPrice() {
        return uniqPrice;
    }
    public int getStockAmount() {
        return stockAmount;
    }
    public double getDiscountRate() {
        return discountRate;
    }
    public int getRam() {
        return ram;
    }
    public String getStorage() {
        return storage;
    }
    public double getScreenSize() {
        return screenSize;
    }
    public String getBrandName() {
        return brandName;
    }
}
