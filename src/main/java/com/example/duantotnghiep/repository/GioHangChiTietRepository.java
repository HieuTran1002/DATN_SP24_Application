package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.GioHang;
import com.example.duantotnghiep.entity.GioHangChiTiet;
import com.example.duantotnghiep.mapper.GioHangCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    @Query(value = "SELECT img.tenimage,sp.tensanpham,sct.giaban,s.size,ghct.soluong,ms.tenmausac  FROM sanphamchitiet sct \n" +
            "join sanpham sp on sct.idsanpham=sp.id \n" +
            "join size s on sct.idsize = s.id\n" +
            "join image img on sct.id = img.idsanphamchitiet\n" +
            "join giohangchitiet ghct on ghct.idsanphamchitiet = sct.id\n" +
            "join giohang gh on gh.id = ghct.idgiohang\n" +
            "join mausac ms on ms.id=sct.idmausac\n" +
            "where img.isdefault = 'true'",nativeQuery = true)
    List<GioHangCustom> loadOnGioHang();
}
