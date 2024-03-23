package com.aktas.controller;

import com.aktas.model.Uye;
import com.aktas.service.UyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/uyeler")
public class UyeController {
    @Autowired
    private UyeService uyeService;

    @GetMapping
    public ResponseEntity<List<Uye>> tumUyeleriGetir() {
        List<Uye> uyeler = uyeService.tumUyeleriGetir();
        return new ResponseEntity<>(uyeler, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Uye> uyeEkle(@RequestBody Uye uye) {
        Uye yeniUye = uyeService.uyeEkle(uye);
        return new ResponseEntity<>(yeniUye, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> uyeSil(@PathVariable Long id) {
        uyeService.uyeSil(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

