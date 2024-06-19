package com.example.NguyenThangTien.service;

import com.example.NguyenThangTien.model.NhanVien;
import com.example.NguyenThangTien.repository.NhanVienRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NhanVienService {

    private final NhanVienRepository nhanVienRepository;

    public Page<NhanVien> findPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return nhanVienRepository.findAll(pageable);
    }
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }
    public Optional<NhanVien> getNhanVienById(String id) {
        return nhanVienRepository.findById(id);
    }

    public void addNhanVien( NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void UpdateNhanVien(@NotNull NhanVien nhanVien){
        NhanVien existingNhanvien=nhanVienRepository.findById(nhanVien.getMaNV()).
                orElseThrow(()->new IllegalArgumentException("NhanVien with Id"+
                        nhanVien.getMaNV()+"does not exist."));


        existingNhanvien.setMaNV(nhanVien.getMaNV());
        existingNhanvien.setTenNv(nhanVien.getTenNv());
        existingNhanvien.setPhai(nhanVien.getPhai());
        existingNhanvien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanvien.setMaPhong(nhanVien.getMaPhong());
        existingNhanvien.setLuong(nhanVien.getLuong());
        nhanVienRepository.save(existingNhanvien);
    }
    public void deleteNhanVien(String id) {
        if (!nhanVienRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        nhanVienRepository.deleteById(id);
    }

}
