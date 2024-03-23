package com.aktas.service;

import com.aktas.model.Uye;
import com.aktas.repository.UyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UyeService {
    @Autowired
    private UyeRepository uyeRepository;

    public List<Uye> tumUyeleriGetir() {
        return uyeRepository.findAll();
    }

    public Uye uyeEkle(Uye uye) {
        return uyeRepository.save(uye);
    }

    public void uyeSil(Long id) {
        uyeRepository.deleteById(id);
    }

    // Diğer işlemler buraya eklenebilir
}

