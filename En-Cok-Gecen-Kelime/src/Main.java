import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();
// Metni kelimelere ayır
        String[] kelimeler = metin.split(" ");

                // Kelimeleri saymak için bir HashMap kullan
                Map<String, Integer> kelimeSayilari = new HashMap<>();

        for (String kelime : kelimeler) {
        // Kelimenin başındaki ve sonundaki noktalama işaretlerini temizle
        kelime = kelime.replaceAll("[^a-zA-Z0-9]", "");

        // Kelimeyi küçük harfe çevir (büyük-küçük harf duyarlılığını kaldırmak için)
        kelime = kelime.toLowerCase();

        // Kelimeyi HashMap'e ekle
        if (kelimeSayilari.containsKey(kelime)) {
        kelimeSayilari.put(kelime, kelimeSayilari.get(kelime) + 1);
        } else {
        kelimeSayilari.put(kelime, 1);
        }
        }

        // En çok geçen kelimeyi bul
        String enCokGecenKelime = "";
        int enCokGecenSayi = 0;

        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
        if (entry.getValue() > enCokGecenSayi) {
        enCokGecenKelime = entry.getKey();
        enCokGecenSayi = entry.getValue();
        }
        }

        if (!enCokGecenKelime.isEmpty()) {
        System.out.println("En çok geçen kelime: " + enCokGecenKelime);
        System.out.println("Toplam sayısı: " + enCokGecenSayi);
        } else {
        System.out.println("Metinde hiç kelime bulunamadı.");
        }
        }
        }