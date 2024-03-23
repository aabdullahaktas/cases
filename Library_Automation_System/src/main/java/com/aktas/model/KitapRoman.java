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
@Table(name = "kitaplar_oman")
public class KitapRoman extends Kitap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tur;

    public KitapRoman(Long id, String ISBN, String baslik, String yazar, int yayinYili, Durum durum, String tur) {
        super(id, ISBN, baslik, yazar, yayinYili, durum);
        this.tur = tur;
    }

}
