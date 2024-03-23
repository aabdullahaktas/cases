package com.aktas.controller;

import com.aktas.model.Kitap;
import com.aktas.service.KitapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitaplar")
public class KitapController {
    @Autowired
    private KitapService kitapService;

    @GetMapping
    public ResponseEntity<List<Kitap>> tumKitaplariGetir() {
        List<Kitap> kitaplar = kitapService.tumKitaplariGetir();
        return new ResponseEntity<>(kitaplar, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Kitap> kitapEkle(@RequestBody Kitap kitap) {
        Kitap yeniKitap = kitapService.kitapEkle(kitap);
        return new ResponseEntity<>(yeniKitap, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> kitapSil(@PathVariable Long id) {
        kitapService.kitapSil(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

