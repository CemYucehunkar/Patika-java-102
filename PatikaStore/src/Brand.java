import java.util.ArrayList;
import java.util.Collections;

public class Brand {
    public static int counter = 1;
    private int id;
    private String brandName;

    public static ArrayList<Brand> brandList = new ArrayList<>();
    static {
        brandList.add(new Brand("Samsung"));
        brandList.add(new Brand("Lenovo"));
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("Huawei"));
        brandList.add(new Brand("Casper"));
        brandList.add(new Brand("Asus"));
        brandList.add(new Brand("HP"));
        brandList.add(new Brand("Xiaomi"));
        brandList.add(new Brand("Monster"));
    }

    public Brand(String brandName) {
        this.brandName = brandName;
        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Brand.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public static void setBrandList(ArrayList<Brand> brandList) {
        Brand.brandList = brandList;
    }

    public static ArrayList<Brand> getBrandList() {
        Collections.sort(brandList, new BrandComparator());
        System.out.println("Our Brands\n-------------");
        for (Brand b : brandList) {
            System.out.println("(" + b.getId() + ")" + " " + b.getBrandName());
        }
        System.out.println();
        return brandList;
    }

}