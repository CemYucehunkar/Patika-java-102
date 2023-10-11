import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dizi = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Bir indeks değeri girin (0-9 arası) veya çıkmak için -1 girin: ");
            int indeks = scanner.nextInt();

            if (indeks == -1) {
                System.out.println("Programdan çıkılıyor.");
                break; // Sonsuz döngüyü sonlandır
            }

            try {
                int eleman = getEleman(dizi, indeks);
                System.out.println("Girdiğiniz indeksteki eleman: " + eleman);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Hata: Geçersiz indeks! Dizi boyutunun dışında bir indeks girdiniz.");
            }
        }
    }

    public static int getEleman(int[] dizi, int indeks) {
        return dizi[indeks];
    }
}