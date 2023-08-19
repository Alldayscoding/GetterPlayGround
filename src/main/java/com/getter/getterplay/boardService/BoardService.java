package com.getter.getterplay.boardService;

import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {


    //C r u d
    void insert(BoardDTO boardDTO);

    //c R u d   (with pagenation)
    Page<GetterBoard> list(Pageable pageable);

    //c R u d (with Search)

    Page<GetterBoard> boardSearch(String keyword, Pageable pageable);

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
