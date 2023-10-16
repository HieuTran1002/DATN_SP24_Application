package com.example.duantotnghiep.repository;

import com.example.duantotnghiep.entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan, UUID> {
}