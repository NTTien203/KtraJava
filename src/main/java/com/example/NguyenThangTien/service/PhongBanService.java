package com.example.NguyenThangTien.service;

import com.example.NguyenThangTien.model.NhanVien;
import com.example.NguyenThangTien.model.PhongBan;
import com.example.NguyenThangTien.repository.NhanVienRepository;
import com.example.NguyenThangTien.repository.PhongBanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }
}
