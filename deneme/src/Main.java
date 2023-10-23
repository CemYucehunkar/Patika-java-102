import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Map<Integer, String> ogrenciNumaralari = new HashMap<>();
        List<Integer> kullanilanNumaralar = new ArrayList<>();
        Set<Integer> birinciTurdaSozAlanlar = new HashSet<>();
        Set<Integer> ikinciTurdaSozAlabilecekler = new HashSet<>();
        Set<Integer> ikinciTurdaSozAlanlar = new HashSet<>();
        boolean devam = true;
        String birinciTurDosyaAdi = "birinci_tur_soz_alanlar.txt";
        String ikinciTurDosyaAdi = "ikinci_tur_soz_alanlar.txt";

        // Öğrenci isimlerini ve numaralarını ekleyin.
        ogrenciNumaralari.put(1, "Abdullah Aslan");
        ogrenciNumaralari.put(2, "Tuba Aydın");
        ogrenciNumaralari.put(3, "Muhammed Fatih Batur");
        ogrenciNumaralari.put(4, "Yasin Derya Bilgin");
        ogrenciNumaralari.put(5, "Merve Bilgin");
        ogrenciNumaralari.put(6, "İbrahim Boz");
        ogrenciNumaralari.put(7, "Öğrenci 7");
        ogrenciNumaralari.put(8, "Öğrenci 8");
        ogrenciNumaralari.put(9, "Öğrenci 9");
        ogrenciNumaralari.put(10, "Öğrenci 10");
        // Diğer öğrencileri de ekleyin...

        int tur = 1;

        // 1. turda söz alanları kontrol et
        File birinciTurDosya = new File(birinciTurDosyaAdi);
        if (birinciTurDosya.exists()) {
            try (Scanner dosyaOkuyucu = new Scanner(birinciTurDosya)) {
                while (dosyaOkuyucu.hasNextLine()) {
                    int numara = Integer.parseInt(dosyaOkuyucu.nextLine);
                    birinciTurdaSozAlanlar.add(numara);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // 2. turda söz alanları kontrol et
        File ikinciTurDosya = new File(ikinciTurDosyaAdi);
        if (ikinciTurDosya.exists()) {
            try (Scanner dosyaOkuyucu = new Scanner(ikinciTurDosya)) {
                while (dosyaOkuyucu.hasNextLine()) {
                    int numara = Integer.parseInt(dosyaOkuyucu.nextLine());
                    ikinciTurdaSozAlanlar.add(numara);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        while (devam) {
            if (tur == 1) {
                if (kullanilanNumaralar.size() == ogrenciNumaralari.size()) {
                    System.out.println("Birinci tur tamamlandı.");
                    tur = 2;
                } else {
                    int randomIndex = random.nextInt(ogrenciNumaralari.size()) + 1;
                    while (kullanilanNumaralar.contains(randomIndex)) {
                        randomIndex = random.nextInt(ogrenciNumaralari.size()) + 1;
                    }

                    System.out.println("Söz alan öğrenci: " + ogrenciNumaralari.get(randomIndex));
                    birinciTurdaSozAlanlar.add(randomIndex);
                    kullanilanNumaralar.add(randomIndex);

                    // Söz alan öğrencinin numarasını birinci tur dosyasına yaz
                    try (FileWriter dosyaYazici = new FileWriter(birinciTurDosyaAdi, true)) {
                        dosyaYazici.write(Integer.toString(randomIndex) + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (ikinciTurdaSozAlabilecekler.isEmpty()) {
                    ikinciTurdaSozAlabilecekler.addAll(ogrenciNumaralari.keySet());
                    ikinciTurdaSozAlabilecekler.removeAll(birinciTurdaSozAlanlar);
                    ikinciTurdaSozAlabilecekler.removeAll(ikinciTurdaSozAlanlar);
                }

                if (ikinciTurdaSozAlabilecekler.isEmpty()) {
                    System.out.println("İkinci tur tamamlandı. Söz alabilecek öğrenci kalmadı.");
                    devam = false;
                } else {
                    List<Integer> liste = new ArrayList<>(ikinciTurdaSozAlabilecekler);
                    Collections.shuffle(liste);
                    int randomIndex = liste.get(0);
                    ikinciTurdaSozAlabilecekler.remove(randomIndex);

                    System.out.println("Söz alan öğrenci: " + ogrenciNumaralari.get(randomIndex));
                    ikinciTurdaSozAlanlar.add(randomIndex);

                    // Söz alan öğrencinin numarasını ikinci tur dosyasına yaz
                    try (FileWriter dosyaYazici = new FileWriter(ikinciTurDosyaAdi, true)) {
                        dosyaYazici.write(Integer.toString(randomIndex) + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (devam) {
                System.out.println("Derste ve soruya yorum yaptı mı? (evet/hayır)");
                String cevap = scanner.nextLine().toLowerCase();
                if (cevap.equals("evet")) {
                    // Yorum yapıldı, ikinci tura geç.
                    if (tur == 1) {
                        Integer randomIndex = null;
                        birinciTurdaSozAlanlar.remove(randomIndex);
                    }
                    tur = 2;
                }
            }
        }
    }
}