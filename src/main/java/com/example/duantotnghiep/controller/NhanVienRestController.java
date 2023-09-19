package com.example.duantotnghiep.controller;

import com.example.duantotnghiep.request.NhanVienRequest;
import com.example.duantotnghiep.response.NhanVienResponse;
import com.example.duantotnghiep.service.impl.NhanVienServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/nhan-vien/")
public class NhanVienRestController {

    @Autowired
    private NhanVienServiceImpl nhanVienService;

    @GetMapping("hien-thi")
    public ResponseEntity<List<NhanVienResponse>> getAll(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        return new ResponseEntity<>(nhanVienService.getAllPage(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<NhanVienRequest> createNhanVien(@Valid @RequestBody NhanVienRequest nhanVienRequest) {
        return new ResponseEntity<>(nhanVienService.createNhanVien(nhanVienRequest), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<NhanVienRequest> updateNhanVien(
            @RequestBody NhanVienRequest nhanVienRequest,
            @PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(nhanVienService.updateNhanVien(nhanVienRequest, id), HttpStatus.OK);
    }

}