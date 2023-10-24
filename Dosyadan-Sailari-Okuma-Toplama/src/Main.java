import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        File dosya = new File("src/Patika.txt");
        try {

            BufferedReader cemdosyayeni = new BufferedReader(new FileReader(dosya));

            String satir;
            int toplam = 0;

            while ((satir = cemdosyayeni.readLine()) != null) {
                toplam += Integer.parseInt(satir);

            }
            System.out.println(toplam);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}