package com.springboot.boardStudy.domain.repository;

import com.springboot.boardStudy.domain.entity.BoardRest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRestRepository extends JpaRepository<BoardRest, Long> {
}
