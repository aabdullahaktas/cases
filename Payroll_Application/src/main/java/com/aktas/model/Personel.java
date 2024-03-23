package com.aktas.model;

import com.aktas.model.emuns.Derece;
import com.aktas.model.emuns.Role;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "personel")
public abstract class Personel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    private double saatlikUcret = 500;
    private double calismaSaati;
    private double maas;
    private Role role;


    public abstract double maasHesapla();

}

