package com.aktas.service;

import com.aktas.model.Kitap;
import com.aktas.repository.KitapRepository;
import com.aktas.repository.UyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KutuphaneService {

    @Autowired
    private KitapRepository kitapRepository;

    @Autowired
    private UyeRepository uyeRepository;

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

