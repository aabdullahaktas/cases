package com.aktas.service;

import com.aktas.model.Kitap;
import com.aktas.repository.KitapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KitapService {
    @Autowired
    private KitapRepository kitapRepository;

    public List<Kitap> tumKitaplariGetir() {
        return kitapRepository.findAll();
    }

    public Kitap kitapEkle(Kitap kitap) {
        return kitapRepository.save(kitap);
    }

    public void kitapSil(Long id) {
        kitapRepository.deleteById(id);
    }

}

