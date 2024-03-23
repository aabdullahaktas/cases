package com.aktas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "yonetici_personel")
@Entity
public class YoneticiPersonel extends Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double bonus;
    @Override
    public double maasHesapla() {
        double maas = getSaatlikUcret() * getCalismaSaati();
        if (getSaatlikUcret() < 500) {
            setSaatlikUcret(500);
        }
        maas += bonus;
        return maas;
    }
}
