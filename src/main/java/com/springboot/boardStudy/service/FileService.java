package com.springboot.boardStudy.service;

import com.springboot.boardStudy.domain.entity.File;
import com.springboot.boardStudy.domain.repository.FileRepository;
import com.springboot.boardStudy.dto.FileDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFileDto(Long id){
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }
}
