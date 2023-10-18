import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> treeSet = new TreeSet<>();

        treeSet.add(new Book("BrainPlus4", 140, "Burcu", "4 Kasım 2023"));
        treeSet.add(new Book("BrainPlus1", 100, "Cem", "1 Kasım 2023"));
        treeSet.add(new Book("BrainPlus2", 120, "Yusuf", "2 Kasım 2023"));
        treeSet.add(new Book("BrainPlus5", 150, "Funda", "5 Kasım 2023"));
        treeSet.add(new Book("BrainPlus3", 130, "Abidin", "3 Kasım 2023"));


        for (Book c : treeSet) {
            System.out.println(c.getPageNumber());
        }
    }
}