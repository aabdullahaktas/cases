package com.aktas.controller;

import com.aktas.model.Kitap;
import com.aktas.service.KutuphaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/kutuphane")
public class KutuphaneController {

    @Autowired
    private KutuphaneService kutuphaneService;

    @GetMapping("/kitaplar")
    public ResponseEntity<List<Kitap>> tumKitaplariGetir() {
        List<Kitap> kitaplar = kutuphaneService.tumKitaplariGetir();
        return new ResponseEntity<>(kitaplar, HttpStatus.OK);
    }

    @PostMapping("/kitaplar")
    public ResponseEntity<Kitap> kitapEkle(@RequestBody Kitap kitap) {
        Kitap yeniKitap = kutuphaneService.kitapEkle(kitap);
        return new ResponseEntity<>(yeniKitap, HttpStatus.CREATED);
    }

    @DeleteMapping("/kitaplar/{id}")
    public ResponseEntity<Void> kitapSil(@PathVariable Long id) {
        kutuphaneService.kitapSil(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Diğer işlemler buraya eklenebilir
}

