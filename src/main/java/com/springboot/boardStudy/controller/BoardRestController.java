package com.springboot.boardStudy.controller;

import com.springboot.boardStudy.dto.BoardRestDto;
import com.springboot.boardStudy.service.BoardRestService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/json")
//@RequiredArgsConstructor    //final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.
public class BoardRestController {
    private BoardRestService boardRestService;

    public BoardRestController(BoardRestService boardRestService){
        this.boardRestService = boardRestService;
    }
    @GetMapping("/")
    public List<BoardRestDto> list(Model model){
        List<BoardRestDto> boardRestDtoList = boardRestService.getBoardRestList(model);
        return boardRestDtoList;
    }

    @GetMapping("/detail/{id}")
    public BoardRestDto detail(@PathVariable("id") Long id,  Model model){
        BoardRestDto boardRestDto = boardRestService.getDetail(id);
        return boardRestDto;
    }

//    @GetMapping("/")
//    public AjaxWriteList list(Model model){
//        List<BoardRestDto> boardRestDtoList = boardRestService.getBoardRestList(model);
//        //BoardRestDto boardRestDtoList2 = (BoardRestDto) boardRestService.getBoardRestList();
//        return buildList(model);
//    }

//    @GetMapping("/test")
//    public BoardRestDto memberTest(){
//        return new BoardRestDto(0L, "Wickies", 20, "제주", new Date());
//    }
//
//    @GetMapping("/test2")
//    public ArrayList<BoardRestDto> memberTest2(){
//        return new ArrayList(Arrays.asList(
//                new BoardRestDto(1L, "Wickies", 20, "제주", new Date()),
//                new BoardRestDto(2L, "마동석", 40, "전주", new Date()),
//                new BoardRestDto(3L, "조승우", 22, "무주", new Date()),
//                new BoardRestDto(4L, "박보영", 32, "진주", new Date()),
//                new BoardRestDto(5L, "엄복동", 17, "상주", new Date())
//        ));
//    }

}
