package com.example.NguyenThangTien.controller;

import com.example.NguyenThangTien.model.NhanVien;
import com.example.NguyenThangTien.service.NhanVienService;
import com.example.NguyenThangTien.service.PhongBanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@Controller
@RequestMapping("/NhanVien")
@RequiredArgsConstructor
public class NhanVienController {
    @Autowired
    private final NhanVienService nhanVienService;
    @Autowired
    private final PhongBanService phongBanService;

    @GetMapping
    public String listNhanVien(@RequestParam(defaultValue = "0") int page, Model model){
        Page<NhanVien> nhanVienPage = nhanVienService.findPaginated(page, 5);
        model.addAttribute("NhanViens",nhanVienPage);
        model.addAttribute("currentPage", page);
        return "NhanVien/ListNhanVien";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("NhanVien",new NhanVien());
        model.addAttribute("phongBans",phongBanService.getAllPhongBan());
        return "NhanVien/AddNhanVien";
    }

    @PostMapping("/add")
    public String AddNhanVien(@Valid NhanVien nhanVien, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "NhanVien/AddNhanVien";
        }
        nhanVienService.addNhanVien(nhanVien);
        return"redirect:/NhanVien";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditForm(@PathVariable String id, Model model){
        NhanVien nhanVien=nhanVienService.getNhanVienById(id).orElseThrow(() -> new IllegalArgumentException("Invalid course id: " + id));
        model.addAttribute("NhanVien", nhanVien);
        model.addAttribute("phongBans",phongBanService.getAllPhongBan());
        return "NhanVien/UpdateNhanVien";
    }
    @PostMapping("/edit/{id}")
    public String updateNhanVien(@PathVariable String id, @Valid NhanVien nhanVien, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "NhanVien/UpdateNhanVien";
        }
        nhanVienService.UpdateNhanVien(nhanVien);
        return "redirect:/NhanVien";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/NhanVien";
    }
}
