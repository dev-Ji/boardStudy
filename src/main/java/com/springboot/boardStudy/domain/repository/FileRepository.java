package com.springboot.boardStudy.domain.repository;

import com.springboot.boardStudy.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
