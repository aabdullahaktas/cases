package com.aktas.model;

import com.aktas.model.emuns.Durum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "kitaplar_tarih")
public class KitapTarih extends Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String konu;

    public KitapTarih(Long id, String ISBN, String baslik, String yazar, int yayinYili, Durum durum, String konu) {
        super(id, ISBN, baslik, yazar, yayinYili, durum);
        this.konu = konu;
    }

    public KitapTarih(Long id, String konu) {
        this.id = id;
        this.konu = konu;
    }

}
