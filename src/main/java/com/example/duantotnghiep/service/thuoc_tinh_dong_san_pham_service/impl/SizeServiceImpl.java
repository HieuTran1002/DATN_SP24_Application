package com.example.duantotnghiep.service.thuoc_tinh_dong_san_pham_service.impl;

import com.example.duantotnghiep.entity.Size;
import com.example.duantotnghiep.repository.SizeRepository;
import com.example.duantotnghiep.request.SizeRequest;
import com.example.duantotnghiep.response.MessageResponse;
import com.example.duantotnghiep.service.thuoc_tinh_dong_san_pham_service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Override
    public List<Size> getAll() {
        return sizeRepository.findByTrangThai(1);
    }

    @Override
    public Size getById(UUID id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Size> getAllSize(Integer trangThai, Integer size, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Size> pageList = sizeRepository.getAllSize(trangThai, size, pageable);
        return pageList.getContent();
    }


    @Override
    public MessageResponse create(SizeRequest request) {
        Size size = new Size();
        size.setId(UUID.randomUUID());
        size.setSize(request.getSize());
        size.setTrangThai(request.getTrangThai());
        size.setNgayTao(timestamp);
        sizeRepository.save(size);
        return MessageResponse.builder().message("Thêm thành công").build();
    }

    @Override
    public MessageResponse update(UUID id, SizeRequest request) {
        Optional<Size> optionalSize= sizeRepository.findById(id);
        if (optionalSize.isPresent()) {
            Size size = optionalSize.get();
            size.setSize(request.getSize());
            size.setTrangThai(request.getTrangThai());
            size.setNgayCapNhat(timestamp);
            sizeRepository.save(size);
            return MessageResponse.builder().message("Cập nhật thành công").build();
        } else {
            return MessageResponse.builder().message("Không tìm thấy thương hiệu với ID: " + id).build();
        }
    }

    @Override
    public MessageResponse delete(UUID id) {
        Optional<Size> optionalSize= sizeRepository.findById(id);
        if (optionalSize.isPresent()) {
            Size size = optionalSize.get();
            size.setTrangThai(2);
            size.setNgayCapNhat(timestamp);
            sizeRepository.save(size);
            return MessageResponse.builder().message("Delete thành công").build();
        } else {
            return MessageResponse.builder().message("Không tìm thấy thương hiệu với ID: " + id).build();
        }
    }

}
