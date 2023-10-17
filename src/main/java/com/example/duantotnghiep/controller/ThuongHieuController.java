package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.entity.Size;
import com.example.duantotnghiep.entity.ThuongHieu;
import com.example.duantotnghiep.service.impl.SizeServiceImpl;
import com.example.duantotnghiep.service.impl.ThuongHieuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thuong-hieu/")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuServiceImpl thuongHieuService;

    @GetMapping("show")
    public ResponseEntity<List<ThuongHieu>> getAllSanPhamGiamGia() {
        return new ResponseEntity<>(thuongHieuService.getALL(), HttpStatus.OK);
    }
}