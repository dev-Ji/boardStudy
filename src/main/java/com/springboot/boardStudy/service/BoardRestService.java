package com.springboot.boardStudy.service;


import com.springboot.boardStudy.domain.entity.Board;
import com.springboot.boardStudy.domain.entity.BoardRest;
import com.springboot.boardStudy.domain.repository.BoardRestRepository;
import com.springboot.boardStudy.dto.BoardDto;
import com.springboot.boardStudy.dto.BoardRestDto;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardRestService {
    private BoardRestRepository boardRestRepository;

    public BoardRestService(BoardRestRepository boardRestRepository){
        this.boardRestRepository = boardRestRepository;
    }

    @Transactional
    public Long savePost(BoardRestDto boardRestDto){
        return boardRestRepository.save(boardRestDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardRestDto> getBoardRestList(Model model){
        List<BoardRest> boardRestList = boardRestRepository.findAll();
        List<BoardRestDto> boardRestDtoList = new ArrayList<>();

            for (BoardRest boardRest: boardRestList) {
                BoardRestDto boardRestDto = BoardRestDto.builder()
                        .id(boardRest.getId())
                        .author(boardRest.getAuthor())
                        .title(boardRest.getTitle())
                        .content(boardRest.getContent())
                        .createdDate(boardRest.getCreatedDate())
                        .build();
                boardRestDtoList.add(boardRestDto);
            }


        return boardRestDtoList;
    }

    @Transactional
    public BoardRestDto getDetail(Long id){
        BoardRest boardRest = boardRestRepository.findById(id).get();
        BoardRestDto boardRestDto = BoardRestDto.builder()
                .id(boardRest.getId())
                .author(boardRest.getAuthor())
                .title(boardRest.getTitle())
                .content(boardRest.getContent())
                .createdDate(boardRest.getCreatedDate())
                .build();
        return boardRestDto;
    }

}
