package com.editornice.member.img.service;

import com.editornice.member.domain.Member;
import com.editornice.member.img.domain.ImageData;
import com.editornice.member.img.ImageUtils;
import com.editornice.member.img.repository.StorageRepository;
import com.editornice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {

    private final StorageRepository storageRepository;
    private final MemberRepository memberRepository;

    public String uploadImage(MultipartFile file,Long id) throws IOException {

        Member member = memberRepository.findById(id).orElseThrow();
        ImageData imageData =
                ImageData.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .imageData(ImageUtils.compressImage(file.getBytes()))
                        .build();
        imageData.setMember(member);
        storageRepository.save(imageData);

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
