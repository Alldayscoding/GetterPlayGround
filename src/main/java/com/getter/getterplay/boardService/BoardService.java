package com.getter.getterplay.boardService;

import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;

import java.util.List;

public interface BoardService {


    //C r u d
    void insert(BoardDTO boardDTO);

    //c R u d
    List<GetterBoard> list();

    //c R u d
    BoardDTO getOne(Long bno);





    default BoardDTO entityToDTO(GetterBoard board){

        return BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .build();
    }

}
