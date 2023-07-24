package com.example.duantotnghiep.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class XuatXu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "TenXuatXu")
    private String tenXuatXu;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @OneToMany(mappedBy = "xuatXu",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<SanPham> sanPhamList;

}
