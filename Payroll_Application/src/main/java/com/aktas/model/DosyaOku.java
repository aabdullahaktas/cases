package com.aktas.model;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DosyaOku {
    public static List<Personel> oku(String dosyaAdi) {
        List<Personel> personelListesi = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (FileReader dosya = new FileReader(dosyaAdi)) {
            Object obj = parser.parse(dosya);
            JSONArray personelArray = (JSONArray) obj;
            for (Object o : personelArray) {
                JSONObject personelJson = (JSONObject) o;
                String role = (String) personelJson.get("role");
                if (role.equals("Yonetici")) {
                    YoneticiPersonel yonetici = new YoneticiPersonel();
                    // Yonetici nesnesini oluştur ve personelListesi'ne ekle
                    personelListesi.add(yonetici);
                } else if (role.equals("Memur")) {
                    MemurPersonel memur = new MemurPersonel();
                    memur.setAd("abd");
                    memur.setSoyad("ak");
                    personelListesi.add(memur);
                }
            }
        } catch (IOException e) {
            System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personelListesi;
    }
}
