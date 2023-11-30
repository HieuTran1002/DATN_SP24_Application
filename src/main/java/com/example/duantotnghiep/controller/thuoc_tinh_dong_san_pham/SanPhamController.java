package com.example.duantotnghiep.controller.thuoc_tinh_dong_san_pham;

import com.example.duantotnghiep.entity.SanPham;
import com.example.duantotnghiep.request.ProductRequest;
import com.example.duantotnghiep.response.ProductDetailUpdateReponse;
import com.example.duantotnghiep.response.ProductResponse;
import com.example.duantotnghiep.response.ProductUpdateResponse;
import com.example.duantotnghiep.service.thuoc_tinh_dong_san_pham_service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/san-pham/")
public class SanPhamController {

    @Autowired
    private SanPhamServiceImpl sanPhamService;

    @GetMapping("hien-thi")
    public ResponseEntity<List<ProductResponse>> filterSanPham(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
    ) {
        return new ResponseEntity<>(sanPhamService.getHoaDonByFilter(pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("thuong-hieu")
    public ResponseEntity<List<ProductResponse>> findByThuongHieu(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "value") String value
    ) {
        return new ResponseEntity<>(sanPhamService.findByThuongHieu(pageNumber, pageSize, value), HttpStatus.OK);
    }

    @GetMapping("kieu-de")
    public ResponseEntity<List<ProductResponse>> findByKieuDe(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "value") String value
    ) {
        return new ResponseEntity<>(sanPhamService.findByKieuDe(pageNumber, pageSize, value), HttpStatus.OK);
    }

    @GetMapping("xuat-xu")
    public ResponseEntity<List<ProductResponse>> findByXuatXu(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "value") String value
    ) {
        return new ResponseEntity<>(sanPhamService.findByXuatXu(pageNumber, pageSize, value), HttpStatus.OK);
    }

    @GetMapping("danh-muc")
    public ResponseEntity<List<ProductResponse>> findByDanhMuc(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "value") String value
    ) {
        return new ResponseEntity<>(sanPhamService.findByDanhMuc(pageNumber, pageSize, value), HttpStatus.OK);
    }

    @GetMapping("name-code")
    public ResponseEntity<List<ProductResponse>> findByNameOrCode(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "value") String value
    ) {
        return new ResponseEntity<>(sanPhamService.findByNameOrCode(pageNumber, pageSize, value), HttpStatus.OK);
    }

    @GetMapping("status")
    public ResponseEntity<List<ProductResponse>> findByStatus(
            @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "status") Integer status
    ) {
        return new ResponseEntity<>(sanPhamService.findByStatus(pageNumber, pageSize, status), HttpStatus.OK);
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductUpdateResponse> findByProduct(@PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(sanPhamService.findByProduct(id), HttpStatus.OK);
    }

    @GetMapping("product-detail/{id}")
    public ResponseEntity<List<ProductDetailUpdateReponse>> findByProductDetail(@PathVariable("id") UUID id
    ) {
        return new ResponseEntity<>(sanPhamService.findByProductDetail(id), HttpStatus.OK);
    }


    @PostMapping("create")
    public ResponseEntity<SanPham> createSanPham(
            @RequestBody ProductRequest productRequest
    ) {
        return new ResponseEntity<>(sanPhamService.createProduct(productRequest), HttpStatus.CREATED);
    }

}
