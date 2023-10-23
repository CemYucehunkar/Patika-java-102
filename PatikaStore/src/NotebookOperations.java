import java.util.List;
import java.util.Scanner;

public class NotebookOperations {
    private List<Notebook> notebookList ;
    Scanner scanner = new Scanner(System.in);

    public NotebookOperations(List<Notebook> notebookList) {
        this.notebookList = notebookList;
        initializeNotebooks();
    }
    public void run() {
        while (true) {
            System.out.println("PatikaStore Notebook Operations !");
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
                    listNotebooks();
                    break;
                case 2:
                    addNotebook();
                    break;
                case 3:
                    removeNotebook();
                    break;
                case 4:
                    filterNotebookById();
                    break;
                case 5:
                    filterNotebookByBrand();
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
    public void listNotebooks() {
        System.out.println("Notebook List");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("| %-2s | %-30s | %-10s | %-10s | %-8s | %-6s | %-8s |\n",
                "ID", "Product Name", "Price", "Brand", "Storage", "Screen", "RAM");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Notebook notebook : notebookList) {
            System.out.printf("| %-2d | %-30s | %-10.2f | %-10s | %-8s | %-6.1f | %-8d |\n",
                    notebook.getId(), notebook.getName(), notebook.getUniqPrice(), notebook.getBrandName(),
                    notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }
    public void initializeNotebooks() {
        Notebook notebook1 = new Notebook(1, "HUAWEI Matebook 14", 7000.0, 512, 14.0, 16, "512 SSD", 14.0, "HUAWEI");
        Notebook notebook2 = new Notebook(2, "LENOVO V14 IGL", 3699.0, 1024, 14.0, 8, "1024 SSD", 14.0, "LENOVO");
        Notebook notebook3 = new Notebook(3, "ASUS Tuf Gaming", 8199.0, 2048, 15.6, 32, "2048 SSD", 15.6, "ASUS");

        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);
    }

    public void addNotebook() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double uniqPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Stock amount: ");
        int stockAmount = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Discount rate: ");
        int discountRate = scanner.nextInt();
        scanner.nextLine();

        System.out.print("RAM: ");
        int ram = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Storage: ");
        String storage = scanner.nextLine();

        System.out.print("Screen size: ");
        double screenSize = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Brand: ");
        String brandName = scanner.nextLine();

        notebookList.add(new Notebook(notebookList.size() + 1, name, uniqPrice, stockAmount, discountRate, ram, storage, screenSize, brandName));
        System.out.println("Product added successfully.");
        listNotebooks();
    }


    public void removeNotebook() {
        System.out.print("Product id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == id) {
                notebookList.remove(notebook);
                System.out.println("Product removed.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void filterNotebookById  () {
        System.out.print("Filter by id : ");
        int i = scanner.nextInt();

        for (Notebook item : notebookList) {
            if (item.getId() == i) {

                System.out.printf("| %-2d | %-30s | %-10.2f TL | %-10s | %-8s | %-6.1f | %-8d |\n",
                        notebookList.get(i).getId(), notebookList.get(i).getName(), notebookList.get(i).getUniqPrice(), notebookList.get(i).getBrandName(),
                        notebookList.get(i).getStorage(), notebookList.get(i).getScreenSize(), notebookList.get(i).getRam());

            }
        }
        System.out.println("Product not found.");

    }
    public void filterNotebookByBrand() {
        System.out.print("Filter by brand : ");
        String brand = scanner.nextLine();
        for (Notebook notebook : notebookList) {
            if (notebook.getBrandName().equals(brand)) {
                System.out.printf("| %-2d | %-30s | %-10.2f TL | %-10s | %-8s | %-6.1f | %-8d |\n",
                        notebook.getId(), notebook.getName(), notebook.getUniqPrice(), notebook.getBrandName(),
                        notebook.getStorage(), notebook.getScreenSize(), notebook.getRam());
            }
        }
    }
}
