package com.getter.getterplay.controller;


import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;
import com.getter.getterplay.boardService.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/board")
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public String boardGET(Model model){
        List<GetterBoard> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "board/board";
    }



    @GetMapping("/post")
    public String postGET(){return "board/post";}

    @PostMapping("/post")
    public String postPOST(BoardDTO boardDTO){

        log.info("BoardPOST............");
        log.info("boardDTO...{}", boardDTO);
        boardService.insert(boardDTO);

        return "redirect:/board";

    }

    @GetMapping("/read")
    public String read(Long bno, Model model){
        BoardDTO board = boardService.getOne(bno);
        log.info("bno......>{}", bno);
        model.addAttribute("board", board);
        log.info("board detail......>{}", board);
        return "/board/boardDetail";
    }


}
