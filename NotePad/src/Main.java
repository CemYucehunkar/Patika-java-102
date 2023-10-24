import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner metininput = new Scanner(System.in);

        System.out.print("Metin Giriniz : ");
        String cem = metininput.nextLine();


        File dosya = new File("src/Patika.txt");
        try {
            dosya.createNewFile();
            BufferedWriter dosyayaz = new BufferedWriter(new FileWriter(dosya,true));
            PrintWriter yazmaislemi = new PrintWriter(dosyayaz);
            yazmaislemi.print(cem);
            yazmaislemi.println();
            yazmaislemi.close();

            BufferedReader okuma = new BufferedReader(new FileReader(dosya));

            String satir;
            while ((satir=okuma.readLine())!=null){
                System.out.println(satir);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}