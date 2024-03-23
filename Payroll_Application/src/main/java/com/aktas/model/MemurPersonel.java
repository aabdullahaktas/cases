package com.aktas.model;

import com.aktas.model.emuns.Derece;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "memur_personel")
public class MemurPersonel extends Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Derece derece;

    public double maasHesapla() {
        if (derece == Derece.JUNIOR) {
            double maas = getSaatlikUcret() * getCalismaSaati();
            if (getCalismaSaati() > 180) {
                maas += (getCalismaSaati() - 180) * getSaatlikUcret() * 1.5;
            }
            return maas;
        } else if (derece == Derece.MID) {
            setSaatlikUcret(getSaatlikUcret() + 250);
            double maas = getCalismaSaati() * getSaatlikUcret();
            if (getCalismaSaati() > 180) {
                maas += (getCalismaSaati() - 180) * getSaatlikUcret() * 1.5;
            }
            maas += 500;
            return maas;
        } else {
            setSaatlikUcret(getSaatlikUcret() + 500);
            double maas = getCalismaSaati() * getSaatlikUcret();
            if (getCalismaSaati() > 180) {
                maas += (getCalismaSaati() - 180) * getSaatlikUcret() * 1.5;
            }
            maas += 500;
            return maas;
        }
    }
}
