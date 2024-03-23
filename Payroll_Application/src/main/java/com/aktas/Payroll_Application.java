package com.aktas;

import java.util.List;
import com.aktas.model.DosyaOku;
import com.aktas.model.MaasBordro;
import com.aktas.model.Personel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Payroll_Application {

    public static void main(String[] args) {
        SpringApplication.run(Payroll_Application.class, args);
        String dosyaAdi = "src/main/resources/personel.json";
        List<Personel> personelListesi = DosyaOku.oku(dosyaAdi);
        MaasBordro.bordroOlustur(personelListesi);
        MaasBordro.azCalisanlariListele(personelListesi);
    }
}
