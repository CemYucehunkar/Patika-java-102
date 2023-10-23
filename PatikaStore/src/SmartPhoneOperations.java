import java.util.List;
import java.util.Scanner;

public class SmartPhoneOperations {
    private List<SmartPhone> smartPhoneList;
    Scanner scanner = new Scanner(System.in);

    public SmartPhoneOperations(List<SmartPhone> smartPhoneList) {
        this.smartPhoneList = smartPhoneList;
        initializeSmartPhones();
    }
    public void run() {
        while (true) {
            System.out.println("PatikaStore SmartPhone Operations !");
            System.out.println("1 - List Products");
            System.out.println("2 - Add Product");
            System.out.println("3 - Remove Product");
            System.out.println("4 - Filter Product (By Id)");
            System.out.println("5 - Filter Product (By Brand Name)");
            System.out.println("0 - Exit");
            System.out.print("Your Choice : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listSmartPhones();
                    break;
                case 2:
                    addSmartPhone();
                    break;
                case 3:
                    removeSmartPhone();
                    break;
                case 4:
                    filterSmartPhoneById();
                    break;
                case 5:
                    filterSmartPhoneByBrand();
                    break;
                case 0:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
    public void initializeSmartPhones() {
        SmartPhone smartPhone1 = new SmartPhone(1, "SAMSUNG GALAXY A51", 3199.0, 128, 10, 6, "128 GB", 6.5, "Samsung", "Siyah", 4000, 48);
        SmartPhone smartPhone2 = new SmartPhone(2, "iPhone 11 64 GB", 7379.0, 64, 10, 6, "64 GB", 6.1, "Apple", "Mavi", 3046, 32);
        SmartPhone smartPhone3 = new SmartPhone(3, "Redmi Note 10 Pro 8GB", 4012.0, 128, 10, 12, "128 GB", 6.5, "Xiaomi", "Beyaz", 4000, 64);

        smartPhoneList.add(smartPhone1);
        smartPhoneList.add(smartPhone2);
        smartPhoneList.add(smartPhone3);
    }
    public void listSmartPhones() {
        System.out.println("SmartPhone List");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s | %-10s | %-8s | %-6s | %-7s | %-10s | %-8s | %-10s |\n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "Camera", "Battery", "RAM","Colour");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (SmartPhone smartPhone : smartPhoneList) {
            System.out.printf("| %-2d | %-30s | %-10.2f TL | %-10s | %-8s | %-6.1f | %-7d | %-10.1f | %-8d | %-10s |\n",
                    smartPhone.getId(), smartPhone.getName(), smartPhone.getUniqPrice(), smartPhone.getBrandName(),
                    smartPhone.getStorage(), smartPhone.getScreenSize(), smartPhone.getCamera(), smartPhone.getBatteryPower(),
                    smartPhone.getRam(), smartPhone.getColour());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void addSmartPhone() {
        System.out.print("Enter the name of the product you want to add : ");
        String name = scanner.nextLine();

        System.out.print("Enter the price of the product you want to add : ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the storage of the product you want to add : ");
        int storage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the screen size of the product you want to add : ");
        double screenSize = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the camera of the product you want to add : ");
        int camera = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the battery power of the product you want to add : ");
        double batteryPower = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter the ram of the product you want to add : ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the colour of the product you want to add : ");
        String colour = scanner.nextLine();

        System.out.print("Enter the brand name of the product you want to add : ");
        String brandName = scanner.nextLine();

        int id = smartPhoneList.size() + 1;
        SmartPhone smartPhone = new SmartPhone(id, name, price, storage, 0, ram, "GB", screenSize, brandName, colour, batteryPower, camera);
        smartPhoneList.add(smartPhone);
        System.out.println("Product added successfully.");
        listSmartPhones();
    }
    public void removeSmartPhone() {
        listSmartPhones();
        System.out.print("Product id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (SmartPhone smartPhone : smartPhoneList) {
            if (smartPhone.getId() == id) {
                smartPhoneList.remove(smartPhone);
                System.out.println("Product removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void filterSmartPhoneById() {
        System.out.print("Filter by id : ");
        int i = scanner.nextInt();

        for (SmartPhone item : smartPhoneList) {
            if (item.getId() == i) {

                System.out.printf("| %-2d | %-30s | %-10.2f TL | %-10s | %-8s | %-6.1f | %-7d | %-10.1f | %-8d | %-10s |\n",
                        smartPhoneList.get(i).getId(), smartPhoneList.get(i).getName(), smartPhoneList.get(i).getUniqPrice(), smartPhoneList.get(i).getBrandName(),
                        smartPhoneList.get(i).getStorage(), smartPhoneList.get(i).getScreenSize(), smartPhoneList.get(i).getCamera(), smartPhoneList.get(i).getBatteryPower(),
                        smartPhoneList.get(i).getRam(), smartPhoneList.get(i).getColour());

            }
        }
        System.out.println("Product not found.");

    }
    public void filterSmartPhoneByBrand() {
        System.out.print("Filter by brand : ");
        String brand = scanner.nextLine();
        for (SmartPhone smartPhone : smartPhoneList) {
            if (smartPhone.getBrandName().equals(brand)) {
                System.out.printf("| %-2d | %-30s | %-10.2f TL | %-10s | %-8s | %-6.1f | %-7d | %-10.1f | %-8d | %-10s |\n",
                        smartPhone.getId(), smartPhone.getName(), smartPhone.getUniqPrice(), smartPhone.getBrandName(),
                        smartPhone.getStorage(), smartPhone.getScreenSize(), smartPhone.getCamera(), smartPhone.getBatteryPower(),
                        smartPhone.getRam(), smartPhone.getColour());
            }
        }
    }
}
