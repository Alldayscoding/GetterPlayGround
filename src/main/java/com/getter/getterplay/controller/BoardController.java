package com.getter.getterplay.controller;


import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;
import com.getter.getterplay.boardService.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String boardGET(Model model,
                           @PageableDefault(page = 0, size = 3, sort = "bno", direction = Sort.Direction.DESC)Pageable pageable,
                            String keyword) {

        log.info("keyword------->>{}", keyword);

        Page<GetterBoard> boardList = null;
        if(keyword == null){
            boardList = boardService.list(pageable);
        }else {
            boardList = boardService.boardSearch(keyword, pageable);
        }


        /* nowPage = current page
        *  startPage = start page in block
        *  endPage = end page in block
        */

        boardList = boardService.list(pageable);
        int nowPage = boardList.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, boardList.getTotalPages());

        model.addAttribute("boardList", boardList);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

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
