package com.example.NguyenThangTien.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Length(min = 3,max=3)
    private String MaNV;
    @Length(min = 7,max=100)
    private String TenNv;
    @Length(min = 2,max=3)
    private String Phai;
    @Length(min=10,max=200)
    private String NoiSinh;

    @ManyToOne
    @JoinColumn(name = "MaPhong")
    private PhongBan MaPhong;

    private int Luong;


}
