import java.util.ArrayList;
import java.util.Scanner;

public class PatikaStore {
    public void displayMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("PatikaStore Product Management Panel !\n1 - Notebook Operations\n2 - Smart Phone Operations\n3 - List Brands\n0 - Exit\n");
            System.out.print("Your Choice : ");
            int c = sc.nextInt();

            switch (c) {
                case 1:
                    NotebookOperations notebookOperations = new NotebookOperations(new ArrayList<>());
                    notebookOperations.run();
                    break;
                case 2:
                    SmartPhoneOperations smartPhoneOperations = new SmartPhoneOperations(new ArrayList<>());
                    smartPhoneOperations.run();
                    break;
                case 3:
                    Brand.getBrandList();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
            }
            System.out.println("-------------------------------\n");
        }

    }
}
