package com.aktas.model;

import com.aktas.model.emuns.Durum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Kutuphane {
    private List<Kitap> kitaplar;
    private List<Uye> uyeler;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
    }

    public void kitapDurumGuncelle(Kitap kitap, Durum durum) {
        kitap.setDurum(durum);
        System.out.println("Kitap durumu güncellendi: " + kitap.getBaslik() + " - Durum: " + durum);
    }

    public void katalogGoruntule() {
        System.out.println("Kütüphane kataloğu:");
        for (Kitap kitap : kitaplar) {
            System.out.println(kitap.getBaslik() + " - Durum: " + kitap.getDurum());
        }
    }

    public void uyeEkle(Uye uye) {
        uyeler.add(uye);
        System.out.println("Üye eklendi: " + uye.getAd() + " " + uye.getSoyad());
    }

    public void uyeSil(Uye uye) {
        uyeler.remove(uye);
        System.out.println("Üye silindi: " + uye.getAd() + " " + uye.getSoyad());
    }

}
