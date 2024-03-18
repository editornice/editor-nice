package com.editornice.member.img.service;

import com.editornice.member.img.domain.ImageData;
import com.editornice.member.img.ImageUtils;
import com.editornice.member.img.repository.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = storageRepository.save(
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }

        return null;
    }

    // 이미지 파일로 압축하기
    public byte[] downloadImage(String fileName) {
        ImageData imageData = storageRepository.findByName(fileName)
                .orElseThrow(RuntimeException::new);


        return ImageUtils.decompressImage(imageData.getImageData());
    }
}
