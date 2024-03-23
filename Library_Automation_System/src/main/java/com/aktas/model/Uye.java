package com.aktas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Uye implements IUye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;

    @ManyToMany
    private List<Kitap> oduncAlinanKitaplar;


    public Uye(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }

    @Override
    public void kitapOduncAl(Kitap kitap) {
        oduncAlinanKitaplar.add(kitap);
        System.out.println("Kitap ödünç alındı: " + kitap.getBaslik());
    }

    @Override
    public void kitapIadeEt(Kitap kitap) {
        oduncAlinanKitaplar.remove(kitap);
        System.out.println("Kitap iade edildi: " + kitap.getBaslik());
    }

    @Override
    public void oduncAlinanKitaplariGoruntule() {
        System.out.println("Ödünç alınan kitaplar:");
        for (Kitap kitap : oduncAlinanKitaplar) {
            System.out.println(kitap.getBaslik());
        }
    }

}
