package com.aktas.model;

import net.minidev.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MaasBordro {
    public static void bordroOlustur(List<Personel> personelListesi) {
        for (Personel personel : personelListesi) {
            JSONObject bordroJson = new JSONObject();
            bordroJson.put("bordro", "SUBAT 2020");
            JSONObject personelJson = new JSONObject();
            personelJson.put("ismi", personel.getAd());
            personelJson.put("calismaSaati", personel.getCalismaSaati());
            JSONObject odemeDetaylari = new JSONObject();
            odemeDetaylari.put("anaOdeme", "₺" + personel.maasHesapla());
            // Mesai hesaplaması yapılacak
            odemeDetaylari.put("mesai", "₺0.00");
            odemeDetaylari.put("toplamOdeme", "₺" + personel.maasHesapla());
            personelJson.put("odemeDetaylari", odemeDetaylari);
            bordroJson.put("personel", personelJson);

            String dosyaAdi = personel.getAd();

            try (FileWriter file = new FileWriter(personel.getAd() + ".json")) {
                file.write(bordroJson.toJSONString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void azCalisanlariListele(List<Personel> personelListesi) {
        for (Personel personel : personelListesi) {
            if (personel.getCalismaSaati() < 150) {
            }
        }
    }
}

