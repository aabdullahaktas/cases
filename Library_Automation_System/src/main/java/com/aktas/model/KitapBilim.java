package com.aktas.model;

import com.aktas.model.emuns.Durum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "kitaplar_bilim")
@Entity
public class KitapBilim extends Kitap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alan;

    public KitapBilim(Long id, String ISBN, String baslik, String yazar, int yayinYili, Durum durum, String alan) {
        super(id, ISBN, baslik, yazar, yayinYili, durum);
        this.alan = alan;
    }
}
